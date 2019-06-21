package com.github.bruce.rpc;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookFeignFallbackFactory implements FallbackFactory<BookFeign>, BookFeign {

    private Throwable cause;

    public BookFeignFallbackFactory() {

    }

    private BookFeignFallbackFactory(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public BookFeign create (Throwable cause) {
        return new BookFeignFallbackFactory(cause);
    }

    @Override
    public String getBookName () {
        log.error("Fallback getBookName :", cause);
        return "DefaultUserName";
    }

    @Override
    public Integer getBookId () {
        log.error("Fallback getBookId :", cause);
        return 0;
    }
}
