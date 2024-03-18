// Por cada secuencia donde haya N cantidad de números pares, invertir la secuencia
public class invertirSec {
  final static int C = 25, N = 2, SEPARADOR = 0;

  public static void main(String[] args) {
    int[] arr = {2,3,2,5,0,0,5,6,7,7,9,0,2,3,1,0,8,2,1,0,9,3,2,8,1};
    int ini = 0, fin = -1, contador = 0, i = 0;
    mostrar(arr);

    while (ini < C) {
      ini = buscarIni(arr, fin + 1);

      if (ini < C) {
        fin = buscarFin(arr, ini);

        while (contador < N && i < getLength(ini, fin)) {
          contador += daRestoCero(arr[ini + i] , 2) ? 1 : 0;
          i++;
        }

        if (contador == N) {
          invertirSec(arr, ini, fin);
        }


      }

      contador = 0;
      i = 0;
    }

    mostrar(arr);

  }
  
  public static void mostrar(int[] arr){
    for (int i = 0; i < C; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
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

  public static boolean daRestoCero(int n, int d){
    return n % d == 0;
  }

  public static void invertirSec(int[] arr, int ini, int fin){
    int aux;
    while (ini < fin) {
      aux = arr[ini];
      arr[ini] = arr[fin];
      arr[fin] = aux;

      ini++;
      fin--;
    }
  }

  public static int getLength(int ini, int fin){
    return fin - ini + 1;
  }


}
