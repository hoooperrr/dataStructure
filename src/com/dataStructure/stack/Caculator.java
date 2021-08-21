package com.dataStructure.stack;

public class Caculator {
    public static void main(String[] args) {
        String expression = "3*10+25+333-2";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack opStack = new ArrayStack(10);

        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到char保存到ch
        String keepNum = "0"; //用于拼接 多位数

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (opStack.isOper(ch)) {
                if (!opStack.isEmpty()) {
                    if (opStack.priority(ch) <= opStack.priority(opStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = opStack.pop();
                        numStack.push(numStack.cal(num1, num2, oper));
                        opStack.push(ch);
                    } else {
                        opStack.push(ch);
                    }
                } else {
                    opStack.push(ch);
                }
            } else {
                keepNum = keepNum.concat(String.valueOf(ch));
                if (index + 1 == expression.length()) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
//                keepNum += ch;
                    if (opStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
//                        if (numStack.isEmpty()) {
//                            numStack.push(ch - 48);
//                            keepNum = "0";
//                        } else {
                            numStack.push(Integer.parseInt(keepNum));
                            keepNum = "0";
                        }
//                    } else {
//                        keepNum = keepNum.concat(String.valueOf(ch));
//                    }
//                    numStack.push(ch - 48);
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            if (opStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = opStack.pop();
            numStack.push(numStack.cal(num1, num2, oper));
        }
        System.out.println("计算结果" + numStack.pop());

    }
}
