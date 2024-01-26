package cat.institutmarianao.shipmentsws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.User;

public interface ActionRepository extends JpaRepository<Action, Long> {
	List<Action> findActionsByShipmentIdOrderByDateDesc(Long shipmentId);
}
