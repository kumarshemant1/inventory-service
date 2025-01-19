package app.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.inventory.entity.Warehouse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Override
	public Warehouse createWarehouse(@NotNull Warehouse warehouse) {
		
		return null;
	}

	@Override
	public Warehouse getWarehouse(@NotNull Long warehouseId) {
		
		return null;
	}

	@Override
	public Warehouse updateWarehouse(@NotNull Warehouse warehouse) {
		
		return null;
	}

	@Override
	public Integer deleteWarehouses(@NotEmpty List<Long> warehouseIds) {
		
		return null;
	}

	

}
