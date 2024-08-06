package com.example.gms_backend.config;

import com.example.gms_backend.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    private static final List<String> PUBLIC_URLS = Arrays.asList(
            "/gms/api/v1/auth/login",
            "/gms/api/v1/auth/refresh",
            "/gms/api/v1/auth/forgot-password",
            "/gms/api/v1/auth/verify-code",
            "/gms/api/v1/auth/reset-password",
            "/gms/api/v1/article/add-view/",
            "/gms/api/v1/brand/get-image-slider",
            "/gms/api/v1/content-website/get-list-general-info",
            "/gms/api/v1/content-website/get-intro-page",
            "/gms/api/v1/brand/get-brand-info",
            "/gms/api/v1/gym/get-list-active-gym",
            "/gms/api/v1/gym/get-gym",
            "/gms/api/v1/service/get-all-benefit",
            "/gms/api/v1/service/get-active-membership-package",
            "/gms/api/v1/customer/get-list-result",
            "/gms/api/v1/customer/get-training-result",
            "/gms/api/v1/class/get-list-category",
            "/gms/api/v1/customer/get-workout-result-homepage",
            "/gms/api/v1/customer/register-free-trial",
            "/gms/api/v1/customer/get-other-result",
            "/gms/api/v1/coach/get-list-coach-homepage",
            "/gms/api/v1/coach/get-list-coach",
            "/gms/api/v1/coach/get-coach-info",
            "/gms/api/v1/coach/get-coach-busy-schedule",
            "/gms/api/v1/coach/get-other-coaches",
            "/gms/api/v1/article/get-top-articles",
            "/gms/api/v1/class/get-list-class",
            "/gms/api/v1/exercise/get-list-category",
            "/gms/api/v1/exercise/get-list-exercise",
            "/gms/api/v1/article/get-list-article",
            "/gms/api/v1/article/get-article",
            "/gms/api/v1/article/get-other-articles",
            "/gms/api/v1/service/get-active-membership-package-with-benefit",
            "/gms/api/v1/customer/create-transfer-registration",
            "/gms/api/v1/customer/get-pay-url",
            "/gms/api/v1/customer/add-member",
            "/gms/api/v1/coach/get-list-coach-with-schedule"
    );

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String path = request.getRequestURI();

        // Bỏ qua các endpoint không cần xác thực
        boolean isPublicUrl = PUBLIC_URLS.stream().anyMatch(path::startsWith);
        if (isPublicUrl) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = getJwtFromCookies(request);
        final String userEmail;
        if (jwt == null) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            userEmail = jwtService.extractUsername(jwt);
        } catch (ExpiredJwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        System.out.println(userEmail);

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        false,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if ("accessToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
