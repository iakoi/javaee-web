package poe.javaee.web.servlet;

import poe.javaee.web.bean.DisplayService;
import poe.javaee.web.bean.DisplaySessionService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/next")
public class NextServlet extends HttpServlet {

    @Inject
    DisplayService displayService;

    @Inject
    DisplaySessionService displaySessionService;

    @Inject
    DisplaySessionService displaySessionService2;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        displayService.add();
        displaySessionService.add();
        displaySessionService2.add();
        request.setAttribute("count", displayService.getCallCount());
        request.setAttribute("sessionCount", displaySessionService.getCallCount());
        request.setAttribute("session2Count", displaySessionService2.getCallCount());
        this.getServletContext().getRequestDispatcher("/next.jsp").forward(request, response);

    }
}
