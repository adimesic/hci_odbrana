package ba.fit.app.hci_odbrana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ba.fit.app.hci_odbrana.podaci.OpstinaVM;

/**
 * Created by Student on 09.12.2016..
 */
public class OpstineAdapter extends ArrayAdapter<OpstinaVM> {

    public OpstineAdapter(Context context, ArrayList<OpstinaVM> opstine) {
        super(context, 0, opstine);
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        OpstinaVM opstine = getItem(position);
        if(view==null)
        {
            view= LayoutInflater.from(getContext()).inflate(R.layout.opstina_item_list,parent,false);
        }

        TextView opstinaID=(TextView)view.findViewById(R.id.textViewID);
        TextView opstina=(TextView)view.findViewById(R.id.textViewOpstina);
        TextView drzava=(TextView)view.findViewById(R.id.textViewDrzava);

        opstinaID.setText(Integer.toString(opstine.getId()));
        opstina.setText(opstine.getNaziv());
        drzava.setText(opstine.getDrzava());

        return view;
    }
}
