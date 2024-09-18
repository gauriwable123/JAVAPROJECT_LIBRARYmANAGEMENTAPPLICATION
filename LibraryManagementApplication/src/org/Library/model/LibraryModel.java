package org.Library.model;

public class LibraryModel {
private int id;
private String name;
private String author;
private String publication;
private int price;
private String category;
private String status;

public LibraryModel(String name,String author,String publication,int price,String category,String status)
{
	this.name=name;
	this.author=author;
	this.publication=publication;
	this.price=price;
	this.category=category;
	this.status=status;
}
public LibraryModel()
{
	
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
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublication() {
	return publication;
}
public void setPublication(String publication) {
	this.publication = publication;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String isStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
