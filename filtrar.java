// Dado un arreglo "filtro", eliminar del arreglo "registro" todas las coincidencias según el filtro
// y hacer un corrimiento izquierda

public class filtrar {
  final static int C = 20, SEPARADOR = 0;

  public static void main(String[] args) {
    int[] registro = {3,4,5,0,1,6,7,0,3,4,5,0,9,9,3,6,0,3,4,5};

    int[] filtro = {0,0,0,0,3,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0};

    mostrar(registro);

    int ini = 0, fin = -1, largo = 0;

    int ini_filtro = buscarIni(filtro, 0);
    int fin_filtro = buscarFin(filtro, ini_filtro);
    int largo_filtro = getLength(ini_filtro, fin_filtro);

    while (ini < C) {
      ini = buscarIni(registro, fin + 1);

      if (ini < C) {
        fin = buscarFin(registro, ini);

        largo = getLength(ini, fin);

        if (largo == largo_filtro && sonSecuenciasIguales(registro, filtro, ini, ini_filtro, largo)) {
          corrimientoIzq(registro, ini, largo);

          fin -= largo;
        }
      }
      
    }

    mostrar(registro);

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

  public static int getLength(int ini, int fin){
    return fin - ini + 1;
  }

  public static void corrimientoIzq(int[] arr, int pos, int times){
    for (int n = 0; n < times; n++) { 
      for (int i = pos; i < C - 1; i++) {
        arr[i] = arr[i + 1];
      }
      arr[C - 1] = SEPARADOR;
    }
  }

  public static boolean sonSecuenciasIguales(int[] arr1, int[] arr2, int ini1, int ini2, int largo){
    int i = 0;
    while (i < largo && arr1[ini1 + i] == arr2[ini2 + i])
    i++;

    return i == largo;
  }

  public static void console(String txt){
    System.out.println(txt);
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
