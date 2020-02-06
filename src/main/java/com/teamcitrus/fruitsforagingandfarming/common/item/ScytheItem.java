package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.google.common.collect.Multimap;
import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ScytheItem extends TieredItem {
    private final float attackDamage;
    private final float attackSpeed;


    public ScytheItem(String name, IItemTier tier, float attackSpeedIn) {
        super(tier, new Item.Properties().maxDamage(tier.getMaxUses() + 100).group(FruitsForagingAndFarming.itemGroup));
        setRegistryName(FruitsForagingAndFarming.MODID, name);

        this.attackSpeed = attackSpeedIn;
        this.attackDamage = 5 + tier.getAttackDamage();
    }


    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {


        return (enchantment.type == EnchantmentType.WEAPON || enchantment.type == EnchantmentType.ALL || enchantment == Enchantments.FORTUNE);

    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {

        if (player.getCooledAttackStrength(0) == 1.0F) {
            for (LivingEntity entitylivingbase : player.world.getEntitiesWithinAABB(LivingEntity.class, entity.getBoundingBox().grow(1.0D, 0.25D, 1.0D))) {
                if (entitylivingbase != player && entitylivingbase != entity && !player.isOnSameTeam(entitylivingbase) && player.getDistanceSq(entitylivingbase.getPositionVec()) < 9.0D) {
                    entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(player), attackDamage);
                }
            }

            player.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, player.getSoundCategory(), 1.0F, 1.0F);
            player.spawnSweepParticles();
        }
        return false;
    }

    //TODO Block Cleaving


    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     *
     * @param stack
     * @param worldIn
     * @param state
     * @param pos
     * @param entityLiving
     */
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving)) {

            if (!entityLiving.isSneaking()) {
                if (!worldIn.isRemote) {
                    if (state.getBlock() instanceof BushBlock) {

                        BlockPos breakposfirst;
                        BlockPos breakpossecond;
                        double div = 360.0D / 8.0D;
                        double quantized = (int) ((entityLiving.rotationYaw + div / 2.0D) / div) % 8;

                        quantized *= -1;

                        if (quantized == 0) {

                            breakposfirst = pos.north();
                            breakposfirst = breakposfirst.east();
                            breakpossecond = pos.south();
                            breakpossecond = breakpossecond.west();
                        } else if (quantized == 1 || quantized == 5) {
                            breakposfirst = pos.north();
                            breakpossecond = pos.south();
                        } else if (quantized == 2) {
                            breakposfirst = pos.south();
                            breakposfirst = breakposfirst.east();
                            breakpossecond = pos.north();
                            breakpossecond = breakpossecond.west();
                        } else if (quantized == 3 || quantized == 7) {
                            breakposfirst = pos.west();
                            breakpossecond = pos.east();

                        } else if (quantized == 4) {
                            breakposfirst = pos.south();
                            breakposfirst = breakposfirst.west();
                            breakpossecond = pos.north();
                            breakpossecond = breakpossecond.east();
                        } else if (quantized == 6) {
                            breakposfirst = pos.north();
                            breakposfirst = breakposfirst.west();
                            breakpossecond = pos.south();
                            breakpossecond = breakpossecond.east();

                        } else {
                            breakposfirst = pos;
                            breakpossecond = pos;
                            System.err.println("Unrecognized Numerical: " + quantized);
                        }


                        if (worldIn.getBlockState(breakposfirst).getBlock() instanceof BushBlock) {


                            worldIn.destroyBlock(breakposfirst, true);


                        }
                        if (worldIn.getBlockState(breakpossecond).getBlock() instanceof BushBlock) {

                            worldIn.destroyBlock(breakpossecond, true);


                        }

                        double d0 = (double) (-MathHelper.sin(entityLiving.rotationYaw * 0.017453292F));
                        double d1 = (double) MathHelper.cos(entityLiving.rotationYaw * 0.017453292F);

                        if (entityLiving instanceof PlayerEntity) {
                          ((PlayerEntity) entityLiving).spawnSweepParticles();
                        }
                    }
                }
            }
            return true;
        }

        return  false;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);
        if (slot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));


        }

        return multimap;
    }


}
