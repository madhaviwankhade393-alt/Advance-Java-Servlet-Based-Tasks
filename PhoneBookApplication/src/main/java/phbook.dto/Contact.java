package phbook.dto;

public class Contact {

private int id;
private String name;
private String phNumber;
private boolean blocked;
private String createdOn;
public Contact() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhNumber() {
	return phNumber;
}
public void setPhNumber(String phNumber) {
	this.phNumber = phNumber;
}
public boolean isBlocked() {
	return blocked;
}
public void setBlocked(boolean blocked) {
	this.blocked = blocked;
}
public String getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(String createdOn) {
	this.createdOn = createdOn;
}
public Contact(int id, String name, String phNumber, boolean blocked, String createdOn) {
	super();
	this.id = id;
	this.name = name;
	this.phNumber = phNumber;
	this.blocked = blocked;
	this.createdOn = createdOn;
}
@Override
public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", phNumber=" + phNumber + ", blocked=" + blocked + ", createdOn="
			+ createdOn + "]";
}
	
	
	













}
