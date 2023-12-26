package com.st0x0ef.beyond_earth.mixin;

import com.st0x0ef.beyond_earth.BeyondEarth;
import com.st0x0ef.beyond_earth.common.util.Methods;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class ServerPlayNetworkHandlerMixin {

    @Shadow public ServerPlayerEntity player;

    @Shadow private int floatingTicks;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;isSleeping()Z", shift = At.Shift.BEFORE))
    private void injectFloatTick(CallbackInfo ci) {
        if (Methods.isLivingInJetSuit(this.player) && Methods.shouldDisableAntiCheat(this.player)) {
            this.floatingTicks = 0;
            Methods.disableFlyAntiCheat(this.player, false);
            BeyondEarth.LOGGER.info("disabled anti cheat for " + this.player);
        }
    }
}
