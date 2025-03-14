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
import app.inventory.exception.WarehouseIdMismatchException;
import app.inventory.service.WarehouseService;
import jakarta.servlet.http.HttpServletRequest;
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
	
	@GetMapping
	public ResponseEntity<List<Warehouse>> getWarehouses() {
		List<Warehouse> response = warehouseService.getWarehouses();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}

	@PutMapping(path = "/{warehouseId}")
	public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long warehouseId, @RequestBody @Valid Warehouse warehouse) {
		if(!warehouseId.equals(warehouse.getWarehouseId())) {
			throw new WarehouseIdMismatchException("warehouseId of path variable doesn't match the warehouseId of the warehouse object payload");
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

	/*
	 * if the case is @RequestParam(value = "l", required = false) Integer limit, Spring will now look for a query parameter named "l" in the URL. The limit variable will be assigned the value of the "l" parameter. If the URL is "/fetch?l=20", limit will be assigned the value 20.
	 */
	@GetMapping(path = "/fetch")
	public String getByPage(@RequestParam(value = "page", defaultValue = "2") int page, 
			@RequestParam(value = "limit", required = false) Integer limit) {
		return "Values are page : " + page + ", limit : " + limit;
	}
	
	@GetMapping(path = "/servlet")
	public String fetchServlet(HttpServletRequest httpServletRequest) {
		return "Session ID : " + httpServletRequest.getSession().getId() + 
				" Protocol : " + httpServletRequest.getProtocol() + 
				" AuthType : " + httpServletRequest.getAuthType();
	}
}
