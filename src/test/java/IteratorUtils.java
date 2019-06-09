import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

class IteratorUtils {
    static void random_test(BinaryTree bt, Iterator it1, Iterator it2) {
        int loopCount = 0;

        while (it1.hasNext() && it2.hasNext()) {
            assertEquals(it1.next(), it2.next());
            loopCount++;
        }

        assertEquals(loopCount, bt.size());
        assertFalse(it1.hasNext());
        assertFalse(it2.hasNext());
    }

    static void fillBTWithRandomNumbers(BinaryTree bt, int amount) {
        List<Integer> randomInts = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            randomInts.add(i);
        }
        Collections.shuffle(randomInts);
        for (Integer randomInt : randomInts) {
            bt.add(randomInt);
        }
    }
}
