
public class MatrixMain {
    public static void main(String[] args){
        MatrixView view = new MatrixView();
        MatrixController controller = new MatrixController(view);
        controller.start();
    }
}
