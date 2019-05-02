package sg.edu.rp.c347.p03_classjournal;

import java.io.Serializable;

public class Module {
    private String code;
    private String name;

    public Module(String code, String name){
        this.code=code;
        this.name=name;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }
}
