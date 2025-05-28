
package com.sgrh.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        // Deja pasar login, logout y recursos estáticos
        if (uri.startsWith("/login") || uri.startsWith("/logout") || uri.contains("/css") || uri.contains("/js") || uri.contains("/images")) {
            return true;
        }

        // Bloquea si no está logueado
        if (session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
