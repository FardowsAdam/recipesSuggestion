import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Breakfast extends Meal{

    Map<String, Recipes> map=new HashMap<>();

    public Breakfast() {
        map.put("بيض",new Recipes(List.of("ملح","خبز","بيض","جبنة","خضروات"),"https://youtu.be/9feEKoL0YWQ"));
        map.put("pancakes",new Recipes(List.of("flour","eggs","milk"),"https://www.wikihow.com/Make-Pancakes"));
        map.put("avocado toast",new Recipes(List.of("avocado","bread","tomato"),"https://cookieandkate.com/avocado-toast-recipe/"));

    }
}
