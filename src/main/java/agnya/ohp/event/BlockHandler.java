package agnya.ohp.event;

import agnya.ohp.registry.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class BlockHandler {
    
    @SubscribeEvent(priority = EventPriority.LOW)
    public void rightClicked(RightClickBlock event) {
        ItemStack offHandItem = event.getPlayer().getOffhandItem();
        if (!(offHandItem.getItem() instanceof BlockItem)) return;
        if (!Keybinds.OHP_KEY.isDown()) return;
        
        Minecraft inst = Minecraft.getInstance(); 
        MultiPlayerGameMode gm = inst.gameMode; ClientLevel world = inst.level;
        LocalPlayer Player = inst.player; 

        if (gm != null && world != null && Player != null) {
            event.setCanceled(true);
            
            gm.useItemOn(Player, world, InteractionHand.OFF_HAND, event.getHitVec());
            Player.swing(InteractionHand.OFF_HAND, true);
        }
    }

}
