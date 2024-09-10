package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.EmployeeModel;
import org.petrolpump.admin.repository.*;
public class EmployeeServiceImpl implements EmployeeService{
	EmployeeRepository empRepo=new EmployeeRepositoryImpl();
	
	public boolean isAddNewEmployee(EmployeeModel model) {
		// TODO Auto-generated method stub
		return empRepo.isAddNewEmployee(model);
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return empRepo.getAllEmployees();
	}

	@Override
	public boolean allocateMachine(int eid, int mid, String... x) {
		// TODO Auto-generated method stub
		return empRepo.allocateMachine(eid, mid, x);
	}

	@Override
	public int verifyEmployee(String email, String contact) {
		// TODO Auto-generated method stub
		return empRepo.verifyEmployee(email, contact);
	}

	@Override
	public EmployeeModel getProfile(int employeeId) {
		// TODO Auto-generated method stub
		return empRepo.getProfile(employeeId);
	}

}
