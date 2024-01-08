package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Formula;

import cat.institutmarianao.shipmentsws.validation.groups.OnShipmentCreate;
import cat.institutmarianao.shipmentsws.validation.groups.OnShipmentUpdate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/* JPA */
@Entity
@Table(name = "shipments")
public class Shipment implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_DESCRIPTION = 500;

	public enum Category {
		PARTICULAR, COMPANY, GOVERNMENT
	}

	public static final String PENDING = "PENDING";
	public static final String IN_PROCESS = "IN_PROCESS";
	public static final String DELIVERED = "DELIVERED";

	public enum Status {
		PENDING, IN_PROCESS, DELIVERED
	}

	/* Lombok */
	@EqualsAndHashCode.Include
	/* Validation */
	@Null(groups = OnShipmentCreate.class) // Must be null on inserts
	@NotNull(groups = OnShipmentUpdate.class) // Must be not null on updates
	/* JPA */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	/* Validation */
	@NotNull
	/* JPA */
	@Enumerated(EnumType.STRING) // Stored as string
	@Column(nullable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
	private Address sender;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "recipient_id", referencedColumnName = "id", nullable = false)
	private Address recipient;

	@NotNull
	private Float weight;
	@NotNull
	private Float height;
	@NotNull
	private Float width;
	@NotNull
	private Float length;

	@Null
	private Boolean express;
	@Null
	private Boolean fragile;

	/* Validation */
	@NotBlank
	@Size(max = MAX_DESCRIPTION)
	/* JPA */
	@Column(nullable = false)
	private String note;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "shipment")
	@Column(nullable = false)
	@OrderBy("date DESC")
	private List<Action> tracking;

	/* Hibernate */
	@Formula("(SELECT CASE a.type WHEN '" + Action.RECEPTION + "' THEN '" + PENDING + "' " + " WHEN '"
			+ Action.ASSIGNMENT + "' THEN '" + IN_PROCESS + "' " + " WHEN '" + Action.DELIVERY + "' THEN '" + DELIVERED
			+ "' ELSE NULL END FROM actions a "
			+ " WHERE a.date=( SELECT MAX(last_action.date) FROM actions last_action "
			+ " WHERE last_action.shipment_id=a.shipment_id AND last_action.shipment_id=id ))")
	// Lombok
	@Setter(AccessLevel.NONE)
	private Status status;

}
