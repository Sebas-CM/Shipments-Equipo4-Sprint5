package cat.institutmarianao.shipmentsws.services;

import java.sql.Date;
import java.util.List;

import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;

public interface ShipmentService {

	List<Shipment> findAll(Status status, String receivedBy, String courierAssigned, Category category, Date from,
			Date to);

	Shipment findById(Long shipmentId);

	Shipment save(Shipment shipment);

	void deleteById(Long shipmentId);
}