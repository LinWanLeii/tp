package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ORDERS;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Order;
import seedu.address.model.order.Status;
import seedu.address.model.person.Person;

/**
 * Edits the details of an existing person in the address book.
 */
public class UpdateStatusCommand extends Command {

    public static final String COMMAND_WORD = "updates";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the Status of the order identified "
            + "by the order number used in the displayed order list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_STATUS + "NAME] \n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_STATUS + "PENDING/PREPARING/COMPLETED/OTHERS ";

    public static final String MESSAGE_EDIT_ORDER_STATUS_SUCCESS = "Edited Order Status: %1$s";
    public static final String MESSAGE_NOT_EDITED = "Status to edit to must be provided.";
    public static final String MESSAGE_DUPLICATE_ORDER = "Operation would result in duplicate order";

    private final Index index;
    private final EditOrderDescriptor editOrderDescriptor;

    /**
     * @param index of the order in the filtered order list to edit
     * @param editOrderDescriptor details to edit the order with
     */
    public UpdateStatusCommand(Index index, EditOrderDescriptor editOrderDescriptor) {
        requireNonNull(index);
        requireNonNull(editOrderDescriptor);

        this.index = index;
        this.editOrderDescriptor = new EditOrderDescriptor(editOrderDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Order> lastShownList = model.getFilteredOrderList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ORDER_DISPLAYED_INDEX);
        }

        Order orderToEdit = lastShownList.get(index.getZeroBased());
        Order editedOrder = createEditedOrder(orderToEdit, editOrderDescriptor);

        if (!orderToEdit.isSameOrder(editedOrder) && model.hasOrder(editedOrder)) {
            throw new CommandException(MESSAGE_DUPLICATE_ORDER);
        }

        model.setOrder(orderToEdit, editedOrder);
        model.updateFilteredOrderList(PREDICATE_SHOW_ALL_ORDERS);
        return new CommandResult(String.format(MESSAGE_EDIT_ORDER_STATUS_SUCCESS, Messages.format(editedOrder)));
    }

    /**
     * Creates and returns a {@code Order} with the details of {@code orderToEdit}
     * edited with {@code editOrderDescriptor}.
     */
    private static Order createEditedOrder(Order orderToEdit, EditOrderDescriptor editOrderDescriptor) {
        assert orderToEdit != null;

        int updatedOrderNumber = editOrderDescriptor.getOrderNumber().orElse(orderToEdit.getOrderNumber());
        Person updatedPerson = editOrderDescriptor.getPerson().orElse(orderToEdit.getPerson());
        String updatedMedicineName = editOrderDescriptor.getMedicineName().orElse(orderToEdit.getMedicineName());
        Status updatedStatus = editOrderDescriptor.getStatus().orElse(orderToEdit.getStatus());

        return new Order(updatedOrderNumber, updatedPerson, updatedMedicineName, updatedStatus);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UpdateStatusCommand)) {
            return false;
        }

        UpdateStatusCommand otherEditCommand = (UpdateStatusCommand) other;
        return index.equals(otherEditCommand.index)
                && editOrderDescriptor.equals(otherEditCommand.editOrderDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("editOrderDescriptor", editOrderDescriptor)
                .toString();
    }

    /**
     * Stores the details to edit the order with. Each non-empty field value will replace the
     * corresponding field value of the order.
     */
    public static class EditOrderDescriptor {
        private int orderNumber;
        private Person person;
        private String medicineName;
        private Status status;

        public EditOrderDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditOrderDescriptor(EditOrderDescriptor toCopy) {
            setOrderNumber(toCopy.orderNumber);
            setPerson(toCopy.person);
            setMedicineName(toCopy.medicineName);
            setStatus(toCopy.status);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(orderNumber, person, medicineName, status);
        }

        public void setOrderNumber(int orderNumber) {
            this.orderNumber = orderNumber;
        }

        public Optional<Integer> getOrderNumber() {
            return Optional.ofNullable(orderNumber);
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public Optional<Person> getPerson() {
            return Optional.ofNullable(person);
        }

        public void setMedicineName(String medicineName) {
            this.medicineName = medicineName;
        }

        public Optional<String> getMedicineName() {
            return Optional.ofNullable(medicineName);
        }

        public void setStatus(Status orderStatus) {
            this.status = orderStatus;
        }

        public Optional<Status> getStatus() {
            return Optional.ofNullable(status);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditOrderDescriptor)) {
                return false;
            }

            EditOrderDescriptor otherEditOrderDescriptor = (EditOrderDescriptor) other;
            return Objects.equals(orderNumber, otherEditOrderDescriptor.orderNumber)
                    && Objects.equals(person, otherEditOrderDescriptor.person)
                    && Objects.equals(medicineName, otherEditOrderDescriptor.medicineName)
                    && Objects.equals(status, otherEditOrderDescriptor.status);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("orderNumber", orderNumber)
                    .add("person", person)
                    .add("medicineName", medicineName)
                    .add("status", status)
                    .toString();
        }
    }
}
