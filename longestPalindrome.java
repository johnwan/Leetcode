Solution2: O(n^2) O(1)
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        String res = "";
        for(int i=0;i<2*n-1;i++){
            int left = i, right=i/2+1;
            if(i%2==0){
                left=i/2-1;
            }else{
                left=i/2;
            }
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>res.length()){
                res=s.substring(left+1,right);
            }
        }
        
        return res;
    }
}
Solution 3:O(n),O(n)
http://www.felix021.com/blog/read.php?2040
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n= s.length();
        int [] p = new int[2*n-1];
        
        int center=0, right=0, cur=0;
        while(cur<2*n-1){
            while(2*center-right>=0 && right<2*n-1 
                && (right%2==1 || s.charAt((2*center-right)/2)==s.charAt(right/2))){
                right++;
                p[center]++;
            }
            right=Math.max(right-1,center);
            p[center]= Math.max(p[center]-1,0);
            cur=center+1;
            while(2*center-cur>=0 && cur+p[2*center-cur]<right){
                p[cur]=p[2*center-cur];
                cur++;
            }
            if(cur<2*n-1){
                center=cur;
                if(right<center) right=center;
                p[center]=right-cur;
            }
        }
        
        String res="";
        for(int i=0;i<2*n-1;i++){      
            int start=0, end=0;
            if(i%2==1){
                start = i/2-(p[i]+1)/2+1;
                end = i/2+(1+p[i])/2;
            }else{
                start = i/2-p[i]/2;
                end = i/2+p[i]/2;
            }
            if(end-start+1>res.length())
                res=s.substring(start,end+1);
        }
        return res;
    }
}
