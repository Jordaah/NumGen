import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenerateurNumeroTelephone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Combien de numéros de téléphone souhaitez-vous générer ? ");
        int nombreDeNumeros = scanner.nextInt();

        List<String> numerosDeTelephone = genererNumerosDeTelephone(nombreDeNumeros);
        enregistrerNumerosDansFichier(numerosDeTelephone, "Numbers.txt");
        System.out.println("Les numéros de téléphone ont été enregistrés dans le fichier Numbers.txt");
    }

    public static List<String> genererNumerosDeTelephone(int nombre) {
        List<String> numerosDeTelephone = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            numerosDeTelephone.add(genererNumeroDeTelephone());
        }
        return numerosDeTelephone;
    }

    public static String genererNumeroDeTelephone() {
        StringBuilder numeroDeTelephone = new StringBuilder("+33");
        numeroDeTelephone.append("6");
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            numeroDeTelephone.append(random.nextInt(10));
        }
        return numeroDeTelephone.toString();
    }

    public static void enregistrerNumerosDansFichier(List<String> numeros, String nomFichier) {
        try {
            FileWriter writer = new FileWriter(nomFichier);
            for (String numero : numeros) {
                writer.write(numero + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des numéros de téléphone dans le fichier.");
            e.printStackTrace();
        }
    }
}
