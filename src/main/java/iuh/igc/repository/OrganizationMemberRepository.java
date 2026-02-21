package iuh.igc.repository;

import iuh.igc.entity.constant.OrganizationRole;
import iuh.igc.entity.organization.OrganizationMember;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Admin 2/15/2026
 *
 **/
@Repository
public interface OrganizationMemberRepository extends JpaRepository<@NonNull OrganizationMember, @NonNull Long> {
    boolean existsByOrganization_IdAndUser_IdAndOrganizationRole(
            Long organizationId,
            Long userId,
            OrganizationRole organizationRole
    );
}
