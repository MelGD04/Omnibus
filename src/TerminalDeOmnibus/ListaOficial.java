package TerminalDeOmnibus;

import java.util.Date;

public class ListaOficial extends Pasajero{
    private Date dia_salida;
    private String destino;

    public ListaOficial(String ID, Date dia_salida, String destino){
        super(ID);
        this.dia_salida = dia_salida;
        this.destino = destino;
    }

    public Date getDia_salida(){

        return dia_salida;
    }

    public String getDestino(){

        return destino;
    }
}
