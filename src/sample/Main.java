package sample;

public class Main {

	public static void main(String[] args) {
		Student roman = new Student("Roman", "Siforov", Gender.MALE);
		Student dmitry = new Student("Dmitry", "Kudelya", Gender.MALE);
		Student ross = new Student("Ross", "Galler", Gender.MALE);
		Student rick = new Student("Rick", "Grims", Gender.MALE);
		Student ras = new Student("Rass", "Al-gul", Gender.MALE);
		Student wednesday = new Student("Wednesday", "Addams", Gender.FEMALE);
		Student alexandra = new Student("Alexandra", "Siforova", Gender.FEMALE);
		Student herbert = new Student("Herbert", "Schildt", Gender.MALE);
		Student oskar = new Student("Oskar", "Norin", Gender.MALE);
		Student gabby = new Student("Gabriella", "Kapenski", Gender.FEMALE);
		Student out = new Student("Out", "of Scope", Gender.FEMALE);
		
		String student;
		
		CSVStringConverter csvSC = new CSVStringConverter();
		
		StudentScanner ss = new StudentScanner();
		
		Group ia01 = new Group("IA-01");
		
		addStudent(ia01, roman);
		addStudent(ia01, dmitry);
		addStudent(ia01, ross);
		addStudent(ia01, rick);
		addStudent(ia01, ras);
		addStudent(ia01, wednesday);
		addStudent(ia01, alexandra);
		addStudent(ia01, oskar);
		addStudent(ia01, gabby);
		addStudent(ia01, herbert);
		addStudent(ia01, out);
		
		
		searchStudent(ia01, "Siforova");
		
		
		searchStudent(ia01, "Siforo");

		ia01.removeStudentByID(9);
		
		searchStudent(ia01, "Kapenski");
		
		System.out.println(ia01.toString());
		
		ss.addStudentToGroup(ia01);
		
		ia01.sortStudentsByLastName();
		
		System.out.println(ia01.toString());
		
		System.out.println("--------------------------");
		
		student = csvSC.toStringRepresentation(herbert);
		
		System.out.println(student);
		
		Student fetchedStudent = csvSC.fromStringRepresentation(student);
		System.out.println(fetchedStudent.toString());

	}
	
	public static void addStudent(Group group, Student student) {
		try {
			group.addStudent(student);
		}catch(GroupOverflowException e) {
			e.printStackTrace();
		}
	}
	
	public static void searchStudent(Group group, String lastName) {
		try {
			group.searchStudentByLastName(lastName);
		} catch(StudentNotFoundException e) {
			e.printStackTrace();
		}
	}

}
