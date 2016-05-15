package pt.fts.enear.jprog.dice;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 *
 * @author Francisco Tiago Soares
 */
public class GraphUtils {

    private GraphUtils() {
        //private contructor because this is an utility class
    }

    
    
    /**
     * Print intStream into printStream sorted such as a similar result should
     * be produced:
     *  2: XXX
     *  3: XXXXXXXXXXX
     *  4: XXXXXXXXXXXXX
     *  5: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
     *  6: XXXXXXXXXXXXXXXXXXXXXXXXX
     *  7: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
     *  8: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
     *  9: XXXXXXXXXXXXXXXXXXXXXX
     *  10: XXXXXXXXXXXXXXXXX
     *  11: XXXXXXXXXXX
     *  12: X
     * 
     * @param intStream IntStream to print
     * @param printStream PrintStream to print to
     * 
     */
    public static void printIntStreamToPrintStream(IntStream intStream, PrintStream printStream) {
        final Iterator<Integer> iter = intStream.sorted().iterator();
        Integer current = null;
        while (iter.hasNext()) {
            Integer i = iter.next();
            if (!i.equals(current)) {
                current = i;
                printStream.println();
                printStream.print(i);
                printStream.print(": ");
            }
            printStream.print("X");
        }
    }
}
