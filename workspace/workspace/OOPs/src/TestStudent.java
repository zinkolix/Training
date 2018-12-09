
public class TestStudent {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Student s1 = new Student("Polo");
		s1.print();
		System.out.println(s1);
		@SuppressWarnings("unused")
		Student s2 =  new Student("lilli");
//		Frustrated f = Student.class.getAnnotation(Frustrated.class);
//		System.out.println(f.level());
	}
}
