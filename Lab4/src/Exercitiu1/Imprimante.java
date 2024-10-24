package Exercitiu1;

public class Imprimante extends Echipamente{
    private float ppm;
    private String dpi;
    private int pcar;
    private mod_tiparire mod_tiparire;

    @Override
    public String toString() {
        return super.toString() + "Imprimante{" +
                "ppm=" + ppm +
                ", dpi=" + dpi +
                ", pcar=" + pcar +
                ", mod_tiparire=" + mod_tiparire +
                '}';
    }

    public float getPpm() {
        return ppm;
    }

    public void setPpm(float ppm) {
        this.ppm = ppm;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public int getPcar() {
        return pcar;
    }

    public void setPcar(int pcar) {
        this.pcar = pcar;
    }

    public Exercitiu1.mod_tiparire getMod_tiparire() {
        return mod_tiparire;
    }

    public void setMod_tiparire(Exercitiu1.mod_tiparire mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }

    public Imprimante(String denumire, int nr_inv, float pret, String zona_mag, Stare_echipamente stare, float ppm, String dpi, int pcar, Exercitiu1.mod_tiparire mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pcar = pcar;
        this.mod_tiparire = mod_tiparire;
    }
}
