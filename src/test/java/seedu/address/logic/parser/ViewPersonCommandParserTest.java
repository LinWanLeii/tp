package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewPersonCommand;


class ViewPersonCommandParserTest {
    private ViewPersonCommandParser parser = new ViewPersonCommandParser();

    @Test
    public void parse_validArgs_returnsViewPersonCommand() {
        assertParseSuccess(
                parser,
                String.valueOf(INDEX_FIRST_PERSON.getOneBased()),
                new ViewPersonCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewPersonCommand.MESSAGE_USAGE));
    }

}
