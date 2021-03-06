package gigaherz.survivalist.integration.chopping;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import javax.annotation.Nonnull;

public class ChoppingRecipeHandler implements IRecipeHandler<ChoppingRecipeWrapper>
{
    @Nonnull
    @Override
    public Class<ChoppingRecipeWrapper> getRecipeClass()
    {
        return ChoppingRecipeWrapper.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull ChoppingRecipeWrapper recipe)
    {
        return ChoppingCategory.UID;
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull ChoppingRecipeWrapper recipe)
    {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull ChoppingRecipeWrapper recipe)
    {
        return true;
    }
}
