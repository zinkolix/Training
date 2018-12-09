// Inner class 
public class EventDemo implements Event {

	@Override
	public void doSomething() {
		System.out.println("First Event");

	}

	private static class EventImpl implements Event { // Inner class can be
														// static , public,
														// private or protected

		@Override
		public void doSomething() {
			System.out.println("Second Event");

		}

	}

	public void thirdEvent() {
		class AnotherImpl implements Event {

			@Override
			public void doSomething() {
				System.out.println("Third Event");

			}

		}
		Event e = new AnotherImpl();
		e.doSomething();
	}
	// Using the inner class methods. (General Approach)

	public void secondEvent() {
		Event e = new EventImpl();
		e.doSomething();
	}

	// Forth Event

	public void forthEvent() {
		Event e = new Event() {

			@Override
			public void doSomething() {
				System.out.println("Forth Event");

			}

		};
		e.doSomething();
	}

	// Lambda expression
	public void fifthEvent() {
		Event e = () -> System.out.println("Fifth Event");
		e.doSomething();
	}

	public static void main(String[] args) {
		EventDemo demo = new EventDemo();
		demo.doSomething();
		demo.secondEvent();
		demo.thirdEvent();
		demo.forthEvent();
		demo.fifthEvent();
		// Instantiation of the inner class
		// EventImpl impl = demo.new EventImpl();
		// Instantiation of the static inner class
		EventImpl impl = new EventDemo.EventImpl();
		// impl.doSomething();
	}
}
