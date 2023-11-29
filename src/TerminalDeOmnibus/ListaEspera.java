package TerminalDeOmnibus;

public class ListaEspera extends Pasajero{
    private String[] destinos = new String[3];

    public ListaEspera(String ID, String[] destinos){
        super(ID);
        this.destinos = destinos;
    }

    public String[] getDestinos(){
        return destinos;
    }
}
