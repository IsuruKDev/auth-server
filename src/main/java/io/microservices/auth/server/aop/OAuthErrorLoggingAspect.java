package io.microservices.auth.server.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@Slf4j
@Aspect
@Component
public class OAuthErrorLoggingAspect {

    private static final String ERROR_MESSAGE = "Error during token generation: ";

    @Before("execution("
            + "public * "
            + "org.springframework.security.oauth2.provider.endpoint"
            + ".TokenEndpoint.handleException(Exception)) && args(ex))")
    public void handleExceptionLogging(Exception ex) {
        if (ex instanceof ClientAbortException) {
            log.debug(ERROR_MESSAGE, ex);
        } else {
            log.error(ERROR_MESSAGE, ex);
        }
    }

    @Before("execution("
            + "public * "
            + "org.springframework.security.oauth2.provider.endpoint"
            + ".TokenEndpoint.handleHttpRequestMethodNotSupportedException("
            + "org.springframework.web.HttpRequestMethodNotSupportedException)) && args(ex))")
    public void handleHttpRequestMethodNotSupportedLogging(HttpRequestMethodNotSupportedException ex) {
        log.debug(ERROR_MESSAGE, ex);
    }

    @Before("execution("
            + "public * "
            + "org.springframework.security.oauth2.provider.endpoint"
            + ".TokenEndpoint.handleClientRegistrationException("
            + "Exception)) && args(ex))")
    public void handleClientRegistrationErrorLogging(Exception ex) {
        log.debug(ERROR_MESSAGE, ex);
    }

    @Before("execution("
            + "public * "
            + "org.springframework.security.oauth2.provider.endpoint"
            + ".TokenEndpoint.handleException("
            + "org.springframework.security.oauth2.common.exceptions.OAuth2Exception)) && args(ex))")
    public void handleOAuth2ExceptionLogging(OAuth2Exception ex) {
        log.debug(ERROR_MESSAGE, ex);
    }
}
