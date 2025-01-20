package app.inventory.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import app.inventory.util.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Warehouse implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "warehouse_id")
	private Long warehouseId;
	
	@Column(name = "warehouse_name")
	private String warehouseName;
	
	private Location location;
	
	@Column(name = "functional")
	private boolean functional; 
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "changed_by")
	private String changedBy;
	
	@Column(name = "changed_at")
	private Timestamp changedAt;
	
	@Override
	public Warehouse clone() {
		try {
			return (Warehouse) super.clone();
		} catch (CloneNotSupportedException ex) {
			throw new AssertionError();
		}
	}
}
