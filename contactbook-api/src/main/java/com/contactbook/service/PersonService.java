package com.contactbook.service;

import com.contactbook.entity.Person;
import com.contactbook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService  implements UserDetailsService {

    @Autowired
    private PersonRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = repository.findByEmailPerson(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));
        return User
                .builder()
                .username(person.getEmailPerson())
                .password(person.getPasswordPerson())
                .roles("USER")
                .build();
    }
}
