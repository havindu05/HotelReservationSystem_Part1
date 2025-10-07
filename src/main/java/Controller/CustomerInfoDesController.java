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
import model.Dto.CustomerInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoDesController implements Initializable {

    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList(
            new CustomerInfoDTO("Havindu", "20", "200510800942", "0772564395", "Galle Road, Ambalangoda", "havindu2005@gmail.com"),
            new CustomerInfoDTO("Dilshan", "25", "199905602314", "0714567890", "Temple Road, Colombo 07", "dilshan95@gmail.com"),
            new CustomerInfoDTO("Sajini", "22", "200210302589", "0761234567", "Beach Road, Galle", "sajini22@gmail.com"),
            new CustomerInfoDTO("Kavindu", "28", "199703401245", "0759876543", "Hill Street, Kandy", "kavindu.k@gmail.com"),
            new CustomerInfoDTO("Tharushi", "24", "200106502178", "0785554433", "Main Street, Matara", "tharushi24@yahoo.com"),
            new CustomerInfoDTO("Nadeesha", "30", "199409902589", "0778882222", "Lake Road, Kurunegala", "nadeesha30@gmail.com"),
            new CustomerInfoDTO("Ashen", "27", "199804401279", "0742225555", "Marine Drive, Colombo 04", "ashen_98@gmail.com"),
            new CustomerInfoDTO("Isuru", "26", "199609602314", "0723334444", "Station Road, Negombo", "isuru26@hotmail.com"),
            new CustomerInfoDTO("Rashmi", "23", "200208801342", "0711122334", "Queens Road, Nuwara Eliya", "rashmi23@gmail.com"),
            new CustomerInfoDTO("Chamod", "29", "199508401765", "0704446666", "Park Lane, Colombo 02", "chamod29@gmail.com")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNo;

    @FXML
    private TableView<CustomerInfoDTO> tblCustomerInfo;

    @FXML
    private TextField textID;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnAdd(ActionEvent event) {
        CustomerInfoDTO newCustomer = new CustomerInfoDTO(
                txtName.getText(),
                txtAge.getText(),
                textID.getText(),
                txtPhoneNumber.getText(),
                txtAddress.getText(),
                txtEmail.getText()
        );
        customerInfoDTOS.add(newCustomer);
        clearFields();
    }

    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        CustomerInfoDTO selected = tblCustomerInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            customerInfoDTOS.remove(selected);
            clearFields();
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        CustomerInfoDTO selected = tblCustomerInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(txtName.getText());
            selected.setAge(txtAge.getText());
            selected.setId(textID.getText());
            selected.setPhoneNo(txtPhoneNumber.getText());
            selected.setAddress(txtAddress.getText());
            selected.setEmail(txtEmail.getText());
            tblCustomerInfo.refresh();
            clearFields();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblCustomerInfo.setItems(customerInfoDTOS);

        tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtName.setText(newSelection.getName());
                txtAge.setText(newSelection.getAge());
                textID.setText(newSelection.getId());
                txtPhoneNumber.setText(newSelection.getPhoneNo());
                txtAddress.setText(newSelection.getAddress());
                txtEmail.setText(newSelection.getEmail());
            }
        });
    }

    private void clearFields() {
        txtName.clear();
        txtAge.clear();
        textID.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
        txtEmail.clear();
    }
}
