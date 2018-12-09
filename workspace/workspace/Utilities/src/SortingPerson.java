import java.util.SortedSet;
import java.util.TreeSet;

public class SortingPerson {

	public static void main(String[] args) {
		PersonComparator pc = new PersonComparator();
		SortedSet<Person> sort = new TreeSet();
		
		sort.add(new Person("Polo ", 21));
		sort.add(new Person("lili ", 20));
		sort.add(new Person("Milli ", 19));
		
		for (Person p : sort) {
			System.out.println(p);
		}
		
	}

}
