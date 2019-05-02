package sg.edu.rp.c347.p03_classjournal;

import java.io.Serializable;

public class DailyGrade implements Serializable {

    private String weekNum;
    private String grade;

    public DailyGrade(String weekNum, String grade) {
        this.weekNum = weekNum;
        this.grade = grade;
    }

    public String getWeekNum() {
        return weekNum;
    }

    public String getGrade() {
        return grade;
    }
}
