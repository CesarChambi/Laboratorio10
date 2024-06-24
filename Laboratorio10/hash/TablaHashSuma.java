/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class TablaHashSuma extends HashA<Integer> {
    public TablaHashSuma(int n) {
        super(n);
    }

    public boolean contains(int key) {
        int hashIndex = functionHash(key);
        LinkedList<Register<Integer>> list = table.get(hashIndex).list;

        for (Node<Register<Integer>> node = list.first; node != null; node = node.getNext()) {
            if (node.getData().getKey() == key) {
                return true;
            }
        }
        return false;
    }

    public ArrayList findPairs(int[] array, int sum) {
        ArrayList pairs = new ArrayList<>();
        for (int num : array) {
            int complement = sum - num;
            if (contains(complement)) {
                pairs.add(new int[]{complement, num});
            }
            insert(num, num);
        }
        return pairs;
    }
}
