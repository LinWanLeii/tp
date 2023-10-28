package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewOrderCommand;


class ViewOrderCommandParserTest {
    private ViewOrderCommandParser parser = new ViewOrderCommandParser();

    @Test
    public void parse_validArgs_returnsViewOrderCommand() {
        assertParseSuccess(parser, "1", new ViewOrderCommand("1"));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewOrderCommand.MESSAGE_USAGE));
    }

}
