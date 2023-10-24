package seedu.address.storage;

import static seedu.address.storage.JsonAdaptedOrder.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.OrderNumber;
import seedu.address.model.person.Person;

public class JsonAdaptedOrderTest {

    private static final String INVALID_ORDERNUMBER_NONINTEGER = "a234";
    private static final String INVALID_ORDERNUMBER_NEGATIVE = "-1234";

    private static final String VALID_ORDERNUMBER = "1234";

    private static final JsonAdaptedPerson VALID_PERSON = new JsonAdaptedPerson(BENSON);

    @Test
    public void toModelType_nonIntegerOrderNumber_throwsIllegalValueException() {
        JsonAdaptedOrder order = new JsonAdaptedOrder(INVALID_ORDERNUMBER_NONINTEGER,
                VALID_PERSON, "panadol");
        String expectedMessage = OrderNumber.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_negativeIntegerOrderNumber_throwsIllegalValueException() {
        JsonAdaptedOrder order = new JsonAdaptedOrder(INVALID_ORDERNUMBER_NEGATIVE,
                VALID_PERSON, "panadol");
        String expectedMessage = OrderNumber.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullOrderNumber_throwsIllegalValueException() {
        JsonAdaptedOrder order = new JsonAdaptedOrder(null,
                VALID_PERSON, "panadol");
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, OrderNumber.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullPerson_throwsIllegalValueException() {
        JsonAdaptedOrder order = new JsonAdaptedOrder(VALID_ORDERNUMBER,
                null, "panadol");
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Person.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullMedicineName_throwsIllegalValueException() {
        JsonAdaptedOrder order = new JsonAdaptedOrder(VALID_ORDERNUMBER,
                VALID_PERSON, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, "medicineName");
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }
}
