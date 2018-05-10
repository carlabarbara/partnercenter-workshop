package partnercenter.customers;

import java.util.UUID;

import lombok.Builder;

import org.springframework.social.partnercenter.PartnerCenterAdmin;
import org.springframework.social.partnercenter.api.customer.Address;
import org.springframework.social.partnercenter.api.customer.Customer;
import org.springframework.social.partnercenter.api.customer.CustomerBillingProfile;
import org.springframework.social.partnercenter.api.customer.CustomerCompanyProfile;

public class CustomerService {
	private final PartnerCenterAdmin connection;

	public CustomerService(PartnerCenterAdmin connection) {
		this.connection = connection;
	}

	public Customer createNewCustomer() {
		throw new UnsupportedOperationException();
	}

	private static CustomerBuilder basicCustomer() {
		return customerBuilder()
				.billingProfile(billingProfileBuilder()
						.address(basicAddress().build())
						.companyName("Mr Wong")
						.culture("AU")
						.language("EN")
						.firstName("MR")
						.lastName("Wong")
						.build())
				.companyProfile(companyProfileBuilder()
						.companyName("Mr Wong")
						.domain("mrwong.onmicrosoft.com")
						.id(UUID.randomUUID().toString()).build());
	}

	private static AddressBuilder basicAddress() {
		return addressBuilder()
				.addressLine1("3 Bridge Ln")
				.city("Sydney")
				.firstName("Mr")
				.lastName("Wong")
				.phone("61 2 9114 7317")
				.postalCode("2000")
				.state("New South Wales");
	}

	@Builder(builderMethodName = "customerBuilder")
	public static Customer createCustomer(CustomerBillingProfile billingProfile, CustomerCompanyProfile companyProfile) {
		Customer customer = new Customer();
		customer.setCompanyProfile(companyProfile);
		customer.setBillingProfile(billingProfile);
		return customer;
	}

	@Builder(builderMethodName = "companyProfileBuilder")
	private static CustomerCompanyProfile createCompanyProfile(String id, String domain, String companyName) {
		CustomerCompanyProfile companyProfile = new CustomerCompanyProfile();
		companyProfile.setTenantId(id);

		companyProfile.setDomain(domain);
		companyProfile.setCompanyName(companyName);
		return companyProfile;
	}

	@Builder(builderMethodName = "billingProfileBuilder")
	private static CustomerBillingProfile createBillingProfile(Address address, String firstName, String lastName, String email, String culture, String language, String companyName) {
		CustomerBillingProfile billingProfile = new CustomerBillingProfile();
		billingProfile.setFirstName(firstName);
		billingProfile.setLastName(lastName);
		billingProfile.setEmail(email);
		billingProfile.setCulture(culture);
		billingProfile.setLanguage(language);
		billingProfile.setCompanyName(companyName);
		billingProfile.setDefaultAddress(address);
		return billingProfile;
	}

	@Builder(builderMethodName = "addressBuilder")
	private static Address createAddress(String city, String state, String addressLine1, Object addressLine2, String postalCode, String firstName, String lastName, String phone) {
		Address address = new Address();
		address.setCountry("US");
		address.setCity(city);
		address.setState(state);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setPostalCode(postalCode);
		address.setFirstName(firstName);
		address.setLastName(lastName);
		address.setPhoneNumber(phone);
		return address;
	}
}
