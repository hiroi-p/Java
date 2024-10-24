package Exercitiu1;

public class Sisteme_calcul extends Echipamente {
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private Sistem_operare sistem_operare;

    @Override
    public String toString() {
        return  super.toString() + "Sisteme_calcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", sistem_operare=" + sistem_operare +
                '}';
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public float getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(float vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public Sistem_operare getSistem_operare() {
        return sistem_operare;
    }

    public void setSistem_operare(Sistem_operare sistem_operare) {
        this.sistem_operare = sistem_operare;
    }

    public Sisteme_calcul(String denumire, int nr_inv, float pret, String zona_mag, Stare_echipamente stare, String tip_mon, float vit_proc, int c_hdd, Sistem_operare sistem_operare) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem_operare = sistem_operare;
    }
}
