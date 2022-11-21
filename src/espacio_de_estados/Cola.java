package espacio_de_estados;

import java.util.ArrayList;

public class Cola extends ArrayList<Estado> {

  public void encolarAlInicio (Estado estado) {
    this.add(0, estado);
  }
  public void encolarAlFinal (Estado estado) {
    this.add(estado);
  }

  public void encolarConPrioridad (Estado estado, double costo) {
    for (int i= 0; i < size(); i++) {
      double costoTotal = get(i).getCostoCombinado();
      if (costoTotal > costo) {
        this.add(i, estado);
        return;
      }
    }
    add(estado);
  }

  public Estado desencolar () {
    if (!this.isEmpty()) return this.remove(0);
    return null;
  }

}
