import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest1 {
	private Collection<String> collection;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		// One - time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp");
		
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		// One - time clean up code
		System.out.println("@AfterClass - oneTimeTearDown");
	}
	
	@Before
	public void setUp() {
		collection = new ArrayList<String>();
		System.out.println("@Before - setUp");
	}
	
	@After
	public void tearDown() {
		collection.clear();
		System.out.println("@After - tearDown");
	}
	
	@Test
	public void testEmptyCollection() {
		assertTrue(collection.isEmpty());
		System.out.println("@Test - testEmptyCollection");
	}
	
	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		collection.add("itemB");
		assertEquals(1, collection.size());
		System.out.println("@Test - testOneItemCollection");
	}
}
