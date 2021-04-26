package org.example.midterm.jwt;

import org.example.midterm.Service.UserService;
import org.example.midterm.security.JwtTokenAuthenticationFilter;
import org.example.midterm.security.JwtTokenGeneratorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //                  to Show Swagger, change / to /**, and to show roles working change /** to /
                .antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/notes/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/notes/**", "/addresses/**").hasAnyAuthority( "ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/notes/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/users/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/userData/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/notes/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/users/signUp").permitAll()
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}

