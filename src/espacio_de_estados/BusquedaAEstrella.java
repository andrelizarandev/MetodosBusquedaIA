package espacio_de_estados;

import java.util.ArrayList;

public class BusquedaAEstrella extends EstrategiaBusqueda {

  public BusquedaAEstrella(ProblemaBusqueda problema) {
    super(problema);
    nombreEstrategia = "Busqueda A";
  }

  @Override
  public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
    double costoAcumulado = estadoActual.getCostoAcumulado();
    for (Estado sucesor:sucesores) {
      if (validar(sucesor)) {
        double acumulado = costoAcumulado + problema.getCosto(estadoActual, sucesor);
        sucesor.setCostoAcumulado(acumulado);
        double estimado = problema.getCostoEstimado(sucesor);
        sucesor.setCostoEstimado(estimado);
        sucesor.setPredecesor(estadoActual);
        colaBusqueda.encolarConPrioridad(sucesor, acumulado + estimado);
      }
    }
  }

}
