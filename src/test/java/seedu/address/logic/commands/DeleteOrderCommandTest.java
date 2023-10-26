package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showOrderAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.order.Order;



class DeleteOrderCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Order orderToDelete = model.getFilteredOrderList().get(INDEX_FIRST.getZeroBased());
        DeleteOrderCommand deleteOrderCommand = new DeleteOrderCommand(INDEX_FIRST);

        String expectedMessage = String.format(DeleteOrderCommand.MESSAGE_DELETE_ORDER_SUCCESS,
                Messages.formatOrder(orderToDelete));

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteOrder(orderToDelete);

        assertCommandSuccess(deleteOrderCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredOrderList().size() + 1);
        DeleteOrderCommand deleteOrderCommand = new DeleteOrderCommand(outOfBoundIndex);

        assertCommandFailure(deleteOrderCommand, model, Messages.MESSAGE_INVALID_ORDER_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showOrderAtIndex(model, INDEX_FIRST);

        Order orderToDelete = model.getFilteredOrderList().get(INDEX_FIRST.getZeroBased());
        DeleteOrderCommand deleteOrderCommand = new DeleteOrderCommand(INDEX_FIRST);

        String expectedMessage = String.format(DeleteOrderCommand.MESSAGE_DELETE_ORDER_SUCCESS,
                Messages.formatOrder(orderToDelete));

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteOrder(orderToDelete);
        showNoOrder(expectedModel);

        assertCommandSuccess(deleteOrderCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showOrderAtIndex(model, INDEX_FIRST);

        Index outOfBoundIndex = INDEX_SECOND;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getOrderList().size());

        DeleteOrderCommand deleteOrderCommand = new DeleteOrderCommand(outOfBoundIndex);

        assertCommandFailure(deleteOrderCommand, model, Messages.MESSAGE_INVALID_ORDER_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeleteOrderCommand deleteFirstOrderCommand = new DeleteOrderCommand(INDEX_FIRST);
        DeleteOrderCommand deleteSecondOrderCommand = new DeleteOrderCommand(INDEX_SECOND);

        // same object -> returns true
        assertTrue(deleteFirstOrderCommand.equals(deleteFirstOrderCommand));

        // same values -> returns true
        DeleteOrderCommand deleteFirstOrderCommandCopy = new DeleteOrderCommand(INDEX_FIRST);
        assertTrue(deleteFirstOrderCommand.equals(deleteFirstOrderCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstOrderCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstOrderCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteFirstOrderCommand.equals(deleteSecondOrderCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        DeleteOrderCommand deleteOrderCommand = new DeleteOrderCommand(targetIndex);
        String expected = DeleteOrderCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, deleteOrderCommand.toString());
    }


    /**
     * Updates {@code model}'s filtered order list to show nothing.
     */
    private void showNoOrder(Model model) {
        model.updateFilteredOrderList(p -> false);

        assertTrue(model.getFilteredOrderList().isEmpty());
    }

}
