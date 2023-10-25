package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Order;
import seedu.address.model.order.OrderNumber;


/**
 * Deletes an order identified using it's order number from the address book.
 */
public class DeleteOrderCommand extends Command {
    public static final String COMMAND_WORD = "deleteo";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the order identified by the order number given.\n"
            + "Parameters: ORDERNUMBER (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_ORDER_SUCCESS = "Deleted Order: %1$s";

    private final OrderNumber orderNumber;

    public DeleteOrderCommand(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredOrderList(Model.PREDICATE_SHOW_ALL_ORDERS);
        List<Order> orderList = model.getFilteredOrderList();
        Optional<Order> order = orderList.stream().filter(x -> x.getOrderNumber().equals(orderNumber)).findFirst();

        if (order.isEmpty()) {
            throw new CommandException(String.format(Messages.MESSAGE_NO_ORDER_WITH_GIVEN_ORDER_NUMBER,
                    orderNumber.toString()));
        }

        model.deleteOrder(order.get());
        return new CommandResult(String.format(MESSAGE_DELETE_ORDER_SUCCESS, orderNumber.toString()));

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeleteOrderCommand)) {
            return false;
        }

        DeleteOrderCommand otherDeleteOrderCommand = (DeleteOrderCommand) other;

        return orderNumber.equals(otherDeleteOrderCommand.orderNumber);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("orderNumber", orderNumber).toString();
    }


}
