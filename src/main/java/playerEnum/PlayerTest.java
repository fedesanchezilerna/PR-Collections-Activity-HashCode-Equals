package playerEnum;

public class PlayerTest {
    public static void main(String[] args) {
        //1. Constructor 1
        Player player1 = new Player("Kylian", "Mbappé", 1.78f, 80.00f, (byte) 18, Sex.MAN, 100, Team.PSG, Position.FORWARD, true);
        System.out.println(player1);

        //2. Constructor 2
        Player player2 = new Player("Bob", "Esponja", 1.72f, 68.50f, Team.JUV, Position.GOALKEEPER);
        System.out.println(player2);

        //3. Constructor 3
        Player player3 = new Player("Patricio", "Estrella", Sex.MAN, Team.SFC, Position.DEFENDER);
        System.out.println(player3);

        //4. Constructor 4
        Player player4 = new Player("Arenita", "Estrella", (byte) 111, Sex.WOMAN, Team.BNF, Position.MIDFIELDER);
        System.out.println(player4);

        //5. Test increasePoints with 100 for an active player, it should be TRUE
        //Check points after calling the method
        System.out.println("\n5.\nIncrease Points: " + player1.increasePoints(100)); // true
        System.out.println("Points after increase: " + player1.getPoints());

        //6. Test increasePoints for an inactive player, it should be FALSE
        //Check points of player are the same before and after calling the method
        player4.setActive(false);
        System.out.println("\n6.\nIncrease Points for inactive: " + player4.increasePoints(50)); // false
        System.out.println("Points after failed increase: " + player4.getPoints());

        //7. Test decreasePoints (5 points) for a player with enough points (100)
        //Check points of player are 95 after calling the method;
        System.out.println("\n7.\nDecrease Points: " + player1.decreasePoints(5)); // true
        System.out.println("Points after decrease: " + player1.getPoints());

        //8. Test decreasePoints (150 points) for a player with (95 points), it should be TRUE
        //Check points of player are 0 after calling the method;
        player1.setPoints(95);
        System.out.println("\n8.\nDecrease Points exceeding: " + player1.decreasePoints(150)); // true
        System.out.println("Points after decrease: " + player1.getPoints());

        //9. Test decreasePoints of a player with negative number (-15), it should be FALSE
        //Check points of player are the same before and after calling the method
        System.out.println("\n9.\nPoints before decrease: " + player2.getPoints());
        System.out.println("Decrease Points with negative value: " + player2.decreasePoints(-15)); // false
        System.out.println("Points after failed decrease: " + player2.getPoints());

        //10. Test decrease points of an inactive player, it should be FALSE
        //Check points of player has not changed after calling the method
        System.out.println("\n10.\nPlayer active: " + player4.isActive());
        System.out.println("Decrease Points for inactive: " + player4.decreasePoints(10)); // false

        //11. Test giveCard() to an active player with 0 cards, it should be true
        //Check cards after calling method
        System.out.println("\n11.\nGive card: " + player1.giveCard()); // true
        System.out.println("Cards after giving: " + player1.getCards());

        //12. Test giveCard() to an active player with 1 cards, it should be true
        //Check cards after calling method
        System.out.println("\n12.\nGive second card: " + player1.giveCard()); // true
        System.out.println("Cards after giving second card: " + player1.getCards());

        //13. Test giveCard() to an active player with 2 cards, it should be false
        //Check cards after calling method
        System.out.println("\n13.\nGive third card: " + player1.giveCard()); // false
        System.out.println("Cards after failed attempt: " + player1.getCards());

        //Getters
        //14. getName
        System.out.println("\n14.\nPlayer name: " + player1.getName());

        //15. getSurname
        System.out.println("\n15.\nPlayer surname: " + player1.getSurname());

        //16. getHeight
        System.out.println("\n16.\nPlayer height: " + player1.getHeight());

        //17. getWeight
        System.out.println("\n17.\nPlayer weight: " + player1.getWeight());

        //18. getAge
        System.out.println("\n18.\nPlayer age: " + player1.getAge());

        //19. getSex
        System.out.println("\n19.\nPlayer sex: " + player1.getSex());

        //20. getTeam
        System.out.println("\n20.\nPlayer team: " + player1.getTeam());

        //21. getTeam -> getName
        System.out.println("\n21.\nPlayer team name: " + player1.getTeam().getName());

        //22. getTeam -> getCountry
        System.out.println("\n22.\nPlayer team country: " + player1.getTeam().getCountry());

        //23. getPosition
        System.out.println("\n23.\nPlayer position: " + player1.getPosition());

        //24. getPoints
        System.out.println("\n24.\nPlayer points: " + player1.getPoints());

        //25. getCards
        System.out.println("\n25.\nPlayer cards: " + player1.getCards());

        //26. isActive
        System.out.println("\n26.\nPlayer active: " + player1.isActive());

        //Setters
        //27. setName
        player1.setName("Don");
        System.out.println("\n27.\nUpdate Player name: " + player1.getName());

        //28. setSurname
        player1.setSurname("Cangrejo");
        System.out.println("\n28.\nUpdate Player surname: " + player1.getSurname());

        //29. setHeight
        player1.setHeight(200.0f);
        System.out.println("\n29.\nUpdate Player height: " + player1.getHeight());

        //30. setWeight
        player1.setWeight(100.1f);
        System.out.println("\n30.\nUpdate Player weight: " + player1.getWeight());

        //31. setAge
        player1.setAge((byte) 99);
        System.out.println("\n31.\nUpdate Player age: " + player1.getAge());

        //32. setTeam
        player1.setTeam(Team.RM);
        System.out.println("\n32.\nUpdate Player team: " + player1.getTeam());

        //33. setPosition
        player1.setPosition(Position.DEFENDER);
        System.out.println("\n33.\nUpdate Player position: " + player1.getPosition());

        //34. setPoints
        player1.setPoints(111);
        System.out.println("\n34.\nUpdate Player points: " + player1.getPoints());

        //35. setActive
        player1.setActive(true);
        System.out.println("\n35.\nUpdate Player active: " + player1.isActive());
    }
}
