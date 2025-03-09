package app.inventory.entity;

import app.inventory.util.Constant;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import app.inventory.entity.Location;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Location implements Serializable, Cloneable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private Long locationId;
	
	@NotBlank
	@Column(name = "latitude")
	private String latitude;
	
	@NotBlank
	@Column(name = "longitude")
	private String longitude;
	
	@NotBlank
	@Column(name = "street")
	private String street;
	
	@NotBlank
	@Column(name = "city")
	private String city;
	
	@NotBlank
	@Column(name = "pincode")
	private String pincode;
	
	@NotNull
	@Column(name = "country")
	@Enumerated(EnumType.STRING)
	private Country country;
	
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
	public Location clone() {
		try {
			return (Location) super.clone();
		} catch (CloneNotSupportedException ex) {
			throw new AssertionError();
		}
	}
}
