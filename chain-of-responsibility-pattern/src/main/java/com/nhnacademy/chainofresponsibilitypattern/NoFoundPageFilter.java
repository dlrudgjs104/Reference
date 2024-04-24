package com.nhnacademy.chainofresponsibilitypattern;

public class NoFoundPageFilter implements Filter{
    @Override
    public void doFilter(Request request,FilterChain filterChain) {
        if(request.getPath().equals("/main")){
            filterChain.doFilter(request);
        }else{
            System.out.println("MyPageCheckFilter : 다음 필터로 넘김! ");

            //다음 filter로 넘김
            filterChain.doFilter(request);
        }
    }
}
