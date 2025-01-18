///**
//
// Filter for JWT authentication.
// <p>This filter intercepts HTTP requests and checks for a valid JWT token in the Authorization header.</p>
// <p>Author: Suvam Mohapatra</p>
// <p>Email: suvam.mohapatra@sita.aero</p>
// */
//package com.safetycube.compliance_ops.web.filter;
//
//import com.safetycube.compliance_ops.client.AuthClient;
//import com.safetycube.compliance_ops.dto.AuthResponse;
//import com.safetycube.compliance_ops.util.SampleUtil;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.stream.Collectors;
//
//@Slf4j
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final AuthClient authClient;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        validateToken(request);
//        filterChain.doFilter(request, response);
//    }
//
//    private void validateToken(HttpServletRequest request) {
//
//        try {
//            String jwt = SampleUtil.getJwtFromRequest(request);
//
//            log.info("JwtAuthenticationFilter doFilterInternal received token: {}",jwt);
//            if (StringUtils.hasText(jwt)) {
//                AuthResponse response = authClient.validate(SampleUtil.convertHeaders(request));
//                User user = new User(response.getUsername(), "", response.getRoles().stream()
//                        .map(role -> "ROLE_" + role) // Assuming roles are prefixed with "ROLE_"
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList()));
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } catch (Exception e) {
//            log.error("validateToken Exception :",e);
//        }
//    }
//}
