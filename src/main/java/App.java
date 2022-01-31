import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {

    public static void main(String[] args) {
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


        //Teams Route
        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "teams.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
