package by.It.academy.mapper;

import by.It.academy.WorkerType;
import by.It.academy.entities.Worker;
import static by.It.academy.utils.Constants.*;

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
                .firstname(request.getParameter(FIRSTNAME))
                .surname(request.getParameter(SURNAME))
                .phoneNumber(request.getParameter(PHONE_NUMBER))
                .workerType(WorkerType.valueOf(request.getParameter(WORKER_TYPE).toUpperCase()))
                .build();
    }
}
