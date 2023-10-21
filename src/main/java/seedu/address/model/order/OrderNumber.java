package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Order's order number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidOrderNumber(String)}
 */
public class OrderNumber {

    public static final String MESSAGE_CONSTRAINTS =
            "Order numbers should only contain numbers, and it should be at least 1 digit long";

    public static final String VALIDATION_REGEX = "\\d+";
    public final String value;


    /**
     * Constructs a {@code OrderNumber}.
     *
     * @param orderNumber A valid order number.
     */
    public OrderNumber(String orderNumber) {
        requireNonNull(orderNumber);
        checkArgument(isValidOrderNumber(orderNumber), MESSAGE_CONSTRAINTS);
        value = orderNumber;
    }

    /**
     * Returns true if a given string is a valid order number.
     */
    public static boolean isValidOrderNumber(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof OrderNumber)) {
            return false;
        }

        OrderNumber otherOrderNumber = (OrderNumber) other;
        return value.equals(otherOrderNumber.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

