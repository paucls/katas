package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SnackMachineTest {

    private SnackMachine snackMachine;

    @Before
    public void setup() {
        snackMachine = new SnackMachine();
    }

    @Test
    public void initialized_with_0_coins_in_transaction() {
        assertThat(snackMachine.getAmountInTransaction(), is(0.0));
    }

    @Test
    public void insertCoin_should_add_coin_to_coins_in_transaction() {
        snackMachine.insertCoin(1.0);

        assertThat(snackMachine.getAmountInTransaction(), is(1.0));
    }

    @Test
    public void insertCoin_should_allow_different_types_of_counts() {
        snackMachine.insertCoin(1.0);
        snackMachine.insertCoin(0.20);

        assertThat(snackMachine.getAmountInTransaction(), is(1.20));
    }

    @Test
    public void insertCoin_should_not_add_invalid_coin_to_transactions() {
        snackMachine.insertCoin(0.25);

        assertThat(snackMachine.getAmountInTransaction(), is(0.0));
    }

    @Test
    public void returnMoneyBack_returns_coins_in_transaction() {
        snackMachine.insertCoin(1.0);
        snackMachine.insertCoin(1.0);
        snackMachine.insertCoin(0.20);

        HashMap<Double, Integer> returnedMoney = snackMachine.returnMoneyBack();

        assertThat(snackMachine.getAmountInTransaction(), is(0.0));

        assertThat(returnedMoney.get(1.0), is(2));
        assertThat(returnedMoney.get(0.20), is(1));
    }
}
