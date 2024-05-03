import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {

      Map<String,Recipes> choice;

    public Meal() {
    }

    public Meal(Map<String,Recipes> choice) {

        this.choice =choice;


    }
    public  List <String> suggestionRecipes(List<String> availableIngredients){
        List<String> suggestedRecipes=new ArrayList<>();
        Map<String, Integer> matchingRecipes = getStringIntegerMap(availableIngredients);

        // Sort recipes by the number of matching ingredients
        List<Map.Entry<String, Integer>> sortedRecipes = new ArrayList<>(matchingRecipes.entrySet());
        sortedRecipes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Get top three matching recipes
        for (int i = 0; i < Math.min(sortedRecipes.size(), 3); i++) {
            suggestedRecipes.add(sortedRecipes.get(i).getKey());
        }

        return suggestedRecipes;


    }
    //method to count the matching ingredients

    private Map<String, Integer> getStringIntegerMap(List<String> availableIngredients) {
        Map<String,Integer> matchingRecipes=new HashMap<>();
        Recipes recipes=new Recipes();
        for(Map.Entry<String, Recipes> entry : choice.entrySet()){
            String recipeName=entry.getKey();
            List<String> requiredIngredients=entry.getValue().getIngredeints();
            String link=entry.getValue().getLink();
            int match=0;
            for(String ingredient: availableIngredients){
                if(requiredIngredients.contains(ingredient)) match++;
            }
           matchingRecipes.put(recipeName+" for farther information: "+link,match);

        }
        return matchingRecipes;
    }
}
