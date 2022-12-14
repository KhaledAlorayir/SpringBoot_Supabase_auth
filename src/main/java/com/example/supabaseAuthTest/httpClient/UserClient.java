package com.example.supabaseAuthTest.httpClient;

import com.example.supabaseAuthTest.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/*
TODO:
secretsss
 */


@HttpExchange(url = "/user",  accept = "application/json", contentType = "application/json")
public interface UserClient {

    @GetExchange("/")
    UserDTO getUser(@RequestHeader(name = "Authorization") String token);

}
