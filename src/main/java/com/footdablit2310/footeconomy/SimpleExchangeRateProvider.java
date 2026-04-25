package com.footdablit2310.footeconomy;

import com.footdablit2310.footlib.api.shared.foot_economy.Currency;
import com.footdablit2310.footlib.api.shared.foot_economy.ExchangeRateProvider;

import java.util.HashMap;
import java.util.Map;

public class SimpleExchangeRateProvider implements ExchangeRateProvider {

    private final Map<Currency, Double> rates = new HashMap<>();

    @Override
    public long convert(long amount, Currency from, Currency to) {
        double fromRate = rates.getOrDefault(from, 1.0);
        double toRate = rates.getOrDefault(to, 1.0);

        // Convert using simple proportional exchange
        double base = amount * fromRate;
        return (long) (base / toRate);
    }

    @Override
    public double getRate(Currency currency) {
        return rates.getOrDefault(currency, 1.0);
    }

    @Override
    public void setRate(Currency currency, double rate) {
        rates.put(currency, rate);
    }
}