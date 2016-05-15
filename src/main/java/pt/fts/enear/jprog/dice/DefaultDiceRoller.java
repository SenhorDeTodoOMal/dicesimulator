package pt.fts.enear.jprog.dice;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * Default implementation for DiceRoller, returns accurately random values for
 * any number of dice with same number of faces
 *
 * @author Francisco Tiago Soares
 *
 */
public class DefaultDiceRoller implements DiceRoller {

    private final Random random;

    /**
     * overload constructor where an alternate Random implementation can be
     * provided, such as SecureRandom to provide true randomness
     *
     * @param random
     * @see Random
     * @see SecureRandom
     */
    public DefaultDiceRoller(Random random) {
        super();
        this.random = random;
    }

    /**
     * default constructor where we use the default Random implementation to
     * determine the dice roll results, it should be enough for most cases
     *
     * @see Random
     */
    public DefaultDiceRoller() {
        this(new Random());
    }

    /**
     * generates a stream of dice rolls of the provided dice equal to the number
     * of throws, caller is responsible for closing stream
     *
     * if numberOfThrows is equal or lower than 0 IllegalArgumentException is
     * thrown
     *
     * @param numberOfThrows number of dice throws
     * @param dice dice to be rolled
     * @return IntStream containing the sequence of numbers for each roll
     * @see IllegalArgumentException
     * @see IntStream
     * @throws IllegalArgumentException
     */
    @Override
    public IntStream roll(long numberOfThrows, Die... dice) throws IllegalArgumentException {
        if (numberOfThrows <= 0) {
            throw new IllegalArgumentException("numberOfThrows should be an integer with value higher than 0");
        }
        if (dice == null || dice.length <= 0) {
            throw new IllegalArgumentException("at least one die must be provided");
        }
        // case for one die, stream of integers equal to numberOfThrows
        IntStream is = random.ints(numberOfThrows, 1, dice[0].getNumberOfSides() + 1);

        // for addionational dice we should add the results together
        for (int ix = 1; ix < dice.length; ix++) {
            final Die die = dice[ix];
            /*
             * we are using built in methods of java 8 intstreams to map the
             * original stream of numbers from the first die with the stream
             * of the next die, we do this iteratively, although we convert this
             * to a recursive function
             */
            is = is.flatMap(i -> random.ints(numberOfThrows, 1, die.getNumberOfSides() + 1)
                    .map(j -> i + j));
        }
        return is;
    }

    /**
     * 
     * Logs into console the frequency of dice rolls in the cast of two d6 a 
     * number of times equal to the requested value in the first argument
     * 
     * @param args there should be only one argument with an integer value
     */
    public static void main(String[] args) {
        if (args == null || args.length <= 0) {
            throw new IllegalArgumentException("number of throws should be provided");
        }
        Long numberOfThrows;
        try {
            numberOfThrows = Long.valueOf(args[0]);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("number of throws should be an integer", e);
        }
        DiceRoller diceRoller = new DefaultDiceRoller();
        try (IntStream is = diceRoller.roll(numberOfThrows, new D6(), new D6())) {
            GraphUtils.printIntStreamToPrintStream(is, System.out);
        }
    }
}
