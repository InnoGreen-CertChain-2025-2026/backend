package iuh.innogreen.blockchain.igc.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

/**
 * Admin 2/13/2026
 *
 **/
public record RegisterRequest(
        @NotBlank(message = "Email người dùng không được để trống")
        @Email(message = "Định dạng email không hợp lệ")
        String email,

        @NotBlank(message = "Tên người dùng được để trống")
        String name,

        @NotBlank(message = "Mật khẩu không được để trống")
        String password,

        String address,

        LocalDate dob
) {
}
