package gigaherz.survivalist.integration.drying;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import javax.annotation.Nonnull;

public class DryingRecipeHandler implements IRecipeHandler<DryingRecipeWrapper>
{
    @Nonnull
    @Override
    public Class<DryingRecipeWrapper> getRecipeClass()
    {
        return DryingRecipeWrapper.class;
    }

    @Deprecated
    @Nonnull
    @Override
    public String getRecipeCategoryUid()
    {
        return DryingCategory.UID;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull DryingRecipeWrapper recipe)
    {
        return getRecipeCategoryUid();
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull DryingRecipeWrapper recipe)
    {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull DryingRecipeWrapper recipe)
    {
        return true;
    }
}
