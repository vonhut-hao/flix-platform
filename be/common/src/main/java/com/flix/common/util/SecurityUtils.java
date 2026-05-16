package com.flix.common.util;

import com.flix.common.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Arrays;

@Slf4j
public class SecurityUtils {
    private static final String USER_ID = "userId";
    private static final String ROLES = "scope";

    private SecurityUtils() {
        /* This utility class should not be instantiated */
    }

    public static Long getCurrentUserId(Jwt jwt) {
        return jwt.getClaim(USER_ID);
    }

    public static boolean isAdminRole(Jwt jwt) {
        log.debug("Checking admin role for JWT: {}", jwt);
        String roles = jwt.getClaim(ROLES);
        return roles != null && Arrays.asList(roles.split(" ")).contains("ADMIN");
    }

    public static void validateOwnership(Long userId, Jwt jwt) {
        if (isAdminRole(jwt)) {
            log.debug("User {} is admin, accept to get resource", userId);
            return;
        }
        if (!getCurrentUserId(jwt).equals(userId)) {
            log.warn("User {} not found", userId);
            log.debug("User {} isn't owner, reject to get resource", userId);
            throw new UserNotFoundException();
        }
    }

}
