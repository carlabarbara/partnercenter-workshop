package partnercenter.invoices;

import static partnercenter.ConnectionFactory.createConnection;

import org.springframework.social.partnercenter.PartnerCenterAdmin;

public class InvoiceMain {

	public static void main(String[] args) {
		tryoutInvoiceOperations();
	}

	/**
	 * We do not use these operations for anything at present
	 */
	private static void tryoutInvoiceOperations() {
		final PartnerCenterAdmin connection = createConnection();

	}
}
