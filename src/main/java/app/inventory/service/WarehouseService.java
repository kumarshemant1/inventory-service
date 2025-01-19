package app.inventory.service;

import java.util.List;

import app.inventory.entity.Warehouse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface WarehouseService {

	Warehouse createWarehouse(@NotNull Warehouse warehouse);
	
	Warehouse getWarehouse(@NotNull Long warehouseId);
	
	Warehouse updateWarehouse(@NotNull Warehouse warehouse);
	
	Integer deleteWarehouses(@NotEmpty List<Long> warehouseIds);
}
