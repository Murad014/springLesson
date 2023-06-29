package com.UnitTest.UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UnitTestApplicationTests {
	UnitTestApplication unitTestApplication;



	@Test
	@Order(1)
	void testEqualsOrNotEquals(){
		System.out.println("Test moethod name: testEqualsOrNotEquals()");
		assertEquals(6, unitTestApplication.add(4, 2), "4 + 2 = 6");
		assertNotEquals(8, unitTestApplication.add(4, 2), "4 + 2 = 6");
	}

	@Test
	@DisplayName("Check is null and not null")
	@Order(3)
	void test_Is_Null(){
		System.out.println("Test moethod name: testIsNUll()");

		String str = null;
		String str02 = "test";
		assertNull(unitTestApplication.checkNull(str), "Must be null");
		assertNotNull(unitTestApplication.checkNull(str02), "Must be null");
	}

	@Test
	@DisplayName("Same Reference or not")
	@Order(2)
	void sameReferenceOrNot(){
		System.out.println("Test method name: sameReferenceOrNot");
		String s = unitTestApplication.sameRefOrNot();
		String s2 = s;
		assertSame(s, s2, "Must be same");
	}

	@Test
	@DisplayName("True and False")
	void testTrueAndFalse(){
		assertTrue(1==1, "Must be true");
		assertFalse(3!=3, "Must be true");

	}

	@Test
	@DisplayName("Same Array and Iterable")
	public void sameArrayAndIterable(){
		List<String> list01 = new ArrayList<>(Arrays.asList("Java", "Python", "Javascript"));
		List<String> list02 = new ArrayList<>(Arrays.asList("Java", "Python", "Javascript"));
		assertIterableEquals(list01, list02, "Must be same List");

		String[] arr01 = {"Java SE", "Java EE"};
		String[] arr02 = {"Java SE", "Java EE"};
		assertArrayEquals(arr01, arr02, "Arrays must be same");

	}

	@Test
	@DisplayName("Exception test")
	public void hasException(){
		assertThrows(Exception.class, () -> unitTestApplication.isNegative(-1), "Exception has");
		assertDoesNotThrow(() -> unitTestApplication.isNegative(5), "No Exception");


	}


	@Test
	@DisplayName("Sleep test")
	public void sleepTest(){
		assertTimeout(Duration.ofSeconds(1), () -> unitTestApplication.isSleep(), "Just have 5 seconds!");
	}





	@BeforeEach
	public void beforeEachTest(){
		System.out.println("@BeforeEach ....");
		unitTestApplication = new UnitTestApplication();
	}

	@AfterEach
	public void afterEach(){
		System.out.println("@afterEach");
	}

	@BeforeAll
	public static  void beforeAll(){
		System.out.println("@BeforeAll ... ");
	}

	@AfterAll
	public static void afterAll(){
		System.out.println("@AfterAll ... ");
	}





//	@Test
//	void contextLoads() {
//
//
//	}

}
