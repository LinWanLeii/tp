package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

import static java.util.Objects.requireNonNull;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class OrderDisplay extends UiPart<Region> {

    private static final String FXML = "OrderDisplay.fxml";

    @FXML
    private TextArea resultDisplay;

    public OrderDisplay() {
        super(FXML);
    }

    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        resultDisplay.setText(feedbackToUser);
    }

}
