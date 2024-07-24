package interview;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


public class SchedulingAppTest {



    public static void main(String[] args) {

        SchedulingApp schedulingApp = new SchedulingApp();
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        scheduleList.add(new Schedule(900, 1100));
        scheduleList.add(new Schedule(1500, 1600));
        scheduleList.add(new Schedule(1600, 1800));
        scheduleList.add(new Schedule(1900, 2100));

        scheduleList.add(new Schedule(1100, 1200));


        List<Schedule> resultSchedule = makeScheduleForEmployee(scheduleList);
        System.out.println("********* Answer  ********* ");
        for(Schedule schedule: resultSchedule){

            System.out.println("schedule start--"+schedule.startTime);
            System.out.println("schedule end--"+schedule.endTime);

        }
        System.out.println("********* Answer end  ********* ");

    }

    private static List<Schedule> makeScheduleForEmployee(List<Schedule> scheduleList) {
        List<Schedule> finalScheduleList = new ArrayList<Schedule>();
        scheduleList.sort((a,b)->a.startTime - b.startTime);
        System.out.println("********* Sorted order ********* ");
        for(Schedule schedule: scheduleList){

            System.out.println("schedule start--"+schedule.startTime);
            System.out.println("schedule end--"+schedule.endTime);

        }
        System.out.println("********* Sorted order end  ********* ");


        PriorityQueue<Schedule> priorityQueue = new PriorityQueue<>((a,b)->b.endTime -a.endTime);
        priorityQueue.add(scheduleList.get(0));

        for(int i=1; i<scheduleList.size();i++){
            int endTime = priorityQueue.peek().endTime;

            if(endTime == scheduleList.get(i).startTime){
                Schedule schedule = priorityQueue.poll();
                schedule.endTime = scheduleList.get(i).endTime;
                priorityQueue.add(schedule);
            }else{
                priorityQueue.add(scheduleList.get(i));
            }
        }




        return priorityQueue.stream().sorted((a,b)->a.startTime-b.startTime).collect(Collectors.toList());
    }


}



