package net.TheTrueSCP.customarmormodel.items.Armor;

import net.TheTrueSCP.customarmormodel.client.CustomArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.Collections;
import java.util.Map;

public abstract class Mod3DArmorItems extends ArmorItem {


    //This is Itemclass, but with subclasses, and these subclasses are the real items which be registered
    public Mod3DArmorItems(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }



    //In the helmet is the explanation how to correctly setting up the items
    public static class Helmet extends Mod3DArmorItems {


        //Call this constructor to create item
        public Helmet(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
            super(pMaterial, pSlot, pProperties);
        }


        //This is the important method, because here you set the model which should be rendered if you wear the item
        public void initializeClient(java.util.function.Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {
                @Override
                public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                    HumanoidModel armorModel =
                            new HumanoidModel( //Here, we create an new Human Model which should be rendered over the player if you wear the item
                                    new ModelPart(Collections.emptyList(),
                                            Map.of(//depending on which item you are currently in, you have to reference the correct body part(s) from your custom model
                                                    //Example:
                                                    "head", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).Head, //This element is the helmet, which means that minecraft should only render the helmet from custom mode
                                                    "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),//All other bodyparts should be empty
                                                    "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                                    "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                                    "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                                    "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                                    "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));

                    armorModel.crouching = living.isShiftKeyDown();
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = living.isBaby();
                    return armorModel;
                }
            });
        }


        //Texture
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "customarmormodel:textures/armor/custom_armor_without_boots.png";
        }
    }

    public static class Chestplate extends Mod3DArmorItems {

        public Chestplate(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
            super(pMaterial, pSlot, pProperties);
        }

        public void initializeClient(java.util.function.Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {
                @Override
                @OnlyIn(Dist.CLIENT)
                public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                    HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
                            Map.of("body", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).Body,
                                    "left_arm", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).LeftArm,//Here were applying the arms to the chestplate
                                    "right_arm", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).RightArm,
                                    "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                    armorModel.crouching = living.isShiftKeyDown();
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = living.isBaby();
                    return armorModel;
                }
            });
        }



        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "customarmormodel:textures/armor/custom_armor_without_boots.png";//Here, you must set the amor texture
        }
    }


    //IMPORTANT:
    //boots and leggings are not seperated bodyparts, that means we must seperate then visually with the texture
    public static class Leggings extends Mod3DArmorItems {

        public Leggings(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
            super(pMaterial, pSlot, pProperties);
        }


        public void initializeClient(java.util.function.Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {
                @Override
                @OnlyIn(Dist.CLIENT)
                public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                    HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
                            Map.of("left_leg", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).LeftLeg,
                                    "right_leg", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).RightLeg,//Leg Model applied
                                    "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                    armorModel.crouching = living.isShiftKeyDown();
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = living.isBaby();
                    return armorModel;
                }
            });
        }



        //For minecraft, the boots model will be rendered too, but we can't see them because in this texture the boot sprites are transparent
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "customarmormodel:textures/armor/custom_armor_without_boots.png";
        }
    }

    public static class Boots extends Mod3DArmorItems {

        public Boots(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
            super(pMaterial, pSlot, pProperties);
        }

        public void initializeClient(java.util.function.Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {
                @Override
                @OnlyIn(Dist.CLIENT)
                public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                    HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
                            Map.of("left_leg", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).LeftLeg, //Leg Model also applied
                                    "right_leg", new CustomArmorModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(CustomArmorModel.LAYER_LOCATION)).RightLeg,
                                    "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                    armorModel.crouching = living.isShiftKeyDown();
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = living.isBaby();
                    return armorModel;
                }
            });
        }

        
        //In this case, the texture has only the sprites for the boots, but NOT for the leggings, that means, only the boots will be visible
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "customarmormodel:textures/armor/custom_armor_without_leggings.png";
        }
    }
    
    
}
