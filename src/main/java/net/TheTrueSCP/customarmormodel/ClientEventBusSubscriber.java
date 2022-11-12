package net.TheTrueSCP.customarmormodel;


import com.mojang.blaze3d.platform.InputConstants;
import net.TheTrueSCP.customarmormodel.client.CustomArmorModel;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

public class ClientEventBusSubscriber
{


 @Mod.EventBusSubscriber(modid = CustomArmorModelMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ModEvents
    {


        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
        {


            //Here, we register the model-layer, thats VERY imported because minecraft needs to know how it schould render the model
            event.registerLayerDefinition(CustomArmorModel.LAYER_LOCATION, CustomArmorModel::createBodyLayer);
        }



    }



}
