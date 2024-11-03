package bean;

public class User {
	private int id;
	private String fname;
	private String lname;
    private String email;
	private String contact;
    private String gender;
    private String password;
	
	public int getId() {
		return id;
	}
    public void setId(int id) {
	this.id=id;
}

    public String getFirstName() {
    	return fname;
    }
    
    public void setFirstName(String fname) {
    	this.fname=fname;
    }
   
    
    public String getLastName() {
    	return lname;
    }
    
    public void setLastName(String lname) {
    	this.lname=lname;
    }
   
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email=email;
    }
    
    public String getContact() {
    	return contact;
    }
    
    public void setContact(String contact) {
    	this.contact=contact;
    }
    
    public String getGender() {
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


