package day19;

class WordDictionary {
    private class Node{
        private Node[] children;
        private boolean isEnd;
        public Node(){
            children = new Node[26];
            isEnd = false;
        }
    }

    private Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return helper(word,0,root);
    }
    public boolean helper(String s, int i , Node cur){
        if(i == s.length()){
            return cur.isEnd;
        }
        if(s.charAt(i) == '.'){
            for(Node child : cur.children){
                if(child != null && helper(s,i + 1,child)){
                    return true;
                }
            }
            return false;
        }else{
            int index = s.charAt(i) - 'a';
            Node child = cur.children[index];
            if(child == null)return false;
            return helper(s,i + 1, child);
        }
    }
}
