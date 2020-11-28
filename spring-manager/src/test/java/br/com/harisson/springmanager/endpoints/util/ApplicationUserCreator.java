package br.com.harisson.springmanager.endpoints.util;

import br.com.harisson.coreproject.model.ApplicationUser;

public class ApplicationUserCreator {
    public static ApplicationUser createValidApplicationUser(){
        return ApplicationUser.builder()
                .accountId(1L)
                .password("123")
                .userKey("8a85867e6ad9e761016ada958bdf5b0f")
                .role("USER")
                .username("Goku")
                .build();
    }

    public static ApplicationUser createApplicationUserToBeSaved(){
        return ApplicationUser.builder()
                .password("123")
                .userKey("8a85867e6ad9e761016ada958bdf5b0f")
                .role("USER")
                .username("Goku")
                .build();
    }
}
