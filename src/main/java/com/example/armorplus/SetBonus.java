package com.example.armorplus;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

/**
 * Bônus do conjunto completo (só vale com as 4 peças equipadas):
 *  - +4 corações de vida máxima (+8 pontos)
 *  - +30% de velocidade de movimento
 *  - 15% menos repulsão (knockback resistance 0.15)
 */
public final class SetBonus {
    private SetBonus() {}

    private static final Identifier HEALTH_ID    = Identifier.of(ArmorPlus.MOD_ID, "set_health");
    private static final Identifier SPEED_ID     = Identifier.of(ArmorPlus.MOD_ID, "set_speed");
    private static final Identifier KNOCKBACK_ID = Identifier.of(ArmorPlus.MOD_ID, "set_knockback");

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (var player : server.getPlayerManager().getPlayerList()) {
                updatePlayer(player);
            }
        });
    }

    public static boolean hasFullSet(PlayerEntity player) {
        return isWearing(player, EquipmentSlot.HEAD,  ModItems.SCARF)
            && isWearing(player, EquipmentSlot.CHEST, ModItems.COAT)
            && isWearing(player, EquipmentSlot.LEGS,  ModItems.PANTS)
            && isWearing(player, EquipmentSlot.FEET,  ModItems.BOOTS);
    }

    private static void updatePlayer(PlayerEntity player) {
        boolean fullSet = hasFullSet(player);

        apply(player, EntityAttributes.MAX_HEALTH, HEALTH_ID, fullSet,
                8.0, EntityAttributeModifier.Operation.ADD_VALUE);
        apply(player, EntityAttributes.MOVEMENT_SPEED, SPEED_ID, fullSet,
                0.30, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        apply(player, EntityAttributes.KNOCKBACK_RESISTANCE, KNOCKBACK_ID, fullSet,
                0.15, EntityAttributeModifier.Operation.ADD_VALUE);

        // Ao tirar uma peça, a vida máxima cai; garante que a vida atual não fique acima dela.
        if (player.getHealth() > player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        }
    }

    private static boolean isWearing(PlayerEntity player, EquipmentSlot slot, Item expected) {
        return player.getEquippedStack(slot).isOf(expected);
    }

    private static void apply(PlayerEntity player, RegistryEntry<EntityAttribute> attribute,
                              Identifier id, boolean enabled, double amount,
                              EntityAttributeModifier.Operation operation) {
        EntityAttributeInstance instance = player.getAttributeInstance(attribute);
        if (instance == null) return;

        // Só mexe no atributo quando o estado muda: evita recalcular e sincronizar todo tick.
        boolean present = instance.hasModifier(id);
        if (enabled && !present) {
            instance.addTemporaryModifier(new EntityAttributeModifier(id, amount, operation));
        } else if (!enabled && present) {
            instance.removeModifier(id);
        }
    }
}
