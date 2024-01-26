package cat.institutmarianao.shipmentsws.services.impl;

import java.io.Console;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import cat.institutmarianao.shipmentsws.repositories.ActionRepository;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.repositories.UserRepository;
import cat.institutmarianao.shipmentsws.services.ActionService;
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
public class ActionServiceImpl implements ActionService {

	@Autowired
	private ActionRepository actionRepository;

	@Override
	public List<Action> findActionsByShipmentId(Long shipmentId) {
		return actionRepository.findActionsByShipmentIdOrderByDateDesc(shipmentId);
	}

}
