package com.burning_sulphur.manual_hammers.item;

import com.burning_sulphur.manual_hammers.ManualHammers;
import com.evandev.manual_labour.content.item.HammerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ManualHammers.MOD_ID);

    public static final DeferredItem<Item> TEST_HAMMER = ITEMS.register("test_hammer", () -> new HammerItem(Tiers.IRON, 6.0f, -3.1f, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
