package bean;




public class Student {
	private int id;
	private String firstname;
	private String lastname;
    private String email;
	private String contact;
	private String gender;
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname=firstname;
	}

	public  String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname=lastname;
	}
	

	

	public  String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}
	public  String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact=contact;
	}
	
	public  String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender=gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
		
	}

}
