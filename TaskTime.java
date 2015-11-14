class Solution {
  public static void main(String[] args) {
    int[] tasks = {1,1,1,1};
    int k = 2;
    Solution s = new Solution();
    System.out.println(s.getTime(tasks, k));
  }
  
  private int getTime(int[] tasks, int k){
    HashMap<Integer, Integer> map = new HashMap<>();
    int t = 0;
    for(int i = 0; i < tasks.length; i++){
      int cur = tasks[i];
      if(!map.containsKey(cur) || map.get(cur) + k <= t){
        map.put(cur, ++t);
      }else{
        t = map.get(cur) + k + 1;
        map.put(cur, t);
      }
    }
    return t;
  }
}
