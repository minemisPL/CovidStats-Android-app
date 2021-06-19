package me.minemis.coronacases.data;

public class CovidData {
    private int allCases;
    private int casesToday;
    private int allDeaths;
    private int deathsToday;

    public int getAllCases() {
        return allCases;
    }

    public void setAllCases(int allCases) {
        this.allCases = allCases;
    }

    public int getCasesToday() {
        return casesToday;
    }

    public void setCasesToday(int casesToday) {
        this.casesToday = casesToday;
    }

    public int getAllDeaths() {
        return allDeaths;
    }

    public void setAllDeaths(int allDeaths) {
        this.allDeaths = allDeaths;
    }

    public int getDeathsToday() {
        return deathsToday;
    }

    public void setDeathsToday(int deathsToday) {
        this.deathsToday = deathsToday;
    }
}
