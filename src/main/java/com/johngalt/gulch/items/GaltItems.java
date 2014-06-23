package com.johngalt.gulch.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created on 6/13/2014.
 */
public class GaltItems
{

    public static ItemBlasterRifle BlasterRifle;
    public static ItemBlasterAmmo BlasterAmmo;
    public static ItemMusket Musket;
    public static ItemMusketShot MusketShot;
    public static ItemWadding Wadding;
    public static ItemIngotLead IngotLead;

    public static Item simpleItem;

    public static void init()
    {
        BlasterRifle = new ItemBlasterRifle();
        BlasterAmmo = new ItemBlasterAmmo();
        simpleItem = new GaltSimpleItem();
        Musket = new ItemMusket();
        MusketShot = new ItemMusketShot();
        Wadding = new ItemWadding();
        IngotLead = new ItemIngotLead();
    }

    public static void register(GaltCommonItem item)
    {
        GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName());
    }


}
