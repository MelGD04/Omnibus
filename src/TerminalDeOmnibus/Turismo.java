package TerminalDeOmnibus;

import java.util.ArrayList;

public class Turismo extends Omnibus{
    private String horallegada_terminal;
    private int cantAsientos_disp;

    public Turismo(String id, String chapa, String destino, String chofer, double cantKm, String horallegada_terminal, int cantAsientos_disp, ArrayList<Pasajero> pasajeros) {
        super(id, chapa, destino, chofer, cantKm, pasajeros);
        this.horallegada_terminal = horallegada_terminal;
        this.cantAsientos_disp = cantAsientos_disp;
    }

    public double Precio(){
        double precio = 0;
        if (cantKm<100){
            return precio = 10;
        }
        else if (cantKm>100 && cantKm<200){
            return precio = 20;
        }
        else{
            return precio = 30;
        }
    }

    public int getCantAsientos_disp(){
        return cantAsientos_disp;
    }

    public void setCantAsientos_disp(){
        cantAsientos_disp--;
    }
}
