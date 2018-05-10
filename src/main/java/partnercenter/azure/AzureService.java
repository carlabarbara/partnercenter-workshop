package partnercenter.azure;

import org.springframework.social.partnercenter.PartnerCenterAdmin;

public class AzureService {
	private final PartnerCenterAdmin connection;

	public AzureService(PartnerCenterAdmin connection) {
		this.connection = connection;
	}

	public void calculateDailyCostOfUsageForLastWeekUsingAzurePricingAndUtilizationRecords(){
		throw new UnsupportedOperationException();
	}

	/**
	 * The daily subscription usage operations are the ones we think might be able to replace the calculation of usage
	 * via AzurePricing and UtilizationRecords
	 */
	public void getDailyAndMonthlySubscriptionUsage() {

	}

	public void tryoutOtherUsageOperations() {

	}
}
