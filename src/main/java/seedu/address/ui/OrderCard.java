package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.order.Order;

/**
 * A UI component that displays information of a {@code Person}.
 */
public class OrderCard extends UiPart<Region> {
    private static final String FXML = "OrderListCard.fxml";

    public final Order order;

    // FXML Elements

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label orderNumber;
    @FXML
    private Label personName;
    @FXML
    private Label address;
    @FXML
    private Label medicineName;
    @FXML
    private Label id;
    @FXML
    private Label status;

    /**
     * Creates a {@code OrderCode} with the given {@code Order} and index to display.
     */
    public OrderCard(Order order, int displayedIndex) {
        super(FXML);
        this.order = order;
        id.setText(displayedIndex + ". ");
        orderNumber.setText("Order #" + order.getOrderNumber());
        personName.setText(order.getPerson().getName().fullName);
        address.setText(order.getPerson().getAddress().value);
        medicineName.setText(order.getMedicineName());
        status.setText(order.getStatus().toString());
        status.setWrapText(true);

        // Set the appropriate CSS style class based on the status
        String statusStyleClass = "status-" + order.getStatus().toString();
        status.getStyleClass().add(statusStyleClass);
    }
}
