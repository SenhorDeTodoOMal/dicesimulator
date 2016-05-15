
package pt.fts.enear.jprog.dice;

import java.util.stream.IntStream;

/**
 * 
 * DiceRoller interface, implementation should return random values for dice
 * throws
 * 
 * @author Francisco Tiago Soares
 */
public interface DiceRoller {
    
    /**
     * generates a stream of dice rolls of the provided dice equal to the 
     * number of throws, caller is responsible for closing stream
     * 
     * if numberOfThrows is equal or lower than 0 IllegalArgumentException
     * is thrown
     * 
     * @param numberOfThrows number of dice throws
     * @param dice dice to be rolled
     * @return  IntStream containing the sequence of numbers for each roll
     * @see IllegalArgumentException
     * @see IntStream
     * @throws IllegalArgumentException
     */
    public IntStream roll(long numberOfThrows,Die... dice) throws IllegalArgumentException;
    
    
}
