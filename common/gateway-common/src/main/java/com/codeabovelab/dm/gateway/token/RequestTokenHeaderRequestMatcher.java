
package com.codeabovelab.dm.gateway.token;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * RequestMatcher(strategy to match an <tt>HttpServletRequest</tt>.) for AuthenticationTokenFilter
 *
 */
public class RequestTokenHeaderRequestMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        return request.getHeader(AuthenticationTokenFilter.X_AUTH_TOKEN) != null
          || request.getParameter(AuthenticationTokenFilter.TOKEN) != null;
    }

}