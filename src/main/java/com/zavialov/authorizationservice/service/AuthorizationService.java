package com.zavialov.authorizationservice.service;

import com.zavialov.authorizationservice.exeption.InvalidCredentials;
import com.zavialov.authorizationservice.exeption.UnauthorizedUser;
import com.zavialov.authorizationservice.model.Authorities;
import com.zavialov.authorizationservice.model.Users;
import com.zavialov.authorizationservice.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(Users user) {
        if (isEmpty(name) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(name, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
