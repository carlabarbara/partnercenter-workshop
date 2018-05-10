package partnercenter.orders;

import org.springframework.social.partnercenter.PartnerCenterAdmin;
import org.springframework.social.partnercenter.api.customer.Customer;
import org.springframework.social.partnercenter.api.order.Order;

public class OrderService {
	private final PartnerCenterAdmin connection;

	public OrderService(PartnerCenterAdmin connection) {
		this.connection = connection;
	}

	public Order placeOrder(Customer customer) {
		throw new UnsupportedOperationException();
	}

	public Order getOrder(String orderId) {
		throw new UnsupportedOperationException();
	}
}
