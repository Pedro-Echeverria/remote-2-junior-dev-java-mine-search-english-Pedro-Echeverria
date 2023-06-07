package template.mine.search.excercice;
import java.util.ArrayList;
public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        Integer boardSize = Integer.parseInt(args[0]);              
        Integer[][] initialBoard = new Integer[boardSize][boardSize];
        initialization(initialBoard, boardSize);
        //Para guardar las minas
        ArrayList<String[]> rowConfiguration = readConfigurationData(args,boardSize);
        //This function can be omitted        
        //initializationForTests(initialBoard, boardSize);
        //TODO: Implement solution
        //No delete
        showInitialBoard(initialBoard, boardSize);
        //muestra el resultado final
        showResultBoard(initialBoard,rowConfiguration,boardSize);
    }
    
    //Incremento y guardo los valores de las minas adyacentes
    private static void contarMinasAdyacentes(int posicion_x,int posicion_y, Integer[][] initialBoard,ArrayList<String[]> rowConfiguration,Integer boardSize)
    {
        Integer inicio_x,fin_x;
        Integer inicio_y,fin_y;
        inicio_x =(posicion_x-1<0)?0:posicion_x-1;
        fin_x =(posicion_x+1>boardSize-1)? boardSize-1:posicion_x+1;
        inicio_y =(posicion_y-1<0)?0:posicion_y-1;
        fin_y =(posicion_y+1>boardSize-1)? boardSize-1:posicion_y+1;
        for (int i = inicio_x; i <= fin_x; i++) {
            for (int j = inicio_y; j <= fin_y; j++) {
                if(i!=posicion_x||j!=posicion_y)
                {
                    if(Boolean.valueOf(rowConfiguration.get(i)[j])) 
                    {
                        initialBoard[posicion_x][posicion_y]++;
                    }
                }
            }
        }
    }
    
    //Guardo todos los argumentos de arraylist de un vector de string
    private static ArrayList<String[]> readConfigurationData(String[] args, Integer boardSize) {
        ArrayList<String[]> rowConfiguration = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            rowConfiguration.add(args[1 + i].split(","));
        }
        return rowConfiguration;
    }   

    //funcion de prueba no usada
    private static void initializationForTests(Integer[][] initialBoard, Integer boardSize) {
        Integer value = 1;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                initialBoard[i][j] = value;
                value++;
            }
        }
    }
        //para inicializar todos los valores de buscaminas en 0
        private static void initialization(Integer[][] initialBoard, Integer boardSize) {
        Integer value = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                initialBoard[i][j] = value;
            }
        }
    }
    //funcion de ejemplo
    private static void showInitialBoard(Integer[][] initialBoard, Integer boardSize) {
        System.out.print("\nThe Minesweeper configuration is: ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print("[");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(initialBoard[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < boardSize - 1) {
                System.out.print(",");
            }
        }
    }
    
        //función que llama al contador de minas adyacentes que guarda los resultados en la matriz inicial, que finalmente los muestra
        private static void showResultBoard(Integer[][] initialBoard, ArrayList<String[]> rowConfiguration , Integer boardSize) {             
        System.out.print("\nThe Minesweeper configuration is: ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print("[");
            for (int j = 0; j < boardSize; j++) {
                contarMinasAdyacentes(i,j,initialBoard,rowConfiguration,boardSize);
                System.out.print(initialBoard[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < boardSize - 1) {
                System.out.print(",");
            }
        }
    }
    
}
