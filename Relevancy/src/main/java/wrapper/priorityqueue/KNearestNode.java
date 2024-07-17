package wrapper.priorityqueue;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class KNearestNode {
    int value;
    int proximity;
    Integer xcoordinate;
    Integer ycoordinate;

 /*   KNearestNode(int value, int proximity){
        this.value = value;
        this.proximity = proximity;
    }*/

    KNearestNode(Integer xcoordinate, Integer ycoordinate){
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
    }
}
