import java.util.regex.*;

public class TestNumeroTelephone {
    public static void main(String[] args) {
        String[] numeros = {"+33612345678", "+330612345678", "+33123456789", "0612345678", "0123456789"};

        for (String numero : numeros) {
            if (validerNumeroTelephone(numero)) {
                System.out.println(numero + " est un numéro de téléphone valide.");
            } else {
                System.out.println(numero + " n'est pas un numéro de téléphone valide.");
            }
        }
    }

    public static boolean validerNumeroTelephone(String numero) {
        String regex = "\\+33\\d{9}";
        return numero.matches(regex);
    }
}
