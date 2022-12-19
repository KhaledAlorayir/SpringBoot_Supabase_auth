package com.example.supabaseAuthTest.config.security;

import com.example.supabaseAuthTest.dto.UserDTO;
import com.example.supabaseAuthTest.httpClient.UserClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SecurityFillter extends OncePerRequestFilter {

    private final UserClient userClient;
    private  final String prefix = "Bearer ";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(token == null || !token.startsWith(prefix)) {
            filterChain.doFilter(request,response);
            return;
        }
        /*
        * right here we extracted the token coming from the frontend and sending it to supabase's API to verify it and get the user info
        * another option is instead of using the supabase API, we could have decoded it and verified it here (the JWT secret is given by supabase), this option might be better because we don't need to make a request to supabase
        *
        * of course for a legit project we would create another table ("profile") and use it as the main table to interact with the user
        * we could set a trigger in supabase that insert the user to the profile table each time a new user signs up
        *
        * */
        try {
            UserDTO user = userClient.getUser(token);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,authorities));
            filterChain.doFilter(request,response);
        } catch (Exception e) {
            System.out.println(e);
            filterChain.doFilter(request,response);
        }


    }
}
