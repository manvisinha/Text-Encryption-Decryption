import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CustomEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                performEncryption();
                break;
            case 2:
                performDecryption();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void performEncryption() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the string to encrypt: ");
            String inputString = sc.nextLine();

            System.out.print("Enter the encryption key (an integer): ");
            int key = sc.nextInt();

            String encryptedString = customEncrypt(inputString, key);

            FileOutputStream fos = new FileOutputStream("FilePath/encryptedFile.txt"); //Replace FilePath
            fos.write(encryptedString.getBytes());
            fos.close();

            System.out.println("String encrypted and written to file successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performDecryption() {
        try {
            FileInputStream fis = new FileInputStream("FilePath/encryptedFile.txt"); //Replace FilePath
            byte[] encryptedBytes = fis.readAllBytes();
            fis.close();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the decryption key (an integer): ");
            int key = sc.nextInt();

            String decryptedString = customDecrypt(new String(encryptedBytes), key);

            System.out.println("Decrypted String: " + decryptedString);

            FileOutputStream fos = new FileOutputStream("FilePath/decryptedFile.txt"); //Replace Filepath
            fos.write(decryptedString.getBytes());
            fos.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String customEncrypt(String inputString, int key) {
        String encryptedString = "";
        for (char c : inputString.toCharArray()) {
            char encryptedChar = (char) (c + key);
            encryptedString += encryptedChar;
        }
        return encryptedString;
    }


    private static String customDecrypt(String inputString, int key) {
        String decryptedString = "";
        for (char c : inputString.toCharArray()) {
            char decryptedChar = (char) (c - key);
            decryptedString += decryptedChar;
        }
        return decryptedString.toString();
    }
}
