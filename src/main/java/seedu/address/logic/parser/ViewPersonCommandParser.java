package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new ViewPersonCommand object
 */
public class ViewPersonCommandParser implements Parser<ViewPersonCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ViewPersonCommand
     * and returns a ViewPersonCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewPersonCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ViewPersonCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewPersonCommand.MESSAGE_USAGE), pe);
        }
    }
}
