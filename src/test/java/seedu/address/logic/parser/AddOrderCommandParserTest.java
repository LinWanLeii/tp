package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEDICINENAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERNUMBER;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddOrderCommand;
import seedu.address.model.order.OrderNumber;


class AddOrderCommandParserTest {

    private static final String VALID_ORDERNUMBER = PREFIX_ORDERNUMBER + " 1 ";
    private static final String INVALID_ORDERNUMBER_NEGATIVE = PREFIX_ORDERNUMBER + "  -1 ";

    private static final String INVALID_ORDERNUMBER = PREFIX_ORDERNUMBER + " asd ";

    private static final String VALID_MEDICINE_NAME = PREFIX_MEDICINENAME + " panadol ";

    private static final String INVALID_MEDICINE_NAME = PREFIX_MEDICINENAME + " ";


    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddOrderCommand.MESSAGE_USAGE);

    private final Parser<AddOrderCommand> parser = new AddOrderCommandParser();

    @Test
    public void parse_missingParts_failure() {

        //Missing index
        assertParseFailure(parser, VALID_ORDERNUMBER + VALID_MEDICINE_NAME, MESSAGE_INVALID_FORMAT);

        //Missing orderNumber
        assertParseFailure(parser, "1 " + VALID_MEDICINE_NAME, MESSAGE_INVALID_FORMAT);

        //Missing medicineName
        assertParseFailure(parser, "1 " + VALID_MEDICINE_NAME, MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5 " + VALID_ORDERNUMBER + VALID_MEDICINE_NAME, MESSAGE_INVALID_INDEX);

        // zero index
        assertParseFailure(parser, "0 " + VALID_ORDERNUMBER + VALID_MEDICINE_NAME, MESSAGE_INVALID_INDEX);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string " + VALID_ORDERNUMBER + VALID_MEDICINE_NAME,
                MESSAGE_INVALID_INDEX);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string ", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1 " + INVALID_ORDERNUMBER_NEGATIVE + VALID_MEDICINE_NAME,
                OrderNumber.MESSAGE_CONSTRAINTS); // invalid orderNumber

        assertParseFailure(parser, "1 " + VALID_ORDERNUMBER + INVALID_MEDICINE_NAME,
                            MESSAGE_INVALID_FORMAT); // invalid medicineName

        assertParseFailure(parser, "1 " + INVALID_ORDERNUMBER + VALID_MEDICINE_NAME,
                OrderNumber.MESSAGE_CONSTRAINTS); // invalid orderNumber

        AddOrderCommand expectedCommand = new AddOrderCommand(Index.fromOneBased(1),
                new OrderNumber("1"), "panadol", false);


        assertParseSuccess(parser, "1 " + VALID_ORDERNUMBER + VALID_MEDICINE_NAME, expectedCommand);

    }

    @Test
    public void parse_containsIgnoreAllergy_success() {
        AddOrderCommand expectedCommand = new AddOrderCommand(Index.fromOneBased(1),
                new OrderNumber("1"), "panadol", true);
        assertParseSuccess(parser, "1 " + VALID_ORDERNUMBER + VALID_MEDICINE_NAME + " ia/", expectedCommand);
    }

}
