package org.Library.client;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale.Category;
import java.util.Scanner;

import org.Library.model.LibraryModel;
import org.Library.model.Student;
import org.Library.service.LibraryService;

public class LibraryManagementApplication {

	

	public static void main(String[] args) {
		LibraryService lservice=new LibraryService();
		
//		String s1= "abc";
//		s1="xyz";
//		System.out.println(s1);

		do {
		
		System.out.println("1:Add new book");
		System.out.println("2:view all book");
		System.out.println("3:count category wise book");
		System.out.println("4:display category wise books with info");
		System.out.println("5:display author wise book");
		System.out.println("6:add new student");
		System.out.println("7:issue book to students");
		System.out.println("8:show stock after book issue");
		System.out.println("9:view students wise book");
		System.out.println("10:delete  book by author");
		Scanner xyz=new Scanner(System.in);
		int choice=xyz.nextInt();
		
		switch(choice)
		{
		case 1:
			xyz.nextLine();
			System.out.println("enter book name");
			String name=xyz.nextLine();
			System.out.println("enter book author");
			String author=xyz.nextLine();
			System.out.println("enter book publication");
			String publication=xyz.nextLine();
			System.out.println("enter book price");
			int price=xyz.nextInt();
			xyz.nextLine();
			System.out.println("enter book category");
			String category=xyz.nextLine();
			System.out.println("enter book status");
			String status=xyz.nextLine();
			
			LibraryModel lm=new LibraryModel(name,author,publication,price,category,status);
			boolean b=lservice.isAddbook(lm);
    		if(b)
    		{
    			System.out.println("book added success");
    		}
    		else
    		{
    			System.out.println("some problem");
    		}
    		break;
		case 2:
			ArrayList al=lservice.getAllBook();
    		if(al!=null)
    		{
    			for(Object obj:al)
    			{
    				LibraryModel lmodel=(LibraryModel)obj;
    				System.out.println(lmodel.getId()+"\t"+lmodel.getName()+"\t"+lmodel.getAuthor()+"\t"+lmodel.getPublication()+"\t"+lmodel.getPrice()+"\t"+lmodel.getCategory()+"\t"+lmodel.isStatus());
    			}
    		}
    		else
    		{
    			System.out.println("no data present in collection");
    		}
     		break;
     		
		case 3:
			ArrayList al1=lservice.getAllBook();
			ArrayList<LibraryModel>all=new ArrayList<LibraryModel>(al1);
			for(int i=0;i<all.size();i++)
			{
				int count=1;
				for(int j=i+1;j<all.size();j++)
				{
					if((all.get(i)).getCategory().equals((all.get(j)).getCategory()))
					{
						count++;
						all.remove(j);
					}
				}
				System.out.println("category:"+(all.get(i).getCategory())+"------------>"+count);
			}
			break;
		case 4:
			ArrayList al2=lservice.getAllBook();
			ArrayList <LibraryModel>al3=new ArrayList<LibraryModel>(al2);
			xyz.nextLine();
			System.out.println("enter category");
			String Cate=xyz.nextLine();
			
			for(int i=0;i<al3.size();i++)
			{
					if(Cate.equals((al3.get(i)).getCategory()))
					{
						
					  System.out.println("data:"+al3.get(i).getCategory()+"\t"+al3.get(i).getName()+"\t"+al3.get(i).getAuthor()+"\t"+al3.get(i).getId()+"\t"+
							  al3.get(i).getPublication()+"\t"+al3.get(i).getPrice()+"\t"+al3.get(i).isStatus());
					  
					}
			}	
			break;
		case 5:
			ArrayList al4=lservice.getAllBook();
			ArrayList <LibraryModel>al5=new ArrayList<LibraryModel>(al4);
			xyz.nextLine();
			System.out.println("enter author");
			String auth=xyz.nextLine();
			for(int i=0;i<al5.size();i++)
			{
				if(auth.equals((al5.get(i)).getAuthor()))
				{
					 System.out.println("data:"+al5.get(i).getCategory()+"\t"+al5.get(i).getName()+"\t"+al5.get(i).getAuthor()+"\t"+al5.get(i).getId()+"\t"+
							  al5.get(i).getPublication()+"\t"+al5.get(i).getPrice()+"\t"+al5.get(i).isStatus());
					  
				}
			}
			break;
		case 6:
			xyz.nextLine();
			System.out.println("enter id of student");
			int sid=xyz.nextInt();
			xyz.nextLine();
			System.out.println("enter name of student");
			String sname=xyz.nextLine();
			System.out.println("enter contact of student");
			String contact=xyz.nextLine();
 
			Student s=new Student(sid,sname,contact);
			boolean b1=lservice.isAddStudent(s);
    		if(b1)
    		{
    			System.out.println("student added success");
    		}
    		else
    		{
    			System.out.println("some problem");
    		}
    		break;
		case 7:
			xyz.nextLine();
			System.out.println("enter student id");
			String sid1=xyz.nextLine();
			
			System.out.println("enter book id :");
			int bid=xyz.nextInt();
			
			Student stud=new Student();
			LibraryModel bookToIssue=lservice.findBookById(bid);
			if(bookToIssue!=null)
			{
        	   if("available".equals(bookToIssue.isStatus()))
        	   {
        		   stud.setCheckavailability("issue");
        		   bookToIssue.setStatus("issued");
        		   System.out.println("book issued successfully");
        	   }
        	   else
        	   {
        		   System.out.println("book is already issued..");
               }
			}
           else
           {
        	   System.out.println("book not found");
           }
			break;
		case 8:
			ArrayList <LibraryModel>books=lservice.getAllBook();
			System.out.println("Remaining books");
			
			for(LibraryModel book:books)
			{
			if("available".equals(book.isStatus()))
    		{
    				System.out.println(book.getId()+"\t"+book.getName()+"\t"+book.getAuthor()+"\t"+book.getPublication()+"\t"+book.getPrice()+"\t"+book.getCategory()+"\t"+book.isStatus());
    		}
			}
     		break;
		case 10:
			al=lservice.getAllBook();
			boolean flag=false;
			xyz.nextLine();
			System.out.println("enter author");
			String nAutthor=xyz.nextLine();
			
			Iterator i=al.iterator();
			while(i.hasNext())
			{
				LibraryModel lm1=(LibraryModel)i.next();
				if(lm1.getAuthor().equals(nAutthor))
				{
					i.remove();
					flag=true;
					
				}
			}
			if(flag)
			{
				System.out.println("remove successfully");
			}
			else
			{
				System.out.println("not removed");
			}
			
			
			break;
			default:
				System.out.println("wrong choice");
			}
		}
		while(true);
		
	}

	private static Object getAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
