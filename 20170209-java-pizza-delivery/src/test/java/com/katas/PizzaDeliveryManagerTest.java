package com.katas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PizzaDeliveryManagerTest {

    @Mock
    OrderRepository orderRepositoryMock;

    @Captor
    private ArgumentCaptor<Order> orderArgumentCaptor;

    @Test
    public void takeOrder_should_create_and_return_new_order() throws Exception {
        // Arrange
        PizzaDeliveryManager pizzaDeliveryManager = new PizzaDeliveryManager(orderRepositoryMock);
        Order persistedOrder = new Order();
        when(orderRepositoryMock.save(Matchers.any())).thenReturn(persistedOrder);

        // Act
        TakeOrderCommand takeOrderCommand = new TakeOrderCommand("John Doe", "999-888777666", "St. Anderson Street", "Hawaian", 1);
        Order order = pizzaDeliveryManager.takeOrder(takeOrderCommand);

        // Assert
        verify(orderRepositoryMock).save(orderArgumentCaptor.capture());
        Order capturedOrder = orderArgumentCaptor.getValue();
        assertThat(capturedOrder.getName(), is("John Doe"));

        assertThat(order, is(persistedOrder));
    }

}
