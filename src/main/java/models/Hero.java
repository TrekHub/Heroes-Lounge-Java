package models;

import java.util.ArrayList;

public class Hero {
    private String heroName;
    private String power;
    private String weakness;
    private String imageUrl;
    private static ArrayList<Hero> allHeroes = new ArrayList<>();


    public Hero(String heroName, String power, String weakness, String imageUrl) {
        this.heroName = heroName;
        this.power = power;
        this.weakness = weakness;
        this.imageUrl = imageUrl;
        allHeroes.add(this);
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<Hero> getAllHeroes() {
        return allHeroes;
    }
}
