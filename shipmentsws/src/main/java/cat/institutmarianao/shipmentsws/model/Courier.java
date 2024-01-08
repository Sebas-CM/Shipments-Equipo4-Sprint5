package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
/* JPA */
@Entity
@DiscriminatorValue(User.COURIER)
public class Courier extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	/* Validation */
	@NotNull
	/* JPA */
	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;
}
