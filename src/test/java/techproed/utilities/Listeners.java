package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  implements ITestListener {
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
}
