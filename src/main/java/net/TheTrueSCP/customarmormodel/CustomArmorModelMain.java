package net.TheTrueSCP.customarmormodel;

import net.TheTrueSCP.customarmormodel.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CustomArmorModelMain.MOD_ID)
public class CustomArmorModelMain
{
    public static final String MOD_ID = "customarmormodel";

    //MainMod Coinstructor
    public CustomArmorModelMain()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register all items
        ModItems.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

}
