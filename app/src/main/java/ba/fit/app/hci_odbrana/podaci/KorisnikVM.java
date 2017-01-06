package ba.fit.app.hci_odbrana.podaci;

/**
 * Created by Adil on 18/06/2016.
 */
public class KorisnikVM {
    private String ime;
    private String prezime;
    private OpstinaVM opstinaVM;

    public KorisnikVM(String ime, String prezime, OpstinaVM opstinaVM) {
        this.ime = ime;
        this.prezime = prezime;
        this.opstinaVM = opstinaVM;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public OpstinaVM getOpstinaVM() {
        return opstinaVM;
    }

    public void setOpstinaVM(OpstinaVM opstinaVM) {
        this.opstinaVM = opstinaVM;
    }
}
