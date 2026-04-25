package com.footdablit2310.footeconomy;

import java.util.UUID;

public class EconomyManager {

    private final WalletStorage storage = new WalletStorage();

    public int getBalance(UUID player) {
        return storage.getBalance(player);
    }

    public boolean hasBalance(UUID player, int amount) {
        return storage.getBalance(player) >= amount;
    }

    public int deposit(UUID player, int amount) {
        if (amount <= 0) {
            return storage.getBalance(player);
        }
        return storage.addBalance(player, amount);
    }

    public boolean withdraw(UUID player, int amount) {
        if (amount <= 0) {
            return false;
        }
        int current = storage.getBalance(player);
        if (current < amount) {
            return false;
        }
        storage.addBalance(player, -amount);
        return true;
    }
}