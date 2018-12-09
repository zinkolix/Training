
import com.mphasis.*;
import com.mphasis.pojo.Person;
import com.mphasis.service.PersonService;
import com.mphasis.service.PersonServiceImpl;
import com.mphasis.util.InvalidPersonException;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPersonService {

	@Test
	public void testPersonAge() throws InvalidPersonException {
		Person p = new Person("Poli", 19, "bangalore");
		PersonService p2 = new PersonServiceImpl();
		p2.addNewPerson(p);
		assertTrue(p.getAge() >= 18 && p.getAge()<=60);
	}
	
	@Test
	public void testPersonFind() throws InvalidPersonException{
		PersonService p2 = new PersonServiceImpl();
		assertNotNull(p2.findPersonByName("Polo"));
	
	}
	
	@Test
	public void testFindAll() throws InvalidPersonException {
		PersonService p2 = new PersonServiceImpl();
		assertNotNull(p2.getAllPersons());
	}
	
	@Test(expected = InvalidPersonException.class)
	public void testBoolean() throws InvalidPersonException {
		Person p = new Person("Poli", 10, "bangalore");
		PersonService p2 = new PersonServiceImpl();
		p2.addNewPerson(p);
	}
	
	@Test(expected = InvalidPersonException.class)
	public void testFindPerson() throws InvalidPersonException{
		PersonService p2 = new PersonServiceImpl();
		p2.findPersonByName("ansh");
		
	}
	
	
}
