package kryvenko.sergii.automation.tasks331;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestTask331 {

    /**
     * Positive testing for finding solution with a natural number 6.
     */
    @Test
    void testFindVariables() {
        final int naturalNumber = 6;
        final int[][] array = {{1, 1, 2 }, {1, 2, 1 }, {2, 1, 1 }};
        Solution s = new Solution(naturalNumber);
        List<Variables> actual = s.findVariables();
        List<Variables> expected = new ArrayList<Variables>();
        for (int[] a : array) {
            expected.add(new Variables(a[0], a[1], a[2]));
        }

        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).getX(), actual.get(i).getX());
            Assert.assertEquals(expected.get(i).getY(), actual.get(i).getY());
            Assert.assertEquals(expected.get(i).getZ(), actual.get(i).getZ());
        }
    }

}
