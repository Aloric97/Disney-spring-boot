package com.API.Disney.service;

import com.API.Disney.repository.PersonajeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PersonajeServiceTest {


    @Mock
    private PersonajeRepository personajeRepository;

    @InjectMocks
    private PersonajeService personajeService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
}
