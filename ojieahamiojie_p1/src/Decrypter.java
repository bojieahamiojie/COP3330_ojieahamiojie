import java.util.Scanner;

public class Decrypter {

    public void main(String[] args){
        System.out.println("Enter the encrypted integers: \n");
        Scanner sc = new Scanner(System.in);

        int e, i, j, k;
        e = 0;
        k = sc.nextInt();

        for (i = 1; i <= 4; i++){
            j = (k % 10) - 7;
            e = (e * 10) + (j + 20) % 10;
            k = k / 10;
        }
        k = 0;

        while (e > 0){
            j = e % 10;
            k = (k * 10) + j;
            e = e / 10;
        }
        System.out.println("The original integers are \n" +k);
    }
}
