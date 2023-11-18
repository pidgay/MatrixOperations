import java.lang.String;
public class MatrixView {

    public void printMenu(){
        System.out.println("MENU");
        separator();
        System.out.println("1. INPUT MATRICES");
        System.out.println("2. MATRIX OPERATIONS");
        System.out.println("3. DISPLAY MATRICES");
        separator();
        System.out.println("9. EXIT");
        separator();
    }

    public void printMatrixInput(int i){
        if (i == 0) {
            System.out.println("MATRIX A");
        }
        else {
            System.out.println("MATRIX B");
        }
        separator();
    }

    public void printMatrixOperationsMenu(){
        System.out.println("MATRIX OPERATIONS");
        separator();
        System.out.println("1. TRANSPOSE MATRIX");
        System.out.println("2. MULTIPLY MATRICES");
        separator();
        System.out.println("9. RETURN");
        separator();
    }

    public void printTransposeMenu(){
        System.out.println("MATRIX TRANSPOSITION");
        separator();
        System.out.println("1. TRANSPOSE INPUT MATRICES");
        System.out.println("2. TRANSPOSE RESULT MATRIX");
        separator();
        System.out.println("9. RETURN");
        separator();
    }

    public void printMultiplyMenu(){
        System.out.println("MATRIX TRANSPOSITION");
        separator();
        System.out.println("1. MULTIPLY A BY B");
        System.out.println("2. MULTIPLY B BY A");
        separator();
        System.out.println("9. RETURN");
        separator();
    }

    public void printMatrixMenu(){
        System.out.println("DISPLAY MATRIX");
        separator();
        System.out.println("1. DISPLAY INPUT MATRICES");
        System.out.println("2. DISPLAY RESULT MATRIX");
        separator();
        System.out.println("9. RETURN");
        separator();
    }

    public void printMatrixName(String name){
        System.out.println("MATRIX " + name);
    }
    public void printMatrix(Matrix matrix) {
        if (matrix == null) {
            System.err.println("Matrix is empty");
            throw new NullPointerException();
        }
        for (int i = 0; i < matrix.getRows(); i++){
            for (int j = 0; j < matrix.getColumns(); j++){
                System.out.print(matrix.getElement(i,j) + " ");
            }
            System.out.print('\n');
        }
    }

    private void separator(){
        System.out.println("==================================");
    }

    public void printRowsInput(){
        System.out.println("INPUT NUMBER OF ROWS: \n");
    }

    public void printColumnsInput(){
        System.out.println("INPUT NUMBER OF COLUMNS: \n");
    }

    public void printValuesInput(){
        System.out.println("INPUT MATRIX VALUES: \n");
    }

    public void printValueIndexes(int i, int j){
        System.out.println("Element: " + i + ' ' + j + '\n');
    }
}
