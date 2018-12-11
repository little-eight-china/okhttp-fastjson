package github.hjg;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 各种加密工具.
 * @author little-eight
 */
public class EncryptUtil {

    /**
     * sha1加密
     * @param sign 签名
     * @return 加密后的签名
     * @throws NoSuchAlgorithmException
     */
    public static String encryptBySHA1(String sign) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(sign.getBytes());
        StringBuilder buf = new StringBuilder();
        byte[] bits = md.digest();
        for (byte bit : bits) {
            int a = bit;
            if (a < 0) {
                a += 256;
            }
            if (a < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(a));
        }
        return buf.toString().toUpperCase();
    }

    /**
     * md5加密（16、32位）
     * @param sign 签名
     * @param digit 16或者32
     * @return 加密后的签名
     */
    public static String encryptByMD5(String sign, int digit) throws Exception {
        String re_md5;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sign.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuilder buf = new StringBuilder("");
            for (byte aB : b) {
                i = aB;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            re_md5 = (digit == 16 ? buf.toString().substring(8, 24) : buf.toString());
        } catch (Exception e) {
            throw new Exception("MD5加密出现错误，错误信息："+e.getMessage(),e);
        }
        return re_md5;
    }

    /**
     * AES加密
     * @param sign 签名
     * @param password  密钥
     * @return 加密后的签名
     * @throws
     */
    public static String encryptByAES(String sign,String password) throws Exception {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(password.getBytes()));
            //3.产生原始对称密钥
            SecretKey originalKey =keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte [] raw=originalKey .getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher=Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] byteEncode=sign.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte [] byteAES=cipher.doFinal(byteEncode);
            //10.将加密后的数据转换为字符串
            return new BASE64Encoder().encode(byteAES);
        } catch (Exception e) {
            throw new Exception("AES加密出现错误，错误信息："+e.getMessage(),e);
        }

    }

    /**
     * AES解密
     * @param sign 加密签名
     * @param password 密钥
     * @return 解密签名
     * @throws Exception
     */
    public static String decryptByAES(String sign,String password) throws Exception {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(password.getBytes()));
            //3.产生原始对称密钥
            SecretKey originalKey=keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte [] raw=originalKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher=Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte [] byteContent= new BASE64Decoder().decodeBuffer(sign);
            //9.解密
            byte [] byteDecode=cipher.doFinal(byteContent);
            return new String(byteDecode,"utf-8");
        } catch (Exception e) {
            throw new Exception("AES解密出现错误，错误信息："+e.getMessage(),e);
        }
    }
}
