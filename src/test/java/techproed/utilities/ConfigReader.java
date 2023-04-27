package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;

public class ConfigReader {
    //önce properties dosyasinda ki verileri okuyabilmek icin java'dan properties classindan bir obje olustururuz.
    public static Properties properties;

    //Herseyden önce calismasi icin static block icerisinde olusturmus oldugun properties dosyasini tanimlar
    //ve atamasini yapariz. FileInputStream ile dosya yolunu akusa aliriz.

    static {
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties=new Properties(); //objeyi olusturduk ve atamasini gerceklestirdik.
            properties.load(fis); //fis'in okudugu bilgileri propertiesE' yükledik
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //properties dosyasindaki key degerini alip test methodumda kullanabilmek icin bir mehod olusturmaliyiz.
    public static String getProperty(String Key){ //String bir deger döndürmesi icin String bir parametre atariz.
        /*
        Test methodundan gönderdigimiz string key degerini alip ConfigReader class'indan
        getProperty() methodunu kullanarak bu key'E ait value'yu bize getirir.
         */


        return properties.getProperty(Key);
    }

}
