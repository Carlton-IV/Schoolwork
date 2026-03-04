//A collection of methods used to test the data structures
import java.util.*;

public class StructureTests {

    /** Fields **/
    //Scanner for various inputs throughout the code
    static Scanner usr = new Scanner(System.in);

    /** Main Method **/
    //Used to test all the structure testing methods
    public static void main(String[] arg) {
        String[] choices = { "SimpleNode", "SingleNode", "DoubleNode" };
        String choice;
        boolean valid = false;
        while (!valid) {
            System.out.print(
                "What program to you want to test? (Type \"Help\" for a list of available programs): "
            );
            choice = usr.nextLine();
            valid = true;
            switch (choice.toLowerCase()) {
                case "help":
                    valid = false;
                    System.out.println();
                    for (String option : choices) {
                        System.out.println(option);
                    }
                    System.out.println();
                    break;
                case "simplenode":
                    simpleNode();
                    break;
                case "singlenode":
                    singleNode();
                    break;
                case "doublenode":
                    doubleNode();
                    break;
                case "quit":
                    System.exit(0);
                default:
                    valid = false;
                    System.out.println(
                        "\nProgram not in list, please try something else.\n"
                    );
                    break;
            }
        }
    }

    /** Data Structure Testing Methods **/
    //SimpleNode
    public static void simpleNode() {
        System.out.println(
            "Creating a simple node with the element \"first\"\n"
        );
        SimpleNode<String> node = new SimpleNode<String>("first");
        System.out.println("Printing element: " + node.getElement());
        System.out.println("\nChanging element to \"last\"\n");
        node.setElement("last");
        System.out.println("Printing element: " + node.getElement());
        System.out.println();
    }

    //SingleNode
    public static void singleNode() {
        System.out.println(
            "Creating two single nodes with the element \"first\" and \"second\", then making them point to each other.\n"
        );
        SingleNode<String> node = new SingleNode<String>("first");
        SingleNode<String> node2 = new SingleNode<String>("second", node);
        node.setNext(node2);

        System.out.println(
            "\nPrinting node.getNext's element: " + node.getNext().getElement()
        );
        System.out.println(
            "\nPrinting node2.getNext's element: " +
                node2.getNext().getElement()
        );
        System.out.println("\nMaking node point to itself\n");
        node.setNext(node);
        System.out.println(
            "Printing node.getNext's element: " + node.getNext().getElement()
        );
        System.out.println();
    }

    //DoubleNode
    public static void doubleNode() {
        System.out.println(
            "Creating three double nodes with the element \"first\", \"second\" and \"third\", then making them point to each other in a loop.\n"
        );
        DoubleNode<String> node = new DoubleNode<String>("first");
        DoubleNode<String> node2 = new DoubleNode<String>(node, "second", null);
        DoubleNode<String> node3 = new DoubleNode<String>(node2, "third", node);
        node.setPrev(node3);
        node.setNext(node2);
        node2.setNext(node3);

        System.out.println("\nPrinting node's element: " + node.getElement());
        System.out.println(
            "\nPrinting node.getNext's element: " + node.getNext().getElement()
        );
        System.out.println(
            "Printing node.getNext.getNext's element: " +
                node.getNext().getNext().getElement()
        );
        System.out.println(
            "Printing node.getNext.getNext.getNext's element: " +
                node.getNext().getNext().getNext().getElement()
        );
        System.out.println(
            "\nPrinting node.getPrev's element: " + node.getPrev().getElement()
        );
        System.out.println(
            "Printing node.getPrev.getPrev.getPrev's element: " +
                node.getPrev().getPrev().getPrev().getElement()
        );
        System.out.println("\nMaking node point to itself\n");
        node.setNext(node);
        node.setPrev(node);
        System.out.println(
            "Printing node.getNext's element: " + node.getNext().getElement()
        );
        System.out.println(
            "Printing node.getPrev's element: " + node.getNext().getElement()
        );
        System.out.println();
    }
}
