package TerminalDeOmnibus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Terminal {
    private String nombre;
    private String direccion;
    private ArrayList<Omnibus> guaguas;
    private ArrayList<Pasajero> pasajeros;

    public Terminal(String nombre, String direccion, ArrayList<Omnibus> guaguas, ArrayList<Pasajero> pasajeros, ArrayList<ListaEspera> LE, ArrayList<ListaOficial> LO) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.guaguas = guaguas;
        this.pasajeros = pasajeros;
    }
    public void agnadirOmnibus(Omnibus obj){

        guaguas.add(obj);
    }

    public void agregarPasajero(Pasajero p){

        pasajeros.add(p);
    }

    public Omnibus getOmnibus(int pos){

        return guaguas.get(pos);
    }

    //F1:Todos los omnibus que salieron en un dia
    public ArrayList<Omnibus> getOmnibusesAstros(int dia_salida){
        ArrayList<Omnibus> astros = new ArrayList<>();
        for(Omnibus guagua : guaguas){
            if(guagua instanceof Astro){
                if(((Astro) guagua).getDia_salida().getDay() == dia_salida){
                    astros.add(guagua);
                }
            }
        }
        return astros;
    }

    //F2:Las dos listas en las cuales se apuntan los pasajeros

    //F3:El dinero recaudado en dia por las ventas de los pasajes
    public double dineroRecaudado(Date dia){
        double precio = 0;
        for(Omnibus guagua : guaguas){
            if(guagua instanceof Astro){
                if(((Astro) guagua).getDia_salida() == dia){
                    precio += guagua.Precio();
                }

            }


        }
        return precio;
    }
    //F4:El destino a donde mas pasajeros viajan
    public String destinoMasviajes(){
        int maximo = 0;
        String masRepetido = "";
        Map<String, Integer> frecuencia = new HashMap<>();
        ArrayList<String> destinos = new ArrayList<>();

        for (Omnibus guagua : guaguas){
            destinos.add(guagua.getDestino());
        }

        for (String i : destinos){
            frecuencia.put(i, frecuencia.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<String, Integer> i : frecuencia.entrySet()){
            if(i.getValue() > maximo){
                masRepetido = i.getKey();
                maximo = i.getValue();
            }
        }
        return "El destino con mas viajes fue "+masRepetido+" con "+maximo+" viajes";
    }
    //F5:Cuales fueron los pasajeros que se fueron a cada omnibus
    public ArrayList<String> Pasajeros_omnibus(){
        ArrayList<String> Pasajeros = new ArrayList<>();

        for(Omnibus guagua : guaguas){
            for(int j = 0; j < guagua.getPasajeros().size(); j++){
                Pasajeros.add("Pasajero: " + guagua.getPasajeros().get(j).getID() + " Omnibus: " + guagua.getId());
            }
        }
        return Pasajeros;
    }
    //F6:Asignar automaticamente los pasajeros que se van a ir en un omnibus de acuerdo a la posicion que ocupan en la lista de correspondiente
    public void asignarPasajerosOmnibus(){
        for(int i = 0; i < pasajeros.size(); i++){
            if(pasajeros.get(i) instanceof ListaOficial){
                ListaOficial LO=(ListaOficial) pasajeros.get(i);
                for(Omnibus guagua : guaguas){
                    if(LO.getDestino().equals(guagua.getDestino()) && LO.getDia_salida() == ((Astro) guagua).getDia_salida()){
                        if(((Astro) guagua).cantAsientos_disp() > 0){
                            guagua.agregarPasajeros(LO);
                            pasajeros.remove(i);
                        }
                    }
                }
            }
        }
        for(Pasajero listaEspera : pasajeros){
            if(listaEspera instanceof ListaEspera){
                ListaEspera LE=(ListaEspera) listaEspera;
                for(Omnibus guagua : guaguas){
                    for(int k = 0; k < 3; k++){
                        if(guagua.getDestino().equals(LE.getDestinos()[k])){
                            if(guagua instanceof Astro && ((Astro) guagua).cantAsientos_disp() > 0){
                                guagua.agregarPasajeros(LE);
                                pasajeros.remove(listaEspera);
                            } else if(guagua instanceof Turismo && ((Turismo) guagua).getCantAsientos_disp() > 0){
                                guagua.agregarPasajeros(LE);
                                ((Turismo) guagua).setCantAsientos_disp();
                                pasajeros.remove(listaEspera);

                            }
                        }
                    }

                }
            }
        }
    }
    //F7:Buscar en cual omnibus se fue determinado pasajero
    public Omnibus buscarPasajero(Pasajero p){
        for(Omnibus guagua : guaguas){
            for(int j = 0; j < guagua.getPasajeros().size(); j++){
                if(guagua.getPasajeros().get(j) == p){
                    return guagua;
                }
            }
        }
        return null;
    }

    public ArrayList<String> infoOmnibus(String des){
        ArrayList<String> destinos = new ArrayList<>();

        for (int i = 0; i < guaguas.size(); i++){
            if (guaguas.get(i).getDestino().equals(des)){
                destinos.add(guaguas.toString());
            }
        }
        return destinos;
    }

    public String omnibusTipos(){
        int cantAstros = 0;
        int cantTurismo = 0;

        for(Omnibus guagua : guaguas){
            if(guagua instanceof Astro){
                cantAstros++;
            } else{
                cantTurismo++;
            }
        }
        return "Cantidad de astros: "+cantAstros+" Cantidad de turismo: "+cantTurismo;
    }

    public Omnibus omnibusMasRecaudo(){
        double mayor = 0;
        int indice = 0;

        for (int i = 0; i < guaguas.size(); i++){
            if(guaguas.get(i).Precio()>mayor){
                mayor=guaguas.get(i).Precio();
                indice = i;
            }
        }
        return guaguas.get(indice);
    }
}
