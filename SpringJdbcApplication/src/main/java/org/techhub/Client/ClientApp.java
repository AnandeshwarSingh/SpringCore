package org.techhub.Client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.techhub.DBConfig.JdbcConfig;
import org.techhub.Model.UserModel;
import org.techhub.Service.curdServiceImpl;
import java.util.*;

public class ClientApp {

	public static void main(String[] args)
	{
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
	  curdServiceImpl curdservice=(curdServiceImpl)context.getBean("curdservice");
	  do
	  {
		  System.out.println("1: insert record");
		  System.out.println("2: View All Record");
		  System.out.println("3: delete record by id");
		  System.out.println("4: update record by id");
		  System.out.println("5: serach employee by id");
		  System.out.println("enetr choice");
		  
		  Scanner xyz=new Scanner(System.in);
		  int ch=xyz.nextInt();
		  switch(ch)
		  {
		  case 1:
			  System.out.println("enetr name and salary");
			  xyz.nextLine();
			  String name=xyz.nextLine();
			  int salary=xyz.nextInt();
//			  int id=xyz.nextInt();
			  
			  UserModel model=new UserModel();
			  boolean b=curdservice.isinsert(model);
			  if(b)
			  {
				  System.out.println("Record Inserted Successfully");
			  }
			  else
			  {
				  System.out.println("Some problem is there");
			  }
			  
			  
			   
			  break;
			  
		  case 2:
			 
			  List<UserModel>list=curdservice.getAllRecord();
			  for(UserModel us:list)
			  {
				  System.out.println(us.getName()+ "\t" +us.getSalary());
			  }
			  break;
			  
		  case 3:
			  System.out.println("enetr Id");
			  int id=xyz.nextInt();
			   b=curdservice.isDeleteUserById(id);
			   if(b)
			   {
				   System.out.println("Record Delted successfully");
			   }
			   
			   else
			   {
				   System.out.println("Some problem is there");
			   }
			  break;
			  
		  case 4:
			  System.out.println("enetr name and salary");
			  xyz.nextLine();
			  name=xyz.nextLine();
			  salary=xyz.nextInt();
			  
			  System.out.println("enetr Id");
			   id=xyz.nextInt();
			   UserModel mod=new UserModel();
			   mod.setName(name);
			   mod.setSalary(salary);
			   mod.setId(id);
			   b=curdservice.isUpdate(mod);
			   if(b)
			   {
				   System.out.println("Record Upadted Successfully");
			   }
			   else
			   {
				   System.out.println("Some problem is there");
			   }
			   
			  break;
			  
		  case 5:
			  System.out.println("enetr Id");
			   id=xyz.nextInt();
			   model=curdservice.getuserById(id);
			   System.out.println(model.getName()+ "\t" +model.getSalary());
			  break;
			  
			  default:
				  
				  System.out.println("wrong choice");
			     
		  }
		  
		  
	  }while(true);
	}

}
