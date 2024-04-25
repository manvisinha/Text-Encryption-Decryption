package project;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EncrypterDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine();

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

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the string to encrypt: ");
            String inputString = scanner.nextLine();

            //aes encryption will start here
            String key = "Pass123456789000"; // Example secret key
            byte[] encryptedBytes = Encrypter.encrypt(inputString, key);

            // writing the byte array into the file
            FileOutputStream fos = new FileOutputStream("C:/Users/Prem/Documents/SEM 4/OOP_JAVA/project/secretsecret2.txt");
            fos.write(encryptedBytes);
            fos.close();

            System.out.println("String encrypted and written to file successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performDecryption() {
        try {
            // Reading encrypted file
            FileInputStream fis = new FileInputStream("C:/Users/Prem/Documents/SEM 4/OOP_JAVA/project/secretsecret2.txt");
            byte[] encryptedBytes = fis.readAllBytes();
            fis.close();

            //aes decryption
            String key = "Pass123456789000"; // Example secret key
            String decryptedString = Decrypter.decrypt(encryptedBytes, key);

            // Displaying decrypted string
            System.out.println("Decrypted String: " + decryptedString);

            FileOutputStream fos = new FileOutputStream("C:/Users/Prem/Documents/SEM 4/OOP_JAVA/project/secretsecret.txt");
            fos.write(decryptedString.getBytes());
            fos.close();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

