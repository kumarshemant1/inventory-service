package app.inventory.entity;

import java.sql.Timestamp;

import app.inventory.util.Constant;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = Constant.INVENTORY_SCHEMA, name = Constant.WAREHOUSE_TABLE)
public class Warehouse {
	
	private Long warehouseId;
	
	private String warehouseName;
	
	private Location location;
	
	private boolean functional; 
	
	private String createdBy;
	
	private Timestamp createdAt;
	
	private String changedBy;
	
	private Timestamp changedAt;
}
