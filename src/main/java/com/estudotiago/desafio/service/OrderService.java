package com.estudotiago.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudotiago.desafio.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	


	public double total(Order order) {

		return (order.getBasic() - (order.getBasic() * (order.getDiscount() * 0.01))) +  shippingService.shipment(order);
				//150 -((150 * 30 ) + 12 )

	}
}
