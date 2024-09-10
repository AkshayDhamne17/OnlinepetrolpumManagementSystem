package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.MachineModel;
import org.petrolpump.admin.repository.MachineRepository;
import org.petrolpump.admin.repository.MachineRepositoryImpl;

public class MachineServiceImpl implements MachineService{

	MachineRepository m=new  MachineRepositoryImpl();
	@Override
	public boolean isAddNewMachine(MachineModel model,String typeId[],String capacity[]) {
	
		return  m.isAddNewMachine(model,typeId,capacity);
	}
	@Override
	public List<Object []> getallMachines() {
	
		return m.getallMachines();
	}
	@Override
	public boolean isDeleteMachineById(int mid) {
		// TODO Auto-generated method stub
		return m.isDeleteMachineById(mid);
	}
	@Override
	public boolean isUpdateMachine(MachineModel model) {
		// TODO Auto-generated method stub
		return m.isUpdateMachine(model);
	}

}
