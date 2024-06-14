package recipes.javaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Meal {

    Map<String,Recipes> choice; // A map storing meal options with their respective recipes.

   
    public Meal() {
    }

    // Constructor to initialize the 'choice' map with specific recipes
    public Meal(Map<String,Recipes> choice) {
        this.choice = choice; 
    }

    
    public List<String> suggestionRecipes(List<String> availableIngredients){
        List<String> suggestedRecipes = new ArrayList<>(); 
        Map<String, Integer> matchingRecipes = getStringIntegerMap(availableIngredients); // Maps recipes to their ingredient match count.

        // Sort recipes by the number of matching ingredients in descending order.
        List<Map.Entry<String, Integer>> sortedRecipes = new ArrayList<>(matchingRecipes.entrySet());
        sortedRecipes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Add the top 5 recipes to the suggested list.
        for (int i = 0; i <  5; i++) {
            suggestedRecipes.add(sortedRecipes.get(i).getKey());
        }

        return suggestedRecipes; 
    }

 
    private Map<String, Integer> getStringIntegerMap(List<String> availableIngredients) {
        Map<String,Integer> matchingRecipes = new HashMap<>();
        Recipes recipes = new Recipes();
        for (Map.Entry<String, Recipes> entry : choice.entrySet()) {
            String recipeName = entry.getKey();
            List<String> requiredIngredients = entry.getValue().getIngredients(); // take the required ingredients from the recipe.
            String link = entry.getValue().getLink(); // Retrieves the link to the recipe
            int match = 0; 
            for (String ingredient : availableIngredients) {
                if (requiredIngredients.contains(ingredient)) match++; // Increment match counter if ingredient is present.
            }
            matchingRecipes.put("{"+recipeName +"}"+ "  for further information:   " + link, match); // Stores the recipe name and link with the match count.
        }
        return matchingRecipes;
    }

    
    public static Map<String,Recipes> fromFileToHashMap(BufferedReader file) throws IOException {
        Map<String,Recipes> mapFromFile = new HashMap<>();
        String line;
        while ((line = file.readLine()) != null) {
            List<String> listFromFile = Arrays.asList(line.split("--")); 
            if (listFromFile.size() >= 3) {
                // Puts the recipe name as key and a new Recipes object as value in the map.
                mapFromFile.put(listFromFile.get(0), new Recipes(Arrays.asList(listFromFile.get(1).split(",")), listFromFile.get(2)));
            }
        }
        return mapFromFile; // Returns the map after if fielled.
    }
}
