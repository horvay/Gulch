package com.johngalt.gulch.items;

import com.johngalt.gulch.GaltSounds;
import com.johngalt.gulch.effects.GaltEffects;
import com.johngalt.gulch.entities.GaltEntities;
import com.johngalt.gulch.recipes.GaltRecipes;
import com.johngalt.gulch.recipes.IGaltRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created on 6/20/2014.
 */
public class GaltCommonGun extends GaltCommonItem implements IGaltRecipes
{
    private GaltSounds.SoundsEnum _ShotSound;
    private BulletEnum _BulletType;
    private GaltEffects.EffectEnum _BarrelParticleEffect;
    private int _ClipSize;


    public GaltCommonGun(BulletEnum bulletType, int clipSize, GaltSounds.SoundsEnum shotSound, GaltEffects.EffectEnum barrelParticleEffect)
    {
        super();

        _ClipSize = clipSize;
        _BulletType = bulletType;
        _ShotSound = shotSound;
        _BarrelParticleEffect = barrelParticleEffect;


        setMaxStackSize(1);
        this.setMaxDamage(_ClipSize + 1);

        GaltRecipes.DeclareRecipes(this);

    }

    @Override
    public ItemStack onItemRightClick(ItemStack gun, World world, EntityPlayer player)
    {
        if (gun.getItemDamage() < _ClipSize)
        {
            GaltSounds.PlaySound(_ShotSound, world, player);
            if (!world.isRemote)
            {

                world.spawnEntityInWorld(GaltEntities.getBulletInstance(_BulletType, world, player));
                GaltEffects.spawnParticleAtHeldItem(_BarrelParticleEffect, player, 0.0F, 0.0F, 0.0F);

                gun.damageItem(1, player);
            }
        }
        else
        {
            GaltSounds.PlaySound(GaltSounds.SoundsEnum.no_ammo, world, player);
        }

        return gun;
    }

    @Override
    public void RegisterRecipes()
    {
        // register every combination of ammo reloading possible.
        for (int dam = _ClipSize; dam > 0; dam--)
        {
            for (int numAmmo = dam; numAmmo > 0; numAmmo--)
            {
                List<Object> input = new ArrayList<Object>();

                for (int i = 0; i < numAmmo; i++)
                    input.add(new ItemStack(GaltCommonGun.GetBulletInstance(_BulletType), 1));

                input.add(new ItemStack(this, 1, dam));

                List<Object> additionalRequirements = GetAdditionalReloadRequirements();
                if (additionalRequirements != null)
                {
                    input.addAll(GetAdditionalReloadRequirements());
                }

                GaltRecipes.RegisterRecipe(false, new ItemStack(this, 1, dam - numAmmo), input.toArray());
            }
        }
    }

    protected List<Object> GetAdditionalReloadRequirements()
    {
        return null;
    }

    public static GaltCommonItem GetBulletInstance(BulletEnum bullet)
    {
        if (bullet == BulletEnum.BlasterBolt)
        {
            return GaltItems.BlasterAmmo;
        }
        else if (bullet == BulletEnum.MusketShot)
        {
            return GaltItems.MusketShot;
        }

        return null;
    }
}