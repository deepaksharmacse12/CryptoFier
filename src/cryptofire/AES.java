package cryptofire;

 
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
public class AES 
{
    static String IV = "AAAAAAAAAAAAAAAA";
    public static byte[] encrypt(byte[] plainText, byte[] encryptionKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec key = new SecretKeySpec(encryptionKey, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        
        return cipher.doFinal(plainText);
    }
 
    public static byte[] decrypt(byte[] cipherText, byte[] encryptionKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(encryptionKey, "AES");
        cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return (cipher.doFinal(cipherText));
    }
}