
package com.codeabovelab.dm.cluman.ui.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * Based on WebMvcAutoConfiguration.WelcomePageHandlerMapping
 */
final class WelcomePageHandlerMapping extends AbstractUrlHandlerMapping {

    // target page, it can be changed in future, or configured by property
    private final String target = "/index.html";

    WelcomePageHandlerMapping(Collection<String> paths) {
        ParameterizableViewController controller = new ParameterizableViewController();
        controller.setViewName("forward:" + target);
        paths.forEach(path -> registerHandler(path, controller));
        //we handle only non handled resources, but resource handler (which has LOWEST_PRECEDENCE - 1) handle all
        setOrder(LOWEST_PRECEDENCE - 10);
    }

    @Override
    public Object getHandlerInternal(HttpServletRequest request) throws Exception {
        String req = request.getRequestURI();
        //this prevent recursion and unnecessary mapping
        if(target.equals(req)) {
            return null;
        }
        List<MediaType> mediaTypes = MediaType
          .parseMediaTypes(request.getHeader(HttpHeaders.ACCEPT));
        for (MediaType mediaType : mediaTypes) {
            if (mediaType.includes(MediaType.TEXT_HTML)) {
                return super.getHandlerInternal(request);
            }
        }
        return null;
    }

}
