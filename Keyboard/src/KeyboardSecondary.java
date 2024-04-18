/**
 * implementation of secondary methods defined in the Keyboard interface using
 * kernel methods
 */
public abstract class KeyboardSecondary implements Keyboard {

    @Override
    public void addRow(char[] row) {
        assert (row.length == this.numCols());
        this.addRow();
        for (int i = 0; i < this.numCols(); i++) {
            this.replaceKey(row[i], this.numRows() - 1, i);
        }
    }

    @Override
    public void addCol(char[] col) {
        assert (col.length == this.numRows());
        this.addCol();
        for (int i = 0; i < this.numRows(); i++) {
            this.replaceKey(col[i], i, this.numCols() - 1);
        }
    }

    @Override
    public void insertRow(char[] row, int location) {
        this.addRow();
        for (int i = this.numRows() - 1; i > location; i--) {
            for (int j = 0; j < this.numCols(); j++) {
                this.replaceKey(this.keyAt(i - 1, j), i, j);
            }
        }
        for (int k = 0; k < this.numCols(); k++) {
            this.replaceKey(row[k], location, k);
        }
    }

    @Override
    public void insertCol(char[] col, int location) {
        this.addCol();
        for (int i = this.numCols() - 1; i > location; i--) {
            for (int j = 0; j < this.numRows(); j++) {
                this.replaceKey(this.keyAt(j, i - 1), j, i);
            }
        }
        for (int k = 0; k < this.numRows(); k++) {
            this.replaceKey(col[k], k, location);
        }
    }

    @Override
    public char[] rowAt(int row) {
        char[] charRow = new char[this.numCols()];
        for (int i = 0; i < this.numCols(); i++) {
            charRow[i] = this.keyAt(row, i);
        }
        return charRow;
    }

    @Override
    public char[] colAt(int col) {
        char[] charCol = new char[this.numRows()];
        for (int i = 0; i < this.numRows(); i++) {
            charCol[i] = this.keyAt(i, col);
        }
        return charCol;
    }

    @Override
    public char keyAt(int row, int col) {
        char emptykey = 0;
        char key = this.replaceKey(emptykey, row, col);
        this.replaceKey(key, row, col);
        return key;
    }

    @Override
    public int size() {
        return this.numRows() * this.numCols();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.numRows(); i++) {
            str += "[";
            for (int j = 0; j < this.numCols(); j++) {
                str += this.keyAt(i, j) + ", ";
            }
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 2);
            }
            str += "]";
        }
        return str;
    }

    /**
     * reports whether {@code k} has the same number of rows and columns as this
     * and if every key in k is the same character as the key in the same
     * position in this.
     *
     * @param k
     *            the keyboard object to compare to
     * @return whether the two keyboards are equal
     */
    public boolean equals(Keyboard k) {
        boolean isEqual = true;
        if (this.numRows() == k.numCols() && this.numCols() == k.numCols()) {
            for (int i = 0; i < this.numCols(); i++) {
                for (int j = 0; j < this.numRows(); j++) {
                    if (!(this.keyAt(i, j) == k.keyAt(i, j))) {
                        isEqual = false;
                        i = this.numCols();
                        j = this.numRows();
                    }
                }
            }
        } else {
            isEqual = false;
        }

        return isEqual;
    }
}
