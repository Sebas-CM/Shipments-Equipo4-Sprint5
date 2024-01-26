package cat.institutmarianao.shipmentsws.services;

import java.sql.Date;
import java.util.List;

import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;


public interface ActionService {
	
	List<Action> findActionsByShipmentId(Long shipmentId);
}