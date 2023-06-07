package Entidades;

import Excecoes.ExcecoesDominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private int numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;
    private long numeroNoites;

    public Reserva(int numeroQuarto, Date dataEntrada, Date dataSaida) throws ExcecoesDominio {
        if (dataEntrada.after(dataSaida)) throw new ExcecoesDominio("Erro na Reserva: Data de saída deve ser maior que data de Entrada.");
        if (dataEntrada.before((new Date()))) throw new ExcecoesDominio("Erro na Reserva: Datas da Reserva deve ser atualizada para datas futuras");
        long diff = dataSaida.getTime() - dataEntrada.getTime();
        this.numeroNoites = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;

    }
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public String toString() {
        return "Número do quarto: " + numeroQuarto +
                "\nData de Entrada (dd/MM/yyyy): " + formato.format(dataEntrada) +
                "\nData de saída (dd/MM/yyyy): " + formato.format(dataSaida) +
                "\nReserva: quarto " + numeroQuarto + ", Entrada " + formato.format(dataEntrada) +
                ", Saída: " + formato.format(dataSaida) + ", " + numeroNoites + " noites";
    }
}
