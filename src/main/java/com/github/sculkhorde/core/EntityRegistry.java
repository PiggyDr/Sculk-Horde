package com.github.sculkhorde.core;

import com.github.sculkhorde.common.entity.*;
import com.github.sculkhorde.common.entity.infection.*;
import com.github.sculkhorde.common.entity.projectile.CustomItemProjectileEntity;
import com.github.sculkhorde.common.entity.projectile.PurificationFlaskProjectileEntity;
import com.github.sculkhorde.common.entity.projectile.SculkAcidicProjectileEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class EntityRegistry {

    /** ENTITY TYPES **/

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SculkHorde.MOD_ID);

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

    public static <T extends Mob> RegistryObject<EntityType<T>> registerMob(String name, EntityType.EntityFactory<T> entity, float width, float height, int primaryEggColor, int secondaryEggColor) {
        RegistryObject<EntityType<T>> entityType = ENTITY_TYPES.register(name,
                () -> EntityType.Builder.of(entity, MobCategory.MONSTER).sized(width, height).build(name));

        return entityType;
    }

    public static final RegistryObject<EntityType<SculkZombieEntity>> SCULK_ZOMBIE = registerMob("sculk_zombie", SculkZombieEntity::new, 0.6f, 1.95f, 0x000000, 0x000000);
    public static final RegistryObject<EntityType<SculkMiteEntity>> SCULK_MITE = registerMob("sculk_mite", SculkMiteEntity::new, 0.6f, 0.6f, 0x000000, 0x000000);
    public static final RegistryObject<EntityType<SculkMiteAggressorEntity>> SCULK_MITE_AGGRESSOR = registerMob("sculk_mite_aggressor", SculkMiteAggressorEntity::new, 0.6f, 0.6f, 0x000000, 0x000000);
    public static final RegistryObject<EntityType<SculkSpitterEntity>> SCULK_SPITTER = registerMob("sculk_spitter", SculkSpitterEntity::new, 0.6f, 1.95f, 0x000000, 0x000000);
    public static final RegistryObject<EntityType<SculkBeeInfectorEntity>> SCULK_BEE_INFECTOR = registerMob("sculk_bee_infector", SculkBeeInfectorEntity::new, 0.6f, 0.6f, 0x000000, 0x000000);
    public static final RegistryObject<EntityType<SculkBeeHarvesterEntity>> SCULK_BEE_HARVESTER = registerMob("sculk_bee_harvester", SculkBeeHarvesterEntity::new, 0.6f, 0.6f, 0x000000, 0x000000);
    public static final RegistryObject<EntityType<SculkHatcherEntity>> SCULK_HATCHER = registerMob("sculk_hatcher", SculkHatcherEntity::new, 0.9f, 1.4f, 0x000000, 0x000000);

    public static final RegistryObject<EntityType<SculkSporeSpewerEntity>> SCULK_SPORE_SPEWER = registerMob("sculk_spore_spewer", SculkSporeSpewerEntity::new, 1f, 2f, 0x000000, 0x000000);

    public static final RegistryObject<EntityType<SculkRavagerEntity>> SCULK_RAVAGER = registerMob("sculk_ravager", SculkRavagerEntity::new, 1.95f, 2.2f, 0x000000, 0x000000);

    public static final RegistryObject<EntityType<CursorProberEntity>> CURSOR_PROBER = ENTITY_TYPES.register("cursor_prober", () -> EntityType.Builder.<CursorProberEntity>of(CursorProberEntity::new, MobCategory.MISC).sized(1f, 1f).clientTrackingRange(4).updateInterval(10).build("cursor_prober"));
    public static final RegistryObject<EntityType<CustomItemProjectileEntity>> CUSTOM_ITEM_PROJECTILE_ENTITY = ENTITY_TYPES.register("custom_item_projectile", () -> EntityType.Builder.<CustomItemProjectileEntity>of(CustomItemProjectileEntity::new, MobCategory.MISC).sized(0.45F, 0.45F).clientTrackingRange(4).updateInterval(10).build("custom_item_projectile"));
    public static final RegistryObject<EntityType<SculkAcidicProjectileEntity>> SCULK_ACIDIC_PROJECTILE_ENTITY = ENTITY_TYPES.register("sculk_acidic_projectile", () -> EntityType.Builder.<SculkAcidicProjectileEntity>of(SculkAcidicProjectileEntity::new, MobCategory.MISC).sized(0.45F, 0.45F).clientTrackingRange(4).updateInterval(10).build("sculk_acidic_projectile"));
    public static final RegistryObject<EntityType<PurificationFlaskProjectileEntity>> PURIFICATION_FLASK_PROJECTILE_ENTITY = ENTITY_TYPES.register("purification_flask_projectile", () -> EntityType.Builder.<PurificationFlaskProjectileEntity>of(PurificationFlaskProjectileEntity::new, MobCategory.MISC).sized(0.45F, 0.45F).clientTrackingRange(4).updateInterval(10).build("purification_flask_projectile"));

    public static final RegistryObject<EntityType<CursorInfectorEntity>> CURSOR_INFECTOR = ENTITY_TYPES.register("cursor_infector", () -> EntityType.Builder.<CursorInfectorEntity>of(CursorInfectorEntity::new, MobCategory.MISC).sized(1f, 1f).clientTrackingRange(4).updateInterval(10).build("cursor_infector"));
    public static final RegistryObject<EntityType<CursorBridgerEntity>> CURSOR_BRIDGER = ENTITY_TYPES.register("cursor_bridger", () -> EntityType.Builder.<CursorBridgerEntity>of(CursorBridgerEntity::new, MobCategory.MISC).sized(1f, 1f).clientTrackingRange(4).updateInterval(10).build("cursor_bridger"));
    public static final RegistryObject<EntityType<CursorSurfaceInfectorEntity>> CURSOR_SURFACE_INFECTOR = ENTITY_TYPES.register("cursor_surface_infector", () -> EntityType.Builder.<CursorSurfaceInfectorEntity>of(CursorSurfaceInfectorEntity::new, MobCategory.MISC).sized(1f, 1f).clientTrackingRange(4).updateInterval(10).build("cursor_surface_infector"));
    public static final RegistryObject<EntityType<CursorSurfacePurifierEntity>> CURSOR_SURFACE_PURIFIER = ENTITY_TYPES.register("cursor_surface_purifier", () -> EntityType.Builder.<CursorSurfacePurifierEntity>of(CursorSurfacePurifierEntity::new, MobCategory.MISC).sized(1f, 1f).clientTrackingRange(4).updateInterval(10).build("cursor_surface_purifier"));
    public static final RegistryObject<EntityType<InfestationPurifierEntity>> INFESTATION_PURIFIER = ENTITY_TYPES.register("infestation_purifier", () -> EntityType.Builder.<InfestationPurifierEntity>of(InfestationPurifierEntity::new, MobCategory.MISC).sized(1f, 1f).clientTrackingRange(4).updateInterval(10).build("infestation_purifier"));




}
