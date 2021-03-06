package it.gabrieletondi.telldontaskkata.doubles;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class TestOrderRepository implements OrderRepository {
    private Order insertedOrder;
    private List<Order> orders = new ArrayList<>();

    //    test double method

    public Order getSavedOrder() {
        return insertedOrder;
    }

    @Override
    public void save(Order order) {
        this.insertedOrder = order;
    }

    @Override
    public Order getById(int orderId) {
        return orders.stream().filter(o -> o.getId() == orderId).findFirst().get();
    }

    //    test double method
    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
