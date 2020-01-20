package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.google.common.collect.Multimap;
import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.enchantment.Enchantment;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;

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
