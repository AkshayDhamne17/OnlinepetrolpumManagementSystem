package org.petrolpump.admin.service;

import java.util.*;

import org.petrolpump.admin.model.*;

public interface MachineService {
 public boolean isAddNewMachine(MachineModel model,String typeId[],String capacity[]);
	public List<Object []> getallMachines();
	public boolean isDeleteMachineById(int mid);
	public boolean isUpdateMachine(MachineModel model);
}
