package espacio_de_estados;

import java.util.ArrayList;

public class BusquedaPorAmplitud extends EstrategiaBusqueda {

  public BusquedaPorAmplitud(ProblemaBusqueda problema) {
    super(problema);
    nombreEstrategia = "Busqueda por Amplitud";
  }

  // Al ser FIFO el primero que entra es el primero en salir
  @Override
  public void encolarSucesores(Estado estadoActual, ArrayList<Estado> sucesores) {
    for (Estado sucesor: sucesores) {
      if (validar(sucesor)) {
        sucesor.setPredecesor(estadoActual);
        colaBusqueda.encolarAlFinal(sucesor);
      }
    }
  }

}
