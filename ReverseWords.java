public class ReverseWords {
    public static String reverseWords(String s) {
        if (s == null || s == ""){
            return "";
        }
        s = s.trim().replaceAll("\\s+", " ");
    	String[] words = s.split(" ");
    	String result = "";
    	for (int i = words.length - 1; i >= 0 ; i--){
    		while(words[i] == "\\s"){
    			i--;
    		}
    	    if (i == 0)
    	        result += words[i];
    	    else
    		    result = result + words[i] + " ";
    	}
		return result;        
    }
    
    public static void main(String[] args){
    	String input = "   a   b ";
    	System.out.print('"'+reverseWords(input)+'"');
    }
}
