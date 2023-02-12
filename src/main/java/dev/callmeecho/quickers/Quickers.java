package dev.callmeecho.quickers;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quickers implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("quickers");
	public static final GameRules.Key<GameRules.IntRule> HOPPER_SPEED = GameRuleRegistry.register("hopperSpeed", GameRules.Category.MISC, GameRuleFactory.createIntRule(8));
	@Override
	public void onInitialize() {

	}
}
