public class tries {
    public static class node{
        node[]character=new node[26];
        boolean eow=false;
        node(){
            for(int i=0;i<26;i++){
                character[i]=null;
            }
        }
    } public static node root=new node();
    public static void insert(String word){
        node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.character[i]==null){
                curr.character[idx]=new node();
            }curr=curr.character[idx];
        }curr.eow=true;
    }
    public static boolean search(String key){
        node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.character[idx]==null){
                return false;
            }curr=curr.character[idx];
        }return curr.eow;
    }
    public static void main(String[] args) {
        String []word={"the","a","there","their","any","thee"};
        for (String s : word) {
            insert(s);
        }
        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
