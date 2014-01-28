import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dhruv Saksena
 * Date: 12/01/14
 * Time: 5:50 PM
 */
public class ArrayListBagTest {

    ArrayListBag<Ballot> votes;

    @Before
    public void testSetup(){
        votes=new ArrayListBag<Ballot>();
    }

    @Test (timeout = 200)
    @Worth (points = 7, feedback="-7 getCurrentSize() or add() failed.")
    public void testGetCurrentSizeAndAdd() throws Exception {
        assertEquals(votes.getCurrentSize(),0);
        votes.add(new Ballot("Panda",500));
        assertEquals(votes.getCurrentSize(),1);
        votes.add(new Ballot("Chinese Panda",300));
        assertEquals(votes.getCurrentSize(),2);
    }

    @Test (timeout = 200)
    @Worth (points = 7, feedback="-7 isEmpty() failed.")
    public void testIsEmpty() {
        assertTrue(votes.isEmpty());
        votes.add(new Ballot("Panda", 500));
        assertFalse(votes.isEmpty());
    }

    @Test (timeout = 200)
    @Worth (points = 7, feedback="-7 remove() failed.")
    public void testRemove() throws Exception {
        assertTrue(votes.isEmpty());
        votes.add(new Ballot("Kung Fu Panda",1000));
        votes.add(new Ballot("The Karate Panda",750));
        assertEquals(2,votes.getCurrentSize());
        votes.remove(new Ballot("The Karate Panda",500));
        assertEquals(1,votes.getCurrentSize());
        votes.remove(new Ballot("Kung Fu Panda",999));
        assertEquals(0,votes.getCurrentSize());
        votes.remove(new Ballot("Im No Panda",300));
        assertEquals(0,votes.getCurrentSize());
    }



    @Test (timeout = 200)
    @Worth (points = 7, feedback="-7 clear() failed.")
    public void testClear() throws Exception {
        assertTrue(votes.isEmpty());
        votes.add(new Ballot("Kung Fu Panda",1000));
        votes.add(new Ballot("The Karate Pande",750));
        votes.clear();
        assertTrue(votes.isEmpty());
        votes.clear();
        assertTrue(votes.isEmpty());
    }

    @Test (timeout = 200)
    @Worth (points = 8, feedback="-8 getFrequencyOf() failed.")
    public void testGetFrequencyOf() throws Exception {

        votes.add(new Ballot("Kung Fu Panda",1000));
        votes.add(new Ballot("Kung Fu Panda",2000));
        votes.add(new Ballot("Red Panda",50));
        votes.add(new Ballot("Kung Fu Panda",4000));
        votes.add(new Ballot("Kung Fu Panda",8000));
        votes.add(new Ballot("Red Panda",60));
        votes.add(new Ballot("Kung Fu Panda",16000));

        votes.add(new Ballot("Giant Panda",100));
        votes.add(new Ballot("Giant Panda",200));
        votes.add(new Ballot("Red Panda",75));
        votes.add(new Ballot("Giant Panda",300));
        votes.add(new Ballot("Giant Panda",400));
        votes.add(new Ballot("Red Panda",52));
        votes.add(new Ballot("Giant Panda",500));
        votes.add(new Ballot("Giant Panda",600));
        votes.add(new Ballot("Red Panda",65));
        votes.add(new Ballot("Giant Panda",700));
        votes.add(new Ballot("Giant Panda",800));

        assertEquals(5,votes.getFrequencyOf(new Ballot("Kung Fu Panda",0)));
        assertEquals(5,votes.getFrequencyOf(new Ballot("Red Panda",7)));
        assertEquals(8,votes.getFrequencyOf(new Ballot("Giant Panda",12)));

    }

    @Test (timeout = 200)
    @Worth (points = 7, feedback="-7 contains() failed.")
    public void testContains() throws Exception {

        votes.add(new Ballot("Kung Fu Panda",1000));
        votes.add(new Ballot("Kung Fu Panda",2000));
        votes.add(new Ballot("Red Panda",50));
        votes.add(new Ballot("Kung Fu Panda",4000));
        votes.add(new Ballot("Kung Fu Panda",8000));
        votes.add(new Ballot("Red Panda",60));
        votes.add(new Ballot("Pandasaurus",16000));

        votes.add(new Ballot("Giant Panda",100));
        votes.add(new Ballot("Giant Panda",200));
        votes.add(new Ballot("Red Panda",75));
        votes.add(new Ballot("Giant Panda",300));
        votes.add(new Ballot("Giant Panda",400));
        votes.add(new Ballot("Red Panda",52));
        votes.add(new Ballot("Giant Panda",500));
        votes.add(new Ballot("Giant Panda",600));
        votes.add(new Ballot("Red Panda",65));
        votes.add(new Ballot("Giant Panda",700));
        votes.add(new Ballot("Giant Panda",800));

        assertTrue(votes.contains(new Ballot("Pandasaurus",90)));
        assertFalse(votes.contains(new Ballot("Pandasaurus-rex",91)));

    }

    @Test (timeout = 200)
    @Worth (points = 7, feedback="-7 testToArray() failed.")
    public void testToArray() throws Exception {

        votes.add(new Ballot("Kung Fu Panda",1000));
        votes.add(new Ballot("Kung Fu Panda",2000));
        votes.add(new Ballot("Red Panda",50));
        votes.add(new Ballot("Kung Fu Panda",4000));
        votes.add(new Ballot("Kung Fu Panda",8000));
        votes.add(new Ballot("Red Panda",60));
        votes.add(new Ballot("Kung Fu Panda",16000));

        votes.add(new Ballot("Giant Panda",100));
        votes.add(new Ballot("Giant Panda",200));
        votes.add(new Ballot("Red Panda",75));
        votes.add(new Ballot("Giant Panda",300));
        votes.add(new Ballot("Giant Panda",400));
        votes.add(new Ballot("Red Panda",52));
        votes.add(new Ballot("Giant Panda",500));
        votes.add(new Ballot("Giant Panda",600));
        votes.add(new Ballot("Red Panda",65));
        votes.add(new Ballot("Giant Panda",700));
        votes.add(new Ballot("Giant Panda",800));

        Object [] expectations = new Object[]{new Ballot("Kung Fu Panda",0),
                new Ballot("Kung Fu Panda",0),
                new Ballot("Red Panda",0),
                new Ballot("Kung Fu Panda",0),
                new Ballot("Kung Fu Panda",0),
                new Ballot("Red Panda",0),
                new Ballot("Kung Fu Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Red Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Red Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Red Panda",0),
                new Ballot("Giant Panda",0),
                new Ballot("Giant Panda",0),};

        Object [] ballotVotes= votes.toArray();
        assertArrayEquals(ballotVotes,expectations);


    }
}
