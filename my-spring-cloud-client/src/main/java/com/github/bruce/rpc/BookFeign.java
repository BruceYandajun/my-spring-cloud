package com.github.bruce.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "book", url = "${book.host}", fallbackFactory = BookFeignFallbackFactory.class)
public interface BookFeign {

    @GetMapping(name = "getBookName", path = "/getBookName")
    String getBookName ();

    @GetMapping(name = "getBookId", path = "/getBookId")
    Integer getBookId ();
}
