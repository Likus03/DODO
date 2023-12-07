package by.It.academy.controllers;

import by.It.academy.entities.Worker;
import by.It.academy.repositories.Repository;
import by.It.academy.repositories.RepositoryImpl;
import by.It.academy.services.Service;
import by.It.academy.services.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {

   private final Service service = ServiceImpl.getInstance();
    List<Worker> workers;
    HttpSession session = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workers = service.read();
        req.setAttribute("workers", workers);

        Optional<Worker> user = getLogInId(req.getParameter("username"), req.getParameter("password"));

        if (user.isEmpty()) {
            req.getRequestDispatcher("/pages/errors/errorLogIn.jsp").forward(req, resp);
        } else {
            session = req.getSession(true);
            session.setAttribute("userType", user.get().getUserType());

            req.getRequestDispatcher("/pages/readWorkers.jsp").forward(req,resp);
        }
    }

    private Optional<Worker> getLogInId(String login, String password) {
        return workers.stream()
                .filter(worker -> (Objects.equals(worker.getLogin(), login) && Objects.equals(worker.getPassword(), password)))
                .findFirst();
    }

}
