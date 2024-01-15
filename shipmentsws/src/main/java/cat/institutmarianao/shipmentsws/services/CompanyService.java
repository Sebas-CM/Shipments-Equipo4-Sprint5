package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Company;
import jakarta.validation.constraints.NotBlank;

public interface CompanyService {

	List<Company> findAll();

	Company getByCompanyId(@NotBlank Long companyId);

}