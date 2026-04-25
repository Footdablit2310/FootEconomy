package com.footdablit2310.footeconomy;

import com.footdablit2310.footlib.api.shared.foot_economy.BalanceProvider;
import com.footdablit2310.footlib.api.shared.foot_economy.Currency;
import com.footdablit2310.footlib.api.shared.foot_economy.TransactionResult;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimpleBalanceProvider implements BalanceProvider {

    private final Map<UUID, Long> balances = new HashMap<>();

    @Override
    public long getBalance(Player player, Currency currency) {
        return balances.getOrDefault(player.getUUID(), 0L);
    }

    @Override
    public void setBalance(Player player, Currency currency, long amount) {
        balances.put(player.getUUID(), amount);
    }

    @Override
    public TransactionResult deposit(Player player, Currency currency, long amount) {
        if (amount <= 0) {
            return TransactionResult.failure("Amount must be positive", getBalance(player, currency));
        }

        long current = getBalance(player, currency);
        long newBalance = current + amount;

        setBalance(player, currency, newBalance);
        return TransactionResult.success(newBalance);
    }

    @Override
    public TransactionResult withdraw(Player player, Currency currency, long amount) {
        if (amount <= 0) {
            return TransactionResult.failure("Amount must be positive", getBalance(player, currency));
        }

        long current = getBalance(player, currency);
        if (current < amount) {
            return TransactionResult.failure("Insufficient funds", current);
        }

        long newBalance = current - amount;
        setBalance(player, currency, newBalance);

        return TransactionResult.success(newBalance);
    }
}