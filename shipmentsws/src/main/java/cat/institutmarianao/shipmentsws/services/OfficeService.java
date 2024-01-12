package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Office;
import jakarta.validation.constraints.NotBlank;

public interface OfficeService {

	List<Office> findAll();

	Office getByOfficeId(@NotBlank Long officeId);

}