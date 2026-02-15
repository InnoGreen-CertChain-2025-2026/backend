package iuh.innogreen.blockchain.igc.service.organization;

import iuh.innogreen.blockchain.igc.dto.request.organization.CreateOrganizationRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Admin 2/15/2026
 *
 **/
public interface OrganizationService {
    @Transactional
    void createOrganization(CreateOrganizationRequest request);
}
