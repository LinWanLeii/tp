package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;


class ViewPersonCommandTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_validIndexUnfilteredList_success() {
        ViewPersonCommand command = new ViewPersonCommand(INDEX_FIRST_PERSON);
        Person expectedPerson = model.getAddressBook().getPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        String expectedMessage = String.format(
                ViewPersonCommand.MESSAGE_VIEW_ORDER_SUCCESS,
                expectedPerson.getName().fullName);
        CommandResult expectedCommandResult = new CommandResult(
                expectedMessage,
                expectedPerson);
        assertCommandSuccess(command, model, expectedCommandResult, model);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        ViewPersonCommand viewPersonCommand = new ViewPersonCommand(outOfBoundIndex);

        assertCommandFailure(viewPersonCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        ViewPersonCommand viewFirstPersonCommand = new ViewPersonCommand(INDEX_FIRST_PERSON);

        // same object -> returns true
        assertTrue(viewFirstPersonCommand.equals(viewFirstPersonCommand));

        // same values -> returns true
        ViewPersonCommand viewFirstPersonCommandCopy = new ViewPersonCommand(INDEX_FIRST_PERSON);
        assertTrue(viewFirstPersonCommand.equals(viewFirstPersonCommandCopy));

        // different types -> returns false
        assertFalse(viewFirstPersonCommand.equals(1));

        // null -> returns false
        assertFalse(viewFirstPersonCommand.equals(null));

        // different person -> returns false
        assertFalse(viewFirstPersonCommand.equals(new ViewPersonCommand(INDEX_SECOND_PERSON)));
    }

    @Test
    public void toStringMethod() {
        ViewPersonCommand viewPersonCommand = new ViewPersonCommand(INDEX_FIRST_PERSON);
        String expected = ViewPersonCommand.class.getCanonicalName() + "{targetIndex=" + INDEX_FIRST_PERSON + "}";
        assertEquals(expected, viewPersonCommand.toString());
    }

}
