package sg.edu.rp.c347.p03_classjournal;

import java.io.Serializable;

public class DailyGrade implements Serializable {

    private int weekNum;
    private String grade;

    public DailyGrade(int weekNum, String grade) {
        this.weekNum = weekNum;
        this.grade = grade;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public String grade() {
        return grade;
    }
}
