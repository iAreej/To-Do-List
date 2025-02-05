package com.example.tableview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableView<Task> table;
    @FXML
    public TableColumn<Task, String> Subject;
    @FXML
    public TableColumn<Task, String> Date;
    @FXML
    public TableColumn<Task, String> Time;
    @FXML
    public TableColumn<Task, String> Location;
    @FXML
    public TableColumn<Task, String> Details;
    ObservableList<Task> list = FXCollections.observableArrayList();
    FilteredList<Task> filteredData = new FilteredList<>(list, b -> true);
    SortedList<Task> sortedData = new SortedList<>(filteredData);
    public static ArrayList<String> todolist=new ArrayList<>();


    @FXML
    private TextField tf1, tf2, tf3, tf4, tf5, top, _tf1, _tf2, _tf3, _tf4, _tf5, tf6, removetxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Subject.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Details.setCellValueFactory(new PropertyValueFactory<>("Details"));
      }

    @FXML
    void Onremovebuttonclick() {
        int id=-1;
        if(removetxt.getText()==""){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("NOTHING IS ENTERED");
            a.show();
        }
        else{
        id = Integer.parseInt(removetxt.getText());}

        if (id>=0 && id<list.size()) {
            list.remove(id-1);
        }
        else {Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("INDEX OUT OF RANGE");
            a.show();

        }
    }

    @FXML
    public void Onsavebuttonclick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("ARE YOU SURE");
        a.show();
        try{File file=new File("todolist.txt");
            FileWriter fw =new FileWriter(file);
            fw.write(String.valueOf(todolist));
            fw.close();}
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    public void Onenterbuttonclick(ActionEvent event){
        Task t1=new Task(tf1.getText(),tf2.getText(),tf3.getText(),
                tf4.getText(),tf5.getText());
        list.addAll(t1);
        table.setItems(list);
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        todolist.add(t1.toString());
        Onsearchbuttonclick();
        }


    @FXML
    public void OnUpdatebuttonclick(ActionEvent event){
        int Id= Integer.parseInt(tf6.getText());
        Task t1=new Task(_tf1.getText(),_tf2.getText(),_tf3.getText(),
                _tf4.getText(),_tf5.getText());
        list.add(Id-1,t1);
        todolist.add(Id-1,t1.toString());
        tf6.setText("");
        _tf1.setText("");
        _tf2.setText("");
        _tf3.setText("");
        _tf4.setText("");
        _tf5.setText("");
        Onsearchbuttonclick();
    }
    @FXML
    public void Onsearchbuttonclick(){
        top.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(task -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;}
            String lowerCaseFilter = newValue.toLowerCase();
            if (task.getSubject().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (task.getTime().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (task.getDate().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (task.getLocation().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (task.getDetails().contains(lowerCaseFilter))
                return true;
            else
                return false;
        }));
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
        top.setText("");
    }
}


