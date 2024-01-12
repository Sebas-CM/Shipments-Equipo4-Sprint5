package cat.institutmarianao.shipmentsws.services;

import java.sql.Date;
import java.util.List;

import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;


public interface ShipmentService {

	List<Shipment> findAll(Status status, String recievedBy, String courierAssigned, Category category, Date from, Date to);

	List<Shipment> findAllPending(String recievedBy, String courierAssigned, Category category, Date from, Date to);
	
	List<Shipment> findAllInProcess(String recievedBy, String courierAssigned, Category category, Date from, Date to);
	
	Shipment findById(Long shipmentId);
	
	List<Action> findTrackingByShipmentId(Long shipmentId);
	
	Shipment save(Shipment shipment);
	
	Action saveAction(Action action);
	
	void deleteById(Long shipmentId);
}