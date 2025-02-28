package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.Model.UserModel;

@Repository("curdRepo ")
public class curdrepoImpl  implements curdRepo
{
     @Autowired
     JdbcTemplate template;
     List<UserModel>list;
    
	public boolean isinsert( final UserModel model)
	{
		int value=template.update("insert into employee values('0',?,?)", new  PreparedStatementSetter()
				
				{

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, model.getName());
						ps.setInt(2, model.getSalary());
						ps.setInt(3, model.getId());
						
						
					}
			
				});
		if(value>0)
		{
			return true;
		}
		else
		{	
		return false;
		}
	}
	
	
	public List<UserModel> getAllRecord()
	{
		list=template.query("select * from employee", new RowMapper<UserModel>()
				{

					public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						UserModel u=new UserModel();
						u.setId(rs.getInt(1));
						u.setName(rs.getString(2));
						u.setSalary(rs.getInt(3));
						return u;
					}
			
				});
		return list;
	}


	public boolean isDeleteUserById(int id)
	{
	  int value=template.update("delete from employee where eid=?", new Object[] {id});	
	  if(value>0)
	  {
		  return true;
	  }
	  else
	  {	  
		return false;
	  }
	}


	public boolean isUpdate(final UserModel model) 
	{
		int value=template.update("update employee set name=? , salary=? where eid=?",new PreparedStatementSetter()
				{

					public void setValues(PreparedStatement ps) throws SQLException 
					{
						
						ps.setString(1, model.getName());
						ps.setInt(2, model.getSalary());
						ps.setInt(3, model.getId());
						
						
					}
			      
				});
		if(value>0)
		{
			return true;
		}
		else
		{	
		  return false;
		}
	}


	public UserModel getuserById(int id)
	{  
		List<UserModel> list = template.query("select * from employee where eid=?",new Object[] {id}, new RowMapper<UserModel>() {
        public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException 
        {
            UserModel mod = new UserModel();
            mod.setId(rs.getInt("eid")); 
            mod.setName(rs.getString("name"));
            mod.setSalary(rs.getInt("salary"));
            return mod;
        }
    });
		return list.isEmpty() ? null : list.get(0);
	}

}
