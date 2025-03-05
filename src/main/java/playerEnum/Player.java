package playerEnum;

import java.util.Objects;

public class Player {

    // Attributes
    private String name;
    private String surname;
    private float height;
    private float weight;
    private byte age;
    private Sex sex;
    private int points;
    private Team team;
    private Position position;
    private boolean active;
    private byte cards;

    // Default values
    private static final int INITIAL_POINTS = 100;
    private static final byte INITIAL_AGE = 18;
    private static final Sex DEFAULT_SEX = Sex.NOTDEFINED;
    private static final byte MAX_CARDS = 2;


    // Constructors
    // #1
    public Player(String name, String surname, float height, float weight, byte age, Sex sex, int points, Team team, Position position, boolean active) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.age = (age < INITIAL_AGE) ? INITIAL_AGE : age;
        this.sex = sex;
        this.points = Math.max(points, INITIAL_POINTS);
        this.team = team;
        this.position = position;
        this.active = active;
        this.cards = 0;
    }

    // #2
    public Player(String name, String surname, float height, float weight, Team team, Position position) {
        this(name,
                surname,
                height,
                weight,
                INITIAL_AGE,
                DEFAULT_SEX,
                INITIAL_POINTS,
                team,
                position,
                true
        );
        this.cards = 0;
    }

    // #3
    public Player(String name, String surname, Sex sex, Team team, Position position) {
        this(name,
                surname,
                0,
                0,
                INITIAL_AGE,
                sex == null ? DEFAULT_SEX : sex,
                INITIAL_POINTS,
                team,
                position,
                true
        );
        this.cards = 0;
    }

    // #4
    public Player(String name, String surname, byte age, Sex sex, Team team, Position position) {
        this(name,
                surname,
                0,
                0,
                (age < INITIAL_AGE) ? INITIAL_AGE : age,
                sex == null ? DEFAULT_SEX : sex,
                INITIAL_POINTS,
                team,
                position,
                true
        );
        this.cards = 0;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = (age < INITIAL_AGE) ? INITIAL_AGE : age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex == null ? DEFAULT_SEX : sex;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = Math.max(points, INITIAL_POINTS);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public byte getCards() {
        return cards;
    }

    public void setCards(byte cards) {
        this.cards = cards;
    }

    // Methods

    /**
     * Increase points if player is active and cards < 2
     *
     * @param points the number of points to increase
     * @return true if the points are increased
     */
    public boolean increasePoints(int points) {
        if (active && points > 0 && cards < MAX_CARDS) {
            this.points += points;
            return true;
        }

        return false;
    }

    /**
     * Decrease points of player, only if the player is active, cards < 2 and points are > 0
     *
     * @param points the number of points to decrease
     * @return true if the points are decreased
     */
    public boolean decreasePoints(int points) {
        if (active && cards < MAX_CARDS && points > 0) {
            this.points -= points;

            if (this.points < 0) {
                this.points = 0;
            }

            return true;
        }

        return false;
    }

    /**
     * Add 1 to number of cards if player is active and cards < 2
     *
     * @return true if player get a new card
     */
    public boolean giveCard() {
        if (active && cards < MAX_CARDS) {
            this.cards++;
            if (cards >= MAX_CARDS) {
                active = false;
            }
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "PLAYER: %-11s %-11s %-10.2f %-10.2f %-10d %-11s %-10d %-10s %-11s %-10b %-10d",
                name, surname, height, weight, age, sex, points, team, position, active, cards
        ).toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Float.compare(height, player.height) == 0 &&
               age == player.age &&
               Objects.equals(name, player.name) &&
               Objects.equals(surname, player.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, height, age);
    }
}
