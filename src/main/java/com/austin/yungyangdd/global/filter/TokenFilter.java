package com.austin.yungyangdd.global.filter;


import com.austin.yungyangdd.global.provider.TokenProvider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter extends GenericFilterBean {



    private final TokenProvider tokenProvider;

    public TokenFilter(TokenProvider tokenProvider){

        this.tokenProvider =tokenProvider;
    }




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {



        String token = tokenProvider.resolveToken((HttpServletRequest) request);

        if(token !=null && tokenProvider.validateToken(token)){

            Authentication auth = tokenProvider.getAuthentication(token);

            SecurityContextHolder.getContext().setAuthentication(auth);

        }
        chain.doFilter(request,response);
    }
}
