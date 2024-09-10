package org.petrolpump.admin.repository;


import java.util.*;

import org.petrolpump.admin.model.FuelTypeModel;

public interface FuelRepository {
	 public boolean isAddFuelType(FuelTypeModel model);
	 public List<FuelTypeModel> getAllFuelTypes();
	 
}
