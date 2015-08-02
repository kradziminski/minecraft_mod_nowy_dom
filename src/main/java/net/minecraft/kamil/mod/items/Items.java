package net.minecraft.kamil.mod.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Items {
    public static Item tutorialItem = new BasicItem("tutorial_item");

    public static void createItems() {
        GameRegistry.registerItem(tutorialItem, "tutorial_item"); // mod_kamila:tutorial_item
        // /give @p mod_kamila:tutorial_item
    }
}
