package net.minecraft.kamil.mod;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ModKamila.MODID, version = ModKamila.VERSION)
public class ModKamila
{
    public static final String MODID = "mod_kamila";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide="com.bedrockminer.tutorial.ClientProxy", serverSide="com.bedrockminer.tutorial.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
}

