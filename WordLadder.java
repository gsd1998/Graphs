package interviewQA.Graphs;

import java.util.*;

class PairWordStep{
    String word;
    int steps;

    public PairWordStep(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<PairWordStep> q = new LinkedList<>();
        int len = beginWord.length();
        for(String i : wordList){
            set.add(i);
        }
        q.offer(new PairWordStep(beginWord,1));
        while(!q.isEmpty()){
            PairWordStep pair = q.poll();
            String word = pair.word;
            int steps = pair.steps;
            if(word.equals(endWord)){
                return steps;
            }
            for(int i = 0; i < len; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i] = ch;
                    String eachWord = new String(replacedWord);
                    if(set.contains(eachWord)){
                        q.offer(new PairWordStep(eachWord, steps+1));
                        set.remove(eachWord);
                    }
                }
            }
        }
        return 0;
    }
}
