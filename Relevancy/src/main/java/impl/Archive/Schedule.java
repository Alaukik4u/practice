package impl.Archive;

import lombok.Data;

@Data
public class Schedule {
    Integer startTime;
    Integer endTime;

    public Schedule(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
