package com.github.bruce.servlet;

import com.github.bruce.service.impl.MyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description
 * <p>
 * </p>
 * DATE 11/11/17.
 *
 * @author yandajun.
 */
public class GoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyServiceImpl service = new MyServiceImpl();
        service.go();
    }
}
