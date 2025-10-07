package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Dto.RoomInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomInfoDesController implements Initializable {

    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
            new RoomInfoDTO("L001", "Presidential Suite", "King-size Bed, Private Balcony, Jacuzzi, Ocean View", 750000),
            new RoomInfoDTO("L002", "Royal Suite", "King Bed, Panoramic City View, Private Butler Service, Lounge Access", 650000),
            new RoomInfoDTO("L003", "Ocean View Suite", "Queen Bed, Sea View, Jacuzzi, Complimentary Breakfast", 550000),
            new RoomInfoDTO("L004", "Garden View Suite", "King Bed, Private Garden, Terrace Seating, Free Wifi", 500000),
            new RoomInfoDTO("L005", "Penthouse Suite", "King Bed, Rooftop Terrace, Private Dining, Spa Access", 800000),
            new RoomInfoDTO("L006", "Luxury Double Room", "Double Bed, City View, Mini-Bar, Smart TV", 350000),
            new RoomInfoDTO("L007", "Honeymoon Suite", "King Bed, Jacuzzi, Romantic Setup, Balcony View", 600000),
            new RoomInfoDTO("L008", "Executive Suite", "King Bed, Work Desk, Lounge Access, Complimentary Breakfast", 450000),
            new RoomInfoDTO("L009", "Family Suite", "Two Double Beds, Living Area, Balcony, Free Wifi", 550000),
            new RoomInfoDTO("L010", "Deluxe Room", "Queen Bed, Ocean View, Mini-Bar, Smart TV", 400000)
    );

    @FXML
    private TableColumn<RoomInfoDTO, String> colDescription;

    @FXML
    private TableColumn<RoomInfoDTO, Double> colPrice;

    @FXML
    private TableColumn<RoomInfoDTO, String> colRoomID;

    @FXML
    private TableColumn<RoomInfoDTO, String> colType;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblRoomInfo.setItems(roomInfoDTOS);

        tblRoomInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtRoomId.setText(newValue.getRoomId());
                txtType.setText(newValue.getType());
                txtDescription.setText(newValue.getDescription());
                txtPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });
    }

    @FXML
    void btnAdd(ActionEvent event) {
        RoomInfoDTO newRoom = new RoomInfoDTO(
                txtRoomId.getText(),
                txtType.getText(),
                txtDescription.getText(),
                Double.parseDouble(txtPrice.getText())
        );
        roomInfoDTOS.add(newRoom);
        clearFields();
    }

    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        RoomInfoDTO selected = tblRoomInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            roomInfoDTOS.remove(selected);
            clearFields();
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        RoomInfoDTO selected = tblRoomInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setRoomId(txtRoomId.getText());
            selected.setType(txtType.getText());
            selected.setDescription(txtDescription.getText());
            selected.setPrice(Double.parseDouble(txtPrice.getText()));
            tblRoomInfo.refresh();
        }
    }

    private void clearFields() {
        txtRoomId.clear();
        txtType.clear();
        txtDescription.clear();
        txtPrice.clear();
    }
}
