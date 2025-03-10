package app.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.inventory.dao.WarehouseRepository;
import app.inventory.entity.Country;
import app.inventory.entity.Location;
import app.inventory.entity.Warehouse;
import app.inventory.exception.WarehouseNotFoundException;
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
		return warehouseRepository.save(warehouse);
	}

	@Override
	public Warehouse getWarehouse(@NotNull Long warehouseId) {
		return warehouseRepository
			.findById(warehouseId)
			.orElseThrow(() -> new WarehouseNotFoundException("Warehouse not found with warehouseId : " + warehouseId));
	}

	@Override
	public Warehouse updateWarehouse(@NotNull Warehouse warehouse) {
		Warehouse response = null;
		Optional<Warehouse> existingWarehouse = warehouseRepository.findById(warehouse.getWarehouseId());
		if(existingWarehouse.isPresent()) {
			Warehouse persistWarehouse = existingWarehouse.get().clone();
			persistWarehouse.setWarehouseName(warehouse.getWarehouseName());
			persistWarehouse.setFunctional(warehouse.isFunctional());
			persistWarehouse.setChangedBy(warehouse.getChangedBy());
			
			response = warehouseRepository.save(persistWarehouse);
		}
		return response;
	}

	@Override
	public Integer deleteWarehouses(@NotEmpty List<Long> warehouseIds) {
		return warehouseRepository.deleteByWarehouseIdIn(warehouseIds);
	}

	@Override
	public List<Warehouse> getWarehouses() {
		return warehouseRepository.findAll();
	}
}
