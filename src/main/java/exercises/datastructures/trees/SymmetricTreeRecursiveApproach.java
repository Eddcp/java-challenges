package exercises.datastructures.trees;

import domain.Tree;

import java.util.Objects;

/* Recursive approach */
public class SymmetricTreeRecursiveApproach {

    private boolean process(Tree<Integer> left,
                            Tree<Integer> right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null
                && Objects.equals(left.getValue(), right.getValue())) {
            return (process(left, right) && process(right, left));
        }
        return false;
    }

    public boolean isSymmetric(Tree<Integer> tree) {
        return process(tree, tree);
    }
}
