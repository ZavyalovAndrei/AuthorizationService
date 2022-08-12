package com.zavialov.authorizationservice.controller;

import com.zavialov.authorizationservice.exeption.InvalidCredentials;
import com.zavialov.authorizationservice.exeption.UnauthorizedUser;
import com.zavialov.authorizationservice.model.Authorities;
import com.zavialov.authorizationservice.model.Users;
import com.zavialov.authorizationservice.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Validated
@RestController
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService();
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss  ");

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Users user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        String resolveInvalidCredentials (InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolveUnauthorizedUser (UnauthorizedUser exception) {

        System.out.println(dateTime.format(formatter) + exception.getMessage());
        return exception.getMessage();
    }
}