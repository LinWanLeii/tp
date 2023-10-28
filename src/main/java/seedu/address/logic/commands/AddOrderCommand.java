package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEDICINENAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERNUMBER;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Order;
import seedu.address.model.order.OrderNumber;
import seedu.address.model.person.Person;

/**
 * A class which represents the adding of order command.
 */
public class AddOrderCommand extends Command {

    public static final String COMMAND_WORD = "addorder";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an order to the person identified "
            + "by the index number used in the displayed person list. \n "
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_ORDERNUMBER + "ORDERNUMBER"
            + PREFIX_MEDICINENAME + "MEDICINENAME \n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_ORDERNUMBER + "91234567 "
            + PREFIX_MEDICINENAME + "panadol";

    public static final String MESSAGE_SUCCESS = "Order added successfully.";

    public static final String MESSAGE_DUPLICATE_ORDER = "This order already exists in the address book";

    private final Index index;
    private final OrderNumber orderNumber;
    private final String medicineName;

    private final Boolean ignoreAllergy;


    /**
     * @param index        of the person in the filtered person to edit.
     * @param orderNumber  of the order.
     * @param medicineName represents the name of medicine.
     */
    public AddOrderCommand(Index index, OrderNumber orderNumber, String medicineName, Boolean ignoreAllergy) {
        requireAllNonNull(index, orderNumber, medicineName);
        this.index = index;
        this.orderNumber = orderNumber;
        this.medicineName = medicineName;
        this.ignoreAllergy = ignoreAllergy;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person person = lastShownList.get(index.getZeroBased());

        // If person is allergic to medicine and ignoreAllergy is false, throw exception
        if (person.isAllergicTo(medicineName) && !ignoreAllergy) {
            throw new CommandException(Messages.MESSAGE_ALLERGIC_TO_MEDICINE);
        }

        Order toAdd = new Order(orderNumber, person, medicineName);
        if (model.hasOrder(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_ORDER);
        }

        model.addOrder(toAdd);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddOrderCommand)) {
            return false;
        }

        AddOrderCommand otherAddCommand = (AddOrderCommand) other;
        return index.equals(otherAddCommand.index) && orderNumber.equals(otherAddCommand.orderNumber)
                && medicineName.equals(otherAddCommand.medicineName);
    }
}
