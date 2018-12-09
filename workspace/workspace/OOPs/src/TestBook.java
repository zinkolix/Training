import com.mphasis.lib.Book;
import com.mphasis.lib.Member;

public class TestBook {

	public static void main(String[] args) {
		Book b1 = new Book(101, "Everyone has a story", "Savi Sharma", 90);

		
		Member m1 = new Member("Sann");
		Member m2 = new Member("Shelly");
		Member m3 = new Member("jack");
		Member m4 = new Member("joe");
		b1.summary();
		b1.issueBook(m1);
		b1.issueBook(m2);
		b1.issueBook(m3);
	
		m1.status();
//		b1.issueBook(m1);
//		b1.issueBook(m4);

	}

}
