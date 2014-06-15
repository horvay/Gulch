package com.johngalt.gulch;

import com.johngalt.gulch.entities.GaltEntities;
import com.johngalt.gulch.blocks.GaltBlocks;
import com.johngalt.gulch.creativetab.GaltTab;
import com.johngalt.gulch.gui.GaltGUI;
import com.johngalt.gulch.gui.GuiHandler;
import com.johngalt.gulch.items.GaltItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created on 6/13/2014.
 */
@Mod(modid = References.MODID, version = References.VERSION, name = References.MODNAME)
public class GulchMod
{
    @SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
    public static CommonProxy proxy;

    @Mod.Instance(References.MODID)
    public static GulchMod instance;

    private static CreativeTabs tab = new GaltTab(CreativeTabs.getNextID(), References.MODID);

    public static CreativeTabs getCreativeTab()
    {
        return tab;
    }

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        GaltItems.InitializeItems();
        GaltItems.RegisterItems();
        GaltEntities.RegisterEntities();
        proxy.registerRenderers();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {

    }
}
