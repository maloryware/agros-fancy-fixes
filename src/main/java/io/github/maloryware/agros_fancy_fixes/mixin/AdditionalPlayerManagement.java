package io.github.maloryware.agros_fancy_fixes.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(BucketItem.class)

public class AdditionalPlayerManagement extends Item {


    public AdditionalPlayerManagement(Settings settings) {
        super(settings);
    }

    @Inject(
            method = "use",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;")
    )

    public void zekoSauced(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir){
        HitResult hitResult = user.raycast(5, 0, false);

        if(hitResult instanceof EntityHitResult result
                && result.getEntity() instanceof PlayerEntity target
                && target.getName().toString().equals("ToksykGaming")){
            target.damage(target.getDamageSources().indirectMagic(user, user), 1);
            user.setStackInHand(hand, Items.MILK_BUCKET.getDefaultStack());
        }

    }

}


