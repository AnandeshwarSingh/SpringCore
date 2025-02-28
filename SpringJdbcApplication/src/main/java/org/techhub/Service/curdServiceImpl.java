package org.techhub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.Model.UserModel;
import org.techhub.repository.curdRepo;
import org.techhub.repository.curdrepoImpl;
@Service("curdservice")
public class curdServiceImpl implements curdService
{
    @Autowired
    //curdrepoImpl curdrepoimpl;
    curdRepo curdrepo;
	public boolean isinsert(UserModel model) 
	{
		
		return curdrepo.isinsert(model);
	}
	public List<UserModel> getAllRecord() 
	{
		
		return curdrepo.getAllRecord();
	}
	public boolean isDeleteUserById(int id) 
	{
		
		return curdrepo.isDeleteUserById(id);
	}
	public boolean isUpdate(UserModel model)
	{
		
		return curdrepo.isUpdate(model);
	}
	public UserModel getuserById(int id) {
		
		return curdrepo.getuserById(id);
	}

}
