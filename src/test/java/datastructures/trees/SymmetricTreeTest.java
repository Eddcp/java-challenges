package datastructures.trees;

import domain.Tree;
import exercises.datastructures.trees.SymmetricTreeIterativeApproach;
import exercises.datastructures.trees.SymmetricTreeRecursiveApproach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SymmetricTreeTest {

    @InjectMocks
    SymmetricTreeIterativeApproach symmetricTreeIterativeApproach;

    @InjectMocks
    SymmetricTreeRecursiveApproach symmetricTreeRecursiveApproach;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSymmetricTree() {
        Tree<Integer> tree = new Tree<>(1);
        tree.setLeft(new Tree<>(2));
        tree.getLeft().setLeft(new Tree<>(3));
        tree.getLeft().setRight(new Tree<>(4));
        tree.setRight(new Tree<>(2));
        tree.getRight().setLeft(new Tree<>(4));
        tree.getRight().setRight(new Tree<>(3));
        var result = symmetricTreeIterativeApproach.isSymmetric(tree);
        Assertions.assertTrue(result);
    }

    @Test
    void testSymmetricTreeRecursiveApproach() {
        Tree<Integer> tree = new Tree<>(1);
        tree.setLeft(new Tree<>(2));
        tree.getLeft().setLeft(new Tree<>(3));
        tree.getLeft().setRight(new Tree<>(4));
        tree.setRight(new Tree<>(2));
        tree.getRight().setLeft(new Tree<>(4));
        tree.getRight().setRight(new Tree<>(3));
        var result = symmetricTreeRecursiveApproach.isSymmetric(tree);
        Assertions.assertTrue(result);
    }

}
