package seedu.address.logic.parser;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.DeleteOrderCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteOrderCommandParser implements Parser<DeleteOrderCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteOrderCommand
     * and returns a DeleteOrderCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteOrderCommand parse(String args) throws ParseException {
        try {
            int orderNumber = Integer.parseInt(args.trim());
            return new DeleteOrderCommand(orderNumber);
        } catch (NumberFormatException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, DeleteOrderCommand.MESSAGE_USAGE), pe);
        }
    }
}
