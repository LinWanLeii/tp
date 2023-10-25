package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.order.Order;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";

    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_INVALID_ORDER_DISPLAYED_INDEX = "The order index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    public static final String MESSAGE_ALLERGIC_TO_MEDICINE = "Warning: This patient is allergic to this medicine! add"
            + " ia/ (ignore allergy) to the end of the command to add this medicine to the order anyway.";

    public static final String MESSAGE_NO_ORDER_WITH_GIVEN_ORDER_NUMBER =
            "There is no order with %1$s as order number.";


    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Tags: ");
        person.getTags().forEach(builder::append);
        builder.append("; Allergies: ");
        person.getAllergies().forEach(builder::append);
        return builder.toString();
    }
    /**
     * Formats the {@code order} for display to the user.
     */
    public static String format(Order order) {
        final StringBuilder builder = new StringBuilder();
        builder.append(order.getOrderNumber())
                .append("; Phone: ")
                .append(order.getPerson())
                .append("; Email: ")
                .append(order.getMedicineName())
                .append("; Address: ")
                .append(order.getStatus());
        return builder.toString();
    }

}
