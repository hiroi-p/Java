package Problema1;

import java.time.LocalDate;

public class Angajat {
    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private float salar;

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", data_angajarii=" + data_angajarii +
                ", salar=" + salar +
                '}';
    }

    public Angajat(String nume, String post, LocalDate data_angajarii, float salar) {
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajarii;
        this.salar = salar;
    }

    public float getSalar() {
        return salar;
    }

    public void setSalar(float salar) {
        this.salar = salar;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Angajat() {

    }
}
