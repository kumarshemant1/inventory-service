package app.inventory.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import app.inventory.util.Constant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private Long warehouseId;
	
	@NotBlank(message = "warehouse name can't be blank")
	@Column(name = "warehouse_name")
	private String warehouseName;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "location_id", unique = true) // @JoinColumn(name = "location_id") creates a column in Warehouse table that acts as a foreign key
	private Location location;
	
	@NotNull
	@Column(name = "functional")
	private boolean functional; 
	
	@Column(name = "created_by", updatable = false)
	private String createdBy;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Column(name = "created_at", updatable = false, insertable = false)
	private Timestamp createdAt;
	
	@Column(name = "changed_by")
	private String changedBy;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	@UpdateTimestamp
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
