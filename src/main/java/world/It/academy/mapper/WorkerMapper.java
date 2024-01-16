package world.It.academy.mapper;

import world.It.academy.WorkerType;
import world.It.academy.entities.Worker;
import world.It.academy.utils.Constants;

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
                .workerType(WorkerType.valueOf(request.getParameter(Constants.WORKER_TYPE).toUpperCase()))
                .build();
    }
}
