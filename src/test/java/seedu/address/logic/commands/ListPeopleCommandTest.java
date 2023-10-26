package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListPeopleCommand.
 */
public class ListPeopleCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        CommandResult expectedCommandResult = new CommandResult(
                ListPeopleCommand.MESSAGE_SUCCESS, CommandResult.ListPanelEffects.PERSON);
        assertCommandSuccess(new ListPeopleCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST);
        CommandResult expectedCommandResult = new CommandResult(
                ListPeopleCommand.MESSAGE_SUCCESS, CommandResult.ListPanelEffects.PERSON);
        assertCommandSuccess(new ListPeopleCommand(), model, expectedCommandResult, expectedModel);
    }
}
