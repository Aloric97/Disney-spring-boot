package com.API.Disney.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    //For authentication
    public UserDetailsService userDetailsService( PasswordEncoder passwordEncoder){
        UserDetails admin= User.withUsername("Leandro").password(passwordEncoder().encode( "123456")).roles("ADMIN_ROL").build();
        UserDetails user= User.withUsername("Emanuel").password(passwordEncoder.encode("123456")).roles("USER_ROL").build();

        return new InMemoryUserDetailsManager(user,admin); //guardar los usuarios a la memoria de forma estatica
    }

    @Bean
    //For authorization
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.
             csrf(csrf ->csrf.disable()).
             authorizeHttpRequests(auth -> auth.requestMatchers("api/personajes/**").permitAll().
                                                requestMatchers("api/peliculas/**").hasRole("ADMIN_ROL")).
             formLogin(form ->form.permitAll()).
             build();

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
