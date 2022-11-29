package rompecabezas;

import static espacio_de_estados.EstrategiaBusqueda.*;
public class BusquedaRompecabezas {

  // Método main donde pasaremos los arrays de strings para la realización de los métodos de búsqueda
  public static void main (String[] args) {
    // Creamos string que serán parseados, inicial y final.
    String sInicial = "1,2,3,8,6,0,7,5,4";
    String sMeta =    "1,2,3,8,0,4,7,6,5";
    // Creamos objeto de ProblemaRompecabezas que extiende de ProblemaBusqueda pasándole los estados iniciales y finales .
    ProblemaRompecabezas problema = new ProblemaRompecabezas(sInicial, sMeta);
    problema.buscarSolucion(BUSQUEDA_POR_AMPLITUD, SIN_REPETICION);
  }

}
