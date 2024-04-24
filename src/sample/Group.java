package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName;
	private Student[] students = new Student[10];
	
	public Group() {
		
	}
	
	public Group(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	
	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
	}
	
	
	
	public void addStudent(Student student) throws GroupOverflowException {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null && i != students.length) {
				student.setId(i+1);
				student.setGroupName(this.getGroupName());
				students[i] = student;
				System.out.println("The student was added to group");
				System.out.println("----------------------------------");
				break;
			}
			if(students[i] != null && i == students.length-1) {
				throw new GroupOverflowException("No free place for a student");
			}
		}
	}
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
		for(int i = 0; i < students.length; i++) {
			if(students[i]!=null && students[i].getLastName().equals(lastName)) {
				System.out.println("The student "+students[i].getLastName()+" has been found");
				System.out.println(students[i].toString());
				System.out.println("----------------------------------");
				return students[i];
			}
		}
		throw new StudentNotFoundException("No such a student "+lastName);
	}
	
	public boolean removeStudentByID(int id) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].getId() == id) {
				System.out.println("The student"+ students[i].getName() +"has been deleted");
				students[i] = null;
			}
		}
		return true;
	}
	

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}
	
	
}
