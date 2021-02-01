package com.grondas.security;

import org.springframework.security.core.Authentication;


public interface AuthenticationFacade {

    Authentication getAuthentication();
}

