package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import cat.institutmarianao.shipmentsws.validation.groups.OnUserCreate;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/* JPA annotations */
@Entity
/* Mapping JPA Indexes */
@Table(name = "users", indexes = { @Index(name = "role", columnList = "role", unique = false),
		@Index(name = "full_name", columnList = "full_name", unique = false),
		@Index(name = "role_x_full_name", columnList = "role, full_name", unique = false) })
/* JPA Inheritance strategy is single table */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)

@JsonIgnoreProperties({ "receptionist", "logistics_manager", "courier" })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role", visible = true)
@JsonSubTypes({ @Type(value = Receptionist.class, name = User.RECEPTIONIST),
		@Type(value = LogisticsManager.class, name = User.LOGISTICS_MANAGER),
		@Type(value = Courier.class, name = User.COURIER) })

public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Values for role - MUST be constants (can not be enums) */
	public static final String RECEPTIONIST = "RECEPTIONIST";
	public static final String LOGISTICS_MANAGER = "LOGISTICS_MANAGER";
	public static final String COURIER = "COURIER";

	public enum Role {
		RECEPTIONIST, LOGISTICS_MANAGER, COURIER
	}

	public static final int MIN_USERNAME = 2;
	public static final int MAX_USERNAME = 25;
	public static final int MIN_PASSWORD = 10;
	public static final int MIN_FULL_NAME = 3;
	public static final int MAX_FULL_NAME = 100;
	public static final int MAX_EXTENSION = 9999;

	/* Lombok */
	@EqualsAndHashCode.Include
	/* Validation */
	@NotBlank
	@Size(min = MIN_USERNAME, max = MAX_USERNAME)
	/* JPA */
	@Id
	@Column(unique = true, nullable = false)
	protected String username;

	/* Validation */
	@NotNull
	/* JPA */
	@Enumerated(EnumType.STRING)
	@Column(name = "role", insertable = false, updatable = false, nullable = false)
	protected Role role;

	/* Validation */
	@NotBlank(groups = OnUserCreate.class)
	@Size(min = MIN_PASSWORD)
	/* JPA */
	@Column(nullable = false)
	/* JSON */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	protected String password;

	/* Validation */
	@NotBlank(groups = OnUserCreate.class)
	@Size(min = MIN_FULL_NAME, max = MAX_FULL_NAME)
	/* JPA */
	@Column(name = "full_name", nullable = false)
	protected String fullName;

	/* Validation */
	@NotNull(groups = OnUserCreate.class)
	@PositiveOrZero
	@Max(MAX_EXTENSION)
	protected Integer extension;
}
