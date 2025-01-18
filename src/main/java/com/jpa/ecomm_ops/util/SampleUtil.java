/**
 * Utility class for JWT (JSON Web Token) related operations.
 *
 * <p>This class provides methods for extracting and manipulating JWT tokens.</p>
 *
 * <p>Author: Suvam Mohapatra</p>
 * <p>Email: suvam.mohapatra@sita.aero</p>
 */
package com.jpa.ecomm_ops.util;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;

public class SampleUtil {

    /**
     * Retrieves the JWT token from the Authorization header of an HTTP request.
     *
     * @param request HTTP servlet request containing the Authorization header
     * @return JWT token if found, null otherwise
     */
    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    /**
     * Converts headers from {@link HttpServletRequest} to {@link HttpHeaders}.
     *
     * @param request HttpServletRequest containing headers to convert
     * @return HttpHeaders containing headers from HttpServletRequest
     */
    public static HttpHeaders convertHeaders(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.add(headerName, headerValue);
        }

        return headers;
    }
}

