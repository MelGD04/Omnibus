package TerminalDeOmnibus;

import java.util.ArrayList;

public abstract class Omnibus {
    protected String id;
    protected String chapa;
    protected String destino;
    protected String chofer;
    protected double cantKm;
    protected ArrayList<Pasajero> pasajeros;


    public Omnibus(String id, String chapa, String destino, String chofer, double cantKm, ArrayList<Pasajero> pasajeros) {
        this.id = id;
        this.chapa = chapa;
        this.destino = destino;
        this.chofer = chofer;
        this.cantKm = cantKm;
        this.pasajeros = pasajeros;
    }
    public abstract double Precio();

    public String getDestino(){

        return destino;
    }

    public ArrayList<Pasajero> getPasajeros(){
        return pasajeros;
    }

    public void agregarPasajeros(Pasajero p){
        pasajeros.add(p);
    }

    public String getId(){

        return id;
    }

    @Override
    public String toString(){
        return "Omnibus{" +
                "id='" + id + '\'' +
                ", chapa='" + chapa + '\'' +
                ", destino='" + destino + '\'' +
                ", chofer='" + chofer + '\'' +
                ", cantKm=" + cantKm +
                '}';
    }
}

   


