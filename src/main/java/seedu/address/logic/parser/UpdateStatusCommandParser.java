package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UpdateStatusCommand;
import seedu.address.logic.commands.UpdateStatusCommand.EditOrderDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class UpdateStatusCommandParser implements Parser<UpdateStatusCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UpdateStatusCommand
     * and returns an UpdateStatusCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UpdateStatusCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STATUS);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UpdateStatusCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_STATUS);

        EditOrderDescriptor editOrderDescriptor = new EditOrderDescriptor();

        if (argMultimap.getValue(PREFIX_STATUS).isPresent()) {
            editOrderDescriptor.setStatus(ParserUtil.parseStatus(argMultimap.getValue(PREFIX_STATUS).get()));
        }

        if (!editOrderDescriptor.isAnyFieldEdited()) {
            throw new ParseException(UpdateStatusCommand.MESSAGE_NOT_EDITED);
        }

        return new UpdateStatusCommand(index, editOrderDescriptor);
    }
}
