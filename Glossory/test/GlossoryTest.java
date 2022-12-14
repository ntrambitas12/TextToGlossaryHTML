import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map3;
import components.queue.Queue;
import components.queue.Queue3;
import components.set.Set;
import components.set.Set3;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class GlossoryTest {

    @Test
    //test nextWordOrSeperator
    public void test() {
        // create separatorSet with all possible separators
        Set<Character> separatorSet = new Set3<>();
        separatorSet.add(' ');
        separatorSet.add(',');
        separatorSet.add('\t');
        separatorSet.add('\n');
        separatorSet.add('!');
        separatorSet.add('.');
        separatorSet.add('?');
        separatorSet.add('/');
        separatorSet.add(':');
        separatorSet.add(';');
        String test = "This is a sample test";
        int pos = 5;

        String returned = Glossory1.nextWordOrSeparator(test, pos,
                separatorSet);

        assertEquals(returned, "is");
    }

    @Test
    //test nextWordOrSeperator
    public void test2() {
        // create separatorSet with all possible separators
        Set<Character> separatorSet = new Set3<>();
        separatorSet.add(' ');
        separatorSet.add(',');
        separatorSet.add('\t');
        separatorSet.add('\n');
        separatorSet.add('!');
        separatorSet.add('.');
        separatorSet.add('?');
        separatorSet.add('/');
        separatorSet.add(':');
        separatorSet.add(';');
        String test = "This is a sample test";
        int pos = 0;

        String returned = Glossory1.nextWordOrSeparator(test, pos,
                separatorSet);

        assertEquals(returned, "This");
    }

    @Test
    //test nextWordOrSeperator
    public void test3() {
        // create separatorSet with all possible separators
        Set<Character> separatorSet = new Set3<>();
        separatorSet.add(' ');
        separatorSet.add(',');
        separatorSet.add('\t');
        separatorSet.add('\n');
        separatorSet.add('!');
        separatorSet.add('.');
        separatorSet.add('?');
        separatorSet.add('/');
        separatorSet.add(':');
        separatorSet.add(';');
        String test = "This is a sample test";
        int pos = 20;

        String returned = Glossory1.nextWordOrSeparator(test, pos,
                separatorSet);

        assertEquals(returned, "t");
    }

    @Test
    //test nextWordOrSeperator
    public void test4() {
        // create separatorSet with all possible separators
        Set<Character> separatorSet = new Set3<>();
        separatorSet.add(' ');
        separatorSet.add(',');
        separatorSet.add('\t');
        separatorSet.add('\n');
        separatorSet.add('!');
        separatorSet.add('.');
        separatorSet.add('?');
        separatorSet.add('/');
        separatorSet.add(':');
        separatorSet.add(';');
        String test = "This              sample";
        int pos = 18;

        String returned = Glossory1.nextWordOrSeparator(test, pos,
                separatorSet);

        assertEquals(returned, "sample");
    }

    @Test
    //test reading file and getting the queue and map sorted correctly
    public void test5() {

        SimpleReader inText = new SimpleReader1L("data/test.txt");
        Queue<String> terms = new Queue3<>();
        Map<String, String> dictionary = new Map3<>();
        Glossory1.getTerm(inText, terms, dictionary);
        String removed = "";

        removed = terms.dequeue();
        assertEquals(removed, "book");

        removed = terms.dequeue();
        assertEquals(removed, "definition");

        removed = terms.dequeue();
        assertEquals(removed, "glossary");

        removed = terms.dequeue();
        assertEquals(removed, "language");

        removed = terms.dequeue();
        assertEquals(removed, "meaning");

        String def = dictionary.value(removed);
        assertEquals(def,
                "something that one wishes to convey, especially by language");

        removed = terms.dequeue();
        def = dictionary.value(removed);
        assertEquals(def, "a word whose definition is in a glossary");

        removed = terms.dequeue();
        def = dictionary.value(removed);
        assertEquals(def, "The coolest electric vehicle on the planet");

        removed = terms.dequeue();
        def = dictionary.value(removed);
        assertEquals(def,
                "a string of characters in a language, which has at least one character");

    }

}
