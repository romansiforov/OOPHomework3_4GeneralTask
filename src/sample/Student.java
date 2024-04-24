package sample;

public class Student extends Human{
	private int id = 0;
	private String groupName = null;
	
	public Student() {
		super();
	}
	
	public Student(String name, String lastName, Gender gender) {
		super(name, lastName, gender);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName=" + 
				groupName + ",name="+super.getName()+
				", last name="+ super.getLastName()+
				", gender="+super.getGender()+"]";
	}
	
	
}
