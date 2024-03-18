// Dada una matriz de C*F, invertir cada sustantivo propio del mensaje.

public class bond {
  final static int C = 20, F = 5;
  final static char SEPARADOR = ' ';

  public static void main(String[] args) {
    console("");
    char[][] msg = {

      {'J','a','m','e','s',' ','B','o','n','d',' ','t','u',' ',' ',' ',' ',' ',' ',' '},
      {'m','i','s','i','o','n',' ','e','s',' ','i','r',' ','a',' ',' ',' ',' ',' ',' '},
      {'G','u','a','d','a','l','a','j','a','r','a',' ',' ',' ',' ',' ',' ',' ',' ',' '},
      {'y',' ','r','o','b','a','r',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
      {'l','o','s',' ','d','a','t','o','s',' ','a',' ','B','e','l','l','a',' ',' ',' '}

    };

    int ini = 0, fin = -1, cambios = 0;

    for (int i = 0; i < F; i++) {
      while (ini < C) {
        ini = buscarIni(msg[i], fin + 1);

        if (ini < C) {
          fin = buscarFin(msg[i], ini);

          if (esMayuscula(msg[i][ini])) {
            invertirSec(msg[i], ini, fin);

            cambios++;
          }
        }
      }

      ini = 0; fin = -1;
    }


    mostrar(msg);
    console("");
    console("Se han realizado "+cambios+" cambios.");
  }

  public static int buscarIni(char[] arr, int pos){
    while(pos < C && arr[pos] == SEPARADOR)
    pos++;

    return pos;
  }

  public static int buscarFin(char[] arr, int pos){
    while(pos < C && arr[pos] != SEPARADOR)
    pos++;

    return pos - 1;
  }

  public static void mostrar(char[] arr){
    for (int i = 0; i < C; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
  }

  public static void mostrar(char[][] mat){
    for (int i = 0; i < F; i++) {
      mostrar(mat[i]);
    }
  }

  public static void console(String txt){
    System.out.println(txt);
  }

  public static boolean esMayuscula(char c){
    return 'A' <= c && c <= 'Z';
  }

  public static void invertirSec(char[] arr, int ini, int fin){
    char aux;

    while(ini < fin){
      aux = arr[ini];
      arr[ini] = arr[fin];
      arr[fin] = aux;

      ini++;
      fin--;
    }
  }
}
