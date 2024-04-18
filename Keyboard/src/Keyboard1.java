import java.util.Iterator;

/**
 * {@code Keyboard} represented as a character matrix with enhanced methods
 *
 * @convention $this.numrows > 0 && $this.numcols > 0
 * @correspondence $this.keys = this
 */
public class Keyboard1 extends KeyboardSecondary {

    /**
     * Representation of {@code this}.
     */
    private char[][] keys;

    /**
     * default empty constructor.
     */
    public Keyboard1() {
        this.createNewRep();
    }

    /**
     * creates new representation of this
     */
    private void createNewRep() {
        this.keys = new char[1][1];
    }

    @Override
    public void addRow() {
        char copy[][] = new char[this.keys.length + 1][this.keys[0].length];
        for (int i = 0; i < this.keys.length; i++) {
            copy[i] = this.keys[i].clone();
        }
        this.keys = copy;
    }

    @Override
    public void addCol() {
        char copy[][] = new char[this.keys.length][this.keys[0].length + 1];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < this.keys[0].length; j++) {
                copy[i][j] = this.keys[i][j];
            }
        }
        this.keys = copy;
    }

    @Override
    public char[] removeRow(int row) {
        assert (this.keys.length > 1);

        char rowArr[] = this.keys[row].clone();
        char copy[][] = new char[this.keys.length - 1][this.keys[0].length];
        for (int i = 0; i < row; i++) {
            copy[i] = this.keys[i].clone();
        }

        for (int j = row; j < copy.length; j++) {
            copy[j] = this.keys[j + 1].clone();
        }

        this.keys = copy;

        return rowArr;
    }

    @Override
    public char[] removeCol(int col) {
        assert (this.keys[0].length > 1);

        char copy[][] = new char[this.keys.length][this.keys[0].length - 1];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = this.keys[i][j];
            }
        }

        char colArr[] = new char[this.keys.length];
        for (int k = 0; k < this.keys.length; k++) {
            colArr[k] = this.keys[k][this.keys[0].length - 1];
        }

        this.keys = copy;

        return colArr;
    }

    @Override
    public int numRows() {
        return this.keys.length;
    }

    @Override
    public int numCols() {
        return this.keys[0].length;
    }

    @Override
    public char keyAt(int row, int col) {
        assert (row >= 0 && this.keys.length > row);
        assert (col >= 0 && this.keys[0].length > col);

        return this.keys[row][col];
    }

    @Override
    public char replaceKey(char key, int row, int col) {
        assert (row >= 0 && this.keys.length > row);
        assert (col >= 0 && this.keys[0].length > col);

        char c = this.keys[row][col];
        this.keys[row][col] = key;
        return c;
    }

    @Override
    public void clear() {
        this.createNewRep();

    }

    @Override
    public Keyboard newInstance() {
        // TODO Auto-generated method stub
        try {
            return this.getClass().getConstructor().newInstance(this.keys);
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void transferFrom(Keyboard source) {
        Keyboard1 newSource = (Keyboard1) source;
        this.keys = newSource.keys;
        newSource.createNewRep();

    }

    @Override
    public Iterator<Keyboard> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
