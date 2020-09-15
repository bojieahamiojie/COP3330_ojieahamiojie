public class Decrypter {

    public String decrypt(String encrypted){
        char[] num = encrypted.toCharArray();
        int i, j;
        char ch, temp;

        temp = num[2];
        num[2] = num[0];
        num[0] = temp;
        temp = num[3];
        num[3] = num[1];
        num[1] = temp;

        for(i = 0; i < 4; i++) {
            j = (num[i] - 48 + 3) %10;
            ch = (char)(j + 48);
            num[i] = ch;
        }
        return new String(num);
    }
}
