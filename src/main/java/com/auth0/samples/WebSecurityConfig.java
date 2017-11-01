package com.auth0.samples;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String TOKEN_AUDIENCE = "spring5";
    private static final String TOKEN_ISSUER = "https://bkrebs.auth0.com/";
    private static final String API_ENDPOINT = "/api/**";
    private static final String PUBLIC_URLS = "/**";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(TOKEN_AUDIENCE, TOKEN_ISSUER)
                .configure(http)
                .authorizeRequests()
                .mvcMatchers(API_ENDPOINT).fullyAuthenticated()
                .mvcMatchers(PUBLIC_URLS).permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}