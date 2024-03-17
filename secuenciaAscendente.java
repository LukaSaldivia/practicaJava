public class secuenciaAscendente { //sin estructuras auxiliares
  // Si es ascendente
  // hacer un corrimiento hacia la izquierda
  final static int C = 15, SEPARADOR = 0;

  public static void main(String[] args) {
    // int[] arr = {SEPARADOR,1,2,3,4,SEPARADOR,SEPARADOR,5,6,3,SEPARADOR,1,2,3,4};
    int[] arr = {1,1,2,5, SEPARADOR,4,5,5,6,SEPARADOR,1,10,SEPARADOR,3,1};
    mostrar(arr);
    

    int ini = 0, fin = -1, largo = 0;

    while (ini < C) {
      ini = buscarIni(arr, fin + 1);

      if (ini < C) {
        fin = buscarFin(arr, ini);

        if (isSecAsc(arr, ini, fin)) {
          largo = getLength(ini, fin);
          corrimientoIzq(arr, ini, largo);
          fin -= largo;          
        }


      }
    }

    mostrar(arr);
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

  public static void fillSecuencia(int [] arr, int ini, int fin, int value){
    for (int i = ini; i <= fin; i++) {
      arr[i] = value;
    }
  }

  public static boolean isSortedAsc(int n1, int n2){
    return n1 <= n2;
  }

  public static boolean isSecAsc(int[] arr, int ini, int fin){
    int vecesNcesarias = getLength(ini, fin) - 1, i = 0;
    
    while (i < vecesNcesarias && isSortedAsc(arr[ini + i], arr[ini + i +1])) {
      i++;
    }
    return i == vecesNcesarias;
    


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

  public static void mostrar(int[] arr){
    for (int i = 0; i < C; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
  }
}
