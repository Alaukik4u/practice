package interview;

import java.sql.SQLOutput;
import java.util.*;


public class SchedulingApp {



    public static void main(String[] args) {

        SchedulingApp schedulingApp = new SchedulingApp();
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        scheduleList.add(new Schedule(900, 1100));
        scheduleList.add(new Schedule(1100, 1200));
        scheduleList.add(new Schedule(1500, 1900));
        scheduleList.add(new Schedule(1300, 1500));


        List<Schedule> resultSchedule = schedulingApp.makeScheduleForEmployee(scheduleList);
        for(Schedule schedule: resultSchedule){
            System.out.println("schedule start--"+schedule.startTime);
            System.out.println("schedule end--"+schedule.endTime);
        }

    }

    private List<Schedule> makeScheduleForEmployee(List<Schedule> scheduleList) {
        List<Schedule> finalScheduleList = new ArrayList<Schedule>();
        scheduleList.sort((a,b)->a.startTime - b.startTime);
        for(Schedule schedule: scheduleList){
            System.out.println("schedule start--"+schedule.startTime);
            System.out.println("schedule end--"+schedule.endTime);
        }

        Schedule previousSchedule = scheduleList.get(0);

        Schedule mergedSchedule;

        for(int i=1; i<scheduleList.size();i++ ){
           if(previousSchedule.endTime.equals(scheduleList.get(i).startTime)){
               mergedSchedule= new Schedule(previousSchedule.startTime, scheduleList.get(i).endTime);
               finalScheduleList.add(mergedSchedule);

           }else{
               mergedSchedule=scheduleList.get(i);
               finalScheduleList.add(mergedSchedule);
           }

            previousSchedule = mergedSchedule;
        }

        return finalScheduleList;
    }


}



