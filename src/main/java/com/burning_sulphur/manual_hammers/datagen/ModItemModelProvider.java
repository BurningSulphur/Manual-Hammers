package com.burning_sulphur.manual_hammers.datagen;

import com.burning_sulphur.manual_hammers.ManualHammers;
import com.burning_sulphur.manual_hammers.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ManualHammers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        basicItem(ModItems.CRYSTALLINE_HAMMER.get()); //don't need to worry about if the mod is installed or not
        basicItem(ModItems.GOBBER_HAMMER.get());
        basicItem(ModItems.GOBBER_HAMMER_NETHER.get());
        basicItem(ModItems.GOBBER_HAMMER_END.get());
        basicItem(ModItems.ENDERITE_HAMMER.get());
    }
}
