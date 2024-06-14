package recipes.javaProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class HelloApplication extends Application{

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Elements
        ComboBox<String> mealTypeComboBox = new ComboBox<>();
        mealTypeComboBox.getItems().addAll("Breakfast", "Lunch", "Dinner");

        TextField ingredientsTextField = new TextField();
        ingredientsTextField.setPromptText("Enter ingredients separated by commas");

        Button suggestButton = new Button("Suggest Recipes");
        TextArea resultsTextArea = new TextArea();
        resultsTextArea.setStyle("-fx-line-spacing:1000px;");
        resultsTextArea.setEditable(false);

        // Layout
        VBox layout = new VBox(10, mealTypeComboBox, ingredientsTextField, suggestButton, resultsTextArea);
        layout.setPadding(new Insets(10));

        // Set the scene
        Scene scene = new Scene(layout, 640, 400);
        stage.setTitle("Meal Suggestion App");
        stage.setScene(scene);
        stage.show();

        // Event Handling
        suggestButton.setOnAction(e -> {
            String selectedMeal = mealTypeComboBox.getValue();
            String[] ingredients = ingredientsTextField.getText().toLowerCase().split(",");


            try {
                Meal meal=null;
                switch (selectedMeal){
                    case "Breakfast" : {
                         meal = new Meal(Meal.fromFileToHashMap(new BufferedReader(new FileReader("C:\\Users\\96657\\IdeaProjects\\myFirstProject\\src\\recipes\\javaProject\\BreakFast.txt"))));
                        resultsTextArea.setText(String.join("\n", meal.suggestionRecipes(java.util.Arrays.asList(ingredients))));
                        break;
                    }
                    case "Lunch" :{
                         meal = new Meal(Meal.fromFileToHashMap(new BufferedReader(new FileReader("C:\\Users\\96657\\IdeaProjects\\myFirstProject\\src\\recipes\\javaProject\\Lunch.txt"))));
                        resultsTextArea.setText(String.join("\n", meal.suggestionRecipes(java.util.Arrays.asList(ingredients))));
                        break;
                    }
                    case "Dinner" :{
                         meal = new Meal(Meal.fromFileToHashMap(new BufferedReader(new FileReader("C:\\Users\\96657\\IdeaProjects\\myFirstProject\\src\\recipes\\javaProject\\Dinner.txt"))));
                        resultsTextArea.setText(String.join("\n", meal.suggestionRecipes(java.util.Arrays.asList(ingredients))));
                        break;
                    }
                    default:
                        System.out.println("Invalid Input");
                        break;
                }

            } catch (Exception ex) {
                resultsTextArea.setText("Error:"+ ex.getMessage());
            }
        });
    }


}

