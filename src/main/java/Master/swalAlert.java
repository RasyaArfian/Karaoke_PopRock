package Master;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class swalAlert {

    public boolean showAlert(Alert.AlertType type, String title, String message, boolean withConfirmation) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        if (withConfirmation && type == Alert.AlertType.CONFIRMATION) {
            return alert.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
        } else {
            alert.showAndWait();
            return true;
        }
    }

}
