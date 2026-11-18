package com.example.armorplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ArmorPlus implements ModInitializer {
    public static final String MOD_ID = "armorplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.register();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.SCARF);
            entries.add(ModItems.COAT);
            entries.add(ModItems.PANTS);
            entries.add(ModItems.BOOTS);
        });
        SetBonus.register();
        LOGGER.info("ArmorPlus iniciado.");
    }
}
