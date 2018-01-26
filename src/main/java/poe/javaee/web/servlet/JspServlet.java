package poe.javaee.web.servlet;

import poe.javaee.web.bean.DisplayService;
import poe.javaee.web.bean.DisplaySessionService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class JspServlet extends HttpServlet {

    @EJB
    DisplayService displayService;

    @EJB
    DisplaySessionService displaySessionService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        displayService.add();
        displaySessionService.add();

        request.setAttribute("count", displayService.getCallCount());
        request.setAttribute("sessionCount", displaySessionService.getCallCount());

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
