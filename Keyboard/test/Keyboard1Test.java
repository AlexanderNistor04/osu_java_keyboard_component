import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Keyboard1Test {

    @Test
    public final void constructorTest() {
        Keyboard k = new Keyboard1();
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 1);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), empty);
    }

    @Test
    public final void testAddRow() {
        Keyboard k = new Keyboard1();
        k.addRow();
        assertEquals(k.numRows(), 2);
        assertEquals(k.numCols(), 1);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), empty);
        assertEquals(k.keyAt(1, 0), empty);
    }

    @Test
    public final void testAddCol() {
        Keyboard k = new Keyboard1();
        k.addCol();
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 2);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), empty);
        assertEquals(k.keyAt(0, 1), empty);
    }

    @Test
    public final void testReplaceKey() {
        Keyboard k = new Keyboard1();
        k.replaceKey('a', 0, 0);
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 1);
        assertEquals(k.keyAt(0, 0), 'a');
    }

    @Test
    public final void testAddRow2() {
        Keyboard k = new Keyboard1();
        char[] c = { 'a' };
        k.addRow(c);
        assertEquals(k.numRows(), 2);
        assertEquals(k.numCols(), 1);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), empty);
        assertEquals(k.keyAt(1, 0), c[0]);
    }

    @Test
    public final void testAddCol2() {
        Keyboard k = new Keyboard1();
        char[] c = { 'a' };
        k.addCol(c);
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 2);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), empty);
        assertEquals(k.keyAt(0, 1), c[0]);
    }

    @Test
    public final void testToString() {
        Keyboard k = new Keyboard1();
        k.replaceKey('a', 0, 0);
        assertEquals("[a]", k.toString());
    }

    @Test
    public final void testNumRows() {
        Keyboard k = new Keyboard1();
        assertEquals(1, k.numRows());
    }

    @Test
    public final void testNumCols() {
        Keyboard k = new Keyboard1();
        assertEquals(1, k.numCols());
    }

    @Test
    public final void testSize() {
        Keyboard k = new Keyboard1();
        assertEquals(1, k.size());
    }

    @Test
    public final void testEquals() {
        Keyboard k1 = new Keyboard1();
        Keyboard k2 = new Keyboard1();
        assertEquals(k1.toString(), k2.toString());
    }

    @Test
    public final void testKeyAt() {
        Keyboard k = new Keyboard1();
        char empty = 0;
        assertEquals(empty, k.keyAt(0, 0));
    }

    @Test
    public final void testInsertRow() {
        Keyboard k = new Keyboard1();
        char[] c = { 'a' };
        k.insertRow(c, 0);
        assertEquals(k.numRows(), 2);
        assertEquals(k.numCols(), 1);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), c[0]);
        assertEquals(k.keyAt(1, 0), empty);
    }

    @Test
    public final void testInsertCol() {
        Keyboard k = new Keyboard1();
        char[] c = { 'a' };
        k.insertCol(c, 0);
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 2);
        char empty = 0;
        assertEquals(k.keyAt(0, 0), c[0]);
        assertEquals(k.keyAt(0, 1), empty);
    }

    @Test
    public final void testRowAt() {
        Keyboard k = new Keyboard1();
        k.replaceKey('a', 0, 0);
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 1);
        char[] c1 = k.rowAt(0);
        char[] c2 = { 'a' };
        assertEquals(c2[0], c1[0]);
    }

    @Test
    public final void testColAt() {
        Keyboard k = new Keyboard1();
        k.replaceKey('a', 0, 0);
        assertEquals(k.numRows(), 1);
        assertEquals(k.numCols(), 1);
        char[] c1 = k.colAt(0);
        char[] c2 = { 'a' };
        assertEquals(c2[0], c1[0]);
    }

}
