 package org.techhub.Service;

import java.util.List;

import org.techhub.Model.UserModel;

public interface curdService 
{
 public boolean isinsert(UserModel model);
 public List<UserModel>getAllRecord();
 public boolean isDeleteUserById(int id);
 public boolean isUpdate(UserModel model);
 public UserModel getuserById(int id);
}
