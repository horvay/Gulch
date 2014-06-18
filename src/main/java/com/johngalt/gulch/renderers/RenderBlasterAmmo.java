package com.johngalt.gulch.renderers;

import com.johngalt.gulch.entities.EntityBlasterBolt;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * Created on 6/14/2014.
 */
public class RenderBlasterAmmo extends Render
{
    private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/arrow.png");

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityBlasterBolt par1EntityBlasterBolt, double par2, double par4, double par6, float par8, float par9)
    {
        this.bindEntityTexture(par1EntityBlasterBolt);
        GL11.glPushMatrix();

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);

        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glRotatef(par1EntityBlasterBolt.prevRotationYaw + (par1EntityBlasterBolt.rotationYaw - par1EntityBlasterBolt.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(par1EntityBlasterBolt.prevRotationPitch + (par1EntityBlasterBolt.rotationPitch - par1EntityBlasterBolt.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.instance;
        byte b0 = 0;
        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = (float) (0 + b0 * 10) / 32.0F;
        float f5 = (float) (5 + b0 * 10) / 32.0F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (float) (5 + b0 * 10) / 32.0F;
        float f9 = (float) (10 + b0 * 10) / 32.0F;
        float f10 = 0.05625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float f11 = 0 - par9;

        if (f11 > 0.0F)
        {
            float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
            GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
        }

        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(120, 40, 40, 0);
        tessellator.addVertex(-7.0D, -2.0D, -2.0D);
        tessellator.addVertex(-7.0D, -2.0D, 2.0D);
        tessellator.addVertex(-7.0D, 2.0D, 2.0D);
        tessellator.addVertex(-7.0D, 2.0D, -2.0D);
        tessellator.draw();


        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(120, 40, 40, 0);
        tessellator.addVertex(-7.0D, 2.0D, -2.0D);
        tessellator.addVertex(-7.0D, 2.0D, 2.0D);
        tessellator.addVertex(-7.0D, -2.0D, 2.0D);
        tessellator.addVertex(-7.0D, -2.0D, -2.0D);
        tessellator.draw();

        for (int i = 0; i < 4; ++i)
        {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f10);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(120, 40, 40, 0);
            tessellator.addVertex(-8.0D, -2.0D, 0.0D);
            tessellator.addVertex(8.0D, -2.0D, 0.0D);
            tessellator.addVertex(8.0D, 2.0D, 0.0D);
            tessellator.addVertex(-8.0D, 2.0D, 0.0D);
            tessellator.draw();
        }



        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glPopMatrix();
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBlasterBolt par1EntityBlasterBolt)
    {
        return arrowTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityBlasterBolt) par1Entity);
    }


    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntityBlasterBolt) par1Entity, par2, par4, par6, par8, par9);
    }
}
