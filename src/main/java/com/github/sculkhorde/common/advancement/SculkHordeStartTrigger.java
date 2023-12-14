package com.github.sculkhorde.common.advancement;

import com.github.sculkhorde.core.SculkHorde;
import com.google.common.base.Predicates;
import com.google.gson.JsonObject;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class SculkHordeStartTrigger extends SimpleCriterionTrigger<SculkHordeStartTrigger.SculkHordeStartCriterion> implements CustomCriterionTrigger{

    public static final SculkHordeStartTrigger INSTANCE = new SculkHordeStartTrigger();
    static final ResourceLocation ID = new ResourceLocation(SculkHorde.MOD_ID, "sculk_horde_start");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public SculkHordeStartCriterion createInstance(JsonObject jsonObject, EntityPredicate.Composite awarePredicate, DeserializationContext deserializationContext) {
        return new SculkHordeStartCriterion(awarePredicate);
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, Predicates.alwaysTrue());
    }

    public static class SculkHordeStartCriterion extends AbstractCriterionTriggerInstance {

        public SculkHordeStartCriterion(EntityPredicate.Composite awarePredicate) {
            super(ID, awarePredicate);
        }
    }
}
