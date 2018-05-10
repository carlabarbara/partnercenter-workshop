package partnercenter.subscriptions;

import org.springframework.social.partnercenter.PartnerCenterAdmin;

public class SubscriptionsMain {
	private final PartnerCenterAdmin connection;

	private final SubscriptionsService subscriptionsService = new SubscriptionsService();

	public SubscriptionsMain(PartnerCenterAdmin connection) {
		this.connection = connection;
	}

	public static void main(String[] args) {
		//get A subscription

		//update a subscription
	}
}
