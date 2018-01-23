class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs= new HashSet<>();
        int i=0;
        int j=0;
        int maxLength=0;
        while(j<s.length()){
            if(hs.contains(s.charAt(j))){
                hs.remove(s.charAt(i));                  
                i++;
            }else{
                hs.add(s.charAt(j));
                j++;
                maxLength=Math.max(maxLength, j-i);                                  
            }
            
        }
        return maxLength;
    }
}

/*an alternate to it could be when we remove position i index , at that time instad of moving i by +1 move it to the position where the repeated element found*/
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> hm= new HashMap<>();
        int i=0;
        int j=0;
        int maxLength=0;
        while(j<s.length()){
            if(hm.containsKey(s.charAt(j))){
                hm.remove(s.charAt(i));                  
                i=Math.max(hm.get(s.charAt(j)), i);
            }else{
                hm.put(s.charAt(j), j+1);
                j++;
                maxLength=Math.max(maxLength, j-i+1);                                  
            }
            
        }
        return maxLength;
    }
}
*/