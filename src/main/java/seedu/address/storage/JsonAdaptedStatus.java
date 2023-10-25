package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.Status;

/**
 * Jackson-friendly version of {@link Status}.
 */
class JsonAdaptedStatus {

    private final String orderStatus;

    /**
     * Constructs a {@code JsonAdaptedStatus} with the given {@code orderStatus}.
     */
    @JsonCreator
    public JsonAdaptedStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Converts a given {@code Status} into this class for Jackson use.
     */
    public JsonAdaptedStatus(Status source) {
        this.orderStatus = source.getStatus().toString();
    }

    @JsonValue
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Converts this Jackson-friendly adapted Status object into the model's {@code Status} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted status.
     */
    public Status toModelType() throws IllegalValueException {
        if (!Status.isValidOrderStatus(orderStatus)) {
            throw new IllegalValueException(Status.MESSAGE_CONSTRAINTS);
        }
        return new Status(Status.OrderStatus.valueOf(orderStatus));
    }

}
