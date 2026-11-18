package com.example.armorplus;

import java.util.Map;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public final class ArmorMaterialData {
    private ArmorMaterialData() {}

    /** Multiplicador de durabilidade (mesmo papel do valor 5 do ferro / 15 do couro). */
    public static final int BASE_DURABILITY = 25;

    /** Aponta para assets/armorplus/equipment/uniforme.json */
    public static final RegistryKey<EquipmentAsset> ASSET_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(ArmorPlus.MOD_ID, "uniforme"));

    // Valores de armadura pedidos: sobretudo +2, cachecol +1, calça +2, botas +2.
    public static final ArmorMaterial MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 1,      // Cachecol
                    EquipmentType.CHESTPLATE, 2,  // Sobretudo
                    EquipmentType.LEGGINGS, 2,    // Calça
                    EquipmentType.BOOTS, 2        // Botas
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,   // toughness
            0.0F,   // knockback resistance base do material (o bônus é aplicado só pelo conjunto completo)
            ItemTags.REPAIRS_LEATHER_ARMOR,
            ASSET_KEY
    );
}
