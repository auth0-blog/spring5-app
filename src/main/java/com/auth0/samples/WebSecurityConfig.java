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
    private static final String HELLO_WORLD_ENDPOINT = "/hello";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(TOKEN_AUDIENCE, TOKEN_ISSUER)
                .configure(http)
                .authorizeRequests()
                .antMatchers(HELLO_WORLD_ENDPOINT).permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}