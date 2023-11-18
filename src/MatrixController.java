import java.util.Scanner;
public class MatrixController{
    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix matrixC;
    private final MatrixView view;
    Scanner scanForInput;

    public MatrixController(MatrixView view){
        this.scanForInput = new Scanner(System.in);
        this.view = view;
        matrixA = null;
        matrixB = null;
        matrixC = null;
    }
    private void startMenu(){
        int input;
       do {
            view.printMenu();
            input = scanForInput.nextInt();
            switch (input) {
                case 1:
                    startInputMatrices();
                    break;
                case 2:
                    startMatrixOperations();
                    break;
                case 3:
                    startDisplayMatrix();
                    break;
                case 9:
                    break;
            }
        } while(input != 9);
    }

    private void startInputMatrices(){
        int rows, columns;
        view.printRowsInput();
        rows = scanForInput.nextInt();
        view.printColumnsInput();
        columns = scanForInput.nextInt();
        for (int i = 0; i < 2; i++){
            view.printMatrixInput(i);

            if( rows < 0 || columns < 0){
                throw new IllegalArgumentException("INCORRECT NUMBER OF COLUMNS OR ROWS");
            }

            if(i == 0){
                matrixA = new Matrix(rows, columns);
                matrixA.setRows(rows);
                matrixA.setColumns(columns);
                inputMatrixValues(matrixA);
            }
            else {
                matrixB = new Matrix(columns,rows);
                matrixB.setRows(columns);
                matrixB.setColumns(rows);
                inputMatrixValues(matrixB);
            }
        }
    }

    private void startMatrixOperations() {
        int input;
        do{
            view.printMatrixOperationsMenu();
            input = scanForInput.nextInt();
            switch (input) {
                case 1:
                    startTranspose();
                    break;
                case 2:
                    startMultiply();
                case 9:
                    break;
            }
        }while(input != 9);
    }

    private void startTranspose(){
        int input;
        do{
            view.printTransposeMenu();
            input = scanForInput.nextInt();
            switch (input){
                case 1:
                    transposeInputMatrices();
                    break;
                case 2:
                    transposeResultMatrix();
                    break;
                case 9:
                    break;
            }
        } while(input != 9);

    }

    private void transposeInputMatrices(){
        if (matrixA == null || matrixB == null) {
            System.err.println("Matrices are empty");
            throw new NullPointerException();
        }
        matrixA.transposeMatrix();
        matrixB.transposeMatrix();
    }

    private void transposeResultMatrix(){
        if (matrixC == null) {
            System.err.println("Matrix is empty");
            throw new NullPointerException();
        }
        matrixC.transposeMatrix();
    }

    private void  startMultiply(){
        int input;
        do{
            view.printMultiplyMenu();
            input = scanForInput.nextInt();
            switch (input){
                case 1:
                    matrixC = new Matrix(matrixA.getColumns(), matrixB.getRows());
                    matrixC.setMatrix(matrixA.multiplyMatrix(matrixB));
                    break;
                case 2:
                    matrixC = new Matrix(matrixB.getColumns(), matrixA.getRows());
                    matrixC.setMatrix(matrixB.multiplyMatrix(matrixA));
                    break;
                case 9:
                    break;
            }
        } while(input != 9);
    }

    private void startDisplayMatrix(){
        int input;
        do{
            view.printMatrixMenu();
            input = scanForInput.nextInt();
            switch (input) {
                case 1:
                    view.printMatrixName("A");
                    view.printMatrix(matrixA);

                    view.printMatrixName("B");
                    view.printMatrix(matrixB);
                    break;
                case 2:
                    view.printMatrix(matrixC);
                    break;
                case 9:
                    break;
            }
        } while(input != 9);
    }

    public void start(){
        startMenu();
    }

    private void inputMatrixValues(Matrix matrix){
        view.printValuesInput();
        for (int i = 0; i < matrix.getRows(); i++){
            for (int j = 0; j < matrix.getColumns(); j++){
                view.printValueIndexes(i,j);
                int input = scanForInput.nextInt();
                matrix.setElement(i,j, input);
            }
        }
    }
}
