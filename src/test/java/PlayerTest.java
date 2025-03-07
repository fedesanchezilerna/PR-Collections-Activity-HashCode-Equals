import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import player.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerTest {

    Player mbappe;
    Player xBusquets;
    Player xBusquets2;
    Player mLeon;
    Player leoMessi;
    Player gerardPique;
    Player alexiaPutellas;

    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        // Constructor1
        // Constructor 1 with all atributes except cards
        mbappe = new Player("Kylian", "Mbappé", 1.78f, 80f, (byte) 23, Sex.MAN, 100, Team.PSG, Position.FORWARD, true);

        // Constructor 1 with values error age = 10, points = -10
        xBusquets = new Player("Sergi", "Busquets", 1.89f, 85f, (byte) 10, Sex.MAN, -10, Team.PSG, Position.FORWARD,
                true);

        // Constructor 1 with inactive player
        mLeon = new Player("Mapi", "Leon", 1.70f, 60f, (byte) 26, Sex.WOMAN, 100, Team.FCB, Position.DEFENDER, false);

        // Constructor2
        leoMessi = new Player("Leo", "Messi", 1.70f, 70f, Team.PSG, Position.FORWARD);

        // Constructor3
        gerardPique = new Player("Gerard", "Pique", Sex.MAN, Team.FCB, Position.DEFENDER);

        // Constructor4
        alexiaPutellas = new Player("Alexia", "Putellas", (byte) 28, Sex.WOMAN, Team.FCB, Position.MIDFIELDER);
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    @Order(1)
    void testDefaultValues() {
        // Default value cards = 0
        // System.out.println("1 " + mbappe.toString());
        assertTrue(mbappe.getCards() == 0);

        // Default value active = true
        assertTrue(mbappe.isActive());

        // System.out.println("2 " + xBusquets.toString());
        // Default age = 18
        assertTrue(xBusquets.getAge() == 18);

        // Default points == 100
        assertEquals(100, xBusquets.getPoints());

        // Default sex = NOTDEFINED
        // System.out.println("3 " + leoMessi.toString());
        assertTrue(leoMessi.getSex().equals(Sex.NOTDEFINED));

    }

    @Test
    @Order(2)
    void testIncreasePointsOK() {
        //System.out.println(mbappe.toString());
        assertTrue(mbappe.increasePoints(10)); // increase active player
        assertEquals(110, mbappe.getPoints());
        //System.out.println(mbappe.toString());
    }

    @Test
    @Order(3)
    void testIncreasePointsNoOK() {
        //System.out.println(mbappe.toString());
        assertFalse(mbappe.increasePoints(-10)); // increase negative
        assertEquals(100, mbappe.getPoints());

        assertFalse(mLeon.increasePoints(10)); // inactive player
        assertEquals(100, mLeon.getPoints());
        //System.out.println(mbappe.toString());

    }

    @Test
    @Order(4)
    void testGiveCards() {
        //System.out.println(mbappe.toString());
        assertTrue(mbappe.giveCard()); // Give a card TRUE
        assertTrue(mbappe.getCards() == 1);
        assertTrue(mbappe.isActive());

        //System.out.println(mbappe.toString());
        assertTrue(mbappe.giveCard()); // Give a card TRUE
        assertTrue(mbappe.getCards() == 2);
        assertFalse(mbappe.isActive());

        assertFalse(mbappe.giveCard()); // Give a card FALSE
        assertTrue(mbappe.getCards() == 2);
        assertFalse(mbappe.isActive());

        //System.out.println(mbappe.toString());

    }

    @Test
    @Order(5)
    void testGetters() {
        //System.out.println(mbappe.toString());
        assertEquals("Kylian", mbappe.getName());
        assertEquals("Mbappé", mbappe.getSurname());
        assertEquals(1.78, mbappe.getHeight(), 0.01);
        assertEquals(80, mbappe.getWeight());
        assertEquals(23, mbappe.getAge());
        assertEquals(Sex.MAN, mbappe.getSex());
        assertEquals(100, mbappe.getPoints());
        assertEquals(Position.FORWARD, mbappe.getPosition());
        assertTrue(mbappe.isActive());
        assertEquals(0, mbappe.getCards());

    }

    @Test
    @Order(6)
    void testSetters() {

        //System.out.println(mbappe.toString());
        mbappe.setName("Kylian2");
        assertEquals("Kylian2", mbappe.getName());

        mbappe.setSurname("Mbappé2");
        assertEquals("Mbappé2", mbappe.getSurname());

        mbappe.setHeight(1.79f);
        assertEquals(1.79, mbappe.getHeight(), 0.01);

        mbappe.setWeight(81f);
        assertEquals(81, mbappe.getWeight());

        mbappe.setAge((byte) 24);
        assertEquals(24, mbappe.getAge());



        mbappe.setPoints(200);
        assertEquals(200, mbappe.getPoints());

        mbappe.setPosition(Position.MIDFIELDER);
        assertEquals(Position.MIDFIELDER, mbappe.getPosition());


    }


    @Test
    @Order(7)
    void testEquals() {

        Player mbappe1 = new Player("Kylian", "Mbappé", 1.78f, 80f, (byte) 23, Sex.MAN, 10, Team.PSG, Position.FORWARD,
                true);
        Player xBusquets1 = new Player("Sergi", "Busquets", 1.89f, 85f, (byte) 10, Sex.MAN, -10, Team.PSG,
                Position.FORWARD, true);
        Player mLeon1 = new Player("Mapi", "Leon", 1.70f, 60f, (byte) 26, Sex.WOMAN, 100, Team.FCB, Position.DEFENDER,
                false);
        Player leoMessi1 = new Player("Leo", "Messi", 1.70f, 70f, Team.PSG, Position.FORWARD);
        Player gerardPique1 = new Player("Gerard", "Pique", 1.94f, 84f, (byte) 35, Sex.MAN, 100, Team.FCB,
                Position.DEFENDER, true);
        Player alexiaPutellas1 = new Player("Alexia", "Putellas", 1.65f, 58f, (byte) 28, Sex.WOMAN, 200, Team.FCB,
                Position.MIDFIELDER, true);
        Player alexiaPutellas2 = new Player("Alexia", "Putellas", 1.65f, 60f, (byte) 28, Sex.WOMAN, 100, Team.PSG,
                Position.DEFENDER, false);
        Player gerardPique2 = new Player("Gerard", "Pique", 1.94f, 85f, (byte) 35, Sex.MAN, 300, Team.FCB,
                Position.MIDFIELDER, true);

        assertTrue(gerardPique1.equals(gerardPique2), "Gerard Pique hauria de ser considerat el mateix jugador");
        assertTrue(alexiaPutellas1.equals(alexiaPutellas2),
                "Alexia Putellas hauria de ser considerada la mateixa jugadora");
        assertFalse(mbappe1.equals(xBusquets1), "Mbappe i Busquets no haurien de ser iguals");
        assertFalse(mLeon1.equals(leoMessi1), "Mapi Leon i Leo Messi no haurien de ser iguals");
    }

}