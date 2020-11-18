import java.util.*;


class Expression {
    public static int ISP(String str) {
        int ret = 0;
        switch (str) {
            case "*":
                ret = 2;
                break;
            case "/":
                ret = 2;
                break;
            case "+":
                ret = 3;
                break;
            case "-":
                ret = 3;
                break;
            case "(":
                ret = 4;
                break;
        }
        return ret;
    }

    public static int ICP(String str) {
        int ret = 0;
        switch (str) {
            case "(":
                ret = 1;
                break;
            case "*":
                ret = 2;
                break;
            case "/":
                ret = 2;
                break;
            case "+":
                ret = 3;
                break;
            case "-":
                ret = 3;
                break;
        }
        return ret;
    }


    static double Eval(Vector<String> infix) throws Exception {
        Stack<String> infixdat = new Stack<>();
        Stack<String> res_infix = new Stack<>();

        System.out.print("infix expression : [");
        for (int i = 0; i < infix.size(); i++) {
            if(i == infix.size()-1){
                System.out.print(infix.elementAt(i));
            }else {
                System.out.print(infix.elementAt(i) + "  ");
            }
        }
        System.out.println("]");


        for (int i = 0; i < infix.size(); i++) {

            if (infix.elementAt(i).equals(")")) {
                for (; !(infixdat.peek().equals("(")); infixdat.pop()) {
                    res_infix.push(infixdat.peek());

                }
                infixdat.pop();
            } else if (infix.elementAt(i).equals("+") || infix.elementAt(i).equals("-") ||
                    infix.elementAt(i).equals("*") || infix.elementAt(i).equals("/") ||
                    infix.elementAt(i).equals("(")) {
                out:
                if (infixdat.empty()) {
                    infixdat.push(infix.elementAt(i));
                } else {
                    while (ICP(infix.elementAt(i)) >= ISP(infixdat.peek())) {
                        res_infix.push(infixdat.peek());
                        infixdat.pop();
                        if (infixdat.empty()) {
                            infixdat.push(infix.elementAt(i));
                            break out;
                        }
                    }
                    infixdat.push(infix.elementAt(i));

                }


            } else {
                res_infix.push(infix.elementAt(i));
            }

            System.out.println("Token : " + infix.elementAt(i));
            System.out.print("Stack : ");
            for (int n = 0; n < infixdat.size(); n++) {
                System.out.print(infixdat.elementAt(n) + " ");

            }
            System.out.println();

            if (i == infix.size() - 1) {
                if (!(infixdat.empty())) {
                    for (int n = infixdat.size(); n > 0; n--) {
                        res_infix.push(infixdat.elementAt(n - 1));
                    }
                }
            } //clean remain operator
        }  // Cal Stack,Token

        // NEED TO IMPLEMENT

        System.out.print("Postfix expression : [");
        for (int i = 0; i < res_infix.size(); i++) {
            if(i == res_infix.size() -1){
               System.out.print(res_infix.elementAt(i));
            }else {
                System.out.print(res_infix.elementAt(i) + "  ");
            }
        }
        System.out.println("]");

        Stack<String> postfix = new Stack<>();
        for (int n = 0; n < res_infix.size(); n++) {
            postfix.push(res_infix.elementAt(n));
            if ((postfix.peek().equals("+") || postfix.peek().equals("-") ||
                    postfix.peek().equals("*") || postfix.peek().equals("/"))) {
                String s = postfix.pop();
                double a = Double.valueOf(postfix.pop());
                double b = Double.valueOf(postfix.pop());
                if ((s.equals("+"))) {
                    postfix.push(String.valueOf(b + a));
                }
                if ((s.equals("-"))) {
                    postfix.push(String.valueOf((b - a)));
                }
                if ((s.equals("*"))) {
                    postfix.push(String.valueOf(b * a));
                }
                if ((s.equals("/"))) {
                    postfix.push(String.valueOf(b / a));
                }


            }
        }

        return Double.valueOf(postfix.peek());
    }
}




