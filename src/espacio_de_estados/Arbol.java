package espacio_de_estados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Arbol extends HashMap<Long, NodoArbol> {
  private NodoArbol raiz;
  public void insertar (Estado estado) {
    NodoArbol nodo = new NodoArbol(estado);
    put(estado.getId(), nodo);
    Estado padre = estado.getPredecesor();
    if (padre == null) raiz = nodo;
    else {
      NodoArbol nodoPadre = this.get(padre.getId());
      nodoPadre.getHijos().add(nodo);
      nodo.setPadre(nodoPadre);
    }
  }
  public boolean contiene (Estado estado) {
    String info = estado.getInfo();
    Iterator <NodoArbol> nodos = this.values().iterator();
    while (nodos.hasNext()) {
      NodoArbol siguiente = (NodoArbol) nodos.next();
      if (info.equals(siguiente.getEstado().getInfo())) return true;
    }
    return false;
  }
  public ArrayList<Estado> getRuta (Estado estado) {
    ArrayList<Estado> ruta = new ArrayList();
    NodoArbol siguiente = get(estado.getId());
    while (siguiente != null) {
      ruta.add(0, siguiente.getEstado());
      siguiente = siguiente.getPadre();
    }
    return ruta;
  }
  public NodoArbol getRaiz() {
    return raiz;
  }

}
