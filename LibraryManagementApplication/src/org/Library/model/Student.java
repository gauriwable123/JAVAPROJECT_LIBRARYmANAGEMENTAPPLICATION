package org.Library.model;

import java.util.ArrayList;

public class Student {
private int sid;
private String sname;
private String contact;
private ArrayList LibraryModel;
private String checkavailability;


public Student(int sid,String sname,String contact)
{
	this.sid=sid;
	this.sname=sname;
	this.contact=contact;
	
}
public Student()
{
	
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getsName() {
	return sname;
}
public void setsName(String sname) {
	this.sname = sname;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public ArrayList getLibraryModel() {
	return LibraryModel;
}
public void setLibraryModel(ArrayList libraryModel) {
	LibraryModel = libraryModel;
}
public String getCheckavailability() 
{
	return checkavailability;
}
public void setCheckavailability(String checkavailability) {
	this.checkavailability = checkavailability;
}

}


