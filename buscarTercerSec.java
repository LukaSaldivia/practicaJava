// Imprimir la tercer secuencia del arreglo

public class buscarTercerSec {
  final static int C = 15, SEPARADOR = 0;

  public static void main(String[] args) {
    int[] arr = {1,2,3,0,0,7,8,9,7,0,2,3,0,6,7};

    int ini = buscarIni(arr, 0, 3);
    int fin = buscarFin(arr, ini);

    mostrar(arr);
    mostrar(arr, ini, fin);
  }

  public static int buscarIni(int[] arr, int pos){
    while(pos < C && arr[pos] == SEPARADOR)
    pos++;

    return pos;
  }

  public static int buscarFin(int[] arr, int pos){
    while(pos < C && arr[pos] != SEPARADOR)
    pos++;

    return pos - 1;
  }

  public static int buscarIni(int[] arr, int pos, int n){

    int i = 0;
    int fin = -1;
    while (pos < C && i < n) {
      pos = buscarIni(arr, fin + 1);

      if (pos < C) {
        fin = buscarFin(arr, pos);
        i++;
      }
    }

    return pos;
  }

  public static void mostrar(int[] arr){
    for (int i = 0; i < C; i++)
    if (arr[i] == SEPARADOR)
    System.out.print("_ ");
    else
    System.out.print(arr[i] + " ");
    
    System.out.println(' ');
  }

  public static void mostrar(int[] arr, int ini, int fin){
    for (int i = ini; i <= fin; i++) {
      System.out.print(arr[i]);
    }

    System.out.println("");
  }
}
