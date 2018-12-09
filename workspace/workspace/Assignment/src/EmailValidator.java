/*Rules to validate email
 * 1- Min 4 chars before @
 * 2- Min 3 chars between @ and .
 * 3- Min 2 chars after .
 * 4- Only one @ and . in email  
 */
public class EmailValidator {

	public static void main(String[] args) {
		String email = "zubair@gmail.com";
		int i = email.indexOf('@') ;
		int	j =  email.indexOf('.');			
		if( i > 3 && j - i - 1 > 2 && email.length() - j - 1 > 1 && email.indexOf('@', i + 1) == -1 && email.indexOf('.', j + 1) == -1 )
			System.out.println("Email validated");
		else 
			System.out.println("Email Not valid");
	}

}
