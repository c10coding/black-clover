package net.dohaw.blackclover.grimmoire.spell;

import lombok.Getter;
import net.dohaw.blackclover.Wrapper;
import net.dohaw.blackclover.config.GrimmoireConfig;
import net.dohaw.blackclover.playerdata.PlayerData;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public abstract class SpellWrapper extends Wrapper<SpellType> {

    @Getter
    protected int hotbarSlot;

    protected ItemStack spellBoundItem;

    @Getter
    protected double cooldown;

    /**
     * This could be mana or in the Anti grimmoires case, souls
     */
    @Getter
    protected double regenConsumed;

    @Getter
    private String spellBoundItemKey;

    protected GrimmoireConfig grimmoireConfig;

    public SpellWrapper(SpellType spellType, String spellBoundItemKey, GrimmoireConfig grimmoireConfig) {
        super(spellType);
        this.spellBoundItemKey = spellBoundItemKey;
        this.grimmoireConfig = grimmoireConfig;
        loadSettings();
        this.spellBoundItem = createSpellBoundItem();
    }

    public ItemStack getSpellBoundItem(){
        return spellBoundItem.clone();
    }

    public NamespacedKey nsk(){
        return NamespacedKey.minecraft(KEY.getConfigKey());
    }

    public abstract void cast(PlayerData pd);

    public abstract void loadSettings();

    public abstract ItemStack createSpellBoundItem();

}
