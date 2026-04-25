package com.footdablit2310.footeconomy;

import com.footdablit2310.footlib.api.shared.foot_economy.*;
import net.minecraft.world.entity.player.Player;

public class FootEconomyAPIImpl implements EconomyAPI {

    private final CurrencyRegistry currencies = new CurrencyRegistry();
    private final BalanceProvider balances = new SimpleBalanceProvider();
    private final ExchangeRateProvider exchange = new SimpleExchangeRateProvider();
    private final AutoRateProvider auto = new SimpleAutoRateProvider();

    @Override
    public Currency defaultCurrency() {
        return currencies.get("foot:sek"); // or whatever your default is
    }

    @Override
    public CurrencyRegistry currencies() {
        return currencies;
    }

    @Override
    public BalanceProvider balances() {
        return balances;
    }

    @Override
    public ExchangeRateProvider exchange() {
        return exchange;
    }

    @Override
    public AutoRateProvider auto() {
        return auto;
    }
}