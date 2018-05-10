package partnercenter.roles;

import org.springframework.social.partnercenter.PartnerCenterAdmin;

import partnercenter.users.UsersService;

public class RoleService {
	private UsersService usersService;
	private final PartnerCenterAdmin connection;

	public RoleService(PartnerCenterAdmin connection) {
		this.usersService = new UsersService(connection);
		this.connection = connection;
	}

	/**
	 * Directory roles are roles in Azure Active Directory. We currently only assign directory roles
	 *
	 * You will need to retrieve the available directory roles first
	 */
	public void assignAnyDirectoryRoleToACustomerUser() {

	}

	public void assignARoleToACustomerUser() {

	}
}
