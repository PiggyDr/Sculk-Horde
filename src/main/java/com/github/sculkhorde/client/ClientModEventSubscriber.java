package com.github.sculkhorde.client;

import com.github.sculkhorde.client.particle.SculkCrustParticle;
import com.github.sculkhorde.client.renderer.block.SculkSummonerBlockRenderer;
import com.github.sculkhorde.client.renderer.entity.*;
import com.github.sculkhorde.core.*;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

@Mod.EventBusSubscriber(modid = SculkHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    public final Map<EntityType<?>, EntityRenderer<?>> renderers = Maps.newHashMap();

    public <T extends Entity> void register(EntityType<T> p_229087_1_, EntityRenderer<? super T> p_229087_2_) {
        this.renderers.put(p_229087_1_, p_229087_2_);
    }


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenders(final EntityRenderersEvent.RegisterRenderers event) {

        // Register Renderers for Entities

        event.registerEntityRenderer(ModEntities.SCULK_ZOMBIE.get(), SculkZombieRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_MITE.get(), SculkMiteRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_MITE_AGGRESSOR.get(), SculkMiteAggressorRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_SPITTER.get(), SculkSpitterRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_BEE_INFECTOR.get(), SculkBeeInfectorRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_BEE_HARVESTER.get(), SculkBeeHarvesterRenderer::new);

        event.registerEntityRenderer(ModEntities.CUSTOM_ITEM_PROJECTILE_ENTITY.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_ACIDIC_PROJECTILE_ENTITY.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(ModEntities.PURIFICATION_FLASK_PROJECTILE_ENTITY.get(), ThrownItemRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_HATCHER.get(), SculkHatcherRenderer::new);

        event.registerEntityRenderer(ModEntities.CURSOR_PROBER.get(), CursorProberRenderer::new);

        event.registerEntityRenderer(ModEntities.CURSOR_INFECTOR.get(), CursorInfectorRenderer::new);

        event.registerEntityRenderer(ModEntities.CURSOR_BRIDGER.get(), CursorBridgerRenderer::new);

        event.registerEntityRenderer(ModEntities.CURSOR_SURFACE_INFECTOR.get(), CursorInfectorRenderer::new);

        event.registerEntityRenderer(ModEntities.CURSOR_SURFACE_PURIFIER.get(), CursorSurfacePurifierRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_SPORE_SPEWER.get(), SculkSporeSpewerRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_RAVAGER.get(), SculkRavagerRenderer::new);

        event.registerEntityRenderer(ModEntities.INFESTATION_PURIFIER.get(), InfestationPurifierRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.SCULK_SUMMONER_BLOCK_ENTITY.get(),SculkSummonerBlockRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_VINDICATOR.get(), SculkVindicatorRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_CREEPER.get(), SculkCreeperRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_ENDERMAN.get(), SculkEndermanRenderer::new);

        event.registerEntityRenderer(ModEntities.ENDER_BUBBLE_ATTACK.get(), EnderBubbleAttackRenderer::new);

        event.registerEntityRenderer(ModEntities.CHAOS_TELEPORATION_RIFT.get(), ChaosTeleporationRiftRenderer::new);

        event.registerEntityRenderer(ModEntities.SCULK_SPINE_SPIKE_ATTACK.get(), SculkSpineSpikeAttackRenderer::new);

    }

    @SubscribeEvent
    public static void registerRenderers(final RegisterParticleProvidersEvent event)
    {
       // Register renderer for sculk crust partcile
       //event.enqueueWork(() -> Minecraft.getInstance().particleEngine.register(ParticleRegistry.SCULK_CRUST_PARTICLE.get(), Provider::new));
        //Minecraft.getInstance().particleEngine.register(ParticleRegistry.SCULK_CRUST_PARTICLE.get(), SculkCrustParticle.Provider::new);
        event.registerSpriteSet(ModParticles.SCULK_CRUST_PARTICLE.get(), SculkCrustParticle.Provider::new);
    }




    /**
     * Used to register custom particle renders.
     * Currently handles the Gorgon particle
     *
     * @param event the particle factory registry event
     **/
    @SubscribeEvent
    public static void registerFactories(final FMLClientSetupEvent event)
    {
        ParticleEngine particles = Minecraft.getInstance().particleEngine;

        //particles.register(ParticleRegistry.SCULK_CRUST_PARTICLE.get(), Provider::new);
        
    }
}
