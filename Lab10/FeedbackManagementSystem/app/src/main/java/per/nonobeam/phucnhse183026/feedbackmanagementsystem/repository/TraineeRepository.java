package per.nonobeam.phucnhse183026.feedbackmanagementsystem.repository;

import per.nonobeam.phucnhse183026.feedbackmanagementsystem.service.TraineeService;

public class TraineeRepository {
    public static TraineeService getTraineeService() {
        return APIClient.getClient().create(TraineeService.class);
    }
}
