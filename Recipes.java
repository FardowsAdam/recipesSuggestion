import java.util.List;

public class Recipes {

   private List<String> ingredeints;
   private String link;

    public Recipes() {
    }

    public Recipes(List<String> ingredients, String link) {

        this.ingredeints = ingredients;
        this.link = link;
    }


    public List<String> getIngredeints() {
        return ingredeints;
    }


    public String getLink() {
        return link;
    }


}
