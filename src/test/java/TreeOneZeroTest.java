import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeOneZeroTest {
    TreeOneZero bt;

    @Before
    public void createBinaryTree() {
        bt = new TreeOneZero();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
    }

    @Test
    public void conatinsNodeTest() {
        Assert.assertTrue(bt.containsNode(6));
        Assert.assertTrue(bt.containsNode(4));
        Assert.assertTrue(bt.containsNode(7));

        Assert.assertFalse(bt.containsNode(1));
        Assert.assertFalse(bt.containsNode(14));
    }

    @Test
    public void deleteTest() {
        Assert.assertTrue(bt.containsNode(9));
        bt.delete(9);
        Assert.assertFalse(bt.containsNode(9));
    }
}
