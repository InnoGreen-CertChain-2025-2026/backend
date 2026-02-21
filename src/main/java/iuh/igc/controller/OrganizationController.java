package iuh.igc.controller;

import iuh.igc.dto.base.ApiResponse;
import iuh.igc.dto.base.PageResponse;
import iuh.igc.dto.request.organization.CreateOrganizationRequest;
import iuh.igc.dto.request.organization.CreateOrganizationInviteRequest;
import iuh.igc.dto.request.organization.UpdateOrganizationContactRequest;
import iuh.igc.dto.request.organization.UpdateOrganizationGeneralRequest;
import iuh.igc.dto.request.organization.UpdateOrganizationLegalRequest;
import iuh.igc.dto.response.orginazation.OrganizationResponse;
import iuh.igc.dto.response.orginazation.OrganizationSummaryResponse;
import iuh.igc.service.organization.OrganizationInviteService;
import iuh.igc.service.organization.OrganizationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Admin 2/20/2026
 *
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrganizationController {

    OrganizationService organizationService;
    OrganizationInviteService organizationInviteService;

    @PostMapping
    public ApiResponse<@NonNull Void> createOrganization(
            @RequestPart("data") @Valid CreateOrganizationRequest createOrganizationRequest,
            @RequestPart("logo") MultipartFile logo
    ) {
        organizationService.createOrganization(createOrganizationRequest, logo);
        return ApiResponse.<Void>builder().build();
    }

    @GetMapping
    public ApiResponse<PageResponse<OrganizationSummaryResponse>> getUserOrganizations(
            @PageableDefault Pageable pageable
    ) {
        Page<@NonNull OrganizationSummaryResponse> page = organizationService.getUserOrganizations(pageable);
        PageResponse<OrganizationSummaryResponse> res = new PageResponse<>(page);

        return new ApiResponse<>(res);
    }

    @GetMapping("/brief")
    public ApiResponse<List<OrganizationSummaryResponse>> getUserBriefOrganizationList() {
        List<OrganizationSummaryResponse> res = organizationService.getUserBriefOrganizationList();
        return new ApiResponse<>(res);
    }

    @GetMapping("/{id}")
    public ApiResponse<OrganizationResponse> getUserBriefOrganizationList(
            @PathVariable("id") Long id
    ) {
        return new ApiResponse<>(organizationService.getUserOrganizationById(id));
    }

    @PatchMapping("/{id}/general")
    public ApiResponse<@NonNull Void> updateOrganizationGeneral(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateOrganizationGeneralRequest request
    ) {
        organizationService.updateOrganizationGeneral(id, request);
        return ApiResponse.<Void>builder().build();
    }

    @PatchMapping("/{id}/legal")
    public ApiResponse<@NonNull Void> updateOrganizationLegal(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateOrganizationLegalRequest request
    ) {
        organizationService.updateOrganizationLegal(id, request);
        return ApiResponse.<Void>builder().build();
    }

    @PatchMapping("/{id}/contact")
    public ApiResponse<@NonNull Void> updateOrganizationContact(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateOrganizationContactRequest request
    ) {
        organizationService.updateOrganizationContact(id, request);
        return ApiResponse.<Void>builder().build();
    }

    @PostMapping("/{id}/invites")
    public ApiResponse<String> inviteUserToOrganization(
            @PathVariable("id") Long id,
            @RequestBody @Valid CreateOrganizationInviteRequest request
    ) {
        return new ApiResponse<>(organizationInviteService.inviteUser(id, request));
    }

    @PostMapping("/invites/{token}/accept")
    public ApiResponse<@NonNull Void> acceptOrganizationInvite(
            @PathVariable("token") String token
    ) {
        organizationInviteService.acceptInvite(token);
        return ApiResponse.<Void>builder().build();
    }

    @PostMapping("/invites/{token}/decline")
    public ApiResponse<@NonNull Void> declineOrganizationInvite(
            @PathVariable("token") String token
    ) {
        organizationInviteService.declineInvite(token);
        return ApiResponse.<Void>builder().build();
    }


}
