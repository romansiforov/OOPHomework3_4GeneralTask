package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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
	
	public boolean isDuplicatedStudentAddedToCurrentGroup() {
		
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length; j++) {
				if(students[i].equals(students[j]) && i != j) {
					System.out.println(students[i].toString()+" with index "+i+" duplicates student with index "+j+" "+students[j].toString());
					return true;
				}
			}
		}
		
		return false;
	}
	

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(students, other.students);
	}
	
	
	
}
