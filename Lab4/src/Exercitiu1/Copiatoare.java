package Exercitiu1;

public class Copiatoare extends Echipamente {
    private int p_ton;
    private Format_copiere formatCopiere;

    public Copiatoare(String denumire, int nr_inv, float pret, String zona_mag, Stare_echipamente stare, int p_ton, Format_copiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return super.toString() + "Copiatoare{" +
                "p_ton=" + p_ton +
                ", formatCopiere=" + formatCopiere +
                '}';
    }

    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public Format_copiere getFormatCopiere() {
        return formatCopiere;
    }

    public void setFormatCopiere(Format_copiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }
}
