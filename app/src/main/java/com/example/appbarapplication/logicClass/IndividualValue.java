package com.example.appbarapplication.logicClass;

import java.util.Date;

public class IndividualValue {
    int upperPressure;
    int lowerPressure;
    int pulse;
    boolean tacihordia;
    Date date;
    public IndividualValue(int upperPressure, int lowerPressure, int pulse, boolean tachihordia,
                           Date date){
        this.upperPressure=upperPressure;
        this.lowerPressure=lowerPressure;
        this.pulse=pulse;
        this.tacihordia=tachihordia;
        this.date=date;
    }
}
