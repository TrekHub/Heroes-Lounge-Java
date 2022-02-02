import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;



public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        //Root Route
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //Hero Route
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());


        //Form route
        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> allTeams = Team.getAllTeams();
            model.put("allTeams", allTeams);
            return new ModelAndView(model, "teams.hbs");
        }, new HandlebarsTemplateEngine());



        post("/getTeams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            String maxMembers = request.queryParams("maxMembers");
            Team resume = new Team(name, cause, maxMembers);
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());








    }
}
