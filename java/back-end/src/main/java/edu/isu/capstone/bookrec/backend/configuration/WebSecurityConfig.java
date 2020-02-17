package edu.isu.capstone.bookrec.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().authorizeRequests()
                .antMatchers("/resources/**", "/css/**", "/js/**")
                    .permitAll()
                .antMatchers("/**")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and().csrf()
                    .disable().headers().frameOptions().disable()
                .and().sessionManagement()
                    .maximumSessions(1)
                    .maxSessionsPreventsLogin(true);
    }
}
