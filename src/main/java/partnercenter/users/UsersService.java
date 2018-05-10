package partnercenter.users;

import org.springframework.social.partnercenter.PartnerCenterAdmin;
import org.springframework.social.partnercenter.api.customer.user.CustomerUser;
import org.springframework.social.partnercenter.api.customer.user.License;

public class UsersService {
	private final PartnerCenterAdmin connection;

	public UsersService(PartnerCenterAdmin connection) {
		this.connection = connection;
	}

	public CustomerUser createUser() {
		throw new UnsupportedOperationException();
	}

	public License assignLicenseToUser() {
		throw new UnsupportedOperationException();
	}


}
