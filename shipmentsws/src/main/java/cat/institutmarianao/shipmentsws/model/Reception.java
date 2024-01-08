package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import cat.institutmarianao.shipmentsws.validation.groups.OnActionCreate;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
/* JPA */
@Entity
@DiscriminatorValue(Action.RECEPTION)
public class Reception extends Action implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Validation */
	@NotBlank(groups = OnActionCreate.class)
	/* JPA */
	@Column(unique = true, nullable = false)
	private Integer trackingNumber;
}
