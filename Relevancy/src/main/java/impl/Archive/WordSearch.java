package impl.Archive;

import java.util.*;


public class WordSearch {
    static Map<String, Set<String>> map = new HashMap<String,  Set<String>>();

    public static void main(String[] args) {
        String word ="icici bank,facebook,face";

        createWordMapping(word);
        String find="i";
        getAllwords(find);

    }

    public static void createWordMapping(String word) {
        String [] words = word.split(",");
        for(String st : words){
            if(st.contains(" ")){
                String [] wordWithspace = word.split(" ");
                for(String spaceword : wordWithspace){
                    for(int i=0; i<spaceword.length(); i++){
                        if(map.containsKey(spaceword.substring(0,i+1))){
                            Set<String> set = map.get(spaceword.substring(0,i+1));
                            set.add(st);
                            map.put(spaceword.substring(0,i+1), set);
                        }else{
                            Set<String> set = new HashSet<>();
                            set.add(st);
                            map.put(spaceword.substring(0,i+1), set);
                        }
                    }
                }
            }else{
                for(int i=0; i<st.length(); i++){
                    if(map.containsKey(st.substring(0,i+1))){
                        Set<String> set = map.get(st.substring(0,i+1));
                        set.add(st);
                        map.put(st.substring(0,i+1), set);
                    }else{
                        Set<String> set = new HashSet<>();
                        set.add(st);
                        map.put(st.substring(0,i+1), set);
                    }
                }
            }
        }
    }

    public static Object getAllwords(String find) {
        Set<String> set = map.get(find);
        for(String s : set){
            System.out.println(s);
        }
        return set;
    }

}



