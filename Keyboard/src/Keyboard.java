
/**
 * {@code KeyboardKernel} enhanced with secondary methods.
 */
public interface Keyboard extends KeyboardKernel {

    /**
     * adds the new row to the right of this.keys.
     *
     * @updates this.keys
     *
     * @param row
     *            the row character array to add to this.keys
     * @requires row.length = this.keys[0].length
     *
     * @ensures this.keys.length = #this.keys.length + 1 and
     *          this.keys[this.keys.length] = row
     */
    void addRow(char[] row);

    /**
     * adds the new column to the bottom of this.keys.
     *
     * @updates this.keys
     *
     * @param col
     *            the column character array to add to this.keys
     * @requires col.length = this.keys.length
     *
     * @ensures this.keys[0].length = #this.keys[0].length + 1 and
     *          this.keys[][this.keys[0].length] = col
     */
    void addCol(char[] col);

    /**
     * inserts {@code row} in this.keys at the location, not removing any
     * existing any data already in this.keys.
     *
     * @param row
     *            the character row to insert in this.keys
     * @param location
     *            the index of where the new row will be made
     * @requires 0 <= location <= this.keys.length and row.length =
     *           this.keys[0].length
     * @ensures this.keys.length = #this.keys.length + 1 and this.keys[location]
     *          = row
     */
    void insertRow(char[] row, int location);

    /**
     * inserts {@code col} in this.keys at the location, not removing any
     * existing any data already in this.keys.
     *
     * @param col
     *            the character column to insert in this.keys
     * @param location
     *            the index of where the new column will be made
     * @requires 0 <= location <= this.keys[0].length and col.length =
     *           this.keys.length
     * @ensures this.keys[0].length = #this.keys[0].length + 1 and
     *          this.keys[][location] = col
     */
    void insertCol(char[] col, int location);

    /**
     * returns the row at {@code row} as a char array.
     *
     * @param row
     *            the index of the row
     * @requires 0 <= {@code row} < this.keys.length
     *
     * @ensures rowAt = this.keys[row]
     *
     * @return the row at {@code row} in this.keys
     */
    char[] rowAt(int row);

    /**
     * returns the column at {@code col} as a char array.
     *
     * @param col
     *            the index of the column
     * @requires 0 <= {@code col} < this.keys[0].length
     *
     * @ensures colAt = this.keys[][col]
     *
     * @return the column at {@code col} in this.keys
     */
    char[] colAt(int col);

    /**
     * reports the character at the specified row and column.
     *
     * @param row
     *            the row of the key
     * @param col
     *            the column of the key
     *
     * @requires 0 <= {@code row} < this.keys.length and 0 = {@code col}
     *           this.keys[0].length
     * 
     * @ensures keyAt = this.keys[row][col]
     *
     * @return the key at the location
     */
    char keyAt(int row, int col);

    /**
     * reports the number of characters in this.keys.
     *
     * @ensures size = this.keys.length * this.keys[0].length
     *
     * @return the number of keys
     */
    int size();

}
