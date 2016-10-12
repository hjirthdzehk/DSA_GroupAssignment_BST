import org.junit.Assert;

public class BinaryTreeTest {

    BinaryTree<Integer> sut;
    @org.junit.Before
    public void Before(){
        sut = new BinaryTree<Integer>();
    }

    @org.junit.Test
    public void add() throws Exception {
        sut.add(3);
        sut.add(2);
        sut.add(5);
        sut.add(6);
        sut.add(8);

        Assert.assertTrue(sut.contains(3));
        Assert.assertTrue(sut.contains(2));
        Assert.assertTrue(sut.contains(5));
        Assert.assertTrue(sut.contains(6));
        Assert.assertTrue(sut.contains(8));

        Assert.assertFalse(sut.contains(7));

        sut.remove(2);

        Assert.assertTrue(sut.contains(3));
        Assert.assertTrue(sut.contains(5));
        Assert.assertTrue(sut.contains(6));
        Assert.assertTrue(sut.contains(8));
        Assert.assertFalse(sut.contains(2));
    }

    @org.junit.Test
    public void getHeight() throws Exception {
        Assert.assertEquals(0, sut.getHeight());
        sut.add(1);
        Assert.assertEquals(1, sut.getHeight());
        sut.add(2);
        Assert.assertEquals(2, sut.getHeight());
        sut.add(3);
        Assert.assertEquals(3, sut.getHeight());
        sut.add(-1);
        Assert.assertEquals(3, sut.getHeight());
    }
}