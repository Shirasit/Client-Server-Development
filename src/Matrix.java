import java.io.Serializable;
import java.util.*;

/**
 * This class represents a Matrix Entity and functions that use primitiveMatrix
 */
public class Matrix implements Serializable {

    int[][] primitiveMatrix;

    //constructor
    public Matrix(int[][] oArray) {
        List<int[]> list = new ArrayList<>();
        for (int[] row : oArray) {
            int[] clone = row.clone();
            list.add(clone);
        }
        primitiveMatrix = list.toArray(new int[0][]);
    }

    /**
     * printMatrix: The function prints a matrix
     * there is no input value
     * there is no return value
     */

    public void printMatrix() {
        for (int[] row : primitiveMatrix) {
            String s = Arrays.toString(row);
            System.out.println(s);
        }
    }

    /**
     * printMatrixwithLength: The function prints a square matrix by the input length
     * @param mat type:int[][]
     * @param length type:int
     * there is no return value
     */
    public static void printMatrixwithLength(int[][] mat, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : primitiveMatrix) {
            stringBuilder.append(Arrays.toString(row));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * getNeighbors: The function finds the neighbors of a specific index:
     * Above it below it, on its sides and the cross
     *
     * @param index type:Index
     * @return List<Index>
     * this function uses try and catch
     */
    public List<Index> getNeighbors(final Index index) {
        List<Index> list = new ArrayList<>();
        int extracted = -1;
        try {
            extracted = primitiveMatrix[index.row + 1][index.column];
            list.add(new Index(index.row + 1, index.column));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row][index.column + 1];
            list.add(new Index(index.row, index.column + 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row - 1][index.column];
            list.add(new Index(index.row - 1, index.column));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row][index.column - 1];
            list.add(new Index(index.row, index.column - 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row + 1][index.column + 1];
            list.add(new Index(index.row + 1, index.column + 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row - 1][index.column - 1];
            list.add(new Index(index.row - 1, index.column - 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row - 1][index.column + 1];
            list.add(new Index(index.row - 1, index.column + 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row + 1][index.column - 1];
            list.add(new Index(index.row + 1, index.column - 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return list;
    }

    /**
     * getNeighborsWithoutCross: The function finds the neighbors of a specific index:
     * Above it, below it, on its sides WITHOUT the cross
     *
     * @param index type: Index
     * @return List<Index>
     * this function uses try and catch
     */
    public List<Index> getNeighborsWithoutCross(final Index index) {
        List<Index> list = new ArrayList<>();
        int extracted = -1;
        try {
            extracted = primitiveMatrix[index.row + 1][index.column];
            list.add(new Index(index.row + 1, index.column));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row][index.column + 1];
            list.add(new Index(index.row, index.column + 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row - 1][index.column];
            list.add(new Index(index.row - 1, index.column));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            extracted = primitiveMatrix[index.row][index.column - 1];
            list.add(new Index(index.row, index.column - 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        return list;
    }

    /**
     * getValue: The function returns the value of specific index -use primitiveMatrix
     *
     * @param index type: Index
     * @return int
     */
    public int getValue(Index index) {
        return primitiveMatrix[index.row][index.column];
    }

    /**
     * getSize: The function returns size of square primitiveMatrix
     * there is no input value
     *
     * @return int
     */

    public int getSize() {
        return primitiveMatrix.length * primitiveMatrix.length;
    }

    /**
     * getOne: The function returns list of index that their value is 1 - use primitiveMatrix
     * there is no input value
     *
     * @return List<Index>
     */
    public List<Index> getOne() {
        List<Index> findOnes = new ArrayList<>();
        Index index;
        for (int i = 0; i < this.primitiveMatrix.length; i++) {
            for (int j = 0; j < this.primitiveMatrix[i].length; j++) {
                if (primitiveMatrix[i][j] == 1) {
                    index = new Index(i, j);
                    findOnes.add(index);
                }

            }

        }
        return findOnes;
    }

}