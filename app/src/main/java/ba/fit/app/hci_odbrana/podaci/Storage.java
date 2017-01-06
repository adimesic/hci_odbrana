package ba.fit.app.hci_odbrana.podaci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adil on 18/06/2016.
 */
public class Storage {
    private static List<OpstinaVM> opstine;
    public static List<OpstinaVM> getOpstine()
    {
        if (opstine == null)
        {
            opstine = new ArrayList<>();
            opstine.add(new OpstinaVM(1, "Mostar", "BiH"));
            opstine.add(new OpstinaVM(2, "Sarajevo", "BiH"));
            opstine.add(new OpstinaVM(3, "Tuzla", "BiH"));
            opstine.add(new OpstinaVM(4, "Banja Luka", "BiH"));
            opstine.add(new OpstinaVM(5, "Zagreb", "Hrvatska"));
            opstine.add(new OpstinaVM(6, "Tuzla", "BiH"));
            opstine.add(new OpstinaVM(7, "Goražde", "BiH"));
            opstine.add(new OpstinaVM(8, "Konjic", "BiH"));
        }
        return opstine;
    }

    private static List<KorisnikVM> korisnici;
    public static List<KorisnikVM> getKorisnici()
    {
        if (korisnici == null)
        {
            korisnici = new ArrayList<>();
            korisnici.add(new KorisnikVM("E.", "Junuz", getOpstine().get(0)));
            korisnici.add(new KorisnikVM("A.", "Joldic", getOpstine().get(7)));
            korisnici.add(new KorisnikVM("E.", "Sudic", getOpstine().get(5)));
            korisnici.add(new KorisnikVM("M.", "Herceg", getOpstine().get(2)));
        }
        return korisnici;
    }
}
