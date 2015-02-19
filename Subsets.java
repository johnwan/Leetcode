public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res;
        res = getSubsets2(S, 0);
        return res;
    }
    private ArrayList<ArrayList<Integer>> getSubsets(int[] S, int index){
        ArrayList<ArrayList<Integer>> res;
        if(index == S.length){
            res = new ArrayList<ArrayList<Integer>>();
            res.add(new ArrayList<Integer>());
        }else{
            res = getSubsets(S, index + 1);
            int item = S[index];
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: res){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.add(item);
                newSubset.addAll(subset);
                moreSubsets.add(newSubset);
            }
            Collections.reverse(moreSubsets);
            res.addAll(moreSubsets);
        }
        return res;
    }
    
    private ArrayList<ArrayList<Integer>> getSubsets2(int[] S, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int max = 1 << S.length; // compute 2^n
        for(int i = 0; i < max; i++){
            ArrayList<Integer> subset = convertIntToSet(i, S);
            res.add(subset);
        }
        return res;
    }
    
    private ArrayList<Integer> convertIntToSet(int x, int[] S){
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int i = x; i > 0; i>>=1){
            if((i & 1) == 1){
                subset.add(S[index]);
            }
            index++;
        }
        return subset;
    }
}
