package net.minecraft.src;

public class EntityAINetherCreeperSwell extends EntityAIBase
{
    /** The NetherCreeper that is swelling. */
    EntityNetherCreeper swellingNetherCreeper;

    /**
     * The NetherCreeper's attack target. This is used for the changing of the NetherCreeper's state.
     */
    EntityLiving NetherCreeperAttackTarget;

    public EntityAINetherCreeperSwell(EntityNetherCreeper par1EntityNetherCreeper)
    {
        this.swellingNetherCreeper = par1EntityNetherCreeper;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLiving var1 = this.swellingNetherCreeper.getAttackTarget();
        if(this.swellingNetherCreeper.getNetherCreeperState() > 0 || var1 != null && this.swellingNetherCreeper.getDistanceSqToEntity(var1) < 20.0D)
        {
        	this.swellingNetherCreeper.rotateAttackRight();
        }
        return this.swellingNetherCreeper.getNetherCreeperState() > 0 || var1 != null && this.swellingNetherCreeper.getDistanceSqToEntity(var1) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
       // this.swellingNetherCreeper.getNavigator().clearPathEntity();
        this.NetherCreeperAttackTarget = this.swellingNetherCreeper.getAttackTarget();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.NetherCreeperAttackTarget = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.NetherCreeperAttackTarget == null)
        {
            this.swellingNetherCreeper.setNetherCreeperState(-1);
        }
        else if (this.swellingNetherCreeper.getDistanceSqToEntity(this.NetherCreeperAttackTarget) > 10.0D)
        {
            this.swellingNetherCreeper.setNetherCreeperState(-1);
        }
        else if (!this.swellingNetherCreeper.getEntitySenses().canSee(this.NetherCreeperAttackTarget))
        {
            this.swellingNetherCreeper.setNetherCreeperState(-1);
        }
        else
        {
            this.swellingNetherCreeper.setNetherCreeperState(1);
        }
    }
}
