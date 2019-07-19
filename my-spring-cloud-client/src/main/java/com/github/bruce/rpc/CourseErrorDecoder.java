package com.github.bruce.rpc;

import com.google.common.io.CharStreams;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import org.springframework.stereotype.Component;

@Component
public class CourseErrorDecoder implements feign.codec.ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String body = CharStreams.toString(response.body().asReader());
            if(response.status() < 500 || response.status() > 599){
                return new HystrixBadRequestException(body);
            }
        } catch (Exception e) {
            //TODO: log
        }
        return feign.FeignException.errorStatus(methodKey, response);
    }
}