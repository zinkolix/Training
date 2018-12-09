
public class ConvertRoman {
	public static void main(String[] args) {
	
		String roman = "xl";
		int decimal = 0;
		
		for(int i = 0; i < roman.length(); i++){
			char ch = roman.charAt(i);
			if(ch == 'i' || ch == 'I'){
				decimal +=1;
				if(roman.charAt(roman.length()-1) == 'V')
					decimal -=2;
				}else 
					if(ch == 'v' || ch == 'V')
						decimal += 5;
					else
						if(ch == 'X' || ch == 'x')
							decimal += 10;
						else 
							if(ch == 'c' || ch == 'C')
								decimal += 100;
							else
								if(ch == 'd' || ch == 'D')
									decimal += 500;
								else
									if(ch == 'M' || ch == 'm')
										decimal += 1000;
									else
										if(ch == 'l' || ch == 'L')
											decimal += 50;
			}
		System.out.println("Roman Value: " + roman);
		System.out.println("Decimal value: " + decimal);
				
		}
	}
	
	
	
	

