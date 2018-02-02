package com.github.bruce.service.impl;

import com.github.bruce.service.IMyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Description
 * <p>
 * </p>
 * DATE 11/11/17.
 *
 * @author yandajun.
 */
@Service
public class MyServiceImpl implements IMyService {

    Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

    public String go() {
        logger.info("enter go method");
        return "go";
    }
}
