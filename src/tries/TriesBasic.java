package tries;

public class TriesBasic {
    public static void main(String[] args) {

    }

    //Tries is a data structure which stores data from top to bottom
    //tries -> 1. using character [a-z]
    //         2. using bits [0-1]


    public static void insertNode(TrieNode root, String word){
        TrieNode curr =root;
        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if (curr.children[ch -'a'] ==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd=true;
    }

    public static boolean searchWord(TrieNode root, String word){
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] ==null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    public static TrieNode deleteNode(TrieNode root, String word){
        //stack the nodes into stack and keep deleting the leaves from the top where isEnd=false
        //T.C->O(length of the word)
        return root;
    }

    //find the shortest prefix of each word that uniquely identifies the word.
    // if no such prefix exist, ans=-1;
    // A= {trie, trap, plate, cat, part, place, tie, tries}
    //ans={ -1, tra,  plat,  c,   pa,   plac,  ti,  tries}




    //given n strings and q words. for each word, count how many of the n strings have
    // that word as the prefix


}
