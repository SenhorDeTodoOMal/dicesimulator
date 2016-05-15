
package pt.fts.enear.jprog.dice;

/**
 * This class is an implementation of Die that
 * represents the traditional 6 sided die which
 * is a perfect cube with numbered faces
 * 
 * @see Die
 * @author Francisco Tiago Soares
 */
public class D6 implements Die{

    /**
     * 
     * @return 6 which is the number of sides on the die
     */
    @Override
    public int getNumberOfSides() {
        return 6;
    }
    
}
