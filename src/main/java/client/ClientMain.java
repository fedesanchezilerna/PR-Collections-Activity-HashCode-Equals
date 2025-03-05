package client;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("========== TESTS ==========");

        // Use Constructor 1
        System.out.println("\nUse Constructor 1");
        Client client1 = new Client("000001", "Lenny", "Kravitz", "US", "612345678", "1234567", (byte) 60);
        System.out.println(client1);

        // Check attributes debt and active are initialize
        System.out.println("\nCheck attributes debt and active are initialize");
        System.out.println("client1 debts:\t\t\t\t\t" + client1.getDebts());
        System.out.println("client1 active:\t\t\t\t\t" + client1.isActive());

        // Use Constructor 2
        System.out.println("\nUse Constructor 2");
        Client client2 = new Client("111111", "Madonna", "Ciccone", "7654321");
        System.out.println(client2);

        // Check all other attributes that are not in the constructor are initialize
        System.out.println("\nCheck all other attributes that are not in the constructor are initialize");
        System.out.println("Client2 nationality:\t\t\t\t" + client2.getNationality());
        System.out.println("Client2 phone:\t\t\t\t\t" + client2.getPhone());
        System.out.println("Client2 age:\t\t\t\t\t" + client2.getAge());
        System.out.println("Client2 debts:\t\t\t\t\t" + client2.getDebts());
        System.out.println("Client2 active:\t\t\t\t\t" + client2.isActive());

        // Test getters and setter setAccount & getAccount
        System.out.println("\nTest getters and setter setAccount & getAccount");
        client1.setAccountNum("420");
        System.out.println("Client1 accountNum:\t\t\t\t" + client1.getAccountNum());

        // Test getters and setter setName & getName
        System.out.println("\nTest getters and setter setName & getName");
        client1.setName("Leonard Albert");
        System.out.println("Client1 name:\t\t\t\t\t" + client1.getName());

        // Test getters and setter setSurname & getSurname
        System.out.println("\nTest getters and setter setSurname & getSurname");
        client2.setSurname("Louise Ciccone");
        System.out.println("Client2 name:\t\t\t\t\t" + client2.getSurname());

        // Test getters and setter setNationality & getNationality
        System.out.println("\nTest getters and setter setNationality & getNationality");
        client2.setNationality("US");
        System.out.println("Client2 nationality:\t\t\t\t" + client2.getNationality());

        // Test getters and setter setPhone & getPhone
        System.out.println("\nTest getters and setter setPhone & getPhone");
        client2.setPhone("666-666-666");
        System.out.println("Client2 phone:\t\t\t\t\t" + client2.getPhone());

        // Test getters and setter setDni & getDni
        System.out.println("\nTest getters and setter setDni & getDni");
        client2.setDni("M4D0NN4");
        System.out.println("Client2 dni:\t\t\t\t\t" + client2.getDni());

        // Test getters and setter setAge & getAge
        System.out.println("\nTest getters and setter setAge & getAge");
        client2.setAge(Byte.MAX_VALUE);
        System.out.println("Client2 age:\t\t\t\t\t" + client2.getAge());

        // Test getters and setter setDebt & getDebt
        System.out.println("\nTest getters and setter setDebt & getDebt");
        client2.setDebts(3000.120f);
        System.out.println("Client2 debt:\t\t\t\t\t" + client2.getDebts());

        // Test isActive and setActive
        System.out.println("\nTest isActive and setActive");
        client1.setActive(false);
        System.out.println("Client1 active:\t\t\t\t\t" + client1.isActive());

        // Test toString
        System.out.println("\nTest toString");
        System.out.println(client1);
        System.out.println(client2);

        // Test cancelDebts
        System.out.println("\nTest cancelDebts");
        client2.cancelDebts();
        System.out.println("Client2 debts:\t\t\t\t\t" + client2.getDebts());


        System.out.println("\nTest reduce & increase debts");
        // Test reduceDebt with amount = 50 (set initial debt to 120.25), result = true, debt = 70.25
        client2.setDebts(120.25f);
        System.out.println("Reduce debts by 50:\t\t\t\t" + client2.reduceDebts(50f));
        System.out.println("Debt after reduce:\t\t\t\t" + client2.getDebts());

        // Test reduceDebt with amount = 150 (set initial debt to 120.25), result = true, debt = 0
        client2.setDebts(120.25f);
        System.out.println("Reduce debts by 150:\t\t\t" + client2.reduceDebts(150f));
        System.out.println("Debt after reduce:\t\t\t\t" + client2.getDebts());

        // Test reduceDebt with amount = -100 (set initial debt to 120.25), result = false, debt = 120.25
        client2.setDebts(120.25f);
        System.out.println("Reduce debts by -100:\t\t\t" + client2.reduceDebts(-100f));
        System.out.println("Debt after reduce:\t\t\t\t" + client2.getDebts());

        // Test increaseDebt with amount = 50 (set initial debt to 120.25), result = true, debt = 170.25
        client2.setDebts(120.25f);
        System.out.println("Increase debts by 50:\t\t\t" + client2.increaseDebts(50f));
        System.out.println("Debt after increase:\t\t\t" + client2.getDebts());

        // Test increaseDebt with amount = -50 (set initial debt to 120.25), result = false, debt = 120.25
        client2.setDebts(120.25f);
        System.out.println("Increase debts by -50:\t\t\t" + client2.increaseDebts(-50f));
        System.out.println("Debt after increase:\t\t\t" + client2.getDebts());
    }
}