package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.util.StringUtil;
import seedu.address.model.person.Person;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class PersonDisplay extends UiPart<Region> {

    private static final String FXML = "PersonDisplay.fxml";

    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label phoneNumber;
    @FXML
    private Label email;
    @FXML
    private Label allergies;

    /**
     * Creates the person display.
     */
    public PersonDisplay(Person person) {
        super(FXML);

        name.setText(person.getName().fullName);
        address.setText(person.getAddress().value);
        phoneNumber.setText(person.getPhone().value);
        email.setText(person.getEmail().value);
        allergies.setText(StringUtil.unmodifiableSetToCommaSeparatedStr(person.getAllergies()));
    }
}
