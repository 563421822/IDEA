package entity;

import lombok.Data;

@Data
public class TrainInfo {
    private String trainNo;
    private String startStation;
    private String startTime;
    private String arrivalTime;
    private String type;
    private String runtime;
    private double mile;
}
