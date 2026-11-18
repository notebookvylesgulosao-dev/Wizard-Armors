package com.example.armorplus;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class ModItems {
    private ModItems() {}

    // Cachecol ocupa o slot da cabeça; sobretudo ocupa o peitoral.
    public static final Item SCARF  = registerArmor("cachecol",  EquipmentType.HELMET);
    public static final Item COAT   = registerArmor("sobretudo", EquipmentType.CHESTPLATE);
    public static final Item PANTS  = registerArmor("calca",     EquipmentType.LEGGINGS);
    public static final Item BOOTS  = registerArmor("botas",     EquipmentType.BOOTS);

    // Desde a 1.21.2 armaduras são itens comuns com o componente "equippable";
    // Item.Settings#armor aplica durabilidade, atributos de armadura e encantabilidade.
    // Além disso, a registryKey precisa ser definida nas Settings antes de criar o Item.
    private static Item registerArmor(String name, EquipmentType type) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ArmorPlus.MOD_ID, name));
        Item item = new Item(new Item.Settings()
                .armor(ArmorMaterialData.MATERIAL, type)
                .registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void register() {
        ArmorPlus.LOGGER.info("Registrando peças do conjunto ArmorPlus.");
    }
}
