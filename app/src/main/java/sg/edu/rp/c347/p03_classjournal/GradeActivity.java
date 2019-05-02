package sg.edu.rp.c347.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class GradeActivity extends AppCompatActivity {

    int requestCodeAdd = 1;
    Button btnEmail, btnInfo, btnAdd;
    ListView lvDg;

    ArrayAdapter aaDg;
    ArrayList<DailyGrade> dailygrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        Intent i = getIntent();
        String type = i.getStringExtra("selectModule");

        btnInfo = (Button)findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = (Button) findViewById(R.id.buttonEmail);
        lvDg = this.findViewById(R.id.lvDg);

        dailygrade = new ArrayList<DailyGrade>();
        dailygrade.add(new DailyGrade("1", "A"));
        dailygrade.add(new DailyGrade("2", "B"));

        aaDg = new DailyGradeAdapter(this, R.layout.row_grade, dailygrade);
        lvDg.setAdapter(aaDg);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                for(int i = 0; i < dailygrade.size(); i++ ){
                    message = message +"\n" + dailygrade.get(i).getWeekNum() + ": DG: " + dailygrade.get(i).getGrade();
                }

                Intent email = new Intent (Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,"Hi Faci, \n \n I am Lutfiah \n Please see my remarks so far, thank you!" + "\n \n" + message

                );
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent (Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(webIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weekText = dailygrade.size()+1;
                Intent i = new Intent(GradeActivity.this, Data.class);
                i.putExtra("week", weekText);
                startActivityForResult(i,requestCodeAdd);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {
                if(requestCode == requestCodeAdd){
                    DailyGrade nWeek = (DailyGrade) data.getSerializableExtra("nWeek");
                    dailygrade.add(nWeek);
                    aaDg.notifyDataSetChanged();
                }
            }
        }
    }
}
