package rompecabezas;

import espacio_de_estados.Estado;

import java.awt.*;
import java.util.Arrays;

public class Rompecabezas extends Estado {

  private final int [][] matriz;

  public Rompecabezas (int[][] matriz) {
    this.matriz = matriz;
  }

  public Rompecabezas (String datos) {
    String[] tokens = datos.split(",");
    // Raiz cuadrada para crear un array de dos direcciones y rellenamos con ints
    int n = (int) Math.sqrt(tokens.length);
    matriz = new int[n][n];
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matriz[i][j] = Integer.parseInt(tokens[i * n + j]);
      }
    }
  }

  public int[][] getMatriz () {
    return matriz;
  }

  public int getDimension () {
    return matriz.length;
  }

  @Override
  public String getInfo() {
    String salida = "";
    for (int[] fila:matriz) {
      salida += Arrays.toString(fila).replace(" ", "");
    }
    return "<" + salida + ">";
  }

  public Rompecabezas copiar () {
    int n = matriz.length;
    int [][] copia = new int[n][n];
    for (int i = 0; i < n; i++) {
      System.arraycopy(matriz[i], 0, copia[i], 0, n);
    }
    return new Rompecabezas(copia);
  }

  public Point getUbicacion (int valor) {
    int n = matriz.length;
    for (int i = 0; i < n; i++ ) {
      for (int j = 0; j < n; j++) {
        if (matriz[i][j] == valor) return new Point(i, j);
      }
    }
    return null;
  }

  public void moverHorizontal (Point cero, int x) {
    matriz[cero.x][cero.y] = matriz[x][cero.y];
    matriz[x][cero.y] = 0;
  }

  public void moverVertical (Point cero, int y) {
    matriz[cero.x][cero.y] = matriz[cero.x][y];
    matriz[cero.x][y] = 0;
  }

}
