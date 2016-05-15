
package pt.fts.enear.jprog.dice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * JUnit test class for DiceRoller
 *
 * @see DiceRoller
 * @see DefaultDiceRoller
 * @author Francisco Tiago Soares
 */
public class DefaultDiceRollerTest {
    
    private DiceRoller dice;
    
    /**
     * Default contructor
     */
    public DefaultDiceRollerTest() {
        super();
    }
    
    @BeforeClass
    public static void setUpClass() {
        //no class setup needed
    }
    
    @AfterClass
    public static void tearDownClass() {
        //no teardown needed
    }
    
    @Before
    public void setUp() {
        // initialize with DefaultDiceRoller
        dice = new DefaultDiceRoller();
    }
    
    /**
     * 
     */
    @After
    public void tearDown() {
        //no teardown needed
    }

    /**
     * test if the average is seven
     */
    @Test
    public void averageSeven() {
        try(IntStream is=dice.roll(5000L, new D6(),new D6())){
            //GraphUtils.printIntStreamToPrintStream(is, System.out);
            assertEquals(is.average().getAsDouble(), 7d,0.5d);
        }
    }
    
    /**
     * test if the frequency is seven
     */
    @Test
    public void frequencySeven() {
        final Map<Integer,Integer> m = new HashMap<>(11);
        try(IntStream is=dice.roll(5000L, new D6(),new D6())){
            
            is.forEach(i->m.put(i, 1+m.getOrDefault(i, 0)));
        }
        Integer frequency =-1;
        Integer moreFrequent=0;
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            if(frequency<entry.getValue()){
                moreFrequent=entry.getKey();
                frequency=entry.getValue();
            }
        }
        assertEquals(7L, moreFrequent.longValue());
    }
    
    /**
     * test if zero value throws IllegalArgumentException
     */
    @Test
    public void zeroValue() {
        try(IntStream is=dice.roll(0L, new D6(),new D6())){
            GraphUtils.printIntStreamToPrintStream(is, System.out);
            assertFalse(true);
        }catch(IllegalArgumentException e){
            assertFalse(e.getLocalizedMessage(), false);
        }
    }
    
    /**
     * test if illegal argument throws IllegalArgumentException
     */
    @Test
    public void illegalArguments() {
        try{
            DefaultDiceRoller.main(new String[]{"test"});
            assertFalse(true);
        }catch(IllegalArgumentException e){
            assertFalse(e.getLocalizedMessage(), false);
        }
    }
}
