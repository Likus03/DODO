package by.It.academy.mapper;

import by.It.academy.entities.UserType;
import by.It.academy.entities.Worker;
import by.It.academy.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class WorkerMapper {
    private static WorkerMapper workerMapper;
    public static WorkerMapper getInstance(){
        if(workerMapper == null){
            workerMapper = new WorkerMapper();
        }
        return workerMapper;
    }

    private WorkerMapper() {
    }

    public Worker buildWorker(HttpServletRequest request){
        return Worker.builder()
                .firstname(request.getParameter(Constants.FIRSTNAME))
                .surname(request.getParameter(Constants.SURNAME))
                .phoneNumber(request.getParameter(Constants.PHONE_NUMBER))
                .login(request.getParameter(Constants.LOGIN))
                .password(request.getParameter(Constants.PASSWORD))
                .userType(UserType.valueOf(request.getParameter("role").toUpperCase()))
                .build();
    }
}
