// Dado un arreglo [0,0,-3,3,0,5,0,6,0,-4,9,0,0,0,0] -> [0,0,3,3,3,0,5,0,6,0,9,9,9,9,0]

public class descomprimir {
  final static int C = 15, MIN = 3, SEPARADOR = 0;
  public static void main(String[] args) {
    // int[] compressed_file = {0, 0, -3, 3, 0, 5, 0, 6, 0, -4, 9, 0, 0, 0, 0};
    int[] compressed_file = {0, 0, -13, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int ini = 0, fin = -1, iterations;

    mostrar(compressed_file);

    while (ini < C) {
      ini = buscarIni(compressed_file, fin+1);

      if (ini < C) {
        fin = buscarFin(compressed_file, ini);

        if (compressed_file[ini] < SEPARADOR) {
          iterations = -compressed_file[ini];
          compressed_file[ini] = compressed_file[ini + 1];

          for (int i = 0; i < iterations - 2; i++) {
            // Corrimiento hacia derecha
            // Notese que empieza desde la derecha hacia la izquierda
            for (int j = C - 1; j > ini; j--) {
              compressed_file[j] = compressed_file[j - 1];
            }
          }
        }
      }
    }

    mostrar(compressed_file);
  }

  public static int buscarIni(int[] arr, int pos){
    while (pos < C && arr[pos] == SEPARADOR) {
      pos++;
    }

    return pos;
  }

  public static int buscarFin(int[] arr, int pos){
    while (pos < C && arr[pos] != SEPARADOR) {
      pos++;
    }

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
}
