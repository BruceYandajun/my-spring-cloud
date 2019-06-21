package com.github.bruce.rpc;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserFeign>, UserFeign {

    private Throwable cause;

    public UserFeignFallbackFactory() {

    }

    private UserFeignFallbackFactory (Throwable cause) {
        this.cause = cause;
    }

    @Override
    public UserFeign create (Throwable cause) {
        return new UserFeignFallbackFactory(cause);
    }

    @Override
    public String getUserName () {
        log.error("Fallback getUserName :", cause);
        return "DefaultUserName";
    }

    @Override
    public Integer getUserId () {
        log.error("Fallback getUserId :", cause);
        return 0;
    }
}
