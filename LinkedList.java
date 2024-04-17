
public class LinkedList {

    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void insertMiddle(Node newNode, Node previous) {
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
    }

    /**
     * @param value The value to be searched.
     * @return The node that has the data value. If no node exists, returns null.
     */
//    public Node search(int value) {
//        Node tmp = head;
//        while (tmp != null) {
//            if (value == tmp.getData()) {
//                return tmp;
//            }
//            tmp = tmp.getNext();
//        }
//        return null;
//    }
    public Node getNodeI(int i) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (index == i) {
                return tmp;
            }
            index++;
            tmp = tmp.getNext();
        }
        return null;
    }

    public int numberOfElements() {
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    public void deleteFirst() {
        head = head.getNext();
        if (isEmpty()) {
            tail = null;
        }
    }

    public Node getPrevious(Node node) {
        Node tmp = head;
        Node previous = null;
        while (tmp != node) {
            previous = tmp;
            tmp = tmp.getNext();
        }
        return previous;
    }

//    public void deleteValue(int value){
//        Node tmp = head;
//        Node previous = null;
//        while (tmp != null) {
//            if (tmp.getData() == value){
//                if (previous != null){
//                    previous.setNext(tmp.next);
//                    if (tmp.next == null){
//                        tail = previous;
//                    }
//                } else {
//                    head = tmp.next;
//                    if (head == null){
//                        tail = null;
//                    }
//                }
//                break;
//            }
//            previous = tmp;
//            tmp = tmp.getNext();
//        }
//    }

    public void deleteLast() {
        tail = getPrevious(tail);
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    public void deleteMiddle(Node node) {
        Node previous;
        previous = getPrevious(node);
        previous.setNext(node.getNext());
    }


    //method for add polynomials together
    public LinkedList addPolynomial(LinkedList polynomial2) {

        // Create a new LinkedList to put the result on it
        LinkedList result = new LinkedList();
        Node current1 = this.head;

        // Two loops to check each terms of each polynomial to find the match terms
        while (current1 != null) {
            Node current2 = polynomial2.head;
            boolean matchFound = false;

            while (current2 != null) {
                // if they match add the coefficients and then add them to result
                if (current1.exponentX == current2.exponentX &&
                        current1.exponentY == current2.exponentY &&
                        current1.exponentZ == current2.exponentZ) {

                    Node newNode = current1.addWith(current2);
                    result.insertLast(newNode);
                    matchFound = true;
                    break;
                }
                current2 = current2.next;
            }
                // if they don't match put them directly to result
                if (!matchFound) {
                    result.insertLast(new Node(current1.coefficient, current1.exponentX, current1.exponentY, current1.exponentZ));
                }
                // check the next node
            current1 = current1.next;
            }
        Node current2 = polynomial2.head;
            // current2 is each term in polynomial2 that we check with first polynomioal
            while (current2 != null) {
                current1 = this.head;
                boolean matchFound = false;

                while (current1 != null) {
                    // if they match add the coefficients and then add them to result
                    if (current1.exponentX == current2.exponentX &&
                            current1.exponentY == current2.exponentY &&
                            current1.exponentZ == current2.exponentZ) {
                        matchFound = true;
                    break;
                }
                    current1 = current1.next;
            }
                // if they dont match put them directly to result
                if (!matchFound) {
                    result.insertLast(new Node(current2.coefficient, current2.exponentX, current2.exponentY, current2.exponentZ));
                }
                current2 = current2.next;
            }
                return result;
    }

    public LinkedList subtractPolynomial(LinkedList polynomial2) {

        // Create a new LinkedList to put the result on it
        LinkedList result = new LinkedList();
        Node current1 = this.head;

        // Two loops to check each terms of each polynomial to find the match terms
        while (current1 != null) {
            Node current2 = polynomial2.head;
            boolean matchFound = false;

            while (current2 != null) {
                // if they match add the coefficients and then add them to result
                if (current1.exponentX == current2.exponentX &&
                        current1.exponentY == current2.exponentY &&
                        current1.exponentZ == current2.exponentZ) {

                    Node newNode = current1.subtractWith(current2);
                    if (newNode != null){
                        result.insertLast(newNode);
                    }
                    matchFound = true;
                    break;
                }
                current2 = current2.next;
            }
            // if they don't match put them directly to result
            if (!matchFound) {
                result.insertLast(new Node(current1.coefficient, current1.exponentX, current1.exponentY, current1.exponentZ));
            }
            // check the next node
            current1 = current1.next;
        }
        Node current2 = polynomial2.head;
        // current2 is each term in polynomial2 that we check with first polynomial
        while (current2 != null) {
            current1 = this.head;
            boolean matchFound = false;

            while (current1 != null) {
                // if they match add the coefficients and then add them to result
                if (current1.exponentX == current2.exponentX &&
                        current1.exponentY == current2.exponentY &&
                        current1.exponentZ == current2.exponentZ) {
                    matchFound = true;
                    break;
                }
                current1 = current1.next;
            }
            // if they dont match put them directly to result
            if (!matchFound) {
                result.insertLast(new Node(-current2.coefficient, current2.exponentX, current2.exponentY, current2.exponentZ));
            }
            current2 = current2.next;
        }
        return result;
    }


        public String toString () {
            StringBuilder result = new StringBuilder();
            Node tmp = head;
            boolean isFirstTerm = true;


            while (tmp != null) {
                if (tmp.getCoefficient() != 0){
                    //if Coefficient is not zero
                    if (!isFirstTerm && tmp.getCoefficient() >= 0) {
                        result.append("+");
                    }
                    result.append(tmp);
                    isFirstTerm = false;
                }
                tmp = tmp.getNext();
            }
            // if all terms are zero return 0
            return (result.length()== 0) ? "0" : result.toString();
        }
}
