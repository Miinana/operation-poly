
public class Node {
    protected int coefficient;
    protected int exponentX;
    protected int exponentY;
    protected int exponentZ;
    protected Node next;

    public Node(int coefficient, int exponentX, int exponentY, int exponentZ) {
        this.coefficient = coefficient;
        this.exponentX = exponentX;
        this.exponentY = exponentY;
        this.exponentZ = exponentZ;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponentX() {
        return exponentX;
    }

    public int getExponentY() {
        return exponentY;
    }

    public int getExponentZ() {
        return exponentZ;
    }

    public Node addWith(Node node) {
        if (this.exponentX == node.exponentX &&
                this.exponentY == node.exponentY &&
                this.exponentZ == node.exponentZ) {
            int newCoefficient = this.coefficient + node.coefficient;

            return new Node(newCoefficient, this.exponentX, this.exponentY, this.exponentZ);
        } else {
            if (this.exponentX > node.exponentX) {
            return new Node(this.coefficient, this.exponentX, this.exponentY, this.exponentZ);
        } else if (this.exponentX < node.exponentX) {
            return new Node(node.coefficient, node.exponentX, node.exponentY, node.exponentZ);
        } else if (this.exponentY > node.exponentY) {
            return new Node(this.coefficient, this.exponentX, this.exponentY, this.exponentZ);
        } else if (this.exponentY < node.exponentY) {
            return new Node(node.coefficient, node.exponentX, node.exponentY, node.exponentZ);
        } else if (this.exponentZ > node.exponentZ) {
            return new Node(this.coefficient, this.exponentX, this.exponentY, this.exponentZ);
        } else {
            return new Node(node.coefficient, node.exponentX, node.exponentY, node.exponentZ);
        }
    }
}

    public Node subtractWith(Node node) {
        if (this.exponentX == node.exponentX &&
                this.exponentY == node.exponentY &&
                this.exponentZ == node.exponentZ) {
            int newCoefficient = this.coefficient - node.coefficient;

            return new Node(newCoefficient, this.exponentX, this.exponentY, this.exponentZ);
        } else {
            if (this.exponentX > node.exponentX) {
                return new Node(this.coefficient, this.exponentX, this.exponentY, this.exponentZ);
            } else if (this.exponentX < node.exponentX) {
                return new Node(node.coefficient, node.exponentX, node.exponentY, node.exponentZ);
            } else if (this.exponentY > node.exponentY) {
                return new Node(this.coefficient, this.exponentX, this.exponentY, this.exponentZ);
            } else if (this.exponentY < node.exponentY) {
                return new Node(node.coefficient, node.exponentX, node.exponentY, node.exponentZ);
            } else if (this.exponentZ > node.exponentZ) {
                return new Node(this.coefficient, this.exponentX, this.exponentY, this.exponentZ);
            } else {
                return new Node(node.coefficient, node.exponentX, node.exponentY, node.exponentZ);
            }
        }
    }
    public String toString() {
        StringBuilder term = new StringBuilder();

        if (coefficient != 0) {
            term.append(coefficient); //if coefficient is 0 return empty
        }else{
            return " ";
        }
            // if exponent is 1 don't write the number 1 is the result
        if (exponentX != 0) {
            term.append("x");
            if (exponentX != 1) {
                term.append(exponentX);
            }
        }

        if (exponentY != 0) {
            term.append("y");
            if (exponentY != 1) {
                term.append(exponentY);
            }
        }

        if (exponentZ != 0) {
            term.append("z");
            if (exponentZ != 1) {
                term.append(exponentZ);
            }
        }
        return term.toString();
    }
}