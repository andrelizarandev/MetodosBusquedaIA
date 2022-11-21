package rompecabezas;

import espacio_de_estados.EstrategiaBusqueda;

import static espacio_de_estados.EstrategiaBusqueda.BUSQUEDA_POR_AMPLITUD;
import static espacio_de_estados.EstrategiaBusqueda.SIN_REPETICION;

public class BusquedaRompecabezas {

  public static void main (String[] args) {
    String sInicial = "1,2,3,8,6,0,7,5,4";
    String sMeta =    "1,2,3,8,0,4,7,6,5";
    ProblemaRompecabezas problema = new ProblemaRompecabezas(sInicial, sMeta);
    problema.buscarSolucion(BUSQUEDA_POR_AMPLITUD, SIN_REPETICION);
  }

}
