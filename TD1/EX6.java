public class EX6 {
    
    
    static void afficherUnicode(String string){
        for(int i = 0; i < string.length(); i++){
            //String unicodeCharacter = convertToUnicode(string.charAt(i));
            System.out.println("Charactère : " + string.charAt(i) + " : unicode : " + (int)string.charAt(i));
        }
    }

    public static void main(String[] args){
        afficherUnicode("abcdef");
    }
}
