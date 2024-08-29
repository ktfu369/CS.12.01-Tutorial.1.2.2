public class HiddenWord {
    String word;
    int[] cnt = new int[128];

    public HiddenWord(String x){
        x = x.toUpperCase();
        word = x;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i);
            cnt[index] ++;
        }
    }

    public String getHiddenWord(){
        return word;
    }

    public String getHint(String x){
        for(int i=0;i<x.length();i++){
            if(x.charAt(i) >= 'a' && x.charAt(i) <= 'z'){
                throw new IllegalArgumentException("Your guess ( " + x + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
            }
        }
        if(x.length() != word.length()){
            throw new IllegalArgumentException("Your guess ( " + x + " ) has " + x.length() + " characters. The hidden word has "+ word.length() + " characters. Your guess must be a word with " + word.length() + " characters!");
        }
        String ans = "";
        for(int i=0;i<x.length();i++){
            if(x.charAt(i) == word.charAt(i)){
                ans += x.charAt(i);
            }else if(cnt[x.charAt(i)] > 0){
                ans += "+";
            }else{
                ans += "*";
            }
        }
        return ans;
    }
}
