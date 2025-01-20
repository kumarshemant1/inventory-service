package app.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.inventory.entity.Warehouse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	private WarehouseRepository warehouseRepository;

	public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
		this.warehouseRepository = warehouseRepository;
	}

	@Override
	public Warehouse createWarehouse(@NotNull Warehouse warehouse) {
		Warehouse response = warehouseRepository.save(warehouse);
		return response;
	}

	@Override
	public Warehouse getWarehouse(@NotNull Long warehouseId) {
		return warehouseRepository
			.findById(warehouseId)
			.orElseThrow(() -> new WarehouseNotFoundException("Warehouse not found with warehouseId : " + warehouseId));
	}

	@Override
	public Warehouse updateWarehouse(@NotNull Warehouse warehouse) {
		Optional<Warehouse> existingObject = getWarehouse(warehouse.getWarehouseId());
		Warehouse persistObject = new Warehouse();
		persistObject.setWarehouseId();
		persistObject.setWarehouseName();
		return warehouseRepository.save(persistObject);
	}

	@Override
	public Integer deleteWarehouses(@NotEmpty List<Long> warehouseIds) {
		
		return null;
	}

	

}
