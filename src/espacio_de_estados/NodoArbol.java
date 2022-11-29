package espacio_de_estados;

import java.util.ArrayList;

// Para determinar padres e hijos de cada nodo
public class NodoArbol <T extends Estado> {
  private final T estado;
  private NodoArbol padre;
  private final ArrayList<NodoArbol> hijos;
  public NodoArbol (T estado) {
    this.estado = estado;
    hijos = new ArrayList();
  }
  public NodoArbol getPadre() {
    return padre;
  }
  public void setPadre(NodoArbol padre) {
    this.padre = padre;
  }
  public T getEstado() {
    return estado;
  }
  public ArrayList<NodoArbol> getHijos() {
    return hijos;
  }
}
