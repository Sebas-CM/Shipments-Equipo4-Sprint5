package cat.institutmarianao.shipmentsws.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.model.Shipment.Status;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithCategory;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithCourierAssigned;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithReceivedBy;
import cat.institutmarianao.shipmentsws.specifications.ShipmentWithStatus;

@Validated
@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Shipment> findAll(Status status, String receivedBy, String courierAssigned, Category category,
			Date from, Date to) {
		Specification<Shipment> spec = Specification.where(new ShipmentWithStatus(status))
				.and(new ShipmentWithReceivedBy(receivedBy)).and(new ShipmentWithCourierAssigned(courierAssigned))
				.and(new ShipmentWithCategory(category)).and(new ShipmentWithFrom(from)).and(new ShipmentWithTo(to));

		return shipmentRepository.findAll(spec);
	}

	@Override
	public Shipment findById(Long shipmentId) {
		return shipmentRepository.findById(shipmentId).orElseThrow(NotFoundException::new);
	}

	@Override
	public Shipment save(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	public void deleteById(Long shipmentId) {
		shipmentRepository.deleteById(shipmentId);
	}

}
