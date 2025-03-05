import static org.junit.jupiter.api.Assertions.*;

import client.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
* Enter a description
*
* @author  <a href="mailto:jseculi@escoladeltreball.org">Joan Seculi</a>
* @version 1.0
* @since   20/02/2022  
* 
*
* This is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation v3.
*
* @see <a href="http://www.gnu.org/licenses/gpl.html">GNU License</a>
*
*
*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientTest {

	Client client1;

	Client client2;

	Client client3;

	
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
		
		// Constructor 1
		client1 = new Client("222222C", "Anne", "Short", "UK", "333333", "45645645J", (byte)30);
		//System.out.println(person2.toString());
		
	
		// Constructor 2
		client2 = new Client("111111AB", "Peter", "Long", "44444444L");
		//System.out.println(person1.toString());

		client3 = new Client("222222C", "Anne", "Short", "UK", "333333", "45645645J",  (byte)30);
		//System.out.println(person3.toString());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(1)
	void testConstructor1() {
		
		//Test constructor 1
		assertTrue(client1.getDebts() == 0);
		assertTrue(client1.isActive());
		
	}
	
	@Test
	@Order(2)
	void testConstructor2() {
		
	
		//Test constructor 2
		assertTrue(client2.getNationality().equals("ES"));
		assertEquals("NOT_PROVIDED", client2.getPhone());
		assertEquals(18, client2.getAge());
		assertTrue(client2.getDebts() == 0);
		assertTrue(client2.isActive());
		
	}
	
	@Test
	@Order(3)
	void testCancelDebtOK() {
		assertTrue(client1.cancelDebts());
		
	}
	

	
	
	
	@Test
	@Order(4)
	void testCancelDebtNoOK() {
		client1.setActive(false);
		assertFalse(client1.cancelDebts());

	}
	
	@Test
	@Order(5)
	void testReduceDebt() {
		client1.setDebts(120.25f);
		assertTrue(client1.reduceDebts(50f));
		assertEquals(70.25, client1.getDebts());

	}
	
	@Test
	@Order(6)
	void testReduceDebt2() {
		client1.setDebts(120.25f);
		assertTrue(client1.reduceDebts(200f));
		assertEquals(0, client1.getDebts());

	}
	
	@Test
	@Order(7)
	void testReduceDebt3() {
		client1.setDebts(120.25f);
		assertFalse(client1.reduceDebts(-200f));
		assertEquals(120.25f, client1.getDebts());

	}
	
	
	@Test
	@Order(8)
	void testIncreaseDebt() {
		client1.setDebts(120.25f);
		assertTrue(client1.increaseDebts(50f));
		assertEquals(170.25, client1.getDebts());

	}
	
	@Test
	@Order(9)
	void testGettersSetters() {

		// getters and setter setAccount & getAccount
		client3.setAccountNum("11111D");
		assertEquals("11111D",client3.getAccountNum());

		// getters and setter setName & getName
		client3.setName("Pepe");
		assertEquals("Pepe", client3.getName());

		// getters and setter setSurname & getSurname
		client3.setSurname("Longer");
		assertEquals("Longer", client3.getSurname());

		// getters and setter setNationality & getNationality
		client3.setNationality("USA");
		assertEquals("USA", client3.getNationality());

		// getters and setter setPhone & getPhone
		client3.setPhone("66666666");
		assertEquals("66666666", client3.getPhone());

		// getters and setter setDni & getDni
		client3.setDni("111111K");
		assertEquals("111111K", client3.getDni());

		// getters and setter setAge & getAge
		client3.setAge((byte) 35);
		assertEquals(35, client3.getAge());

		// Test isActive and getActive
		assertTrue(client3.isActive());
		assertTrue(client1.isActive());
		assertTrue(client2.isActive());

		client3.setActive(false);
		assertFalse(client3.isActive());

	}
	
	

	@Test
	@Order(10)
	void testEqualsAndHashCode() {
		Client c1 = new Client("0000001", "Bugs", "Bunny", "US", "1111111", "11111111A", (byte) 15);
		Client c2 = new Client("0000002", "Marilyn", "Monroe", "US", "2222222", "22222222B", (byte) 27);
		Client c3 = new Client("0000003", "Peter", "Pan", "UK", "3333333", "33333333C", (byte) 12);
		Client c4 = new Client("0000004", "Bart", "Simpson", "UK", "4444444", "44444444D", (byte) 10);
		Client c5 = new Client("0000005", "Mafalda", "Srta.", "AR", "5555555", "55555555E", (byte) 8);
		Client c6 = new Client("0000006", "Lisa", "Simpson", "US", "6666666", "66666666F", (byte) 8);
		Client c7 = new Client("0000007", "Charlie", "Brown", "UK", "7777777", "77777777G", (byte) 8);
		Client c8 = new Client("0000008", "SpongeBob", "SquarePants", "US", "8888888", "88888888H", (byte) 5);
		Client c9 = new Client("0000009", "Patrick", "Star", "US", "9999999", "99999999I", (byte) 5);

		Client c10 = new Client("0000010", "Homer", "Simpson", "US", "1212121", "10101010J", (byte) 45);
		Client c11 = new Client("0000010", "Maggie", "Simpson", "US", "1212121", "11111111K", (byte) 30);

		Client c12 = new Client("0000006", "Lisa", "Simpson", "US", "6666666", "66666666F", (byte) 8);
		Client c13 = new Client("0000007", "Charlie", "Brown", "UK", "7777777", "77777777G", (byte) 8);

		// Test clients amb el mateix accountNum i dni
		assertEquals(c6, c12);
		assertEquals(c7, c13);
		assertEquals(c6.hashCode(), c12.hashCode());
		assertEquals(c7.hashCode(), c13.hashCode());

		// Test clients diferents
		assertNotEquals(c1, c2);
		assertNotEquals(c3, c4);
		assertNotEquals(c5, c6);
		assertNotEquals(c8, c9);

		// Test hashCode per clients diferents
		assertNotEquals(c1.hashCode(), c2.hashCode());
		assertNotEquals(c3.hashCode(), c4.hashCode());
		assertNotEquals(c5.hashCode(), c6.hashCode());
		assertNotEquals(c8.hashCode(), c9.hashCode());
	}
	

}