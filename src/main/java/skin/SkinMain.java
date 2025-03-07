package skin;

public class SkinMain {
    public static void main(String[] args) {
        // Test 1
        Skin skin1 = new Skin("Synth", Sex.MAN, 1500);
        System.out.println(skin1);
        System.out.println("Lose life: " + skin1.loseLife());
        System.out.println("Lose life: " + skin1.loseLife());
        System.out.println("Lose life: " + skin1.loseLife());
        System.out.println("Lose life: " + skin1.loseLife());
        System.out.println("Increase life: " + skin1.increaseLife());
        System.out.println("Increase points: " + skin1.increasePoints(100));

        // Test 2
        Skin skin2 = new Skin("Orelia", Sex.WOMAN, 100);
        System.out.println(skin2);
        System.out.println("Increase life: " + skin2.increaseLife());
        System.out.println("Increase life: " + skin2.increaseLife());
        System.out.println("Increase life: " + skin2.increaseLife());
        skin2.increasePoints(100);
        System.out.println(skin2);
        skin2.decreasePoints(50);
        System.out.println(skin2);
        skin2.decreasePoints(150);
        System.out.println(skin2);
        System.out.println("Battling: " + skin2.battling());
        System.out.println("Resting: " + skin2.resting());
        System.out.println("Eating: " + skin2.eating());
        System.out.println("Get sword: " + skin2.getSword());
        System.out.println("Get gun: " + skin2.getGun());
        System.out.println("Get rope: " + skin2.getRope());
        System.out.println("Battling: " + skin2.battling());

        // Test Part 2 - Modes
        Skin[] skins = {
                new Skin("Orelia", Sex.WOMAN, 100),
                new Skin("Midas Rex", Sex.MAN, 100),
                new Skin("Lachlan", Sex.MAN, 100),
                new Skin("The Grefg", Sex.MAN, 100),
                new Skin("Blastoff", Sex.MAN, 100),
                new Skin("Hypersonic", Sex.MAN, 100),
                new Skin("Wanderlust", Sex.MAN, 100),
                new Skin("Hunter", Sex.MAN, 100),
                new Skin("The Mighty Volt", Sex.MAN, 100),
                new Skin("Backlash", Sex.NOT_DEFINED, 100)
        };

        Mode saveTheWorld = new Mode(Modes.SAVE_THE_WORLD, skins, 500);
        System.out.println("Skins in SAVE_THE_WORLD:");
        for (Skin s : saveTheWorld.getSkins()) System.out.println(s);
        System.out.println("Zombies in SAVE_THE_WORLD: " + saveTheWorld.getZombis().length);
    }
}
