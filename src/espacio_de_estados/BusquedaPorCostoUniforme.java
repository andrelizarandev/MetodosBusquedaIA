package espacio_de_estados;

import java.util.ArrayList;

public class BusquedaPorCostoUniforme extends EstrategiaBusqueda {

  public BusquedaPorCostoUniforme(ProblemaBusqueda problema) {
    super(problema);
    nombreEstrategia = "Búsqueda por Costo Uniforme";
  }

  @Override
  public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
    double costoAcumulado = estadoActual.getCostoAcumulado();
    for (Estado sucesor:sucesores) {
      if (validar(sucesor)) {
        double costo = costoAcumulado + problema.getCosto(estadoActual, sucesor);
        sucesor.setCostoAcumulado(costo);
        sucesor.setPredecesor(estadoActual);
        colaBusqueda.encolarConPrioridad(sucesor, costo);
      }
    }
  }
}
