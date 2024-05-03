import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        System.out.println("Enter the meal name :");
        String mealType=kb.nextLine().trim().toLowerCase();
        System.out.println("Enter available ingredients -separated by comma- ");
        String ingredients=kb.nextLine().trim().toLowerCase();
        List<String> availableIngredients= Arrays.asList(ingredients.split(","));
        Meal meal=null;

        switch (mealType){
            case "breakfast" : {
                meal=new Meal(new Breakfast().map);
                break;
            }
            case "lunch" :{
                 meal=new Meal(new Lunch().map);
                break;
            }
            case "dinner" :{
                meal=new Meal(new Dinner().map);
                break;
            }
            default:
                System.out.println("Invalid Input");
                break;
        }
        if(meal!=null){
            System.out.println("Suggested recipes: ");
            List<String> suggestion=meal. suggestionRecipes(availableIngredients);
            if(suggestion.isEmpty()) System.out.println("no matching recipes found");
            for(String element : suggestion){
                System.out.println(element);
            }
        }

    }
}