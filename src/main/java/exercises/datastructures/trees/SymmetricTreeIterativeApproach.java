package exercises.datastructures.trees;

import domain.Tree;

import java.util.LinkedList;
import java.util.Queue;

/* Recursive approach */
public class SymmetricTreeIterativeApproach {

    private boolean process(Tree<Integer> left,
                            Tree<Integer> right) {
        Queue<Tree<Integer>> treeLinkedList = new LinkedList<Tree<Integer>>();

        /* Initially, add left and right nodes of root */
        treeLinkedList.add(left);
        treeLinkedList.add(right);

        while (!treeLinkedList.isEmpty()) {
            Tree<Integer> temporaryLeft = treeLinkedList.remove();
            Tree<Integer> temporaryRight = treeLinkedList.remove();

            if (temporaryLeft == null && temporaryRight == null)
                continue;

            if ((temporaryLeft == null && temporaryRight != null) ||
                    (temporaryLeft != null && temporaryRight == null))
                return false;

            if (temporaryLeft.getValue() != temporaryRight.getValue())
                return false;

            treeLinkedList.add(temporaryLeft.getLeft());
            treeLinkedList.add(temporaryRight.getRight());
            treeLinkedList.add(temporaryLeft.getRight());
            treeLinkedList.add(temporaryRight.getLeft());
        }

        return true;
    }

    public boolean isSymmetric(Tree<Integer> tree) {
        return process(tree, tree);
    }
}
