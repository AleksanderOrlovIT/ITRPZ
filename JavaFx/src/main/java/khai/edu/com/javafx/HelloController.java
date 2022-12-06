package khai.edu.com.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import khai.edu.com.entity.User;
import khai.edu.com.service.UserService;

public class HelloController {
    @FXML
    private TextField Age;

    @FXML
    private Button CreateButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button FindAllButton;

    @FXML
    private TextField Id;

    @FXML
    private TextField Name;

    @FXML
    private TextArea Output;

    @FXML
    private Button UpdateButton;

    @FXML
    void initialize(){
        CreateButton.setOnAction(event-> {
            try {
                User user = new User(Name.getText(), Integer.valueOf(Age.getText()), Id.getText());
                if(UserService.findById(user.getId()) != null){
                    Output.setText("User with this id already exists");
                }
                else UserService.create(user);
            }catch (Exception e) {Output.setText("Wrong input, failed to create");}
        });
        FindAllButton.setOnAction(event -> {
            String output = "";
            User[] users = UserService.findAll();
            if(users.length == 0) output += "Users empty";
            else {
                for (int i = 0; i < users.length; i++) {
                    output += "User: " + (i + 1) + " name: " + users[i].getName() + " age: " + users[i].getAge()
                            + " id: " + users[i].getId() + "\n";
                }
            }
            Output.setText(output);
        });
        DeleteButton.setOnAction(event -> {
            if(UserService.deleteWithoutId()) Output.setText("Successful delete");
            else Output.setText("Nothing to delete");
        });
        UpdateButton.setOnAction(event -> {
            try {
                if (UserService.findById(Id.getText()) == null) Output.setText("Wrong input");
                else {
                    UserService.update(new User(Name.getText(), Integer.valueOf(Age.getText()), Id.getText()));
                    Output.setText("Successful update");
                }
            }catch (Exception e) {Output.setText("Wrong input, failed to update");}
        });
    }
}