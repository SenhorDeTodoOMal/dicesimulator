/*
 * LICENSE
 */
package pt.fts.enear.jprog.dice;

/**
 * This class is an implementation of Die that
 * represents the traditional 6 sided die which
 * is a perfect cube with numbered faces
 * 
 * @see Die
 * @author Francisco Tiago Soares
 */
public class D6 implements Die<Integer>{
    
    @Override
    public Integer[] getFaces() {
        return new Integer[]{1,2,3,4,5,6};
    }
    
}
