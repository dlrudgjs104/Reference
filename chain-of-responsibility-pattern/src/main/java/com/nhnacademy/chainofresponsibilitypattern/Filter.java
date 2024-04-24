package com.nhnacademy.chainofresponsibilitypattern;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}