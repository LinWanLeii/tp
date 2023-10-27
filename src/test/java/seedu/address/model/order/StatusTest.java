package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
public class StatusTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Status(null));
    }
    @Test
    public void constructor_invalidStatusName_throwsIllegalArgumentException() {
        String invalidStatusName = "LOST";
        assertThrows(AssertionError.class, () -> new Status(Status.toOrderStatus(invalidStatusName)));
    }
    @Test
    public void equals_sameStatusObjects_returnsTrue() {
        Status status1 = new Status(Status.OrderStatus.PENDING);
        Status status2 = new Status(Status.OrderStatus.PENDING);
        assertEquals(status1, status2);
    }

    @Test
    public void equals_differentStatusObjects_returnsFalse() {
        Status status1 = new Status(Status.OrderStatus.PENDING);
        Status status2 = new Status(Status.OrderStatus.COMPLETED);
        assertNotEquals(status1, status2);
    }

    @Test
    public void hashCode_equalStatusObjects_returnsEqualHashCodes() {
        Status status1 = new Status(Status.toOrderStatus("PENDING"));
        Status status2 = new Status(Status.OrderStatus.PENDING);
        assertEquals(status1.hashCode(), status2.hashCode());
    }
    @Test
    public void toString_returnsCorrectStringRepresentation() {
        Status status = new Status(Status.OrderStatus.PREPARING);
        assertEquals("PREPARING", status.toString());
    }
}
