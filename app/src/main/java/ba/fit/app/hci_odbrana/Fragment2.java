package ba.fit.app.hci_odbrana;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    View view;
    Button btnSpremi, btnOdustani;
    int opcinaID;
    String opcinaPrikaz, ime, prezime;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        opcinaID=getArguments().getInt("opcinaID");
        opcinaPrikaz=getArguments().getString("opcinaNaziv");
        ime=getArguments().getString("korisnikIme");
        prezime=getArguments().getString("korisnikPrezime");

        btnSpremi=(Button)view.findViewById(R.id.buttonSnimi);
       btnOdustani=(Button)view.findViewById(R.id.buttonOdustani);


        btnSpremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spremi();
            }


        });


        return view;
    }


    public void spremi() {

        Fragment1 fragment1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putInt("opcinaID",opcinaID);
        bundle.putString("opcinaNaziv",opcinaPrikaz);
        fragment1.setArguments(bundle);
        Toast.makeText(getActivity(),"Uspješno dodan " + ime + " " + prezime,Toast.LENGTH_LONG).show();

        FragmentManager frm = getActivity().getSupportFragmentManager();
        frm.beginTransaction().replace(R.id.forFragments,fragment1).commit();
    }

}
