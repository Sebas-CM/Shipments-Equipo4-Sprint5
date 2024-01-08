package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import cat.institutmarianao.shipmentsws.validation.groups.OnUserCreate;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
/* JPA */
@Entity
@DiscriminatorValue(User.RECEPTIONIST)
public class Receptionist extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_PLACE = 100;

	/* Validation */
	@NotNull(groups = OnUserCreate.class)
	/* JPA */
	@ManyToOne(fetch = FetchType.EAGER)
	private Office office;
	/* Validation */
	@Size(max = MAX_PLACE)
	@NotBlank(groups = OnUserCreate.class)
	private String place;

}
