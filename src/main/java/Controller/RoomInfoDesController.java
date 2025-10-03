package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Dto.RoomInfoDTO;

public class RoomInfoDesController {

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
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colRoomID;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;

    @FXML
    void btnReload(ActionEvent event) {

        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblRoomInfo.setItems(roomInfoDTOS);
    }

}
