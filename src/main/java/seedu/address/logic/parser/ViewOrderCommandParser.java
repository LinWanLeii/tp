package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ViewOrderCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new ViewOrderCommand object
 */
public class ViewOrderCommandParser implements Parser<ViewOrderCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewOrderCommand
     * and returns a ViewOrderCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewOrderCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty() || !trimmedArgs.matches("^\\d+$")) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewOrderCommand.MESSAGE_USAGE));
        }

        return new ViewOrderCommand(trimmedArgs);
    }
}
