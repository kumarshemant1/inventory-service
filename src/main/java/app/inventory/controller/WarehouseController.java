package app.inventory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.inventory.entity.Warehouse;
import app.inventory.service.WarehouseService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(path = "/warehouse", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class WarehouseController {

	private WarehouseService warehouseService;

	public WarehouseController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@PostMapping
	public ResponseEntity<Warehouse> createWarehouse(@RequestBody @Valid Warehouse warehouse) {
		Warehouse response = warehouseService.createWarehouse(warehouse);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(response);
	}

	@GetMapping(path = "/{warehouseId}")
	public ResponseEntity<Warehouse> getWarehouse(@PathVariable Long warehouseId) {
		Warehouse response = warehouseService.getWarehouse(warehouseId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}

	@PutMapping(path = "/{warehouseId}")
	public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long warehouseId, @RequestBody @Valid Warehouse warehouse) {
		if(!warehouseId.equals(warehouse.getWarehouseId())) {
			
		} 
		Warehouse repsonse = warehouseService.updateWarehouse(warehouse);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repsonse);
	}

	@DeleteMapping(path = "/{warehouseIds}")
	public ResponseEntity<Integer> deleteWarehouses(@PathVariable List<Long> warehouseIds) {
		Integer response = warehouseService.deleteWarehouses(warehouseIds);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}

	@GetMapping(path = "/fetch")
	public String getByPage(@RequestParam(value = "page", defaultValue = "2") int page, 
			@RequestParam(value = "limit", required = false) Integer limit) {
		return "Values are page : " + page + ", limit : " + limit;
	}
}
