package espacio_de_estados;

import java.util.ArrayList;

public class BusquedaPorProfundidad extends EstrategiaBusqueda {

  public BusquedaPorProfundidad(ProblemaBusqueda problema) {
    super(problema);
    nombreEstrategia = "Busqueda por Profundidad";
  }

  @Override
  public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
    for (Estado sucesor: sucesores) {
      if (validar(sucesor)) {
        sucesor.setPredecesor(estadoActual);
        colaBusqueda.encolarAlInicio(sucesor);
      }
    }
  }

}
