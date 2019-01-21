package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarehouseTest {

    private Warehouse warehouse;

    @Before
    public void setUp() {
        warehouse = new Warehouse();
    }

    @Test
    public void when_batch_of_CDs_received_should_indicate_success() {
        Batch batch = new Batch();

        String result = warehouse.receiveBatch(batch);

        assertThat(result).isEqualTo("SUCCESS");
    }

    @Test
    public void when_batch_containing_one_CD_received_should_update_CDs_stock() {
        Batch camelaBatch = new Batch("Camela VI", 1);

        warehouse.receiveBatch(camelaBatch);

        int stockCount = warehouse.stockCountOf("Camela VI");
        assertThat(stockCount).isEqualTo(1);
    }

    @Test
    public void when_batch_containing_several_CDs_received_should_update_CDs_stock() {
        Batch camelaBatch = new Batch("Camela X", 100);

        warehouse.receiveBatch(camelaBatch);

        int stockCount = warehouse.stockCountOf("Camela X");
        assertThat(stockCount).isEqualTo(100);
    }

    @Test
    public void when_batch_containing_several_CDs_of_diverse_titles_received_should_update_CDs_stock() {
        Batch batch = new Batch();
        batch.add("Camela Mix 2019", 50);
        batch.add("Black", 100);

        warehouse.receiveBatch(batch);

        assertThat(warehouse.stockCountOf("Camela Mix 2019")).isEqualTo(50);
        assertThat(warehouse.stockCountOf("Black")).isEqualTo(100);
    }
}
