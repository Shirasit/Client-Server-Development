import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents an Index - component by row and col
 */
public class Index implements Serializable {
    int row, column;

    // Constructor
    public Index(int oRow, int oColumn) {
        this.row = oRow;
        this.column = oColumn;
    }

    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }

    /**
     * The function compares between objects and returns boolean value
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return row == index.row &&
                column == index.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }


}