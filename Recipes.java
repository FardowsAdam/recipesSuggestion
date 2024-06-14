package recipes.javaProject;

import java.util.List;

public class Recipes {
   private List<String> ingredients; // Store list of ingredients
   private String link; // Store link to the recipe

   public Recipes() {
     
   }

   public Recipes(List<String> ingredients, String link) {
       this.ingredients = ingredients; 
       this.link = link; 
   }

   public List<String> getIngredients() {
       return ingredients; 
   }

   public String getLink() {
       return link; 
   }
}
