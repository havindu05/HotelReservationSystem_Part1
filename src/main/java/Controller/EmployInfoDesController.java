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
import model.Dto.EmployInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployInfoDesController implements Initializable {

    private final ObservableList<EmployInfoDTO> employInfoDTOS = FXCollections.observableArrayList(
            new EmployInfoDTO("John Silva", "32", "EMP001", "0771234567", "No.12, Galle Road, Colombo", 85000.00),
            new EmployInfoDTO("Alice Fernando", "28", "EMP002", "0719876543", "No.8, Temple Lane, Kandy", 78000.00),
            new EmployInfoDTO("Nimal Perera", "45", "EMP003", "0751122334", "No.20, Main Street, Negombo", 92000.00),
            new EmployInfoDTO("Sunethra Jayawardena", "38", "EMP004", "0769988776", "No.45, Lake View, Nuwara Eliya", 110000.00),
            new EmployInfoDTO("Ruwan Karunaratne", "40", "EMP005", "0723344556", "No.17, Beach Road, Galle", 95000.00),
            new EmployInfoDTO("Kamal Weerasinghe", "29", "EMP006", "0775566778", "No.3, Temple Road, Kurunegala", 72000.00),
            new EmployInfoDTO("Tharushi Wickrama", "26", "EMP007", "0704455667", "No.22, Hill Street, Matara", 68000.00),
            new EmployInfoDTO("Dilan Abeysekara", "35", "EMP008", "0781122443", "No.14, Park Avenue, Colombo", 105000.00),
            new EmployInfoDTO("Malithi Ranasinghe", "31", "EMP009", "0719988776", "No.9, Station Road, Gampaha", 89000.00),
            new EmployInfoDTO("Chathura Jayasena", "27", "EMP010", "0763344559", "No.27, River Side, Anuradhapura", 75000.00)
    );

    @FXML
    private TableColumn<EmployInfoDTO, String> colAddress;

    @FXML
    private TableColumn<EmployInfoDTO, String> colAge;

    @FXML
    private TableColumn<EmployInfoDTO, String> colID;

    @FXML
    private TableColumn<EmployInfoDTO, String> colName;

    @FXML
    private TableColumn<EmployInfoDTO, String> colPhoneNo;

    @FXML
    private TableColumn<EmployInfoDTO, Double> colSalary;

    @FXML
    private TableView<EmployInfoDTO> tblEmployInfo;

    @FXML
    private TextField textID;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAdd(ActionEvent event) {
        String name = txtName.getText();
        String age = txtAge.getText();
        String id = textID.getText();
        String phone = txtPhoneNumber.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        EmployInfoDTO employ = new EmployInfoDTO(name, age, id, phone, address, salary);
        employInfoDTOS.add(employ);
        tblEmployInfo.refresh();
        clearFields();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        EmployInfoDTO selected = tblEmployInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            employInfoDTOS.remove(selected);
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        EmployInfoDTO selected = tblEmployInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(txtName.getText());
            selected.setAge(txtAge.getText());
            selected.setId(textID.getText());
            selected.setPhoneNo(txtPhoneNumber.getText());
            selected.setAddress(txtAddress.getText());
            selected.setSalary(Double.parseDouble(txtSalary.getText()));
            tblEmployInfo.refresh();
        }
    }

    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtName.clear();
        txtAge.clear();
        textID.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
        txtSalary.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tblEmployInfo.setItems(employInfoDTOS);

        tblEmployInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtName.setText(newVal.getName());
                txtAge.setText(newVal.getAge());
                textID.setText(newVal.getId());
                txtPhoneNumber.setText(newVal.getPhoneNo());
                txtAddress.setText(newVal.getAddress());
                txtSalary.setText(String.valueOf(newVal.getSalary()));
            }
        });
    }
}
