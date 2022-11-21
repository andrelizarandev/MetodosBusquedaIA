package espacio_de_estados;

import java.util.ArrayList;

public class BusquedaBestFirst extends EstrategiaBusqueda {

  public BusquedaBestFirst(ProblemaBusqueda problema) {
    super(problema);
    nombreEstrategia = "Busqueda best-first";
  }

  @Override
  public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
    for (Estado sucesor:sucesores) {
      if (validar(sucesor)) {
        double costo = problema.getCostoEstmado(sucesor);
        sucesor.setCostoEstimado(costo);
        sucesor.setPredecesor(estadoActual);
        colaBusqueda.encolarConPrioridad(sucesor, costo);
      }
    }
  }

}
