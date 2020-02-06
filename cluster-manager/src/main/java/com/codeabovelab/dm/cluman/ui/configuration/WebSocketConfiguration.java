
package com.codeabovelab.dm.cluman.ui.configuration;

import com.codeabovelab.dm.cluman.security.TempAuth;
import com.codeabovelab.dm.cluman.ui.tty.WsTtyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ExecutorChannelInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.*;

import java.security.Principal;

/**
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {

    public static final String ENDPOINT = "/ui/stomp";

    @Autowired
    private SecurityChannelInterceptor interceptor;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(ENDPOINT)
          .setAllowedOrigins(UiConfiguration.ALLOWED_ORIGIN)
          .withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(interceptor);
    }

    /**
     * Interceptor which temporary extract auth from message into security context. <p/>
     * Note that current implementation is not good.
     */
    @Component
    private static class SecurityChannelInterceptor implements ExecutorChannelInterceptor {

        public static final String AUTH_KEY = TempAuth.class.getName();

        @Override
        public Message<?> beforeHandle(Message<?> message, MessageChannel channel, MessageHandler handler) {
            SimpMessageHeaderAccessor smha = SimpMessageHeaderAccessor.wrap(message);
            Principal user = smha.getUser();
            if(user instanceof Authentication) {
                TempAuth auth = TempAuth.open((Authentication)user);
                smha.setHeader(AUTH_KEY, auth);
            }
            return message;
        }

        @Override
        public void afterMessageHandled(Message<?> message, MessageChannel channel, MessageHandler handler, Exception ex) {
            SimpMessageHeaderAccessor smha = SimpMessageHeaderAccessor.wrap(message);
            Object attribute = smha.getHeader(AUTH_KEY);
            if(attribute instanceof TempAuth) {
                ((TempAuth)attribute).close();
            }
        }

        @Override
        public Message<?> preSend(Message<?> message, MessageChannel channel) {
            return message;
        }

        @Override
        public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

        }

        @Override
        public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {

        }

        @Override
        public boolean preReceive(MessageChannel channel) {
            return true;
        }

        @Override
        public Message<?> postReceive(Message<?> message, MessageChannel channel) {
            return message;
        }

        @Override
        public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {

        }
    }

    @Configuration
    static class PreWsConfig {
        @Bean
        WebSocketClient webSocketClient() {
            return new StandardWebSocketClient();
        }
    }

    @EnableWebSocket
    @Configuration
    static class WsConfig implements WebSocketConfigurer {

        @Autowired
        private WsTtyHandler wsTtyHandler;

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
            registry.addHandler(wsTtyHandler, "/ui/tty");
        }
    }
}