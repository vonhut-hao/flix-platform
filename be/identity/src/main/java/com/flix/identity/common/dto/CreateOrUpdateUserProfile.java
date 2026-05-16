package com.flix.identity.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateOrUpdateUserProfile(
        String avatarUrl,
        @NotBlank String fullName,
        @Pattern(
                regexp = "^(0|84)\\d{7,9}$",
                message = "Invalid phone number format. It should start with '0' or '+84' followed by 9 digits."
        ) String phoneNumber
) {
}
