    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length < 2) return A.length;
        int slow = 0;
        int fast = 1;
         
        while(fast < A.length){
            if(A[fast] == A[slow]){
                fast++;
            }else{
                A[++slow] = A[fast++];
            }    
        }
        return slow+1;
    }
