package seedu.address.testutil;

import seedu.address.model.order.Order;
import seedu.address.model.order.Status;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building Person objects.
 */
public class OrderBuilder {

    public static final String DEFAULT_ORDER_NUMBER = "1234";
    public static final String DEFAULT_MEDICINE_NAME = "Panadol";
    public static final String DEFAULT_STATUS = "PENDING";
    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends")
            .withAllergies("Aspirin")
            .build();

    private int orderNumber;
    private Person person;
    private String medicineName;
    private Status status;
    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public OrderBuilder() {
        orderNumber = Integer.parseInt(DEFAULT_ORDER_NUMBER);
        person = ALICE;
        medicineName = DEFAULT_MEDICINE_NAME;
        status = new Status(Status.toOrderStatus(DEFAULT_STATUS));
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public OrderBuilder(Order orderToCopy) {
        orderNumber = orderToCopy.getOrderNumber();
        person = orderToCopy.getPerson();
        medicineName = orderToCopy.getMedicineName();
        status = orderToCopy.getStatus();
    }
    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public OrderBuilder withStatus(String status) {
        this.status = new Status(Status.toOrderStatus(status));
        return this;
    }
    public Order build() {
        return new Order(orderNumber, person, medicineName, status);
    }
}
