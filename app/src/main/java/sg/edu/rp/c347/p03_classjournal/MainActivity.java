package sg.edu.rp.c347.p03_classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter aa;
    ArrayList<Module> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv=findViewById(R.id.lvModules);

        module=new ArrayList<Module>();
        module.add(new Module("C346", "Android Programming"));

        aa=new ModuleAdapter(this,R.layout.row,module);
        lv.setAdapter(aa);
    }
}
