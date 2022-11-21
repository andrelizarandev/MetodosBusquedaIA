package rompecabezas;

import static espacio_de_estados.EstrategiaBusqueda.*;
public class BusquedaRompecabezas {

  public static void main (String[] args) {
    String sInicial = "1,2,3,8,6,0,7,5,4";
    String sMeta =    "1,2,3,8,0,4,7,6,5";
    ProblemaRompecabezas problema = new ProblemaRompecabezas(sInicial, sMeta);
    problema.buscarSolucion(BUSQUEDA_POR_PROFUNDIDAD, SIN_REPETICION);
  }

}
