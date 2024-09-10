package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.FuelTypeModel;

public interface FuelService {
	
 public boolean isAddFuelType(FuelTypeModel model);
	public List<FuelTypeModel> getAllFuelTypes();
 
}
