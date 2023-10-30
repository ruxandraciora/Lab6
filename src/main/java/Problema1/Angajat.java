package Problema1;

import java.time.LocalDate;

public class Angajat {

    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private float salariu;

    public Angajat() {}

    public Angajat(String nume, String post, LocalDate data_angajarii,float salariu)
    {
        this.nume=nume;
        this.post=post;
        this.data_angajarii=data_angajarii;
        this.salariu=salariu;
    }

    public String getNume()
    {
        return nume;
    }

    public String getPost()
    {
        return post;
    }

    public LocalDate getData_angajarii()
    {
        return data_angajarii;
    }

    public float getSalariu()
    {
        return salariu;
    }

    public String toString()
    {
        return "Nume: " + nume + "\nPost: " + post +"\nData angajarii: " + data_angajarii + "\nSalariu: " + salariu;
    }
}
