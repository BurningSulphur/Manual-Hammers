package com.burning_sulphur.manual_hammers.datagen;

import com.burning_sulphur.manual_hammers.ManualHammers;
import com.burning_sulphur.manual_hammers.item.ModItems;
import com.burning_sulphur.manual_hammers.util.ModTags;
import com.evandev.manual_labour.content.item.HammerItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.evandev.manual_labour.registry.ModTags.Items.HAMMERS;



public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ManualHammers.MOD_ID, existingFileHelper);
    }

    private static TagKey<Item> externalTag(String namespace, String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, path));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        List<ResourceLocation> hammerItems = new ArrayList<>();
        //--------------------------------------------------ADD HAMMERS HERE--------------------------------------------
        if (ModList.get().isLoaded("phantasm")) {
            hammerItems.add(ModItems.CRYSTALLINE_HAMMER.getId());
        }
        if (ModList.get().isLoaded("gobber2")) {
            hammerItems.add(ModItems.GOBBER_HAMMER.getId());
            hammerItems.add(ModItems.GOBBER_HAMMER_NETHER.getId());
            hammerItems.add(ModItems.GOBBER_HAMMER_END.getId());
        }
        if (ModList.get().isLoaded("enderitemod")) {
            hammerItems.add(ModItems.ENDERITE_HAMMER.getId());
        }




        //--------------------------------------------------------------------------------------------------------------


        for (ResourceLocation currentHammerItem: hammerItems) {

            tag(HAMMERS).addOptional(currentHammerItem);//evans tag
            tag(ModTags.Items.TOOLS_HAMMER).addOptional(currentHammerItem);//my tag putting it in c:tools/hammers
            tag(Tags.Items.TOOLS).addOptional(currentHammerItem);//neoforge tag c:tools
            tag(ItemTags.DURABILITY_ENCHANTABLE).addOptional(currentHammerItem);//vanilla tag
            tag(ItemTags.MINING_LOOT_ENCHANTABLE).addOptional(currentHammerItem);//vanilla tag
            tag(ItemTags.MINING_ENCHANTABLE).addOptional(currentHammerItem); //vanilla tag
            tag(ItemTags.CLUSTER_MAX_HARVESTABLES).addOptional(currentHammerItem); //vanilla tag
        }



        tag(externalTag("phantasm", "gets_xp_speed_boost"))
                .addOptional(ModItems.CRYSTALLINE_HAMMER.getId());


        tag(externalTag("enderitemod", "enderite_tools"))
                .addOptional(ModItems.ENDERITE_HAMMER.getId());
        tag(externalTag("enderitemod", "enderite_items"))
                .addOptional(ModItems.ENDERITE_HAMMER.getId());


    }



}