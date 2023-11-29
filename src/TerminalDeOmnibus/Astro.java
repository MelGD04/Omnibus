package TerminalDeOmnibus;

import java.util.ArrayList;
import java.util.Date;

public class Astro extends Omnibus{
    private Date dia_salida;
    private String hora_salida;
    private int cant_asientos;

    public Astro(String id, String chapa, String destino, String chofer, double cantKm, Date dia_salida, String hora_salida, int cant_asientos, ArrayList<Pasajero> pasajeros) {
        super(id, chapa, destino, chofer, cantKm, pasajeros);
        this.dia_salida = dia_salida;
        this.hora_salida = hora_salida;
        this.cant_asientos = cant_asientos;
    }

    public double Precio(){
        double Precio = cantKm*4;

        return Precio;
    }

    public Date getDia_salida(){
        return dia_salida;
    }

    public int cantAsientos_disp(){
        return cant_asientos-pasajeros.size();
    }
}
