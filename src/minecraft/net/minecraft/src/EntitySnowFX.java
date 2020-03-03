package net.minecraft.src;

public class EntitySnowFX extends EntityFX
{
  
    int i;
    int initialIndex = 192;
    private boolean stop;
    public EntitySnowFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 1.8F);
    }

    public EntitySnowFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.399999999776482582D;
        this.motionY *= 0.799999999776482582D;
        this.motionZ *= 0.399999999776482582D;
        this.motionY = -0.04D - (rand.nextFloat() * 0.04f);
        this.particleScale *= 0.25F;
        this.particleScale *= par14;
        this.particleMaxAge = 175;
        this.noClip = false;
        if(rand.nextBoolean())
        {
        	initialIndex -=16;
        }
        this.setParticleTextureIndex(initialIndex);
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
     
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	if(onGround)
    	{
    		stop = true;
    		this.setParticleTextureIndex(initialIndex + 2);
    	}
    	if(!stop && this.particleAge >= 20)
    	{
    		this.setParticleTextureIndex(initialIndex + 1);
    	}
    		/*i = 15 - (this.particleAge) * 8 / (this.particleMaxAge / 2);
    		if(i<=8)
    		{
    			i=8;
    		}*/
    	//	this.setParticleTextureIndex(i);
    	
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);

       /* if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }*/

        this.motionX *= 0.9600000143051147D;
       // this.motionY *= 0.999999999776482582D;
        this.motionZ *= 0.9600000143051147D;

        if (this.onGround)
        {
        	
            this.motionX *= 0.015D;
            this.motionZ *= 0.015D;
        }
    }
}
