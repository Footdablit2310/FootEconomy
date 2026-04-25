package com.footdablit2310.footeconomy;

import com.footdablit2310.footlib.api.shared.foot_economy.AutoRateProvider;
import com.footdablit2310.footlib.api.shared.foot_economy.Currency;
import net.minecraft.world.entity.player.Player;

public class SimpleAutoRateProvider implements AutoRateProvider {

    private boolean autoMode = false;
    private double stability = 1.0;

    @Override
    public void updateRates() {
        // No-op for now — you can add real logic later
    }

    @Override
    public double getStability() {
        return stability;
    }

    @Override
    public void setStability(double stability) {
        this.stability = stability;
    }

    @Override
    public boolean isAutoMode() {
        return autoMode;
    }

    @Override
    public void setAutoMode(boolean autoMode) {
        this.autoMode = autoMode;
    }

    @Override
    public void recordTransaction(Player player, Currency currency, long amount) {
        // No-op for now — could be used to adjust rates dynamically
    }
}