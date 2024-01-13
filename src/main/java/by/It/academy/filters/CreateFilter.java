//package by.It.academy.filters;
//
//import by.It.academy.entities.Worker;
//import by.It.academy.services.worker.WorkerService;
//import by.It.academy.services.worker.WorkerServiceImpl;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//import static by.It.academy.utils.Constants.*;
//
//@WebFilter(urlPatterns = "/create")
//public class CreateFilter extends HttpFilter {
//    private final WorkerService workerService = WorkerServiceImpl.getInstance();
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (checkLogin(req.getParameter(LOGIN)).isPresent()) {
//            req.getRequestDispatcher(ERROR_SING_UP).forward(req, res);
//        } else chain.doFilter(req, res);
//    }
//
//    private Optional<Worker> checkLogin(String login) {
//        List<Worker> workers = workerService.read();
//        return workers.stream()
//                .filter(courier -> courier.getLogin().equals(login))
//                .findFirst();
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
