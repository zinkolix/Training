
public class TestMaths {
	public static void main(String[] args) {
		//Inner class implementation
		class MathsImpl implements Maths {
			@Override
			public void pi() {
				System.out.println(3.14);
			}
		}
		Maths m2 = new MathsImpl();
		
		//overriding the method
		Maths m1 = new Maths() {
			
			@Override
			public void pi() {
				System.out.println(3.14);
				
			}
		};
		
		//Lambda Expression		
		Maths m = () -> System.out.println(3.14);
		m.pi();
		m1.pi();
		m2.pi();
		
	}
}
