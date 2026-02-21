package iuh.igc.service.organization;

import iuh.igc.dto.request.organization.CreateOrganizationInviteRequest;
import org.springframework.transaction.annotation.Transactional;

public interface OrganizationInviteService {

    @Transactional
    String inviteUser(Long organizationId, CreateOrganizationInviteRequest request);

    @Transactional
    void acceptInvite(String inviteToken);

    @Transactional
    void declineInvite(String inviteToken);
}
