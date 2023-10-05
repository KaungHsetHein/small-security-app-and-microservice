package com.example.methodsecurity.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    private Map<String, List<String>> secretNames = Map.of("john",List.of("Doe","william"),
            "mary",List.of("Smith","James"));
    @PreAuthorize("hasAuthority('write')")
    public String getName(){
        return "Oh! Blah Blah";

    }
    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretName(String name){
        return secretNames.get(name);
    }
}
