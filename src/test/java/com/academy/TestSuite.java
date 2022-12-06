package com.academy;

import com.academy.unit.Test_UNIT_01;
import com.academy.utils.MySuiteListener;
import com.academy.utils.ParamContainer;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.io.File;
import java.util.Collections;

import static com.academy.settings.GlobalParameters.REPORT_PATH;

public class TestSuite {

    public static void main(String[] args) {
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Academy Test Suite");
        xmlSuite.setParameters(new ParamContainer().getValues());
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("Unit Test Suite");
        xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(Test_UNIT_01.class)));
        TestNG testSuite = new TestNG();
        testSuite.setXmlSuites(Collections.singletonList(xmlSuite));
        testSuite.addListener(new MySuiteListener());
        testSuite.setOutputDirectory(REPORT_PATH + File.separator + "testng-output");
        testSuite.run();
    }
}
