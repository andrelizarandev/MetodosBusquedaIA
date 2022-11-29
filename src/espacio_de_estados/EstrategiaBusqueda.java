package espacio_de_estados;

import java.util.ArrayList;

public abstract class EstrategiaBusqueda {

  // Declaramos las const que determinarán las busquedas que utilizaremos
  public static final int BUSQUEDA_POR_AMPLITUD = 1;
  public static final int BUSQUEDA_POR_PROFUNDIDAD = 2;
  public static final int BUSQUEDA_POR_COSTO_UNIFORME = 3;
  public static final int BUSQUEDA_BEST_FIRST = 4;
  public static final int BUSQUEDA_A_ESTRELLA = 5;
  public static final boolean CON_REPETICION = true;
  public static final boolean SIN_REPETICION = false;
  protected boolean conRepeticion;
  protected Cola colaBusqueda;
  protected Arbol arbol;
  protected ProblemaBusqueda problema;
  protected String nombreEstrategia;

  public EstrategiaBusqueda (ProblemaBusqueda problema) {
    this.problema = problema;
    colaBusqueda = new Cola();
    arbol = new Arbol();
  }

  // Método que será sobreescrito con el extends por cada tipo de búsqueda
  public abstract void encolarSucesores (Estado estadoActual, ArrayList<Estado> sucesores);

  // Dependiendo el tipo de busqueda
  // Empezamos la búsqueda insertando el estado de inicio, desencolándolo y lo insertamos en la cola como cualquier método búsqueda, determinando si es el nodo raiz o no y sí es nodo padre
  public Estado realizarBusqueda (boolean repeticion) {
    System.out.println(nombreEstrategia);
    colaBusqueda.clear();
    arbol.clear();
    conRepeticion = repeticion;
    colaBusqueda.encolarAlInicio(problema.estadoInicial);
    int i = 0;
    while (!colaBusqueda.isEmpty()) {
      System.out.println("" + (i++) + " " + colaBusqueda);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        System.out.println("Error en la interrupción");
        System.exit(-1);
      }
      // Quitar del arreglo y poner en el árbol
      Estado estadoActual = colaBusqueda.desencolar();
      arbol.insertar(estadoActual);
      if (estadoActual.getInfo().equals(problema.estadoMeta.getInfo())) return estadoActual;
      ArrayList<Estado> sucesores = problema.getSucesores(estadoActual);
      encolarSucesores(estadoActual, sucesores);
    }
    return null;
  }

  protected boolean validar (Estado sucesor) {
    if (!conRepeticion) return !arbol.contiene(sucesor);
    return true;
  }

  public String getRuta (Estado estado) {
    return "RUTA = " + arbol.getRuta(estado).toString();
  }
}
