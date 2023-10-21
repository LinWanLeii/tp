package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import seedu.address.model.order.Order;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class OrderDisplay extends UiPart<Region> {

    private static final String FXML = "OrderDisplay.fxml";

    private Order order;
    @FXML
    private TextArea resultDisplay;
    @FXML
    private Label orderNumber;
    @FXML
    private Label orderPerson;
    @FXML
    private Label orderDetails;

    /**
     * Creates the order display.
     */
    public OrderDisplay(Order order) {
        super(FXML);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/OrderDisplay.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String display = order.toString();
        orderNumber.setText(order.getOrderNumber().toString());
        orderPerson.setText(order.getPerson().getName().fullName);
        orderDetails.setText(order.getMedicineName());
    }
}
