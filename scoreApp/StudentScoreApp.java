
import java.util.Scanner;

public class StudentScoreApp {

	private static Student[] students = new Student[5];
	
	private static int count = 0;
	
	
	// 전체 학생 성적을 조회하다.
	public static void retrieveStudentAll() {		
		for (int i = 0; i < count ; i++) {
			students[i].printStudent();
		}
	}
	
	
	// 순위를 구한다.
	public static void rank() {
		for (int i = 0; i < count; i++) {
			int rank = 1;
			for (int j = 0; j < count; j++) {
				if(students[i].getTotal() < students[j].getTotal()) {
					students[i].setRank(++rank);
				}
			}
		}		
	}
	
	
	/*
	 * 번호로 학생정보를 조회한다.
	 * 번호에 해당하는 학생정보가 존재하는 경우 학생 정보를 참조하는 주소를 반환하고 
	 * 그렇지 않은 경우 null을 반환한다.
	 */
	public static Student findStudentByNo(int no) {
		for (int i = 0; i < count ; i++) {
			if (students[i].getNo() == no) {
				return students[i];
			}	
		}
		return null;
	}
	
	
	
	
	/*
 	 * 이름으로 학생정보를 검색한다.
	 * 동명이인이 존재할 수 있다.
	 */	
	public static void findStudentByName(String name) {
		boolean isExist = false;
		for (int i = 0; i < count ; i++) {
			if (students[i].getName().equals(name)) {
				students[i].printStudent();
				isExist = true;
			}	
		}
		
		if(!isExist) {
			System.out.println("학생정보가 존재하지 않습니다. 정확한 이름을 입력하세요.");
		}
	}
	
	
	/*
	 * 학생정보를 검색하다
	 * 1 : 번호, 2 : 이름, 3 : 종료
	*/
	public static void findStudent() {
		
		Scanner scan = new Scanner(System.in);
		
		do {

			System.out.println("학생성적검색");
			System.out.println("1. 번호");
			System.out.println("2. 이름");
			System.out.println("3. 종료");
			System.out.print("검색하고자 하는 항목을 선택하세요 ");
			int item = Integer.parseInt(scan.nextLine());	
			
			if (item == 1) {
				System.out.print("번호 : ");
				int no = Integer.parseInt(scan.nextLine());	
				Student s = findStudentByNo(no);
				if (s == null) {
					continue;
				}				
				s.printStudent();
				
			} else if (item == 2) {
				System.out.print("이름 : ");
				String name = scan.nextLine();				
				findStudentByName(name);				
						
			} else {
				break;
			}
		
		} while (true);

	}
	

	/*
	 * 학생 성적을 등록하다
	 * 번호, 이름, 국어, 영어, 수학 
	 */
	public static void regiterStudent() {

		Scanner scan = new Scanner(System.in);

		System.out.print("번호 : ");
		int no = Integer.parseInt(scan.nextLine());

		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("국어 : ");
		int kor = Integer.parseInt(scan.nextLine());

		System.out.print("영어 : ");
		int eng = Integer.parseInt(scan.nextLine());

		System.out.print("수학 : ");
		int math = Integer.parseInt(scan.nextLine());

		students[count] = new Student(no, name, kor, eng, math);
		count++;
		rank();
		System.out.println("학생정보가 등록되었습니다.");

	}
	

	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean isExit = false;
		do {

			System.out.println("===== 성적관리시스템 =====");
			System.out.println("1. 성적 등록");
			System.out.println("2. 성적 검색");
			System.out.println("3. 전체 성적 조회");
			System.out.println("4. 종료");
			System.out.print("항목을 선택하세요 ");

			int item = Integer.parseInt(scan.nextLine());
			
						
			switch (item) {
			case 1:
				regiterStudent();
				break;
			case 2:
				findStudent();
				break;
			case 3:
				retrieveStudentAll();
				break;
			case 4:
				isExit = true;
				break;
			}

		} while (!isExit);

	}

}
