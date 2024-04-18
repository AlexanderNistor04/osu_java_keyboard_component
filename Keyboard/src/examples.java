/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class examples {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private examples() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        Keyboard k = new Keyboard1();

        // adds empty rows/columns to the keyboard
        // keyboard starts with 1 empty row and 1 empty column by default
        k.addRow();
        k.addCol();

        // replaces the keys in the keyboard, indexing starts at 0
        k.replaceKey('a', 0, 0);
        k.replaceKey('b', 0, 1);
        k.replaceKey('c', 1, 0);
        k.replaceKey('d', 1, 1);

        // displays a textual representation of the keyboard
        System.out.println(k.toString());

        // clears every key in the keyboard and resets its size back to default
        k.clear();
        for (int i = 0; i < 3; i++) {
            k.addCol();
        }

        // adds a row already full of characters instead of an empty row
        // similar method exists for adding columns
        char[] c = { 'a', 'b', 'c', 'd' };
        for (int i = 0; i < k.numCols(); i++) {
            k.addRow(c);
        }
        k.removeRow(0);
        System.out.println(k.toString());

        // inserts a row to any position instead of at the end
        // similar method exists for inserting columns
        char[] c2 = { 'c', 'h', 'a', 'r' };
        k.insertRow(c2, 0);
        System.out.println(k.toString());

        // removes a row from any position
        // similar method exists for columns
        k.removeRow(0);
        System.out.println(k.toString());

        // returns the keys in a row as a char array
        // similar method exists for columns
        String str = "";
        char[] row = k.rowAt(0);
        for (int i = 0; i < row.length; i++) {
            str += row[i];
        }

        // returns the number of rows, columns, and keys
        System.out.println("number of rows: " + k.numRows());
        System.out.println("number of columns: " + k.numCols());
        System.out.println("number of keys: " + k.size());
    }

}
