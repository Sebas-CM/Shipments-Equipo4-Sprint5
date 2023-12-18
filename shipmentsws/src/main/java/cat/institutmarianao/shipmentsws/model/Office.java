/**
 *
 */
package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import cat.institutmarianao.shipmentsws.validation.groups.OnUserCreate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/* JPA */
@Entity
@Table(name = "offices")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_NAME = 100;

	/* Lombok */
	@EqualsAndHashCode.Include
	/* Validation */
	@Positive(groups = OnUserCreate.class)
	/* JPA */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	/* Validation */
	@Size(max = MAX_NAME)
	@NotBlank(groups = OnUserCreate.class)
	/* JPA */
	@Column(unique = true, nullable = false)
	private String name;

}
