package main;

public class Encryptor {
    
    String key = "";

    void changeKey(String newKey){
        this.key = newKey;
    }

    String encrypt(String text){
        String out = "";
        int count = 0;
        for(char thisChar: text.toCharArray()){
            int num = (int)thisChar;
            num+=keyRead(this.key, count);
            count++;
            out+=(char)num;
        }
        return out;
    }

    String decrypt(String text){
        String out = "";
        int count = 0;
        for(char thisChar: text.toCharArray()){
            int num = (int)thisChar;
            num-=keyRead(this.key, count);
            count++;
            out+=(char)num;
        }
        return out;
    }

    int keyRead(String key, int location){
        char[] charArray = key.toCharArray();
        int num = (int)charArray[location%(key.length())];
        location = location%key.length();
        char[] keyCharArray = key.toCharArray();
        int out = keyCharArray[location];
        out+=num;
        return out%20;
    }
}
