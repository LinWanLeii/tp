package seedu.address.testutil;

import seedu.address.logic.commands.UpdateStatusCommand.EditOrderDescriptor;
import seedu.address.model.order.Order;
import seedu.address.model.order.Status;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditOrderDescriptorBuilder {

    private EditOrderDescriptor descriptor;

    public EditOrderDescriptorBuilder() {
        descriptor = new EditOrderDescriptor();
    }

    public EditOrderDescriptorBuilder(EditOrderDescriptor descriptor) {
        this.descriptor = new EditOrderDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditOrderDescriptorBuilder(Order order) {
        descriptor = new EditOrderDescriptor();
        descriptor.setOrderNumber(order.getOrderNumber());
        descriptor.setPerson(order.getPerson());
        descriptor.setMedicineName(order.getMedicineName());
        descriptor.setStatus(order.getStatus());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditOrderDescriptorBuilder withStatus(String status) {
        descriptor.setStatus(new Status(Status.toOrderStatus(status)));
        return this;
    }

    public EditOrderDescriptor build() {
        return descriptor;
    }
}
