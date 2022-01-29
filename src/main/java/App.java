import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import models.Hero;
import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Hero hero = new Hero("hello", "food", "lies", "kncdcndcndhcmdm");
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> allheroes = hero.getAllHeroes();
            model.put("heroes", allheroes);
            return new ModelAndView(model, "index.hbs");

        }, new HandlebarsTemplateEngine());

        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.params("name");
            String cause = request.params("cause");
            Integer maxMembers = Integer.parseInt(request.params("maxMembers"));

            Team team = new Team(name, maxMembers, cause);
            ArrayList<Team> allTeams = Team.getAllTeams();
            model.put("teams", allTeams);


            return new ModelAndView(model, "team.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
