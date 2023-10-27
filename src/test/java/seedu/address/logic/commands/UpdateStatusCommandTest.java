package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.UpdateStatusCommand.EditOrderDescriptor;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.order.Order;
import seedu.address.testutil.EditOrderDescriptorBuilder;
import seedu.address.testutil.OrderBuilder;



/**
 * Contains integration tests (interaction with the Model) and unit tests for EditCommand.
 */
public class UpdateStatusCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        Order editedOrder = new OrderBuilder().withStatus("COMPLETED").build();
        EditOrderDescriptor descriptor = new EditOrderDescriptorBuilder(editedOrder).build();
        UpdateStatusCommand updateStatusCommand = new UpdateStatusCommand(INDEX_SECOND_PERSON, descriptor);

        String expectedMessage = String.format(
                UpdateStatusCommand.MESSAGE_EDIT_ORDER_STATUS_SUCCESS, Messages.format(editedOrder));

        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.setOrder(model.getFilteredOrderList().get(1), editedOrder);

        assertCommandSuccess(updateStatusCommand, model, expectedMessage, expectedModel);
    }
    @Test
    public void toStringMethod() {
        Index index = Index.fromOneBased(1);
        UpdateStatusCommand.EditOrderDescriptor editOrderDescriptor =
                new UpdateStatusCommand.EditOrderDescriptor();
        UpdateStatusCommand updateStatusCommand = new UpdateStatusCommand(index, editOrderDescriptor);
        String expected = UpdateStatusCommand.class.getCanonicalName() + "{index=" + index + ", editOrderDescriptor="
                + editOrderDescriptor + "}";
        assertEquals(expected, updateStatusCommand.toString());
    }
}
