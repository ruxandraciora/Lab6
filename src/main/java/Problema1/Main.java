package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(List<Angajat> lista)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire()
    {
        try
        {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> lista = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return lista;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Angajat> lista = citire();

        Scanner read = new Scanner(System.in);
        int optiune;
        do {
            System.out.println("0. Iesire.");
            System.out.println("1. Afisarea listei de angajati.");
            System.out.println("2. Afisarea angajatilor care au salariu peste 2500 RON.");
            System.out.println("3. Crearea si afisarea listei cu angajatii din luna aprilie a anului trecut care au functie de conducere.");
            System.out.println("4. Afisarea angajatilor care nu au functie de conducere.");
            System.out.println("Introduceti optiunea: ");
            optiune = read.nextInt();
            switch(optiune)
            {
                case 0: break;
                case 1:
                    lista.stream()
                            .forEach(System.out::println);
                    break;
                case 2:
                    lista.stream()
                            .filter(angajat -> angajat.getSalariu() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    lista.stream()
                            //.filter(angajat -> (angajat.getData_angajarii().isBefore(LocalDate.of(LocalDate.now().getYear()-1,))))
                            .filter(angajat -> (angajat.getPost().compareToIgnoreCase("sef") == 0) || (angajat.getPost().compareToIgnoreCase("director") == 0))
                            .forEach(System.out::println);

                    break;

            }

        }while(optiune!=0);
    }

}
