public class ordenarPalabras {
  final static int C = 15, F = 4, A = C*F;
  final static int ABC_LENGTH = 27;
  final static char SEPARADOR = ' ';

  public static void main(String[] args) {
  //   char[][] MSJ = {
  //     {' ','P','U','E','R','T','A',' ',' ','A','B','R','E',' ',' '},
  //     {' ','L','A',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
  //     {' ','J','U','A','N',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
  //     {' ',' ',' ','M','A','Ñ','A','N','A',' ',' ',' ','D','E',' '}

  // };
  // char[][] MSJ = {
  //   {'G','A','T','O',' ','F','E','O',' ','J','O','S','E','O',' '},
  //   {' ','Z','I','G','Z','A','G',' ',' ','A','U','R','A',' ',' '},
  //   {' ','C','A','S','A',' ','B','E','S','O',' ','P','A','I','S'},
  //   {'T','O','R','T','A',' ','U','N',' ','M','A','I','Z',' ',' '}
    
  // };
    char[][] MSJ = {
      {' ','J','A','U','L','A',' ',' ',' ',' ',' ',' ',' ',' ',' '},
      {' ',' ',' ',' ',' ',' ',' ',' ',' ','M','A','S','T','E','R'},
      {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
      {' ',' ',' ',' ','A','C','I','D','O',' ',' ',' ',' ',' ',' '}

  };
    

  char[] RESPONSE = new char[A];
  for (int i = 0; i < A; i++) {
    RESPONSE[i] = SEPARADOR;
  }


  mostrarMat(MSJ);

  int ini = 0, fin = -1;
  int last_ini_palabra = -2;


  int[] info_palabra = buscarPrimerSecuenciaEnMat(MSJ);


  for (int i = 0; i < F; i++) {
    while (ini < C) {
      ini = buscarIni(MSJ[i], fin+1);
      if (ini < C) {
        fin = buscarFin(MSJ[i], ini);

        if (estaAntes(MSJ[i][ini], MSJ[info_palabra[0]][info_palabra[1]])) {
          info_palabra[0] = i;
          info_palabra[1] = ini;
          info_palabra[2] = fin - ini;
        }
      }
    }
    
    
    if (!esMatrizVacia(MSJ) && i == F - 1) {
      last_ini_palabra = transcribirSecuencia(RESPONSE, MSJ[info_palabra[0]], last_ini_palabra + 2, info_palabra[1], info_palabra[2]);
      info_palabra = buscarPrimerSecuenciaEnMat(MSJ);
      i = 0;
    }
    
    ini = 0;
    fin = -1;

  }

  mostrarMat(MSJ);
  mostrarArr(RESPONSE);
  }

  public static int buscarIni(char[] arr, int pos){
    while (pos < C && arr[pos] == SEPARADOR ) {
      pos++;
    }

    return pos;
  }

  public static int buscarFin(char[] arr, int pos){
    while (pos < C && arr[pos] != SEPARADOR ) {
      pos++;
    }

    return pos-1;
  }


  public static void mostrarArr(char[] arr){
    for (int i = 0; i < arr.length; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
  }
  public static void mostrarArr(int[] arr){
    for (int i = 0; i < arr.length; i++)
      if (arr[i] == SEPARADOR)
        System.out.print("_ ");
      else
        System.out.print(arr[i] + " ");

    System.out.println(' ');
  }

  public static void mostrarMat(char[][]mat){
    System.out.println(' ');
    for (int i = 0; i < F; i++)
        mostrarArr(mat[i]);
    System.out.println(' ');
  }

  public static boolean estaAntes(char nuevo, char original){
    return nuevo <= original;
  }

  public static void vaciarSecuencia(char[] arr, int ini, int fin){
    for (int i = ini; i <= fin; i++) {
      arr[i] = SEPARADOR;
    }
  }

  public static boolean esArregloVacio(char[] arr){
    int i = 0;
    while (i < C && arr[i] == SEPARADOR) {
      i++;
    }

    return i == C;
  }

  public static boolean esMatrizVacia(char[][] mat){
    boolean vacia = true;
    int i = 0;
    while (i < F && vacia) {
      vacia = esArregloVacio(mat[i]);
      i++;
    }

    return vacia;
  }

  public static int transcribirSecuencia(char[] destino, char[] origen, int ini_destino, int ini_origen, int largo_palabra){
    for (int i = 0; i <= largo_palabra; i++) {
      destino[ini_destino+i] = origen[ini_origen+i];
    }

    vaciarSecuencia(origen, ini_origen, ini_origen + largo_palabra);

    return ini_destino+largo_palabra;
  }

  public static int[] buscarPrimerSecuenciaEnMat(char[][] mat){
    int[] datos = {0,-1,0};

    while (datos[1] < 0 && datos[0] < F) {
      datos[1]  = buscarIni(mat[datos[0]], datos[1] + 1);

      if (datos[1] >= C) {
        datos[1] = -1;
        datos[0]++;
      }
    }

    if (datos[1] > -1) {
      datos[2] = buscarFin(mat[datos[0]], datos[1]) - datos[1];
    }


    return datos;
  }
}
