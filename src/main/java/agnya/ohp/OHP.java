package agnya.ohp;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

@Mod(OHP.MODID)
public class OHP
{
    private static final Logger LOGGER = LogUtils.getLogger(); // Not being used currently
    public static final String MODID = "offhandplace";
    public static CreativeModeTab TAB_SOD;

    public OHP() {	
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @OnlyIn(Dist.DEDICATED_SERVER)
    @SubscribeEvent
    public void warnServer(ServerStartingEvent event) {
        LOGGER.warn("SERVER DETECTED! Offhand Place is a client-side mod!");
    }
}
