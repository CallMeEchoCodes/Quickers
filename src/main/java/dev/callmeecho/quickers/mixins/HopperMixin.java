package dev.callmeecho.quickers.mixins;

import dev.callmeecho.quickers.Quickers;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HopperBlockEntity.class)
public abstract class HopperMixin extends LootableContainerBlockEntity {
    public HopperMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) { super(blockEntityType, blockPos, blockState); }

    @Shadow
    private int transferCooldown;
    @Inject(method = "setTransferCooldown", at = @At("HEAD"), cancellable = true)
    private void setCooldownMixin(int cooldown, CallbackInfo ci) {
        if (cooldown > 0) {
            if (world != null) {
                int value = world.getGameRules().getInt(Quickers.HOPPER_SPEED) - 8;
                Quickers.LOGGER.debug(String.valueOf(value));
                this.transferCooldown = cooldown + value;
                ci.cancel();
            }
        }
    }
}