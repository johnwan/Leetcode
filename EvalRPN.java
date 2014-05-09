public class Solution {
    public static int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        String opreator = "+-*/";
        Stack<Integer> num = new Stack<Integer>();
        for(String str: tokens){
            if (opreator.contains(str)){
            	Integer b = num.pop();
            	Integer a = num.pop();
            	num.push(calculate(a,b,str));
            }else{
            	num.push(Integer.parseInt(str));
            }
        }
		return num.peek();
    }

	private static Integer calculate(Integer a, Integer b, String str) {
		// TODO Auto-generated method stub
		switch(str){
		case "+": return a+b; 
		case "-": return a-b; 
		case "*": return a*b; 
		case "/": return a/b;
		}
		return 0;
	}
}
