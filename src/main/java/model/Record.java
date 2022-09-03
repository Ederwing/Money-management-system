package model;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Record {
    private String ID;
    private boolean isIncome;
    private double value;
    private String type;
    private String time;
    public Record() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        time = sdf.format(date);
    }
//    public Record() {    }
//    public Record(Date date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        time = sdf.format(date);
//    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
