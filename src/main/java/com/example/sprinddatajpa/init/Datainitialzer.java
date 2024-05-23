package com.example.sprinddatajpa.init;

import com.example.sprinddatajpa.domain.Authority;
import com.example.sprinddatajpa.domain.Role;
import com.example.sprinddatajpa.feature.authority.AuthorityRepository;
import com.example.sprinddatajpa.feature.role.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Datainitialzer {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    void initAuthority(){
        List<String> authorities = List.of("READ","WRITE","DELETE");
        if(authorityRepository.count()==0){
            authorities.forEach(auth -> {
                var authority = new Authority();
                authority.setName(auth);
                authorityRepository.save(authority);
            });
        }
    }

    @PostConstruct
    void roleInit(){
        List<String> roles = List.of("ADMIN","USER");
        if(roleRepository.count()==0){
            var allAuthorities =  new HashSet<>(authorityRepository.findAll());
            for(var role : roles){
                var roleObj = new Role();
                if(role.equals("ADMIN")){
                    roleObj.setAuthorities(allAuthorities);
                }else if (role.equals("USER")){
                    roleObj.setAuthorities(
                            allAuthorities.stream()
                                    .filter(auth -> auth.getName().equals("READ"))
                                    .collect(Collectors.toSet())
                    );
                }
                roleObj.setName(role);
                roleRepository.save(roleObj);
            }
        }
    }

}
