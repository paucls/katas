package com.katas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SnackMachine {

	private double amountInTransaction = 0;
	private HashMap<Double, Integer> coinsInTransaction = new HashMap<>();

	public SnackMachine() {
		coinsInTransaction.put(0.01, 0);
		coinsInTransaction.put(0.02, 0);
		coinsInTransaction.put(0.05, 0);
		coinsInTransaction.put(0.10, 0);
		coinsInTransaction.put(0.20, 0);
		coinsInTransaction.put(0.50, 0);
		coinsInTransaction.put(1.00, 0);
		coinsInTransaction.put(2.00, 0);
	}

	public double getAmountInTransaction() {
		Double amount = 0.0;

		for (Map.Entry<Double, Integer> coin : coinsInTransaction.entrySet()) {
			amount =+ coin.getKey() * coin.getValue();
		}

		return amount;
	}

	public void insertCoin(double value) {
		if (coinsInTransaction.get(value) == null) {
			return;
		}

		amountInTransaction = amountInTransaction + value;

		coinsInTransaction.put(value, coinsInTransaction.get(value) + 1);
	}

	public HashMap<Double, Integer> returnMoneyBack() {
		amountInTransaction = 0;

		return coinsInTransaction;
	}
}
