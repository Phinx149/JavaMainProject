public class Mat {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows, int ncols) {
        this.nrows = nrows;
        this.ncols = ncols;
        this.matrix = new int[this.nrows][this.ncols];
    }

    public Matrix(int[][] arr) {
        matrix = arr;
    }

    public Matrix transpose() {
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println("\n");
        }
        return this;
    }
    public static void main(String [] args){
        System.out.print("Name");
        Matrix matrix = new Matrix(3, 3);
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix matrix2 = new Matrix(x);
        matrix2.transpose();
    }
}
