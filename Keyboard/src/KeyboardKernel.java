import components.standard.Standard;

/**
 * Keyboard kernel component with primary methods.
 *
 * @mathmodel <pre>
 *  KEYBOARD_MODEL is (
 *      matrix of char
 *  )
 * </pre>
 *
 * @initially {@code
 *  ():
 *      ensures
 *          this = [[]]
 * }
 */
public interface KeyboardKernel extends Standard<Keyboard>, Iterable<Keyboard> {

    /**
     * adds an empty row to the bottom of this.keys.
     *
     * @updates this.keys
     *
     * @ensures this.keys.length = #this.keys.length + 1
     */
    void addRow();

    /**
     * adds an empty column to the right of this.keys.
     *
     * @updates this.keys
     *
     * @ensures this.keys[0].length = #this.keys[0].length + 1
     */
    void addCol();

    /**
     * removes and returns the row from this.keys at {@code row} as a character
     * array.
     *
     * @param row
     *            the index of the removed row
     *
     * @requires 0 <= row < this.keys.length and this.keys.length > 1
     *
     * @ensures this.keys.length = #this.keys.length - 1
     *
     * @return a character array from this.keys at {@code row}
     */
    char[] removeRow(int row);

    /**
     * removes and returns the column from this.keys at {@code col} as a
     * character array.
     *
     * @param col
     *            the index of the removed column
     *
     * @requires 0 <= col < this.keys[0].length and this.keys[0].length > 1
     *
     * @ensures this.keys[0].length = #this.keys[0].length - 1
     *
     * @return a character array from this.keys at {@code col}
     */
    char[] removeCol(int col);

    /**
     * reports the number of rows in this.keys.
     *
     * @return the number of rows
     *
     * @ensures numRows = this.keys.length
     */
    int numRows();

    /**
     * reports the number of columns in this.keys.
     *
     * @return the number of columns
     *
     * @ensures numCols = this.keys[0].length
     */
    int numCols();

    /**
     * reports the character in the given location then replaces it with the
     * given key.
     *
     * @param key
     *            the new key which will replace the old key in the location
     * @param row
     *            the index of the row of the key
     * @param col
     *            the index of the column of the key
     *
     * @updates this.keys
     *
     * @requires 0 <= row < this.keys.length and 0 <= col < this.keys[0].length
     *
     * @ensures this.keys[row][col] = key
     *
     * @return the key that was previously in the given location
     */
    char replaceKey(char key, int row, int col);

}
