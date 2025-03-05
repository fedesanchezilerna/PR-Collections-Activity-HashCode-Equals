package playerEnum;

public enum Team {
    FCB("Futbol Club Barcelona", "Spain"),
    RM("Real Madrid", "Spain"),
    SFC("Sevilla FC", "Spain"),
    PSG("Paris Saint Germain", "France"),
    BNF("Benfica", "Portugal"),
    JUV("Juventus", "Italy");

    // Attributes
    private final String name;
    private final String country;

    // Constructor
    private Team(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
