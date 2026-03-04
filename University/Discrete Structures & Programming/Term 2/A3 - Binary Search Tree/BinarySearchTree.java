import java.util.*;

public class BinarySearchTree<E> extends LinkedBinaryTree<E> {

    protected Comparator<E> comp;

    public BinarySearchTree() {
        comp = new DefaultComparator<E>();
    }

    protected Position<E> treeSearch(E elm, Position<E> pos) {
        if (isExternal(pos)) return pos;
        else {
            E tempElm = pos.element();
            int comparison = comp.compare(elm, tempElm);
            if (comparison < 0 && hasLeft(pos)) return treeSearch(
                elm,
                left(pos)
            );
            else if (comparison >= 0 && hasRight(pos)) return treeSearch(
                elm,
                right(pos)
            );
            return pos;
        }
    }

    public Position<E> insert(E elm) {
        if (isEmpty()) return addRoot(elm);
        Position<E> insertPos = treeSearch(elm, root);
        int comparison = comp.compare(elm, insertPos.element());
        if (comparison < 0) return insertLeft(insertPos, elm);
        return insertRight(insertPos, elm);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> intSearch = new BinarySearchTree<>();
        ArrayList<Position<Integer>> sorted = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) System.out.print(
                intSearch.insert((int) (Math.random() * 1000)).element() + ", "
            );
        }
        System.out.println("\n");
        intSearch.inorderPositions(intSearch.root(), sorted);
        int count = 0;
        for (Position<Integer> pos : sorted) {
            System.out.print(pos.element() + ", ");
            count++;
            if (count == 15) {
                count = 0;
                System.out.println();
            }
        }

        System.out.println("\n\n");

        BinarySearchTree<String> strSort = new BinarySearchTree<>();
        ArrayList<Position<String>> sortedStr = new ArrayList<>();
        System.out.print(strSort.insert("Hayden").element() + ", ");
        System.out.print(strSort.insert("Carlton").element() + ", ");
        System.out.print(strSort.insert("Marc").element() + ", ");
        System.out.print(strSort.insert("Richard").element() + ", ");
        System.out.print(strSort.insert("Chenkuan").element() + ", ");
        System.out.print(strSort.insert("Matthew").element() + ", ");
        System.out.print(strSort.insert("Gabe").element() + ", ");
        System.out.print(strSort.insert("Sarah").element() + ", ");
        System.out.print(strSort.insert("Rooney").element() + ", ");
        System.out.print(strSort.insert("Adam").element() + ", ");
        System.out.print(strSort.insert("Chesca").element() + ", ");
        System.out.print(strSort.insert("Ryker").element() + ", ");
        System.out.print(strSort.insert("River").element() + ", ");
        System.out.print(strSort.insert("Carissa").element() + ", ");
        System.out.print(strSort.insert("Shane").element() + ", ");
        System.out.print(strSort.insert("Madison").element() + ", ");
        System.out.print(strSort.insert("JP").element() + ", ");
        System.out.println("\n");
        strSort.inorderPositions(strSort.root(), sortedStr);
        for (Position<String> pos : sortedStr) {
            System.out.print(pos.element() + ", ");
        }
    }
}
