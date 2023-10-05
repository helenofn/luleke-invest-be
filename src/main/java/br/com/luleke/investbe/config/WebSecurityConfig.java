package br.com.luleke.investbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            );
        return http.build();
    }
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
        		new AntPathRequestMatcher("/auth/**"),
        		new AntPathRequestMatcher("/h2-console/**")
        );
    }
	
	
	/*
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .headers()
            .frameOptions()
            .sameOrigin()
            .httpStrictTransportSecurity()
            .includeSubDomains(true)
            .maxAgeInSeconds(31536000)
        .and()
        	.contentSecurityPolicy("script-src 'self' 'unsafe-inline' ");
		
        http.httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .antMatchers("/h2-console/**","/auth/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .apply(new JwtConfig(jwtTokenProvider));
    }
    */

}
