package sg.edu.rp.c347.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> module;
    private Context context;
    private TextView tvCode, tvName;


    public ModuleAdapter(Context context,int resource,ArrayList<Module> objects){
        super(context,resource,objects);
        module=objects;
        this.context=context;

    }

    //getView() method
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //inflate
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //INFLATE row.xml
        View rowView=inflater.inflate(R.layout.row,parent,false);
        //get tv
        tvCode=rowView.findViewById(R.id.tvModuleCode);
        tvName=rowView.findViewById(R.id.tvModuleName);

        //position
        Module currentType=module.get(position);
        //set tv to show type
        tvCode.setText(currentType.getCode());
        tvName.setText(currentType.getName());

        //return lv
        return rowView;
    }
}
