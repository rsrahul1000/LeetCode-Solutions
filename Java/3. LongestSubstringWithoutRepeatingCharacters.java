class Solution {
    // Question is to find the longest Substring Without Repeating Characters
    // This Solution uses HashSet Data Structure to improve the time complexity of the program
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        // Hashset Datastructure makes it easier to maintain non repeating characters as it only contains unique elements
        HashSet<Character> set = new HashSet<>();
        int result = 1;
        int i=0; 
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            // if new element then add it to the hashset and take the max of set size and previously calculated result
            if(!set.contains(c)){
                set.add(c);
                result = Math.max(result, set.size());
            }else{
                while(i<j){
                    if(s.charAt(i)==c){     //if character repeates then remove the set an goto next character
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));
                    i++;
                }
            }    
        }
        return result;
    }
}