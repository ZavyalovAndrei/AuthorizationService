package com.zavialov.authorizationservice.controller;

import com.zavialov.authorizationservice.exeption.InvalidCredentials;
import com.zavialov.authorizationservice.exeption.UnauthorizedUser;
import com.zavialov.authorizationservice.model.Authorities;
import com.zavialov.authorizationservice.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService();

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        String resolveInvalidCredentials (InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolveUnauthorizedUser (UnauthorizedUser exception) {
        return exception.getMessage();
    }
}