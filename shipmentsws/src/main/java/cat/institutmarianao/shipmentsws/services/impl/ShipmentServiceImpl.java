package cat.institutmarianao.shipmentsws.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.model.Courier;
import cat.institutmarianao.shipmentsws.model.Receptionist;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;
import cat.institutmarianao.shipmentsws.model.User;
import cat.institutmarianao.shipmentsws.model.User.Role;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.repositories.UserRepository;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
import cat.institutmarianao.shipmentsws.services.UserService;
import cat.institutmarianao.shipmentsws.specifications.UserWithFullName;
import cat.institutmarianao.shipmentsws.specifications.UserWithRole;
import cat.institutmarianao.shipmentsws.validation.groups.OnUserCreate;
import cat.institutmarianao.shipmentsws.validation.groups.OnUserUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Shipment> findAll(Status status, String recievedBy, String courierAssigned, Category category,
			Date from, Date to) {
		return shipmentRepository.findAll();
	}

	@Override
	public List<Shipment> findAllPending(String recievedBy, String courierAssigned, Category category, Date from,
			Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipment> findAllInProcess(String recievedBy, String courierAssigned, Category category, Date from,
			Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment findById(Long shipmentId) {
		// TODO Auto-generated method stub
		return shipmentRepository.findById(shipmentId);
	}

	@Override
	public List<Action> findTrackingByShipmentId(Long shipmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment save(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	public Action saveAction(Action action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long shipmentId) {
		shipmentRepository.deleteById(shipmentId);
		
	}

}
