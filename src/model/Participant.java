package model;

public class Participant implements Comparable<Participant>{
	
	private String id;
	private String firstName ;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	//private ¿avatar? photo
	
	private Participant rigth;
	private Participant left;
	
	private Participant next;
	private Participant preovious;
	
	public Participant(String id, String firstName, String lastName, String email, String gender, String country
			) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public int compareTo(Participant arg0) {
			int resul = 0;
			if(firstName.compareToIgnoreCase(arg0.getFirstName())>0){
				resul = 1;
			}
			else if(firstName.compareToIgnoreCase(arg0.getFirstName())<0){
				resul = -1;
			}else {
				resul = 0;
			}
		return resul;
	}
	public Participant getRigth() {
		return rigth;
	}
	public void setRigth(Participant right) {
		this.rigth = right;
	}
	public Participant getLeft() {
		return left;
	}
	public void setLeft(Participant left) {
		this.left = left;
	}
	@Override
	public String toString() {
		return firstName + "\t" + lastName + "\n";
	}
	public Participant getNext() {
		return next;
	}
	public void setNext(Participant next) {
		this.next = next;
	}
	public Participant getPreovious() {
		return preovious;
	}
	public void setPreovious(Participant preovious) {
		this.preovious = preovious;
	}
}
