package partnercenter.relationships;

import java.util.List;

import org.springframework.social.partnercenter.PartnerCenterAdmin;
import org.springframework.social.partnercenter.api.relationships.PartnerRelationship;

public class RelationshipService {
	private final PartnerCenterAdmin connection;

	public RelationshipService(PartnerCenterAdmin connection) {
		this.connection = connection;
	}

	public List<PartnerRelationship> getIndirectResellers(String partnerId) {
		throw new UnsupportedOperationException();
	}

	public List<PartnerRelationship> getDirectResellers(String partnerId) {
		throw new UnsupportedOperationException();
	}
}
