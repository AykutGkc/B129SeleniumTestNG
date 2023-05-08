package techproed.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners  implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {
    /*
    -Listeners: TestNG de bir testin durumunu ve sonucunu izleyen ve bu duruma yanit veren bir yapidir.
    -Testlerin passed ve failed olma durumlarini, baslangic ve bitisini takip eder ve raporlayabilir.
    -Bunun icin TestNG den ITestListener arayüzünü(interface) kullaniriz. Olusturdugumuz Listeners
    class'ina ITestListener arayüzündeki methodlaru Override etmek icin implements ederiz.
     */

    @Override
    public void onStart(ITestContext context) { //BeforeClass gibi
        System.out.println("onStart Methodu - > Tüm testlerden önce tek bir sefer cagrilir."+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish Methodu - > Tüm testlerden sonra tek bir sefer cagrilir."+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) { //Before gibi
        System.out.println("onTestStart Methodu - > Her bir testden önce tek bir sefer cagrilir."+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Methodu - > PASSED olan testlerden sonra tek bir sefer cagrilir."+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Methodu - > FAILED olan testlerden sonra tek bir sefer cagrilir."+result.getName());
        ReusableMethods.fullScrennShot("onTEstFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Methodu - > SKIP(atlanan) olan testlerden sonra tek bir sefer cagrilir."+result.getName());

    }

       /*
       Bu method (retry) sadece FAIL olan test case'leri tekrar çalıştırır
       maxRetryCount ek olarak çalisma sayısıdır. Bu örnekte Fail olan test (maxRetryCount = 1) normal bir kere
       çalıştıktan sonra fail olursa 1 kez daha çalışacaktır.
        */
    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        /*
        Bu methodun amaci test notasyonlarini, siniflari, cons.lari,methodlari transform(dönüstürme) etmize
      olanak saglar.
        Bu method sayesinde Listeners sinifini .xml dosyasinda kullanabilecegiz ve istedigimiz class'lari fail
      durumunda listeners sinifi rety methodu kullanarak istedigimiz kadar tekrar calistirabiliriz.
         */
        annotation.setRetryAnalyzer(Listeners.class);
    }
}
