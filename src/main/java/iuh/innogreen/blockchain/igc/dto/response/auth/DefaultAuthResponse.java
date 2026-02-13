package iuh.innogreen.blockchain.igc.dto.response.auth;

/**
 * Admin 2/13/2026
 *
 **/
public record DefaultAuthResponse(
        UserSessionResponse userSessionResponse,
        String accessToken
) {
}
