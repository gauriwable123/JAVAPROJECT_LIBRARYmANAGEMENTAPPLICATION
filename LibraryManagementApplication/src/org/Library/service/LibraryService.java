package org.Library.service;

import org.Library.model.LibraryModel;
import org.Library.model.Student;
import org.Library.repository.LibraryRepository;
import java.util.ArrayList;
public class LibraryService {

	LibraryRepository lRepo=new LibraryRepository();
	
	public boolean isAddbook(LibraryModel lm)
	{
		int bid=lRepo.getId();
    	bid+=1;//
    	lm.setId(bid);
    	boolean b=lRepo.isAddbook(lm);
    	return b;
	}
	public ArrayList getAllBook()
    {
    
    	ArrayList al=lRepo.getAllBook();
		return al.size()>0?al:null;
    }
	public boolean isAddStudent(Student s)
	{
		boolean b=lRepo.isAddStudent(s);
		return b;
	}
	public  LibraryModel findBookById(int bid) {
		
		for(LibraryModel book:lRepo.getAllBook1())
		{
			if(book.getId()==bid)
			{
				return book;
			}
		}
		return null;
	}
	
	
	
	
	
}
