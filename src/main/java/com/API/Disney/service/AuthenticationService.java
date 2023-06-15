package com.API.Disney.service;

import com.API.Disney.dto.CredentialsDto;
import com.API.Disney.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthenticationService {


    public UserDto authenticate(CredentialsDto credentialsDto);

    public UserDto findByLogin(String login);
}
