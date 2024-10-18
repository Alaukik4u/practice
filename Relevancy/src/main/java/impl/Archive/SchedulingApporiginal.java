package impl.Archive;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class SchedulingApporiginal {



    public static void main(String[] args) {

        SchedulingApporiginal schedulingApp = new SchedulingApporiginal();
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        scheduleList.add(new Schedule(900, 1100));
        scheduleList.add(new Schedule(1100, 1200));
        scheduleList.add(new Schedule(1500, 1900));
        scheduleList.add(new Schedule(1300, 1500));
        scheduleList.add(new Schedule(1800, 2000));



        List<Schedule> resultSchedule = schedulingApp.makeScheduleForEmployee(scheduleList);
        resultSchedule.sort((a,b)->a.startTime-b.startTime);
        for(Schedule schedule: resultSchedule){
            System.out.println("schedule start--"+schedule.startTime);
            System.out.println("schedule end--"+schedule.endTime);
        }

    }

    private List<Schedule> makeScheduleForEmployee(List<Schedule> scheduleList) {
        PriorityQueue<Schedule> priorityQueue = new PriorityQueue<Schedule>((a,b) -> a.startTime - b.startTime);
        PriorityQueue<Schedule> resultPriorityQueue = new PriorityQueue<Schedule>((a,b) -> b.endTime - a.endTime);

        for(Schedule schedule: scheduleList){
            priorityQueue.add(schedule);
        }

        resultPriorityQueue.add(priorityQueue.poll());

         while(!priorityQueue.isEmpty()){
             Schedule secondSchedule = priorityQueue.poll();
             Schedule previousSchedule = resultPriorityQueue.poll();

             if(previousSchedule.endTime.equals(secondSchedule.startTime)){
                 resultPriorityQueue.add(new Schedule(previousSchedule.startTime, secondSchedule.endTime));
             }else{
                 resultPriorityQueue.add(previousSchedule);
                 resultPriorityQueue.add(secondSchedule);
             }

         }

        return resultPriorityQueue.stream().collect(Collectors.toList());
    }


}



