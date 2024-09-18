package org.Library.repository;

import java.util.ArrayList;
import org.Library.model.LibraryModel;
import org.Library.model.Student;

public class LibraryRepository {

	static ArrayList al=new ArrayList();//it is my temporary database
	
	
	public boolean isAddbook(LibraryModel lm) {
		boolean b=al.add(lm);
		return b;
	}
	public int getId() 
	{	
		return al.size();
	}
	public ArrayList getAllBook()
	{
		return al;
	}
    public boolean isAddStudent(Student s)
     {
	  boolean b=al.add(s);
	  return b;
     }
    public ArrayList<LibraryModel>getAllBook1()
    {
		return al;
    	
    }
    
 
}
