package com.footdablit2310.footeconomy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WalletStorage {

    private final Map<UUID, Integer> balances = new HashMap<>();

    public int getBalance(UUID player) {
        return balances.getOrDefault(player, 0);
    }

    public int addBalance(UUID player, int amount) {
        int newBalance = getBalance(player) + amount;
        balances.put(player, newBalance);
        return newBalance;
    }
}