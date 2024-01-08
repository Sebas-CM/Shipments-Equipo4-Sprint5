package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/* JPA */
@Entity
@Table(name = "adresses")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Lombok */
	@EqualsAndHashCode.Include
	/* Validation */
	@NotNull
	/* JPA */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	protected Long id;
	
	/* Validation */
	
	/* JPA */
	@Column(unique = true, nullable = false)
	private String name;
	
	/* JPA */
	@Column(nullable = false)
	private String street;
	
	/* JPA */
	@Column(nullable = true)
	private String number;
	
	/* JPA */
	@Column(nullable = true)
	private String floor;
	
	/* JPA */
	@Column(nullable = true)
	private String door;

	/* JPA */
	@Column(nullable = false)
	private String city;
	
	/* JPA */
	@Column(nullable = false)
	private String province;

	/* JPA */
	@Column(nullable = false)
	private String postalCode;

	/* JPA */
	@Column(nullable = false)
	private String country;
}
