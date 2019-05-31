package com.ramazone.ramazone.service;

import com.ramazone.ramazone.MyUserPrincipal;
import com.ramazone.ramazone.model.user.User;
import com.ramazone.ramazone.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return new MyUserPrincipal(user);
    }
}
