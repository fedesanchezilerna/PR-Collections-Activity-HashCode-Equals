import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import skin.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SkinTest {
    private Skin skin1;
    private Skin skin2;
    
    private Zombi zombi1;
    private Zombi zombi2;
    
    

    @BeforeEach
    void setUp() {
        skin1 = new Skin("Synth", Sex.MAN, 1500);
        skin2 = new Skin("Lovely", Sex.WOMAN, 1200);
        
        zombi1 = new Zombi(101);
        zombi2 = new Zombi(202);
        
        
    }

    @Test
    @Order(1)
    void testLoseLife() {
        assertTrue(skin1.loseLife());
        assertTrue(skin1.loseLife());
        assertTrue(skin1.loseLife());
        assertFalse(skin1.loseLife());
    }

    @Test
    @Order(2)
    void testIncreaseLife() {
        assertTrue(skin2.increaseLife());
        assertTrue(skin2.increaseLife());
        assertFalse(skin2.increaseLife());
    }

    @Test
    @Order(3)
    void testIncreaseDecreasePoints() {
        assertTrue(skin2.increasePoints(100));
        assertEquals(100, skin2.getPoints());
        assertTrue(skin2.decreasePoints(50));
        assertEquals(50, skin2.getPoints());
        assertTrue(skin2.decreasePoints(100));
        assertEquals(0, skin2.getPoints());
    }

    @Test
    @Order(4)
    void testStatusChange() {
        assertTrue(skin2.eating());
        assertEquals(Status.EATING, skin2.getStatus());
        assertTrue(skin2.resting());
        assertEquals(Status.RESTING, skin2.getStatus());
    }

    @Test
    @Order(5)
    void testAccessories() {
        assertTrue(skin2.getSword());
        assertTrue(skin2.getGun());
        assertTrue(skin2.getRope());
    }

    @Test
    @Order(6)
    void testBattling() {
        assertFalse(skin2.battling());
        skin2.getSword();
        assertTrue(skin2.battling());
    }

    @Test
    @Order(7)
    void testEnums() {
        assertEquals(Sex.MAN, Sex.valueOf("MAN"));
        assertEquals(Sex.WOMAN, Sex.valueOf("WOMAN"));
        assertEquals(Sex.NOT_DEFINED, Sex.valueOf("NOT_DEFINED"));
        
        assertEquals(Status.RESTING, Status.valueOf("RESTING"));
        assertEquals(Status.EATING, Status.valueOf("EATING"));
        assertEquals(Status.BATTLING, Status.valueOf("BATTLING"));
        
        assertEquals(Modes.SAVE_THE_WORLD, Modes.valueOf("SAVE_THE_WORLD"));
        assertEquals(Modes.BATTLE_ROYALE, Modes.valueOf("BATTLE_ROYALE"));
        assertEquals(Modes.CREATIVE, Modes.valueOf("CREATIVE"));
    }
    
    @Test
    @Order(8)
    void testConstructor() {
        assertEquals(101, zombi1.getCode());
        assertEquals(10, zombi1.getStrength());
        assertTrue(zombi1.isActive());

        assertEquals(202, zombi2.getCode());
        assertEquals(10, zombi2.getStrength());
        assertTrue(zombi2.isActive());
    }
    
    @Test
    @Order(10)
    void testUniqueSkins() {
    	Set<Skin> skins;
    	skins = new HashSet<>();
    	Skin s1 = new Skin("Synth", Sex.MAN, 1500);
    	Skin s2 = new Skin("Orelia", Sex.WOMAN, 200);
    	Skin s3 = new Skin("Midas Rex", Sex.MAN, 150);
    	Skin s4 = new Skin("Lachlan", Sex.MAN, 3000);
    	Skin s5 = new Skin("The Grefg", Sex.MAN, 400);
    	Skin s6 = new Skin("Blastoff", Sex.MAN, 450);
    	Skin s7 = new Skin("Hypersonic", Sex.MAN, 300);
    	Skin s8 = new Skin("Wanderlust", Sex.MAN, 100);
    	Skin s9 = new Skin("Wanderlust", Sex.WOMAN, 3500);
    	Skin s10 = new Skin("Polarity", Sex.WOMAN, 400);
    	Skin s11 = new Skin("Lachlan", Sex.MAN, 300); // Duplicat
    	Skin s12 = new Skin("Polarity", Sex.WOMAN, 200); // Duplicat
    	Skin s13 = new Skin("Orelia", Sex.WOMAN, 100); // Duplicat
        
        
        assertTrue(skins.add(s1));
        assertTrue(skins.add(s2));
        assertTrue(skins.add(s3));
        assertTrue(skins.add(s4));
        assertTrue(skins.add(s5));
        assertTrue(skins.add(s6));
        assertTrue(skins.add(s7));
        assertTrue(skins.add(s8));
        assertTrue(skins.add(s9));
        assertTrue(skins.add(s10));
        assertFalse(skins.add(s11));
        assertFalse(skins.add(s12));
        assertFalse(skins.add(s13));
        assertEquals(10, skins.size(), "The set must contain only 10 unique elements.");
        
        
        assertEquals(s4, s11);
        assertEquals(s10, s12);
        assertEquals(s2, s13);
        
        assertEquals(s4.hashCode(), s11.hashCode());
        assertEquals(s10.hashCode(), s12.hashCode());
        assertEquals(s2.hashCode(), s13.hashCode());
        
    }
    
}