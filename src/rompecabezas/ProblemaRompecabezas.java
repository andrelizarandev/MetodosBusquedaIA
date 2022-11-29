package rompecabezas;

import espacio_de_estados.ProblemaBusqueda;

import java.awt.*;
import java.util.ArrayList;

public class ProblemaRompecabezas extends ProblemaBusqueda<Rompecabezas> {
  public static final int COSTO_FIJO = 0;
  public static final int MAS_CARO_VERTICAL = 1;
  public static final int MAS_CARO_HORIZONTAL = 2;
  public static final int DIFERENTES = 3;
  public static final int DISTANCIA_MANHATTAN = 4;
  public static final int DISTANCIA_EUCLIDIANA = 5;

  private int tipoCostoAcumulado;
  private int tipoCostoEstimado;

  public ProblemaRompecabezas (Rompecabezas rInicial, Rompecabezas rMeta, int tipoCostoAcumulado, int tipoCostoEstimado ) {
    super(rInicial, rMeta);
    this.tipoCostoAcumulado = tipoCostoAcumulado;
    this.tipoCostoEstimado = tipoCostoEstimado;
  }

  public ProblemaRompecabezas (String sInicial, String sMeta, int tipoCostoAcumulado, int tipoCostoEstimado) {
    this(new Rompecabezas(sInicial), new Rompecabezas(sMeta), tipoCostoAcumulado, tipoCostoEstimado);
  }

  public ProblemaRompecabezas (Rompecabezas rInicial, Rompecabezas rMeta) {
    this (rInicial, rMeta, COSTO_FIJO, DIFERENTES);
  }

  // Por constructores llegamos a ProblemaBusqueda donde entregaremos objetos Rompecabezas que por constructor les pasaremos los strings de estado inicial y final.
  public ProblemaRompecabezas (String sInicial, String sMeta) {
    this (new Rompecabezas(sInicial), new Rompecabezas(sMeta));
  }

  @Override
  public double getCosto (Rompecabezas estadoActual, Rompecabezas estadoSucesor) {
    switch (tipoCostoAcumulado) {
      case COSTO_FIJO:
        return 1;
      case MAS_CARO_VERTICAL:
      case MAS_CARO_HORIZONTAL: {
        Point ceroActual = estadoActual.getUbicacion(0);
        Point ceroSucesor = estadoSucesor.getUbicacion(0);
        if (ceroActual.x != ceroSucesor.x) return tipoCostoAcumulado == MAS_CARO_HORIZONTAL ? 2 : 1;
        else return tipoCostoAcumulado == MAS_CARO_VERTICAL ? 2 : 1;
      }
      default:
        throw new UnsupportedOperationException("Costo acumulado no definido");
    }
  }
  @Override
  public double getCostoEstimado (Rompecabezas estadoActual) {
    int n = estadoActual.getDimension();
    int totalNumeros = n * n;
    double costo = 0;
    for (int i = 1; i < totalNumeros; i++) {
      Point pActual = estadoActual.getUbicacion(i);
      Point pMeta = estadoMeta.getUbicacion(i);
      switch (tipoCostoEstimado) {
        case DIFERENTES: {
          if ((int) pActual.distance(pMeta) != 0) {
            costo++;
          }
          break;
        }
        case DISTANCIA_EUCLIDIANA: {
          costo += pActual.distance(pMeta);
          break;
        }
        case DISTANCIA_MANHATTAN: {
          int difX = Math.abs(pActual.x - pMeta.x);
          int difY = Math.abs(pActual.y - pMeta.y);
          costo += (difX + difY);
          break;
        }
        default:
          throw new UnsupportedOperationException("Costo estimado no definido");
      }
    }
    return costo;
  }
  @Override
  public ArrayList<Rompecabezas> getSucesores (Rompecabezas estadoActual) {
    ArrayList<Rompecabezas> sucesores = new ArrayList();
    int n = estadoActual.getDimension();
    Point cero = estadoActual.getUbicacion(0);
    int izq = cero.x - 1;
    int der = cero.x + 1;
    int sup = cero.y - 1;
    int inf = cero.y + 1;
    if (izq >= 0) {
      Rompecabezas estadoSucesor = estadoActual.copiar();
      estadoSucesor.moverHorizontal(cero, izq);
      sucesores.add(estadoSucesor);
    }
    if (der < n) {
      Rompecabezas estadoSucesor = estadoActual.copiar();
      estadoSucesor.moverHorizontal(cero, der);
      sucesores.add(estadoSucesor);
    }
    if (sup >= 0) {
      Rompecabezas estadoSucesor = estadoActual.copiar();
      estadoSucesor.moverVertical(cero, sup);
      sucesores.add(estadoSucesor);
    }
    if (inf < n) {
      Rompecabezas estadoSucesor = estadoActual.copiar();
      estadoSucesor.moverVertical(cero, inf);
      sucesores.add(estadoSucesor);
    }
    return sucesores;
  }

}
