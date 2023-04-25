package techproed.tests.day22_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    /*
    @Test: Testlerimizi yazmak icin kullandigimiz notasyon.
    @BeforeSuite: Her bir test suite'nden önce bir kez calisir.
    @AfterSuite:  Her bir test suite'nden sonra bir kez calisir.
    @BeforeTest: Her bir test öncesi bir kez calisir.
    @AfterTest: Her bir test sonrasi bir kez calisir.
    @BeforeClass: Her bir class'tan önce bir kez calisir.
    @AfterClass: Her bir class'tan sonra bir kez calisir.
    @BeforeMethod: Her bir test methodundan önce bir kez önce calisir.--> Junit'deki '@Before'
    @AfterMethod: Her bir test methodundan sonra bir kez önce calisir.--> Junit'deki '@After'
    --TestNG de @BeforeGroups,@AfterGroups,@FindBy gibi notasyonlar da vardir.Bunlari ileriki konularda görecegiz.
    --Junit'te @BeforeClass ve @AfterClass notasyoyuna sahip metodlar static olmak ZORUNDAYDI.
    --TestNG frameworkunde böyle bir zorunluluk yoktur.
     */

    @Test
    public void test1(){
        System.out.println("Test 1 Calisti");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 Calisti");
    }

    @Test
    public void test3(){
        System.out.println("Test 3 Calisti");
    }

    @Test
    public void test4(){
        System.out.println("Test 4 Calisti");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }

}
