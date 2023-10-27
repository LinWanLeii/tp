package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;

/**
 * Represents a Status of a order.
 * Guarantees: Status is valid as declared in {@link #isValidOrderStatus(OrderStatus)}
 */
public class Status {
    /**
     * Represents the status that are available for the orders.
     */
    public enum OrderStatus {
        PENDING,
        PREPARING,
        COMPLETED,
        OTHERS
    }

    public static final String MESSAGE_CONSTRAINTS = "Order Status can only be"
            + OrderStatus.PENDING + OrderStatus.PREPARING + OrderStatus.COMPLETED + OrderStatus.OTHERS;
    private OrderStatus orderStatus;

    /**
     * Constructs a {@code Status}.
     *
     * @param orderStatus A valid status for an order.
     */
    public Status(OrderStatus orderStatus) {
        requireNonNull(orderStatus);
        assert isValidOrderStatus(orderStatus)
                : "OrderStatus can only be PENDING/PREPARING/COMPLETED/OTHERS";
        checkArgument(isValidOrderStatus(orderStatus), MESSAGE_CONSTRAINTS);
        this.orderStatus = orderStatus;
    }

    /**
     * Updates the Status of an order with newStatus.
     *
     * @param newStatus The new status of the order.
     */
    public void updateStatus(OrderStatus newStatus) {
        assert isValidOrderStatus(newStatus)
                : "Update on OrderStatus can only be PENDING/PREPARING/COMPLETED/OTHERS";
        checkArgument(isValidOrderStatus(newStatus), MESSAGE_CONSTRAINTS);
        orderStatus = newStatus;
    }
    /**
     * Converts String to order Status.
     *
     * @param status The status of the order.
     */
    public static OrderStatus toOrderStatus(String status) {
        assert isValidOrderStatus(status)
                : "OrderStatus can only be PENDING/PREPARING/COMPLETED/OTHERS";
        checkArgument(isValidOrderStatus(status), MESSAGE_CONSTRAINTS);
        for (OrderStatus validStatus : OrderStatus.values()) {
            if (validStatus.toString().equals(status.toUpperCase())) {
                return validStatus;
            }
        }
        return null;
    }

    /**
     * Gets the OrderStatus of the Status.
     *
     * @return The orderStatus.
     */
    public OrderStatus getStatus() {
        return orderStatus;
    }
    /**
     * Returns true if a given orderStatus is a valid status.
     */
    public static boolean isValidOrderStatus(OrderStatus orderStatus) {
        for (OrderStatus validStatus : OrderStatus.values()) {
            if (orderStatus == validStatus) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns true if a given orderStatus is a valid status.(For String)
     */
    public static boolean isValidOrderStatus(String orderStatus) {
        for (OrderStatus validStatus : OrderStatus.values()) {
            if (Objects.equals(validStatus.toString(), orderStatus)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Status)) {
            return false;
        }

        Status otherAllergy = (Status) other;
        return orderStatus.equals(otherAllergy.orderStatus);
    }

    @Override
    public int hashCode() {
        return orderStatus.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return orderStatus.toString();
    }

}
