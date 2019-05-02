package sg.edu.rp.c347.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter aa;
    ArrayList<Module> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lvModules);

        module=new ArrayList<Module>();
        module.add(new Module("C346", "Android Programming"));

        aa=new ModuleAdapter(this,R.layout.row,module);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = module.get(position);
                String selectModule = selectedModule.getCode();

                //create intent
                Intent i = new Intent(MainActivity.this, GradeActivity.class);

                //pass object
                i.putExtra("selectModule",selectModule);
                startActivity(i);
            }
        });
    }
}
