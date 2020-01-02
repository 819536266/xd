package com.xd;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huboxin
 * @title: test
 * @projectName bk
 * @description:
 * @date 2019/12/3116:31
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    /*下边命令生成密钥证书，采用RSA 算法每个证书包含公钥和私钥
            keytool -genkeypair -alias xd -keyalg RSA -keypass 123456 -keystore jwt.jks -storepass 123456
            Keytool 是一个java提供的证书管理工具
            -alias：密钥的别名
            -keyalg：使用的hash算法
            -keypass：密钥的访问密码
            -keystore：密钥库文件名，xc.keystore保存了生成的证书
            -storepass：密钥库的访问密码
            查询证书信息：
            keytool -list -keystore xc.keystore
            删除别名
            keytool -delete -alias xckey -keystore xc.keystore*/


    @Test
    public void contextLoads() {

        //密钥库文件
        String keystore="jwt.jks";
        //密钥库密码
        String key_password="123456";

        //密钥别名
        String alias="xd";

        //访问密码
        String password="123456";
        //文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥工厂
        KeyStoreKeyFactory Factory = new KeyStoreKeyFactory(classPathResource, key_password.toCharArray());
        //密钥对(公钥和私钥)
        KeyPair keyPair = Factory.getKeyPair(alias, password.toCharArray());
        //获取私钥
        RSAPrivateCrtKey aPrivate = (RSAPrivateCrtKey) keyPair.getPrivate();
        Map objectObjectMap = new HashMap();
        objectObjectMap.put("name","你好");
        objectObjectMap.put("sex",12);
        //生成JWT令牌
        Jwt jwt = JwtHelper.encode(JSONUtil.toJsonStr(objectObjectMap), new RsaSigner(aPrivate));
        String encoded = jwt.getEncoded();


        System.out.println(encoded);
    }

    @Test
    public void textverify(){

        //公钥
        String publickey="-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhBiPmSdXw0sZnrGaOPPgSWQOQ/yU9BkFJcQy1koQc/sWgGChGi8GUcG6ztheyn8iRsWmP6UiTFO9H5AQ8GShRkTwxA7JidBRpZnwjoRtv2bxFOK40hsH/TVTs8kJJZiSNZyJYpLvyaPZunWuy0siJdsMQvlTch4py9ITB2lP0EuPzMENk86UOz38Mn7MiXOBbOvA/d4+fnvNDrCu6Dl6BlArdGxgfM+NWYd4RfDtvGEBRbuYNERifHwDy7DrQyxmBTi99nVWu38AT+XwWmgMg+EDYv9nv7E8yu+HU+y/sztQKaq5nNQ7CEHZPhiD7NhsyVcw6Bv7T53DcG7AwTFbjwIDAQAB-----END PUBLIC KEY-----\n";
        //token
        String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZXgiOjEyLCJuYW1lIjoi5L2g5aW9In0.Tg43FBWEcolnfVM-4aR0S7K3NYmGcyk9x1wCo3NOdJwZhPhIcSHcPw-xlWeMntTUO7iRzo98A8gmLN8kgJy9YUIGpyxc-J714Q6i7csZg1lZ94YYUUuxhqMr6dXN48fCLBxcDPy6WctB3ZHZRacQ32FuQRv2AUMeI018_noNZYkKBJkb-WjtcnBfeeANkEK-aTofHH_1NyiEM3T9QeinwcLbhjWrwXFO6Vty1Kno3bu8SXH9_tyMXuwe-PBIm_qeSzq1Eo1LBlAO_1HsVVSJdRVSbsmPBI_93IwX9h8VRVzM6yjkPI70I2BsXXt6zk6b7BmfAuRf4l8DDraD22dz5A";
        //这一步校验
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));
        String claims = jwt.getClaims();
        System.out.println(claims);

    }
}
