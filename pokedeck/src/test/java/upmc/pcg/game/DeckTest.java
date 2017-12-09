package upmc.pcg.game;

import junit.framework.TestCase;
import org.junit.Test;
public class DeckTest extends TestCase {
    
    public DeckTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testHello() {}
    
    @Test
    public void deckTest(){
        Deck deck = new Deck("testunnom");
        assertNotNull(deck);
        assertTrue("testunnom"==deck.view_name_deck());
    }
}
