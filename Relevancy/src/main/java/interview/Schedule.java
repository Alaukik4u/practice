package interview;

import lombok.Data;

import java.util.Date;

@Data
public class Schedule {
    Integer startTime;
    Integer endTime;

    public Schedule(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
