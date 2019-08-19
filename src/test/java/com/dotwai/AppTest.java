package com.dotwai;

import static org.junit.Assert.assertTrue;

import com.dotwai.entity.AVLNode;
import com.dotwai.entity.BinaryNode;
import com.dotwai.utils.Print;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
//        List<Integer[][]> integers = NQueen.nQueen(4);
        List<Integer[][]> integers = NQueenSolution.nQueen(10);
        for (int k=0;k<integers.size();k++){
            System.out.println("第"+k+"种解法：");
            for(int i=0;i<integers.get(k).length;i++){
                for(int j=0;j<integers.get(k)[i].length;j++){
                    System.out.print(integers.get(k)[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    @Test
    public void fibonacciTest(){
        int[] generate = FibonacciSearch.generate(25);
        for (int i = 0; i < generate.length; i++) {
            System.out.println(generate[i]);
        }
    }

    @Test
    public void fibonacciSearchTest(){
        FibonacciSearch.initTable(10000, 10);
        int key = FibonacciSearch.getKey(5000);
        System.out.println("key:"+key);
        int index = FibonacciSearch.searchKey(key);
        System.out.println(index);
    }

    @Test
    public void binarySearchTest(){
        BinarySearch.initTable(10000, 10);
        int key = BinarySearch.getKey(4545);
        System.out.println("key:"+key);
        int index = BinarySearch.searchKey(key);
        int indexRecursive = BinarySearch.searchKeyRecursive(key, 0, 9999);
        System.out.println(index);
        System.out.println(indexRecursive);
    }

    @Test
    public void interploationSearchTest(){
        InterploationSearch.initTable(10000, 10);
        int key = InterploationSearch.getKey(2360);
        System.out.println("key:"+key);
        int index = InterploationSearch.searchKey(key);
        System.out.println(index);
    }

    @Test
    public void binarySortTreeTest(){
        BinarySortTree.init(20, 100);
        BinarySortTree.traverse();
        BinaryNode search = BinarySortTree.search(55);
        System.out.println(search);
        Print.printBinaryTree(BinarySortTree.getRoot());
        Print.printBinaryTree(BinarySortTree.getRoot(), 10);
//        if (search != null){
//            BinarySortTree.delete(search.getValue());
//            BinarySortTree.traverse();
//        }
//        BinarySortTree.destroy();
//        BinarySortTree.traverse();
    }

    @Test
    public void test(){
        System.out.println(Math.pow(2, 3));
    }

    @Test
    public void AVLTreeTest(){
        Random random = new Random();
        for (int i=0;i<4;i++){
            AVLNode avlNode = new AVLNode();
            avlNode.setBf(0);
            avlNode.setValue(random.nextInt(100));
            AVLTree.insert(avlNode);
        }
        Print.printAVLTree(AVLTree.getRoot(), AVLTree.getDepth());
    }
}
