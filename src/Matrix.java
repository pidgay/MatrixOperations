public class Matrix {
    private int rows, columns;
    private int [][] matrix;

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public void transposeMatrix(){
        int [][] transposed = new int [columns][rows];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                transposed[j][i] = matrix[i][j];
            }
        }
        matrix = transposed;
        int tmp = rows;
        rows = columns;
        columns = tmp;
    }

    public int [][] multiplyMatrix(Matrix matrix){
        int [][] resultMatrix = new int[this.rows][matrix.getColumns()];
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < matrix.getColumns(); j++){
                for (int k = 0; k < this.columns; k++){
                    resultMatrix[i][j] += this.matrix[i][k] * matrix.getMatrix()[k][j];
                }
            }
        }
        return resultMatrix;
    }
    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getColumns(){
        return columns;
    }

    public void setColumns(int columns){
        this.columns = columns;
    }

    public int getElement(int i, int j){
        return matrix[i][j];
    }

    public void setElement(int i, int j, int value) {
        matrix[i][j] = value;
    }
    public int[][] getMatrix(){
        return matrix;
    }

    public void setMatrix(int [][] matrix){
        this.matrix = matrix;
    }
}
