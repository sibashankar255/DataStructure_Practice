package tries;

public class TrieNode {
    boolean isEnd;
    TrieNode children[];
    TrieNode(){
        isEnd=false;
        children = new TrieNode[26];// for all i, children[i]=null;
    }
}
