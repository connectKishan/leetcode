class Solution {
    public String longestPalindrome(String s) {
        int len =s.length();
        String pstr=null;
        int pl=1;
        boolean[][] palTable =new boolean [len][len];
        
        for(int i=0; i<len;i++){
            for(int j=0; j<len; j++){
                palTable[i][j]=false;
            }
        }
        
           //Bcoz len 1 string will always be paalindrome
        for(int i=0; i<len; i++) {
            palTable[i][i]=true;
            pstr=s.substring(i, i+1);
            pl=1;
        }
        
        // for substring of len 2
        for(int i=0; i<=len-2; i++){
            if(s.charAt(i)==s.charAt(i+1)){
               palTable[i][i+1]=true;
               pstr=s.substring(i, i+2);
                pl=2;
            }
        }

    //from thirsd index string , match with the preious two and one length string
        int j=0;
        for(int k=2; k<len; k++){
        for(int i=0; i<len-k; i++){
            j=i+k;
                if(s.charAt(i)==s.charAt(j) && palTable[i+1][j-1]==true){
                    palTable[i][j]=true;
                    if((j-i+1)>pl){
                    pstr= s.substring(i, j+1);
                    pl=j-i+1;
                    }                    
                }
            }
        }
         
        return pstr;     
    }
}