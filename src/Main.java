import Entidades.Reserva;
import Excecoes.ExcecoesDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        System.out.println("Gostaria de confirmar sua reserva?Sim/Não");
        Scanner lerTeclado = new Scanner(System.in);
        String resposta = lerTeclado.nextLine();
        if (resposta.equalsIgnoreCase("sim")){
            System.out.println("Número do quarto");
            try {
                int numeroQuarto = lerTeclado.nextInt();

                System.out.println("Data entrada (dd/mm/aaaa)");
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                Date novaEntrada = formatoData.parse(lerTeclado.next());

                System.out.println("Data saída (dd/mm/aaaa)");
                Date novaSaida = formatoData.parse(lerTeclado.next());

                Reserva novaReserva = new Reserva(numeroQuarto, novaEntrada, novaSaida);
                System.out.println(novaReserva);
            } catch (ExcecoesDominio e){
                System.out.println(e.getMessage());

            } catch (InputMismatchException e){
                System.out.println("Erro: quarto deve conter apenas numeros");
            }
        }
    }
}