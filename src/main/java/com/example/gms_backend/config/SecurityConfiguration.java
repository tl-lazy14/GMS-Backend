package com.example.gms_backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/auth/login",
                        "/auth/refresh",
                        "/auth/forgot-password",
                        "/auth/verify-code",
                        "/auth/reset-password",
                        "/article/add-view/**",
                        "/brand/get-image-slider",
                        "/content-website/get-list-general-info",
                        "/content-website/get-intro-page",
                        "/brand/get-brand-info",
                        "/gym/get-list-active-gym",
                        "/gym/get-gym/**",
                        "/service/get-all-benefit",
                        "/service/get-active-membership-package",
                        "/customer/get-list-result",
                        "/customer/get-training-result/**",
                        "/class/get-list-category",
                        "/customer/get-workout-result-homepage",
                        "/customer/register-free-trial",
                        "/customer/get-other-result/**",
                        "/coach/get-list-coach-homepage",
                        "/coach/get-list-coach",
                        "/coach/get-coach-info/**",
                        "/coach/get-coach-busy-schedule/**",
                        "/coach/get-other-coaches/**",
                        "/article/get-top-articles",
                        "/class/get-list-class",
                        "/exercise/get-list-category",
                        "/exercise/get-list-exercise",
                        "/article/get-list-article",
                        "/article/get-article/**",
                        "/article/get-other-articles/**",
                        "/service/get-active-membership-package-with-benefit",
                        "/customer/create-transfer-registration",
                        "/customer/get-pay-url",
                        "/customer/add-member",
                        "/coach/get-list-coach-with-schedule/**"
                ).permitAll()

                .requestMatchers(
                        "/user/create-user",
                        "/user/get-list-gym-managers",
                        "/user/get-user/**",
                        "/user/edit-user/**",
                        "/user/delete-user/**",
                        "/user/export-list-gym-managers",
                        "/exercise/add-category",
                        "/exercise/edit-category/**",
                        "/exercise/delete-category/**",
                        "/exercise/get-exercise/**",
                        "/exercise/add-exercise",
                        "/exercise/edit-exercise/**",
                        "/exercise/delete-exercise/**",
                        "/article/add-article",
                        "/article/edit-article/**",
                        "/article/delete-article/**",
                        "/article/handle-publish/**",
                        "/brand/update-image-slider",
                        "/content-website/get-list-intro-page",
                        "/content-website/edit-intro-page/**",
                        "/content-website/add-general-info",
                        "/content-website/edit-general-info/**",
                        "/content-website/delete-general-info/**",
                        "/brand/update-brand-info",
                        "/gym/get-list-gym",
                        "/gym/add-gym",
                        "/gym/edit-gym/**",
                        "/service/add-membership-package",
                        "/service/edit-membership-package/**",
                        "/service/delete-membership-package/**",
                        "/service/add-benefit",
                        "/service/edit-benefit/**",
                        "/service/delete-benefit/**",
                        "/service/update-benefit-membership",
                        "/service/get-all-pt-package",
                        "/service/add-pt-package",
                        "/service/edit-pt-package/**",
                        "/service/delete-pt-package/**",
                        "/equipment/add-category",
                        "/equipment/edit-category/**",
                        "/equipment/delete-category/**",
                        "/class/add-category",
                        "/class/edit-category/**",
                        "/class/delete-category/**"
                ).hasAuthority("SENIOR_ADMIN")

                .requestMatchers(
                        "/equipment/get-all-category",
                        "/equipment/get-list-equipment",
                        "/equipment/export-list-equipment",
                        "/equipment/add-equipment",
                        "/equipment/edit-equipment/**",
                        "/equipment/delete-equipment/**",
                        "/equipment/get-list-repair",
                        "/equipment/export-list-repair",
                        "/equipment/add-repair",
                        "/equipment/edit-repair/**",
                        "/equipment/delete-repair/**",
                        "/equipment/handle-repair-status/**",
                        "/equipment/get-all-equipment-code/**",
                        "/service/get-all-membership-package",
                        "/service/get-active-pt-package",
                        "/coach/get-all-coach/**",
                        "/coach/add-coach",
                        "/coach/edit-coach/**",
                        "/coach/get-coach-schedule/**",
                        "/coach/get-list-member/**",
                        "/coach/add-schedule/**",
                        "/coach/edit-schedule/**",
                        "/coach/delete-schedule/**",
                        "/customer/get-list-non-mem-cus",
                        "/customer/export-list-non-mem-cus",
                        "/customer/add-non-mem-cus",
                        "/customer/edit-non-mem-cus/**",
                        "/customer/delete-non-mem-cus/**",
                        "/customer/get-list-transfer-registration",
                        "/customer/handle-approve-member-registration/**",
                        "/customer/get-list-trial-registration",
                        "/customer/export-list-trial-registration",
                        "/customer/handle-contact-trial/**",
                        "/customer/handle-approve-trial/**",
                        "/customer/select-trial-date/**",
                        "/customer/get-list-member",
                        "/customer/export-list-member",
                        "/customer/edit-member/**",
                        "/customer/get-member-info/**",
                        "/customer/get-membership-service-info/**",
                        "/customer/get-pt-service-info/**",
                        "/customer/get-member-schedule/**",
                        "/customer/extend-service/**",
                        "/customer/upgrade-service/**",
                        "/service/get-active-pt-package",
                        "/service/get-list-membership-better/**",
                        "/customer/register-pt-service/**",
                        "/customer/select-pt/**",
                        "/customer/add-workout-result/**",
                        "/customer/edit-workout-result/**",
                        "/class/get-category/**",
                        "/class/add-class",
                        "/class/edit-class/**",
                        "/class/delete-class/**",
                        "/class/get-list-participant/**",
                        "/class/get-list-available-mem/**",
                        "/class/add-member-to-class/**",
                        "/class/remove-member-from-class/**",
                        "/gym/dashboard/general-dashboard-data/**",
                        "/gym/dashboard/member-growth-rate/**",
                        "/gym/dashboard/get-new-member-today/**",
                        "/gym/dashboard/new-member-by-month/**",
                        "/gym/dashboard/non-mem-customer-by-month/**",
                        "/gym/dashboard/revenue-by-month/**",
                        "/gym/dashboard/equipment-repair-cost-by-month/**",
                        "/gym/dashboard/get-coaches-ranking/**"
                ).hasAnyAuthority("SENIOR_ADMIN", "GYM_MANAGER")

                .anyRequest().authenticated()
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
