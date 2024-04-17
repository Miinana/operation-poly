
import java.io.*; //  BufferedReader and BufferedWriter

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            // first number is line nunmbers
            int linenumber = Integer.parseInt(br.readLine().trim());
            // first character in each line shows the operator
            for (int i = 0; i < linenumber; i++) {
                String line = br.readLine().trim();
                char operation = line.charAt(0);
                String[] operands = line.substring(2).split(" ");
                // each operator do what

                switch (operation) {
                    case '+':
                        addition(operands, bw);
                        break;
                    case '-':
                        subtraction(operands, bw);
                        break;
                    case '*':
                        multiplication(operands, bw);
                        bw.newLine();
                        break;
                    default:
                        System.out.println("Unexpected operation" + operation);
                }
                bw.newLine();
            }
                    br.close();
                    bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        // Create Linked list from Polynomials
        private static LinkedList createPolynomial (String polynomialString){
            // Create a new linked list
            LinkedList polynomial = new LinkedList();

            // Spilt polynomials
            String[] terms = polynomialString.split("[-+]");
            //String[] terms = polynomialString.split("[-|+]");

            for (String term : terms) {
                Node node = createNodeFromTerm(term);
                if (node != null) {
                    polynomial.insertLast(node);
                }
            }
            return polynomial;
        }

        // seprate two polynomials and then seperate each polynomials to terms that are seperated by +.-/*
        private static Node createNodeFromTerm (String term){
            int coefficient = 1;
            int exponentX = 0;
            int exponentY = 0;
            int exponentZ = 0;

            // split terms by x, y, z
            String[] component = term.split("[xyz]");
            for (int i = 0; i< component.length; i++){
                if (component[i].isEmpty()){
                    component[i] = (i==0)? "1": "0";
                }
            }
            // set exponents
            if (term.contains("x")) {
                if (component.length > 1) {
                    exponentX = Integer.parseInt(component[1]);
                } else {
                    exponentX = 1;
                }
            }
            if (term.contains("y")) {
                if (component.length > 2) {
                        exponentY = Integer.parseInt(component[2]);
                } else {
                    exponentY = 1;
                }
            }
            if (term.contains("z")) {
                if (component.length > 3) {
                    exponentZ = Integer.parseInt(component[3]);
                } else {
                    exponentZ = 1;
                }
            }

                    // if x or y or z missed next exponents shift back
            if (!term.contains("x") && component.length > 2) {
                exponentY = Integer.parseInt(component[1]);
                exponentZ = Integer.parseInt(component[2]);
            }
            if (!term.contains("y") && component.length > 2) {
                exponentZ = Integer.parseInt(component[2]);
            }

                    // if there is no x y z return exponent as 0
            if (!term.contains("x")) {
                exponentX = 0;
            }
            if (!term.contains("y")) {
                exponentY = 0;
            }
            if (!term.contains("z")) {
                exponentZ = 0;
            }
            coefficient = Integer.parseInt(component[0]);

            return new Node(coefficient, exponentX, exponentY, exponentZ);
    }

        // method for addition
        private static void addition( String[]operands, BufferedWriter bw){
            try{
                LinkedList result = new LinkedList();
                LinkedList polynomial1 = createPolynomial (operands [0]);
                LinkedList polynomial2 =createPolynomial (operands [1]);
                result = polynomial1.addPolynomial(polynomial2);
                bw.write(result.toString());
            }
            catch (Exception e){
                System.err.println("Error!");
                e.printStackTrace();
            }
        }
        //method for subtraction
        private static void subtraction( String[]operands, BufferedWriter bw){
                    try{
                        LinkedList result = new LinkedList();
                        LinkedList polynomial1 = createPolynomial (operands [0]);
                        LinkedList polynomial2 =createPolynomial (operands [1]);
                        result = polynomial1.subtractPolynomial(polynomial2);
                        bw.write(result.toString());
                    }
                    catch (Exception e){
                        System.err.println("Error!");
                        e.printStackTrace();
                    }
                }

        //method for multiplication
    private static void multiplication( String[]operands, BufferedWriter bw) throws IOException {
            System.out.println("multiplication!");
        }
    }


