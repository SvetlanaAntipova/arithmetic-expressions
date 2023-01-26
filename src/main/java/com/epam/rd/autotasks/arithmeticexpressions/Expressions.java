package com.epam.rd.autotasks.arithmeticexpressions;


public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if(value<0) return "("+value+")";
                return ""+value;
            }
        };
    }

    public static Expression sum(Expression... members){
        return new Expression() {
            @Override
            public int evaluate() {
                int val=0;
                for (Expression member : members) val += member.evaluate();
                return val;
            }

            @Override
            public String toExpressionString() {
                String expr ="(";
                for (Expression x:members){
                    expr += (x.toExpressionString()+" + ");
                }
                expr = expr.substring(0,(expr.length()-3));
                expr += ")";
                return expr;
            }
        };
    }

    public static Expression product(Expression... members){
        return new Expression(){

            @Override
            public int evaluate() {
                int val=1;
                for (Expression member : members) {
                  val*=member.evaluate();
                }
                return val;
            }

            @Override
            public String toExpressionString() {
                String expr ="(";
                for (Expression x:members){
                    expr += (x.toExpressionString()+" * ");
                }
                expr = expr.substring(0,(expr.length()-3));
                expr += ")";
                return expr;
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression(){

            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                String min = minuend.toExpressionString();
                String sub = subtrahend.toExpressionString();
                return "("+min+" - "+sub+")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        return new Expression(){

            @Override
            public int evaluate() {
                return dividend.evaluate() /divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                String divid = dividend.toExpressionString();
                String divis = divisor.toExpressionString();
                return "("+divid+" / "+divis+")";
            }
        };
    }

}
