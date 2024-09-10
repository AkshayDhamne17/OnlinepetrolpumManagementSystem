package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.EmployeeModel;

public interface EmployeeService {
   public boolean isAddNewEmployee(EmployeeModel model);
	public List<EmployeeModel> getAllEmployees();
	public boolean allocateMachine(int eid, int mid, String... x);
	public int verifyEmployee(String email,String contact);
	public EmployeeModel getProfile(int employeeId);
}
