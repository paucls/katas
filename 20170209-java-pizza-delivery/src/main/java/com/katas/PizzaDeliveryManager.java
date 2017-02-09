package com.katas;

public class PizzaDeliveryManager {

    private final OrderRepository orderRepository;

    public PizzaDeliveryManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order takeOrder(TakeOrderCommand takeOrderCommand) {
        Order order = new Order();
        order.setName(takeOrderCommand.getName());

        return orderRepository.save(order);
    }
}
