package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderListTest {
    private List<Order> list;
    private OrderList orderList;

    private Order order;
    private final Status orderStatus = new Status(Status.OrderStatus.PENDING);
    @BeforeEach
    public void init() {
        order = new Order(new OrderNumber("1"), ALICE, "panadol", orderStatus);
        list = new ArrayList<>();
        list.add(order);
        orderList = new OrderList();
        orderList.add(order);
    }

    @Test
    public void setOrders() {
        OrderList newOrderList = new OrderList();
        newOrderList.setOrders(orderList);
        assertEquals(orderList, newOrderList);
    }

    @Test
    public void equals() {
        assertTrue(orderList.equals(orderList));

        assertFalse(orderList.equals(order));
    }

}
