package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.FuelTypeModel;
import org.petrolpump.admin.repository.*;
public class FuelTypeServiceImpl implements FuelService {
	 FuelRepository fuelrepo= new  FuelRepositoryImpl();
	
	public boolean isAddFuelType(FuelTypeModel model) {
		
		return fuelrepo.isAddFuelType(model);
	}

	@Override
	public List<FuelTypeModel> getAllFuelTypes() {
		return fuelrepo.getAllFuelTypes();
	}

}
