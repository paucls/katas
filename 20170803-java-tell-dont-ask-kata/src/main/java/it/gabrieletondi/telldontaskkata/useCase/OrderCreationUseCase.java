package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.domain.OrderItem;
import it.gabrieletondi.telldontaskkata.domain.OrderStatus;
import it.gabrieletondi.telldontaskkata.domain.Product;
import it.gabrieletondi.telldontaskkata.repository.OrderRepository;
import it.gabrieletondi.telldontaskkata.repository.ProductCatalog;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

public class OrderCreationUseCase {
    private final OrderRepository orderRepository;
    private final ProductCatalog productCatalog;

    public OrderCreationUseCase(OrderRepository orderRepository, ProductCatalog productCatalog) {
        this.orderRepository = orderRepository;
        this.productCatalog = productCatalog;
    }

    public void run(SellItemsRequest request) {
        Order order = new Order();

        for (SellItemRequest itemRequest : request.getRequests()) {
            Product product = productCatalog.getByName(itemRequest.getProductName());

            if (product == null) {
                throw new UnknownProductException();
            }
            else {

                final OrderItem orderItem = new OrderItem(product, itemRequest.getQuantity());

                applyTax(orderItem);

                order.addItem(orderItem);
            }
        }

        orderRepository.save(order);
    }

    private void applyTax(OrderItem orderItem) {
        final BigDecimal taxAmount = calculateTaxAmount(orderItem.getQuantity(), orderItem.getProduct());
        final BigDecimal taxedAmount = calculateTaxedAmount(orderItem.getQuantity(), orderItem.getProduct());

        orderItem.setTax(taxAmount);
        orderItem.setTaxedAmount(taxedAmount);
    }

    private BigDecimal calculateTaxAmount(int itemQuantity, Product product) {
        return calculateUnitaryTax(product).multiply(BigDecimal.valueOf(itemQuantity));
    }

    private BigDecimal calculateTaxedAmount(int itemQuantity, Product product) {
        final BigDecimal unitaryTaxedAmount = product.getPrice().add(calculateUnitaryTax(product)).setScale(2, HALF_UP);
        return unitaryTaxedAmount.multiply(BigDecimal.valueOf(itemQuantity)).setScale(2, HALF_UP);
    }

    private BigDecimal calculateUnitaryTax(Product product) {
        return product.getPrice().divide(valueOf(100))
                .multiply(product.getCategory().getTaxPercentage()).setScale(2, HALF_UP);
    }
}
