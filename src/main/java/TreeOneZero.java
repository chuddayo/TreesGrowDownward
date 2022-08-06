/**
 * Created by kristofer on 7/13/20.
 */
public class TreeOneZero {
    Node root;

    private Node addRecursive (Node current, Integer value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }

    public void add (Integer value) {
        this.root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive (Node current, Integer value) {
        if (current == null) return false;
        if (current.getValue().equals(value)) return true;
        if (value < current.getValue()) {
            return containsNodeRecursive(current.getLeft(), value);
        }
        return containsNodeRecursive(current.getRight(), value);
    }

    public boolean containsNode(Integer value) {
        return containsNodeRecursive(root, value);
    }

    public void delete(Integer value) {
        deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, Integer value) {
        if (current == null) return null;

        if (current.getValue().equals(value)) { // delete this current node
            if (current.getLeft() == null && current.getRight() == null) return null;
            if (current.getLeft() == null) { // we can deduce that right is not null from line above
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            // otherwise we have two non-null children
            // so we will just replace the value of the current node
            // and delete the smallest value node in the right tree
            Integer smallestValue = findSmallestValueOfTree(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (value < current.getValue()) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(), value));
        return current;
    }

    private Integer findSmallestValueOfTree (Node baseNode) {
        if (baseNode.getLeft() == null) return baseNode.getValue();
        return findSmallestValueOfTree(baseNode.getLeft());
    }



}
