package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_IGNORE_ALLERGY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEDICINENAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERNUMBER;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddOrderCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.OrderNumber;


/**
 * Parses input arguments and creates a new AddOrderCommand object.
 */
public class AddOrderCommandParser implements Parser<AddOrderCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddOrderCommand
     * and returns an AddOrderCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddOrderCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_ORDERNUMBER, PREFIX_MEDICINENAME, PREFIX_IGNORE_ALLERGY);

        if (argMultimap.getPreamble().isEmpty()
            || argMultimap.getValue(PREFIX_MEDICINENAME).orElse("").isEmpty()
            || argMultimap.getValue(PREFIX_ORDERNUMBER).orElse("").isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddOrderCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_ORDERNUMBER, PREFIX_MEDICINENAME);

        Index index = ParserUtil.parseIndex(argMultimap.getPreamble());

        OrderNumber orderNumber = ParserUtil.parseOrderNumber(argMultimap.getValue(PREFIX_ORDERNUMBER).get());

        Boolean ignoreAllergy = false;
        if (argMultimap.getValue(PREFIX_IGNORE_ALLERGY).isPresent()) {
            ignoreAllergy = true;
        }

        return new AddOrderCommand(index, orderNumber, argMultimap.getValue(PREFIX_MEDICINENAME).get(), ignoreAllergy);

    }

}
