// Hay 3 arreglos, uno que es el mensaje, otro son las palabras a eliminar y otro son con las que hay que reemplazar.
// Si en el mensaje dice "puta", se cambiará por "madre" haciendo el corrimiento debido para que
// entre la palabra nueva y se mantenga las distancias entre palabras

// Ejemplo: "Hijo de puta te fuiste al choto Ulises            " -> "Hijo de madre te fuiste al pene Ulises            "
// 
public class controlParental {
  final static int C = 50;
  final static char SEPARADOR = ' ';

  public static void main(String[] args) {

    String _msj = "Hijo de puta te fuiste al choto Ulises             ";
    // String _msj = "Forro de mierda te fuiste al choto Ulises          ";
    String _filtros = "  puta    choto forro        mierda               ";
    String _reemplazos = "      madre      pene          malo     caca      ";

    // Esto es para ahorrar tiempo pero básicamente msj = {'H','i','j','o',' ',...}
    char[] msj = toArray(_msj);
    char[] filtros = toArray(_filtros);
    char[] reemplazos = toArray(_reemplazos);
    
    console("");
    mostrar(msj);
    
    int ini = 0, fin = -1, ini_filtro = 0, fin_filtro = -1, ini_reemplazo = 0, fin_reemplazo = -1, indice_filtro = 0;
    int largo, largo_filtro, largo_reemplazo;
    boolean coinciden = false;
    
    // Recorrida de secuencias de msj
    while (ini < C) {
      ini = buscarIni(msj, fin + 1);
      
      if(ini < C){
        fin = buscarFin(msj, ini);
        
        // Recorrida de secuencias de filtros por cada secuencia de msj
        while (ini_filtro < C && !coinciden) {
          
            ini_filtro = buscarIni(filtros, fin_filtro + 1);
            
            if (ini_filtro < C) {
              fin_filtro = buscarFin(filtros, ini_filtro);
              
              largo = getLength(ini, fin);
              largo_filtro = getLength(ini_filtro, fin_filtro);
              
              if (largo == largo_filtro && sonSecuenciasIguales(msj, filtros, ini, ini_filtro, largo)) {
                coinciden = true;
                ini_reemplazo = buscarIni(reemplazos, fin_reemplazo + 1, indice_filtro + 1);
                
                if (ini_reemplazo < C) {
                  fin_reemplazo = buscarFin(reemplazos, ini_reemplazo);
                  
                  largo_reemplazo = getLength(ini_reemplazo, fin_reemplazo);
                  
                  corrimientoIzq(msj, ini, largo_filtro);
                  corrimientoDer(msj, ini, largo_reemplazo);
                  
                  for (int j = 0; j < largo_reemplazo; j++) {
                    msj[ini + j] = reemplazos[ini_reemplazo + j];
                  }
                  
                  fin -= largo_reemplazo;
                }
              }
              
            }

            indice_filtro++;
          }

          ini_filtro = 0; fin_filtro = -1;
          coinciden = false;
          indice_filtro = 0;
          
        }
    }
    
    console("\nDespués del control:\n");
    mostrar(msj);
    
  }

  public static void mostrar(char[] arr){
    for (int i = 0; i < C; i++)
    if (arr[i] == SEPARADOR)
    System.out.print("_ ");
    else
    System.out.print(arr[i] + " ");
    
    System.out.println(' ');
  }

  public static void mostrar(char[] arr, int ini, int fin){
    for (int i = ini; i <= fin; i++) {
      System.out.print(arr[i]);
    }

    System.out.println("");
  }

  public static char[] toArray(String s){
    int largo = s.length();

    char[] res = new char[largo];

    for (int i = 0; i < largo; i++) {
      res[i] = s.charAt(i);
    }

    return res;
  }

  public static void console(String txt){
    System.out.println(txt);
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

  public static int getLength(int ini, int fin){
    return fin - ini + 1;
  }

  public static boolean sonSecuenciasIguales(char[] arr1, char[] arr2, int ini1, int ini2, int largo){
    int i = 0;
    while (i < largo && Character.toLowerCase(arr1[ini1 + i]) == Character.toLowerCase(arr2[ini2 + i]))
    i++;

    return i == largo;
  }

  public static int buscarIni(char[] arr, int pos, int n){

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

  public static void corrimientoIzq(char[] arr, int pos, int times){
    for (int n = 0; n < times; n++) { 
      for (int i = pos; i < C - 1; i++) {
        arr[i] = arr[i + 1];
      }
    }
  }
  
  public static void corrimientoDer(char[] arr, int pos, int times){
    for (int n = 0; n < times; n++) { 
      for (int i = C - 1; i > pos; i--) {
        arr[i] = arr[i - 1];
      }
    }
  }

}
