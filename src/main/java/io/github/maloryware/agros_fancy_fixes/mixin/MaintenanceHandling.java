package io.github.maloryware.agros_fancy_fixes.mixin;

import com.mojang.authlib.GameProfile;
import io.github.maloryware.agros_fancy_fixes.config.AFFConfig;
import net.minecraft.server.PlayerManager;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.net.SocketAddress;
import java.util.List;

@Mixin(PlayerManager.class)
public class MaintenanceHandling {


    @Inject(method = "checkCanJoin", at = @At("HEAD"), cancellable = true)
    public void isInMaintenanceList(SocketAddress address, GameProfile profile, CallbackInfoReturnable<Text> cir){
        //stubb
        List<String> allowedMaintenanceProfiles = List.of(
                "2658711d-889e-48aa-a9ab-dbeaebadda8c",
                "3659cfeb-9107-48f8-aecc-c0881958260d"
        );

        if(AFFConfig.maintenance_mode && !AFFConfig.allowed_maintenance_playerlist.contains(profile.getId().toString())){
            cir.setReturnValue(Text.of("Server under maintenance, be back soon!"));
        }
    }


}
