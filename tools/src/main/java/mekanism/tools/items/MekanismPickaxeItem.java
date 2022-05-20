package mekanism.tools.items;

import mekanism.tools.material.BaseMekanismMaterial;
import mekanism.tools.utils.ToolsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MekanismPickaxeItem extends PickaxeItem {

    private final BaseMekanismMaterial material;

    public MekanismPickaxeItem(BaseMekanismMaterial material, Properties settings) {
        super(material, (int) material.getPickaxeDamage(), material.getPickaxeAtkSpeed(), settings);

        this.material = material;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);

        ToolsUtils.addDurability(tooltip, stack);
    }

    @Override
    public float getAttackDamage() {
        return material.getPickaxeDamage() + getTier().getAttackDamageBonus();
    }
}
