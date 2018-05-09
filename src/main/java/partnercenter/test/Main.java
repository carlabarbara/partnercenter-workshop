package partnercenter.test;

import static org.springframework.social.partnercenter.http.logging.LogLevel.INFO;

import java.util.Locale;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.social.microsoft.graph.Graph;
import org.springframework.social.microsoft.graph.connect.GraphApiAdaptor;
import org.springframework.social.microsoft.graph.connect.MicrosoftGraphConnectionFactory;
import org.springframework.social.microsoft.graph.connect.MicrosoftGraphServiceProvider;
import org.springframework.social.microsoft.graph.security.OAuth2ParametersBuilder;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.partnercenter.PartnerCenter;
import org.springframework.social.partnercenter.PartnerCenterAdmin;
import org.springframework.social.partnercenter.api.billing.pricing.AzureResourcePricing;
import org.springframework.social.partnercenter.api.billing.pricing.PricingMeter;
import org.springframework.social.partnercenter.api.customer.Address;
import org.springframework.social.partnercenter.api.customer.Customer;
import org.springframework.social.partnercenter.api.customer.CustomerBillingProfile;
import org.springframework.social.partnercenter.api.customer.CustomerCompanyProfile;
import org.springframework.social.partnercenter.api.order.BillingCycle;
import org.springframework.social.partnercenter.api.order.Order;
import org.springframework.social.partnercenter.api.order.OrderLineItem;
import org.springframework.social.partnercenter.api.uri.SecurityRegion;
import org.springframework.social.partnercenter.connect.PartnerCenterConnection;
import org.springframework.social.partnercenter.connect.PartnerCenterConnectionFactory;
import org.springframework.social.partnercenter.connect.admin.PartnerCenterAdminConnection;
import org.springframework.social.partnercenter.http.logging.LogLevel;
import org.springframework.web.client.RestClientException;


@Slf4j(topic = "Microsoft Partner Center")
public class Main {
	private static PartnerCenter partnerCenter;
	private static PartnerCenterAdmin partnerCenterAdmin;
	private static PartnerCenterConnection connection;
	private static PartnerCenterAdminConnection adminConnection;

	public static void main(String[] args) {
		initializePartnerCenterCSP58TIP();
		adminConnection.refresh();

	}

	private static void initializePartnerCenterCSP58TIP() {
		PartnerCenterConnectionFactory connectionFactory = new PartnerCenterConnectionFactory(
				"",
				"",
				"",
				"",
				SecurityRegion.USA);

		try {
			adminConnection = connectionFactory.createConnection("", "");
			partnerCenterAdmin = adminConnection.getApi();
			partnerCenterAdmin.enableSlf4j(INFO);
			connection = connectionFactory.createConnection();
			partnerCenter = connection.getApi();
			partnerCenter.enableSlf4j(INFO);
		} catch (RestClientException e) {
			e.printStackTrace();
		}

	}

	public static Customer createCustomer(Customer mosiCustomerAccount) {
		Customer customer = new Customer();
		customer.setCompanyProfile(createCompanyProfile(mosiCustomerAccount));
		customer.setBillingProfile(createBillingProfile(mosiCustomerAccount));
		return customer;
	}

	private static CustomerCompanyProfile createCompanyProfile(Customer mosiCustomerAccount) {
		CustomerCompanyProfile companyProfile = new CustomerCompanyProfile();
		companyProfile.setTenantId(mosiCustomerAccount.getId());

		companyProfile.setDomain(mosiCustomerAccount.getCompanyProfile().getDomain());
		companyProfile.setCompanyName(mosiCustomerAccount.getCompanyProfile().getCompanyName());
		return companyProfile;
	}

	private static CustomerBillingProfile createBillingProfile(Customer mosiCustomerAccount) {
		CustomerBillingProfile billingProfile = new CustomerBillingProfile();
		billingProfile.setFirstName(mosiCustomerAccount.getBillingProfile().getFirstName());
		billingProfile.setLastName(mosiCustomerAccount.getBillingProfile().getLastName());
		billingProfile.setEmail(mosiCustomerAccount.getBillingProfile().getEmail());
		billingProfile.setCulture(mosiCustomerAccount.getBillingProfile().getCulture());
		billingProfile.setLanguage(mosiCustomerAccount.getBillingProfile().getLanguage());
		billingProfile.setCompanyName(mosiCustomerAccount.getCompanyProfile().getCompanyName());
		billingProfile.setDefaultAddress(createAddress(mosiCustomerAccount));
		return billingProfile;
	}

	private static Address createAddress(Customer mosiCustomerAccount) {
		Address address = new Address();
		address.setCountry("US");
		final Address address1 = mosiCustomerAccount.getBillingProfile().getDefaultAddress();
		address.setCity(address1.getCity());
		address.setState(address1.getState());
		address.setAddressLine1(address1.getAddressLine1());
		address.setAddressLine2(address1.getAddressLine2());
		address.setPostalCode(address1.getPostalCode());
		address.setFirstName(address1.getFirstName());
		address.setLastName(address1.getLastName());
		address.setPhoneNumber(address1.getPhoneNumber());
		return address;
	}

	private static void initializeGraph(String domain) {
		MicrosoftGraphConnectionFactory connectionFactory = new MicrosoftGraphConnectionFactory(Graph.PROVIDER_ID,new MicrosoftGraphServiceProvider(new OAuth2Template("", "", "", "")), new GraphApiAdaptor());
		final String query = connectionFactory.getOAuthOperations().buildAuthorizeUrl(OAuth2ParametersBuilder.forClient("7b03414d-b730-404d-8131-bf9e4026413f").redirectUri("https://psmelser.com:9000/").responseMode("query").build());

	}
}
