// Dado un arreglo [0,0,3,3,3,0,5,0,6,0,9,9,9,9,0] -> [0,0,-3,3,0,5,0,6,0,-4,9,0,0,0,0]


public class comprimir {
  final static int C = 15, MIN = 3, SEPARADOR = 0;

  public static void main(String[] args) {
    // int[] file = {0,0,3,3,3,0,5,0,6,0,9,9,9,9,0};
    int[] file = {0,0,3,3,3,3,3,3,3,3,3,3,3,3,0};
    int ini = 0, fin = -1, largo_secuencia;

    mostrar(file);

    while (ini < C) {
      ini = buscarIni(file, fin + 1);

      if (ini < C) {
        fin = buscarFin(file, ini);

        largo_secuencia = obtenerLargo(ini, fin);

        if (largo_secuencia >= MIN) {
          for (int r = 0; r < largo_secuencia - MIN + 1; r++) {
            // Corrimiento hacia izquierda
            // Notese que empieza desde la izquierda hacia la derecha
            for (int i = ini + 2; i < C - 1; i++) {
              file[i] = file[i + 1];
              file[C-1] = SEPARADOR;
            }
          }

          file[ini] = -largo_secuencia;

          }
        
      }
    }
    mostrar(file);
  }


  public static int buscarIni(int[] arr,int pos){
    while (pos < C && arr[pos] == SEPARADOR) {
      pos++;
    }
    return pos;
  }
  public static int buscarFin(int[] arr,int pos){
    while (pos < C && arr[pos] != SEPARADOR) {
      pos++;
    }
    return pos-1;
  }

  public static int obtenerLargo(int ini, int fin){
  return fin - ini + 1;
  }

  public static void mostrar(int[] arr){
    for (int i = 0; i < C; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
  }

}
