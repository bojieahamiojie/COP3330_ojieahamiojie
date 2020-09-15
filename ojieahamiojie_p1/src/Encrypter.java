public class Encrypter {
    public String encrypt(String inputValue) {
        char[] num = inputValue.toCharArray();
        int i, j;
        char ch, temp;

        for (i = 0; i < 4; i++) {
            j = (num[i] - 48 + 7) % 10;
            ch = (char) (j + 48);
            num[i] = ch;
        }
        temp = num[0];
        num[0] = num[2];
        num[2] = temp;
        temp = num[1];
        num[1] = num[3];
        num[3] = temp;

        return new String(num);
    }
}
