import java.util.Comparator;
import java.util.function.Predicate;

public class PersonPredicates {
	public static Predicate<Person> teenager() {
		Predicate<Person> teen = (p) -> p.getAge() >= 13 && p.getAge() <= 19;
		return teen;
	}
	public static Predicate<Person> young() {
		Predicate<Person> yng = (p) -> p.getAge() >= 20 && p.getAge() <= 40;
		return yng;
	}
	
	public static Comparator<Person> sortByAge() {
		Comparator<Person> pc = (p1, p2) -> p1.getAge() - p2.getAge();
		return pc;
	}

}
