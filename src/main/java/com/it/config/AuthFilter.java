package com.it.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.it.entities.User;
import com.it.repository.UserRepository;
import com.it.utils.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // ✅ Allow register & login without token
        String uri = request.getRequestURI();
        return uri.startsWith("/users/register") || uri.startsWith("/users/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response,
                                   FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String header = request.getHeader("Authorization");

            if (header != null && header.startsWith("Bearer ")) {
                String token = header.substring(7);

                if (JwtUtils.isvalid(token)) {
                    int userId = Integer.parseInt(JwtUtils.getData(token));

                    Optional<User> optionalUser = userRepository.findById(userId);
                    if (optionalUser.isPresent()) {
                        User user = optionalUser.get();

                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(
                                        user, null, user.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authToken);
                        filterChain.doFilter(request, response);
                    } else {
                        writeError(response, HttpStatus.BAD_REQUEST, "User Not Found!");
                    }
                } else {
                    writeError(response, HttpStatus.UNAUTHORIZED, "Invalid Token!");
                }
            } else {
                writeError(response, HttpStatus.UNAUTHORIZED, "Authorization Header Missing!");
            }
        } catch (Exception e) {
        	writeError(response, HttpStatus.UNAUTHORIZED, "Token Expired or Invalid!");
        }
    }

    private void writeError(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        response.setStatus(status.value());
        PrintWriter pw = response.getWriter();
        pw.write(message);
    }
}
