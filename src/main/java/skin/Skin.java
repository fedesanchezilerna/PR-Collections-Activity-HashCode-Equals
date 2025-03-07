package skin;

import java.util.Arrays;
import java.util.Objects;

public class Skin {
    private static int idNext = 1;

    private String name;
    private Sex sex;
    private boolean available = true;
    private int price;
    private byte numberOfLives = 3;
    private int points = 0;
    private Status status = Status.RESTING;
    private boolean[] accessories = {false, false, false};
    private int id;

    public Skin(String name, Sex sex, int price) {
        this.name = name;
        this.sex = sex;
        this.price = price;
        this.id = idNext++;
    }

    public boolean loseLife() {
        if (numberOfLives > 1) {
            numberOfLives--;
            return true;
        } else if (numberOfLives == 1) {
            numberOfLives = 0;
            available = false;
            return true;
        }
        return false;
    }

    public boolean increaseLife() {
        if (available && numberOfLives < 5) {
            numberOfLives++;
            return true;
        }
        return false;
    }

    public boolean resting() {
        if (available) {
            status = Status.RESTING;
            return true;
        }
        return false;
    }

    public boolean eating() {
        if (available) {
            status = Status.EATING;
            return true;
        }
        return false;
    }

    public boolean battling() {
        if (available && (accessories[0] || accessories[1] || accessories[2])) {
            status = Status.BATTLING;
            return true;
        }
        return false;
    }

    public boolean increasePoints(int points) {
        if (available) {
            this.points += points;
            return true;
        }
        return false;
    }

    public boolean decreasePoints(int points) {
        if (available) {
            this.points = Math.max(0, this.points - points);
            return true;
        }
        return false;
    }

    public boolean getSword() {
        if (available) {
            accessories[0] = true;
            return true;
        }
        return false;
    }

    public boolean getGun() {
        if (available) {
            accessories[1] = true;
            return true;
        }
        return false;
    }

    public boolean getRope() {
        if (available) {
            accessories[2] = true;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(byte numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean[] getAccessories() {
        return accessories;
    }

    public void setAccessories(boolean[] accessories) {
        this.accessories = accessories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Skin [name=" + name + ", sex=" + sex + ", available=" + available +
               ", price=" + price + ", numberOfLives=" + numberOfLives + ", points=" + points +
               ", status=" + status + ", accessories=" + Arrays.toString(accessories) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skin skin = (Skin) o;
        return Objects.equals(name, skin.name) && sex == skin.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }
}
