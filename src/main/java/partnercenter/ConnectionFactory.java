package partnercenter;

import static org.springframework.social.partnercenter.http.logging.LogLevel.INFO;

import org.springframework.social.partnercenter.PartnerCenterAdmin;
import org.springframework.social.partnercenter.api.uri.SecurityRegion;
import org.springframework.social.partnercenter.connect.PartnerCenterConnectionFactory;
import org.springframework.social.partnercenter.connect.admin.PartnerCenterAdminConnection;
import org.springframework.social.partnercenter.http.logging.LogLevel;
import org.springframework.web.client.RestClientException;

public class ConnectionFactory {
	public static PartnerCenterAdmin createConnection() {
		PartnerCenterConnectionFactory connectionFactory = new PartnerCenterConnectionFactory(
				"",
				"",
				"",
				"",
				SecurityRegion.USA);

		try {
			PartnerCenterAdminConnection adminConnection = connectionFactory.createConnection("paul.smelser@testtestappdirecttip.onmicrosoft.com", "2nALqM5WeWYm8");
			PartnerCenterAdmin partnerCenterAdmin = adminConnection.getApi();
			partnerCenterAdmin.enableSlf4j(INFO);
			connectionFactory.enableSl4fjForAuthRequests(LogLevel.INFO);
			return partnerCenterAdmin;
		} catch (RestClientException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
