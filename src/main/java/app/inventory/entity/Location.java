package app.inventory.entity;

import app.inventory.util.Constant;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = Constant.INVENTORY_SCHEMA, name = Constant.LOCATION_TABLE)
public class Location {
	
	private Long locationId;
}
