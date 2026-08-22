package com.burning_sulphur.manual_hammers.item;

import com.burning_sulphur.manual_hammers.ManualHammers;
import com.evandev.manual_labour.content.item.HammerItem;
import net.enderitemc.enderitemod.materials.EnderiteMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

import com.kwpugh.gobber2.lists.ToolMaterialTiers;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ManualHammers.MOD_ID);

    //public static final DeferredItem<Item> TEST_HAMMER = ITEMS.register("test_hammer", () -> new HammerItem(Tiers.IRON, 6.0f, -3.1f, new Item.Properties()));

    //-----------------------------------------ADDING HAMMERS----------------------------------------
    /*
    Note to add a hammer:
     1. first add the cursemaven snippet for the mod
     2. Make the Hammer here - import the material tier
     3. add it to the creative menu in ManualHammers
     4. Add the name to the Lang Files
     5. Add to list in ModItemTagProvider
     5. Add to list in ModItemModelProvider
     6. Add item texture in assets/manual_hammers/textures/item
     7. add recipe




     */

    public static final DeferredItem<Item> CRYSTALLINE_HAMMER = ModList.get().isLoaded("phantasm")
            ? ITEMS.register("crystalline_hammer", () -> new HammerItem(net.lyof.phantasm.item.ModTiers.CRYSTALLINE, 6.0f, -3.1f, new Item.Properties()))
            : null;
    public static final DeferredItem<Item> GOBBER_HAMMER = ModList.get().isLoaded("gobber2")
            ? ITEMS.register("gobber_hammer", () -> new HammerItem(ToolMaterialTiers.OVERWORLD_GOBBER, 6.0f, -3.1f, new Item.Properties()))
            : null;
    public static final DeferredItem<Item> GOBBER_HAMMER_NETHER = ModList.get().isLoaded("gobber2")
            ? ITEMS.register("gobber_hammer_nether", () -> new HammerItem(ToolMaterialTiers.NETHER_GOBBER, 6.0f, -3.1f, new Item.Properties()))
            : null;
    public static final DeferredItem<Item> GOBBER_HAMMER_END = ModList.get().isLoaded("gobber2")
            ? ITEMS.register("gobber_hammer_end", () -> new HammerItem(ToolMaterialTiers.END_GOBBER, 6.0f, -3.1f, new Item.Properties()))
            : null;
    public static final DeferredItem<Item> ENDERITE_HAMMER = ModList.get().isLoaded("enderitemod")
            ? ITEMS.register("enderite_hammer", () -> new HammerItem(EnderiteMaterial.ENDERITE, 6.0f, -3.1f, new Item.Properties()))
            : null;

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
