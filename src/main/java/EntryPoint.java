import java.util.Random;

public class EntryPoint {
    public static void main(String[] args) {
        int[] elementCountToTest = new int[] {10000, 100000, 1000000};
        for (int i = 0; i < elementCountToTest.length; i++) {
            int elementCountToInsert = elementCountToTest[i];
            double bstMedianHeight = getBstMedianHeight(elementCountToInsert);
            System.out.println("element count: " + elementCountToInsert);
            System.out.println(bstMedianHeight);
            System.out.println(2.99 * Math.log(elementCountToInsert));
            System.out.println("------------------");
            System.out.println();
        }
    }

    private static double getBstMedianHeight(int elementCountToInsert) {
        Random rnd = new Random(0);
        double bstMedianHeight = 0;
        for (int i = 0; i < 100; i++) {
            BinaryTree<Integer> bst = new BinaryTree<Integer>();
            for (int j = 0; j < elementCountToInsert; j++) {
                bst.add(rnd.nextInt());
            }
            bstMedianHeight += bst.getHeight();
        }
        bstMedianHeight /= 100;
        return bstMedianHeight;
    }
}
