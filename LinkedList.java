
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

    public void insertLast(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
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
