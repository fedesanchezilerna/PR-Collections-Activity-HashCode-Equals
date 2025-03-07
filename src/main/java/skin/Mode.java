package skin;

public class Mode {
    private Modes modeName;
    private Skin[] skins;
    private Zombi[] zombis;

    public Mode(Modes modeName, Skin[] skins, int numZombis) {
        this.modeName = modeName;
        this.skins = skins;
        this.zombis = new Zombi[numZombis];
        for (int i = 0; i < numZombis; i++) {
            this.zombis[i] = new Zombi(i + 1);
        }
    }

    public Skin[] getSkins() {
        return skins;
    }

    public Zombi[] getZombis() {
        return zombis;
    }

    public Modes getModeName() {
        return modeName;
    }

    public void setModeName(Modes modeName) {
        this.modeName = modeName;
    }

    public void setSkins(Skin[] skins) {
        this.skins = skins;
    }

    public void setZombis(Zombi[] zombis) {
        this.zombis = zombis;
    }
}
