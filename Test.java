import java.time.LocalDate;
import java.util.Scanner;

public class Test {
	
	
	public static boolean isValid(String ssn) {
		
		int[] check = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
		
		int total = 0; 
		for (int i = 0; i < check.length; i++) {
			int temp = ssn.charAt(i) - '0';
			total += check[i] * temp;
		}
		
		int result = total % 11;
		result = 11 - result;
		
		if (result >= 10) {
			result %= 10;
		}
		
		
		if (result == (ssn.charAt(ssn.length()-1) - '0')) {
			return true;
		}
		
		return false;
	}
	
	

	public static void main(String[] args) {
		
		System.out.print("주민등록번호를 입력하세요 (000000-0000000) ");
		
		Scanner scan = new Scanner(System.in);
		String ssn = scan.nextLine();
		
		boolean result = isValid(ssn);
		
		if (!result) {
			System.out.println("유효한 주민번호가 아닙니다.");
			return;
		}
		
		
		
		if (ssn.charAt(7) == '1' || ssn.charAt(7) == '3') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
	
		
		LocalDate date = LocalDate.now();
		int year = date.getYear();
	
		if (ssn.charAt(7) == '1' || ssn.charAt(7) == '2') {
			//1900년도
			System.out.println( year - (1900 + Integer.parseInt(ssn.substring(0, 2))) );
			
		} else {
			//2000년도
			System.out.println( year - (2000 + Integer.parseInt(ssn.substring(0, 2))) );
		}

	}

}
