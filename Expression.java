import java.util.Stack;
import java.util.Vector;


class Expression {


    static double Eval(Vector<String> infix) throws Exception {

        System.out.print("infix expriession :[");
        for(int i =0; i<infix.size()-1;i++) {
            System.out.print(infix.elementAt(i) + " ");
        }
        System.out.println(infix.elementAt(infix.size()-1)+"]");

        Stack<String> postfix = new Stack<>();
        Stack<String> stack = new Stack<>();

        //    char[] output = new char[infix.size()];//output
        //    char[] fix = infix.toString().toCharArray();//infix->char

        for(int pos = 0; pos<infix.size();pos++) {
            if(infix.elementAt(pos).equals(")")) {//if pos is )
                while(!stack.peek().contentEquals("(")) {
                    postfix.push(stack.peek());
                    stack.pop();
                } stack.pop();
            }
            else if(infix.elementAt(pos).equals("*") ||// pos 가
                    infix.elementAt(pos).equals("/") ||
                    infix.elementAt(pos).equals("-") ||
                    infix.elementAt(pos).equals("+") ||
                    infix.elementAt(pos).equals("(") ) {

                if(!stack.empty()) {    //문자인데 스택이 안비어이/ㅅ을때
                    while((infix.elementAt(pos).equals("*")||infix.elementAt(pos).equals("/"))
                            &&
                            (stack.peek().equals("*")
                                    ||stack.peek().equals("/")) ||
                            (infix.elementAt(pos).equals("+")||infix.elementAt(pos).equals("-"))&&
                                    (stack.peek().equals("+")||stack.peek().equals("-")||
                                            stack.peek().equals("*") ||stack.peek().equals("/"))) {
                        postfix.push(stack.peek());
                        stack.pop();
                        if(stack.empty()){
                            break;
                        }
                    }
                    if(stack.empty()) ;stack.push(infix.elementAt(pos));
                }
                else { //문자인데 스택이 비어있을 때
                    stack.push(infix.elementAt(pos));
                }
            }

            else {//if pos is int
                postfix.push(infix.elementAt(pos));
            }



            System.out.println("Token : " + infix.elementAt(pos));

            System.out.print("Stack : ");
            for(int m = 0; m< stack.size();m++) {
                System.out.print(stack.elementAt(m)+" ");
            } System.out.println();
            ///////////////////////////////////////////////
            System.out.print("Postfix exprssion : [");
            for(int m = 0;m<postfix.size();m++) {
                if( m == postfix.size()-1) {
                    System.out.print(postfix.elementAt(m));
                    break;
                }
                System.out.print(postfix.elementAt(m) + " ");
            } System.out.println("]");

        }
        System.out.print("Postfix exprssion : [");
        for(int m = 0;m<postfix.size();m++) {
            if( m == postfix.size()-1) {
                System.out.print(postfix.elementAt(m));
                break;
            }
            System.out.print(postfix.elementAt(m) + " ");
        } System.out.println("]");

        return 0.0;
    }

};
//if(ICP.equals("*")||ICP.equals("/")) num1 = 1;
//else if(ICP.equals("+")||ICP.equals("-")) num1 = 2;
//else if(ICP.equals("(")) num1 = 0;
//if(ISP.equals("*") ||ISP.equals("/")) num2 = 1;
//else if(ISP.equals("+")||ISP.equals("-")) num2 = 2;
//else if(ISP.equals("(")) num2 = 3;


