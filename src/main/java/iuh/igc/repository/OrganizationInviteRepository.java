package iuh.igc.repository;

import iuh.igc.entity.constant.OrganizationInviteStatus;
import iuh.igc.entity.organization.OrganizationInvite;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OrganizationInviteRepository extends JpaRepository<@NonNull OrganizationInvite, @NonNull Long> {

    boolean existsByOrganization_IdAndInviteeEmailIgnoreCaseAndStatusAndExpiresAtAfter(
            Long organizationId,
            String inviteeEmail,
            OrganizationInviteStatus status,
            LocalDateTime now
    );

    Optional<OrganizationInvite> findByInviteToken(String inviteToken);
}
