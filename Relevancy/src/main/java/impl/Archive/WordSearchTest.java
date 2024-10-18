package impl.Archive;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WordSearchTest {


    @Test
    public void testWordwithonechar(){
        WordSearch.createWordMapping("icici bank,facebook,face");
        Set set = new HashSet<>();
        set.add("icici bank");

        assertEquals(set, WordSearch.getAllwords("i"));
    }


    @Test
    public void testWordwithseconwordchar(){
        WordSearch.createWordMapping("icici bank,facebook,face");
        Set set = new HashSet<>();
        set.add("icici bank");

        assertEquals(set, WordSearch.getAllwords("b"));
    }


    @Test
    public void testWordwithseconword(){
        WordSearch.createWordMapping("icici bank,facebook,face");
        Set set = new HashSet<>();
        set.add("icici bank");

        assertEquals(set, WordSearch.getAllwords("bank"));
    }

}
