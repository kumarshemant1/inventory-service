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
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(path = "/warehouse", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class WarehouseController {

	@PostMapping()
	public ResponseEntity<Warehouse> createWarehouse(@RequestBody @Valid Warehouse warehouse) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new Warehouse());
	}
	
	@GetMapping(path = "/{warehouseId}")
	public ResponseEntity<Warehouse> getWarehouse(@PathVariable Long warehouseId) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new Warehouse());
	}
	
	@PutMapping(path = "/{warehouseId}")
	public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long warehouseId, @RequestBody @Valid Warehouse warehouse) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new Warehouse());
	}
	
	@DeleteMapping(path = "/{warehouseIds}")
	public ResponseEntity<Integer> deleteWarehouses(@PathVariable List<Long> warehouseIds) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(5);
	}
	
	@GetMapping(path = "/fetch")
	public String getByPage(@RequestParam(value = "page", defaultValue = "2") int page, 
			@RequestParam(value = "limit", required = false) Integer limit) {
		return "Values are page : " + page + ", limit : " + limit;
	}
}
