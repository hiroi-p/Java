package Problema2;

import Problema1.PerecheNumere;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    static List<Mobilier> citire() throws IOException {
        File file = new File("Lab5/src/main/resources/mobilier.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Mobilier> lista = mapper.readValue(file, new TypeReference<List<Mobilier>>() {
        });
        return lista;
    }
    public static void main(String[] args) throws IOException {
        List<Mobilier> mobilierList = citire();

        for (Mobilier mobilier : mobilierList) {
            System.out.println("Piesa de mobilier: " + mobilier.getNume());
            for (Placa placa : mobilier.getPlaci()) {
                System.out.println("  Placa: " + placa.getDescriere() + ", Dimensiuni: " + placa.getLungime() + "x" + placa.getLatime() + " mm, Orientare: " + placa.getOrientare());
            }
        }

        // Afișarea caracteristicilor plăcilor pentru o anumită piesă de mobilier
        String numeMobilierCautat = "dulap 1"; // Exemplu
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(numeMobilierCautat)) {
                System.out.println("Caracteristicile plăcilor pentru " + numeMobilierCautat + ":");
                for (Placa placa : mobilier.getPlaci()) {
                    System.out.println("  Placa: " + placa.getDescriere() + ", Dimensiuni: " + placa.getLungime() + "x" + placa.getLatime() + " mm, Orientare: " + placa.getOrientare());
                }
            }
        }

        // Calcularea numărului de coli de pal necesare
        String numeMobilierCalcul = "dulap 1"; // Exemplu
        int dimensiuneColaLungime = 2800;
        int dimensiuneColaLatime = 2070;
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(numeMobilierCalcul)) {
                int arieTotala = 0;
                for (Placa placa : mobilier.getPlaci()) {
                    arieTotala += placa.getLungime() * placa.getLatime() * placa.getNr_bucati();
                }
                int arieCola = dimensiuneColaLungime * dimensiuneColaLatime;
                int numarColiNecesar = (int) Math.ceil((double) arieTotala / arieCola);
                System.out.println("Numărul estimativ de coli de pal necesare pentru " + numeMobilierCalcul + ": " + numarColiNecesar);
            }
        }
    }
}
