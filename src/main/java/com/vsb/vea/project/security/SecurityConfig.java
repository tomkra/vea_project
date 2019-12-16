package com.vsb.vea.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/**/*.css")
                    .permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/rest/**")
                    .permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/**")
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .failureUrl("/login-error")
                    .and()
                .logout()
                    .permitAll()
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/login?logout")
                    .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

    @Autowired
    public void init(AuthenticationManagerBuilder builder) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        builder.inMemoryAuthentication()
                .withUser("tomas").password(passwordEncoder().encode("tomas")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
