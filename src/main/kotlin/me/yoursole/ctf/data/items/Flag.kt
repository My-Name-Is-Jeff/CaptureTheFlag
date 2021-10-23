package me.yoursole.ctf.data.items

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

object Flag {
    val flag by lazy {
        val flag = ItemStack(Material.BLUE_BANNER)
        val meta = flag.itemMeta
        val lore: MutableList<String> = ArrayList()
        meta.setDisplayName(ChatColor.BLUE.toString() + "The Flag")
        lore.add(ChatColor.GOLD.toString() + "Keep me safe")
        lore.add(ChatColor.GOLD.toString() + "When I am in your inventory you get points")
        meta.lore = lore
        meta.isUnbreakable = true
        meta.setCustomModelData(1)
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        flag.itemMeta = meta
        return@lazy flag
    }
}