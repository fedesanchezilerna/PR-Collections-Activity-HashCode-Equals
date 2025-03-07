package skin;

public class Zombi {
    private int code;
    private int strength = 10;
    private boolean active = true;

    public Zombi(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Zombi [code=" + code + ", strength=" + strength + ", active=" + active + "]";
    }
}
