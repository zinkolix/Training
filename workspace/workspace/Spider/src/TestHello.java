
public class TestHello {
	public static void main(String[] args) {
		Hello hi = (n) -> {
			return "Hello " + n;
		};
		
		System.out.println(hi.sayHello("Anshu"));
		hi.sayGoodbye();
		Hello.sayGreeting();
	}
}
