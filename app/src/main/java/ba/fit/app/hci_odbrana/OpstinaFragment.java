package ba.fit.app.hci_odbrana;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ba.fit.app.hci_odbrana.podaci.OpstinaVM;
import ba.fit.app.hci_odbrana.podaci.Storage;


/**
 * A simple {@link Fragment} subclass.
 */
public class OpstinaFragment extends Fragment {

    View view;


    int opstinaID;
    String OpstinaNaziv, ime, prezime;

    ArrayList<OpstinaVM> opstine = null;
    public OpstinaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.fragment_opstina, container, false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        ime=getArguments().getString("korisnikIme");
        prezime=getArguments().getString("korisnikPrezime");

        popuniListu();


        return view;
    }

    private void popuniListu() {

        opstine = new ArrayList<OpstinaVM>(Storage.getOpstine());
        OpstineAdapter opstineAdapter = new OpstineAdapter(getActivity(),opstine);
        final ListView listView = (ListView)view.findViewById(R.id.listOpstine);
        listView.setAdapter(opstineAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OpstinaVM o = (OpstinaVM)listView.getItemAtPosition(position);
                opstinaID = o.getId();
                OpstinaNaziv=o.getNaziv();

                Bundle b = new Bundle();
                b.putInt("opcinaId",opstinaID);
                b.putString("opcinaNaziv",OpstinaNaziv);
                b.putString("korisnikIme",ime);
                b.putString("korisnikPrezime",prezime);

                Fragment1 fragment = new Fragment1();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragment.setArguments(b);
                fragmentManager.beginTransaction().replace(R.id.forFragments,fragment).commit();

               // Toast.makeText(getActivity(),Integer.toString(opstinaID),Toast.LENGTH_LONG).show();
            }
        });
    }

}
