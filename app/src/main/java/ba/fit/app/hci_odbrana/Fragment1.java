package ba.fit.app.hci_odbrana;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment  {

    View view;
    Button btnSnimi, btnOpstine;
    EditText ime, prezime;
    String opcinaPrikaz="";
    int opcinaID=0;

    Bundle b = getArguments();

    public Fragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);

        }
        ime = (EditText) view.findViewById(R.id.editTextIme);
        prezime = (EditText) view.findViewById(R.id.editTextPrezime);
        btnSnimi = (Button) view.findViewById(R.id.buttonSnimiMain);
        btnOpstine = (Button) view.findViewById(R.id.buttonOpstina);

        if (getArguments() != null) {
            opcinaPrikaz = getArguments().getString("opcinaNaziv");
            opcinaID = getArguments().getInt("opcinaID");
            if(getArguments().getString("korisnikIme")!=null)
                ime.setText(getArguments().getString("korisnikIme"));
            if(getArguments().getString("korisnikPrezime")!=null)
                prezime.setText(getArguments().getString("korisnikPrezime"));
            btnOpstine.setText(opcinaPrikaz);

        }

        btnSnimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snimi();
            }
        });

        btnOpstine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prikaziOpstine();
            }
        });

        return view;
    }

    private void prikaziOpstine() {
        OpstinaFragment fragment = new OpstinaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("korisnikIme",ime.getText().toString());
        bundle.putString("korisnikPrezime",prezime.getText().toString());
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.forFragments,fragment).commit();
    }

    private void snimi() {

        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putInt("opcinaID",opcinaID);
        bundle.putString("opcinaNaziv",opcinaPrikaz);
        bundle.putString("korisnikIme",ime.getText().toString());
        bundle.putString("korisnikPrezime",prezime.getText().toString());
        fragment2.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.forFragments,fragment2).commit();

    }

}

