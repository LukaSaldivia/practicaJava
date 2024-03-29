// ❗ Si después necesitas seguir recorriendo secuencias, recordar restar fin - #corrimientos

public class corrimientos {
  final static int C = 8, SEPARADOR = 0;

  public static void main(String[] args) {
    int[] arr = {0,0,2,2,2,2,2,0};

    msg("Arreglo original");
    mostrar(arr);
    msg("Corrimiento hacia derecha : 1 vez");
    corrimientoDer(arr, 0, 1);
    mostrar(arr);
    msg("Corrimiento hacia izquierda : 4 veces");
    corrimientoIzq(arr, 0, 4);
    mostrar(arr);

  }

  public static int buscarIni(int[] arr, int pos){
    while (pos < C && arr[pos] == SEPARADOR)
    pos++;

    return pos;
  }

  public static int buscarFin(int[] arr, int pos){
    while(pos < C && arr[pos] != SEPARADOR)
    pos++;

    return pos - 1;
  }

  public static void mostrar(int[] arr){
    for (int i = 0; i < C; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
  }

  public static void corrimientoIzq(int[] arr, int pos, int times){
    for (int n = 0; n < times; n++) { 
      for (int i = pos; i < C - 1; i++) {
        arr[i] = arr[i + 1];
      }
      // Esto es así porque el corrimiento se hace desde el extremo, si se hiciese desde una posicion x, arr[x] = SEPARADOR
      arr[C - 1] = SEPARADOR;
    }
  }
  public static void corrimientoDer(int[] arr, int pos, int times){
    for (int n = 0; n < times; n++) { 
      for (int i = C - 1; i > pos; i--) {
        arr[i] = arr[i - 1];
      }
      arr[pos] = SEPARADOR;
    }
  }

  public static void msg(String msg){
    System.out.println(msg);
  }
}
