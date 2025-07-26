package interviewQA.Graphs;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<List<String>> q = new LinkedList<>();
        int len = beginWord.length();
        for(String word : wordList){
            set.add(word);
        }
        ArrayList<String> initial = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> usedWordOnLevel = new ArrayList<>();
        usedWordOnLevel.add(beginWord);
        initial.add(beginWord);
        q.offer(initial);
        int level = 0;

        while(!q.isEmpty()){
            List<String> vec = q.poll();
            if(vec.size() > level){
                level++;
                for(String w : usedWordOnLevel){
                    set.remove(w);
                }
            }
            String usedWord = vec.get(vec.size() - 1);
            if(usedWord.equals(endWord)){
                if(ans.size() == 0){
                    ans.add(vec);
                }else {
                    if(ans.get(0).size() == vec.size()){
                        ans.add(vec);
                    }
                }
            }

            for(int i = 0; i < len; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedWord = usedWord.toCharArray();
                    replacedWord[i] = ch;
                    String finalWord = new String(replacedWord);
                    if(set.contains(finalWord)){
                        usedWordOnLevel.add(finalWord);
                        vec.add(finalWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.offer(temp);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
