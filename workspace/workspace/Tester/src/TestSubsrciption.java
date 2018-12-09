import static org.junit.Assert.*;

import org.junit.Test;

public class TestSubsrciption {

	@Test
	public void test_returnEuro() {
		System.out.println("Test if pricePerMonth returns Euro...");
		Subscription sub = new Subscription(200, 2);
		assertTrue(sub.pricePerMonth() == 100.0);
	}
	
	@Test
	public void test_roundUp() {
		System.out.println("Test if pricePerMonth rounds up correctly...");
		Subscription sub = new Subscription(152, 3);
		assertTrue(Math.floor(sub.pricePerMonth()) == 50);
	}
}
