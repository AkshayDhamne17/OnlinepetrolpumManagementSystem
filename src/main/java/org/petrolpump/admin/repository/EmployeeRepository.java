package org.petrolpump.admin.repository;

import java.util.*;

import org.petrolpump.admin.model.EmployeeModel;

public interface EmployeeRepository {
	public boolean isAddNewEmployee(EmployeeModel model);
	public List<EmployeeModel> getAllEmployees();
	public boolean allocateMachine(int eid,int mid,String...x);
	public int verifyEmployee(String email, String contact);
	public EmployeeModel getProfile(int employeeId);
}
