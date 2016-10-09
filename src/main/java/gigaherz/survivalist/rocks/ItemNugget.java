package gigaherz.survivalist.rocks;

import gigaherz.survivalist.Survivalist;
import gigaherz.survivalist.api.state.IItemState;
import gigaherz.survivalist.api.state.ItemStateManager;
import gigaherz.survivalist.api.state.ItemStateful;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.List;

public class ItemNugget extends ItemStateful
{
    public static final PropertyEnum<Subtype> ORE = PropertyEnum.create("ore", Subtype.class);

    public ItemNugget(String name)
    {
        super(name);
        setHasSubtypes(true);
        setUnlocalizedName(Survivalist.MODID + ".nugget");
        setCreativeTab(CreativeTabs.MATERIALS);
        setStateManager(new ItemStateManager(this, ORE));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        IItemState state = getStateManager().get(stack.getMetadata());

        if (state == null)
            return getUnlocalizedName();

        String subName = state.getValue(ORE).getUnlocalizedSuffix();

        return "item." + Survivalist.MODID + subName;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (Subtype type : ORE.getAllowedValues())
        {
            IItemState state = getDefaultState().withProperty(ORE, type);
            subItems.add(state.getStack());
        }
    }

    public enum Subtype implements IStringSerializable
    {
        IRON("iron", ".iron_nugget"),
        COPPER("copper", ".copper_nugget"),
        TIN("tin", ".tin_nugget"),
        LEAD("lead", ".lead_nugget"),
        SILVER("silver", ".silver_nugget");

        final String name;
        final String unlocalizedSuffix;

        Subtype(String name, String unlocalizedSuffix)
        {
            this.name = name;
            this.unlocalizedSuffix = unlocalizedSuffix;
        }

        @Override
        public String getName()
        {
            return name;
        }

        public String getUnlocalizedSuffix()
        {
            return unlocalizedSuffix;
        }
    }
}
