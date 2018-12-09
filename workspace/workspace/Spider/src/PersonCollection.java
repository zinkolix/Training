import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class PersonCollection {
	

	public static void main(String[] args) {
		ArrayList<Person> lst = new ArrayList<Person>();
		lst.add(new Person("Polo", 21));
		lst.add(new Person("Lili", 20));
		lst.add(new Person("Mili", 19));
		
		Predicate<Person> teen = PersonPredicates.teenager();
		Predicate<Person> yng = PersonPredicates.young();
		Predicate<Person> str = yng.and((p) -> p.getName().equals("Polo"));
		
		Comparator<Person> pc = PersonPredicates.sortByAge();
		SortedSet<Person> sort = new TreeSet(pc);
		for (Person p : lst) {
//			if(str.test(p))
//			System.out.println(p);
//			if(yng.test(p))
//				System.out.println("young: " + p);
			System.out.println(p);
		}
		Collections.sort(lst,PersonPredicates.sortByAge());
		lst.forEach((p) -> p.print());
		
		//lst.forEach((p) -> p.print());
	}
}
