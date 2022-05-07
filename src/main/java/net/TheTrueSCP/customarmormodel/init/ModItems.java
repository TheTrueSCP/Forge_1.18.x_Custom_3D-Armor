package net.TheTrueSCP.customarmormodel.init;

import net.TheTrueSCP.customarmormodel.CustomArmorMaterial;
import net.TheTrueSCP.customarmormodel.CustomArmorModelMain;
import net.TheTrueSCP.customarmormodel.items.Armor.ModDrillerMK1ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    //This is basicly our registration for our item, but you can use your own itemregistration

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CustomArmorModelMain.MOD_ID);


    public static final RegistryObject<Item> CUSTOM_ARMOR_HELMET = ITEMS.register("custom_armor_helmet",
            () -> new ModDrillerMK1ArmorItem.Helmet(CustomArmorMaterial.CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> CUSTOM_ARMOR_CHESTPLATE = ITEMS.register("custom_armor_chestplate",
            () -> new ModDrillerMK1ArmorItem.Chestplate(CustomArmorMaterial.CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> CUSTOM_ARMOR_LEGGINGS = ITEMS.register("custom_armor_leggings",
            () -> new ModDrillerMK1ArmorItem.Leggings(CustomArmorMaterial.CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> CUSTOM_ARMOR_BOOTS = ITEMS.register("custom_armor_boots",
            () -> new ModDrillerMK1ArmorItem.Boots(CustomArmorMaterial.CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));




    //hooked up in the Mod Constructor to register all items
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
