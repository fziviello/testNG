package com.academy.unit;

import com.academy.unit.enumerative.Months;
import com.academy.unit.enumerative.Seasons;
import org.springframework.core.annotation.Order;
import org.testng.Assert;
import org.testng.annotations.*;
import java.math.BigInteger;

import static com.academy.settings.TestGroups.*;
import static org.testng.Assert.assertThrows;

public class Test_UNIT_01 {

    private Calculator calculator;
    private Costruct costruct;
    private ExampleArray exampleArray;

    @BeforeClass
    void beforeAll() {
        calculator = new Calculator();
        costruct = new Costruct();
        exampleArray = new ExampleArray();
    }

    @BeforeGroups(groups = { MATH,CONSTRUCT,ARRAY,MATRIX,ENUM,EXCEPTION,SORT })
    void beforeGroups() {
        beforeAll();
    }

    @DataProvider (name = "data-provider_bubble")
    public Object[][] bdpMethod(){
        return new Object[][] {{0,8,21,3,10}};
    }

    @DataProvider (name = "data-provider_int")
    public Object[][] fdpMethod(){
        return new Object[][] {{ 1 },{ 2 }};
    }

    @DataProvider (name = "data-provider_matrix")
    public Object[][] mdpMethod(){
        return new Object[][] {{ 5 , 4 }, { 3 , 2 },{ 4 , 1 }};
    }

    @DataProvider (name = "data-provider_string")
    public Object[][] strdpMethod(){
        return new Object[][] {{"Fabio"}, {"Riccardo"}, {"Giuseppe"}};
    }

    @DataProvider (name = "data-provider_string_int")
    public Object[][] strintdpMethod(){
        return new Object[][] {{"Fabio" , 0}, {"Riccardo" , 1}, {"Giuseppe", 2}};
    }

    @BeforeMethod
    void beforeEach() {}

    @Test(testName = "sum", groups = { MATH })
    @Order(1)
    void sum(){
        Assert.assertEquals(15, calculator.sum(10,5));
    }

    @Test(dataProvider = "data-provider_int",testName = "diff parameterized", groups = { MATH })
    @Order(2)
    void diff(int dataValue){
        Assert.assertEquals(0, calculator.diff(dataValue,dataValue));
    }

    @Test(testName = "mpy", groups = { MATH })
    @Order(3)
    void mpy(){
        Assert.assertEquals(50, calculator.mpy(10,5));
    }

    @Test(testName = "div", groups = { MATH })
    @Order(4)
    void div(){
        Assert.assertEquals(2, calculator.div(10,5));
    }

    @Test(testName = "factorial", groups = { MATH })
    @Order(5)
    void factorial(){
        Assert.assertEquals(BigInteger.valueOf(3628800), calculator.factorial(BigInteger.valueOf(10)));
    }

    @Test(testName = "module", groups = { MATH })
    @Order(6)
    void mod(){
        Assert.assertEquals(1, calculator.mod(5,2));
    }

    @Test(dataProvider = "data-provider_int", testName = "is prime", groups = { MATH })
    @Order(7)
    void prime(int dataValue){
        Assert.assertTrue(calculator.isPrime(dataValue), dataValue + " is not prime");
    }

    @Test(testName = "Exception")
    void exceptionTesting() {
        try {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> { throw new IllegalArgumentException("my exception message"); }
            );
        }
        catch (Exception e){
            Assert.assertEquals("my exception message", e.getMessage());
        }
    }

    @Test(testName = "For", groups = { CONSTRUCT })
    void _for(){
        Assert.assertEquals(10, costruct._for(0,10));
    }

    @Test(testName = "Foreach", groups = { CONSTRUCT })
    void _forEach(){
        Assert.assertEquals(3, costruct._forEach(new int[]{10, 20, 30}));
    }

    @Test(testName = "While", groups = { CONSTRUCT })
    void _while(){
        Assert.assertEquals(10, costruct._while(0,10));
    }

    @Test(testName = "Do While", groups = { CONSTRUCT })
    void _doWhile(){
        Assert.assertEquals(10, costruct._doWhile(0,10));
    }

    @Test(dataProvider = "data-provider_int", testName = "if else", groups = { CONSTRUCT })
    void _ifelse(int dataValue){
        Assert.assertTrue(costruct._ifelse(1, dataValue));
    }

    @Test(dataProvider = "data-provider_int",testName = "switch case", groups = { CONSTRUCT })
    void _switchCase(int dataValue){
        Assert.assertEquals(dataValue, costruct._switchCase(dataValue));
    }

    @Test(testName = "Pyramid", groups = { MATRIX })
    void pyramid(){
        costruct.pyramid(10);
    }

    @Test(dataProvider = "data-provider_string_int",testName = "Array", groups = { ARRAY })
    void changeValue(String value, int position){
        exampleArray.changeValue(value,position);
    }

    @Test(dataProvider = "data-provider_string",testName = "ArrayList add Item", groups = { ARRAY })
    void addItemArrayList(String value){
        exampleArray.addItemArrayList(value);
    }

    @Test(dataProvider = "data-provider_string_int", testName = "ArrayList add Item in Position", groups = { ARRAY })
    void addItemArrayListInPosition(String value, int position){
        exampleArray.addItemArrayList(value,position);
    }

    @Test(testName = "ArrayList remove Item", groups = { ARRAY })
    @Parameters({ "val_1"})
    void removeItemArrayList(int dataValue){
        exampleArray.removeItemArrayList(dataValue);
    }

    @Test(dataProvider = "data-provider_bubble",testName = "bubbleSort", groups = { ARRAY }, timeOut = 1000)
    void bubbleSort(int[] dataValue){
        Assert.assertEquals(new int[]{0,3,8,10,21}, exampleArray.bubbleSort(dataValue));
    }

    @Test(testName = "Custom ArrayList", groups = { ARRAY })
    void customArrayList(){
        exampleArray.customArrayList();
    }

    @Test(testName = "ArrayList to Json", groups = { ARRAY })
    void arrayListToJson(){
        Assert.assertEquals("[{\"name\":\"Fabio\",\"surname\":\"Ziviello\",\"age\":32},{\"name\":\"Giuseppe\",\"surname\":\"Di Biase\",\"age\":32}]",exampleArray.arrayListToJson(exampleArray.getArrayList()));
    }

    @Test(testName = "Json to Array", groups = { ARRAY })
    void jsonToArray(){
        exampleArray.jsonToArrayList("[{\"name\":\"Fabio\",\"surname\":\"Ziviello\",\"age\":32},{\"name\":\"Giuseppe\",\"surname\":\"Di Biase\",\"age\":32}]");
    }

    @Test(dataProvider = "data-provider_matrix",testName = "Matrice", groups = { MATRIX })
    void matrix(int row, int col){
        exampleArray.matrix(row, col);
    }

    @Test(testName = "Enum Season", groups = { ENUM })
    void _getSeason(){
        Assert.assertEquals(Seasons.INVERNO.name(), Months.getSeason(12));
    }

    @Test(testName = "Enum Month", groups = { ENUM })
    void _getMonth(){
        Assert.assertEquals((Months.DICEMBRE.name()).toLowerCase(), Months.getMonth(12));
    }

    @AfterMethod
    void tearDown() { }

    @AfterClass
    void tearDownAll() { }

    @AfterGroups(groups = { MATH,CONSTRUCT,ARRAY,MATRIX,ENUM,EXCEPTION,SORT })
    void afterGroups() {
        tearDownAll();
    }
}
