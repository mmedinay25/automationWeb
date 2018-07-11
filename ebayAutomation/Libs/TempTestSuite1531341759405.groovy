import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/ScheduleEbay')

suiteProperties.put('name', 'ScheduleEbay')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\automationWeb\\ebayAutomation\\Reports\\ScheduleEbay\\20180711_154234\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/ScheduleEbay', suiteProperties, [new TestCaseBinding('Test Cases/ebayExercise - Iteration 1', 'Test Cases/ebayExercise',  [ 'varTalla' : '10' , 'varArticulo' : 'PUMA' , 'varCategoria' : '11450' , 'varOrdenamiento' : 'Precio + Env\u00EDo: m\u00E1s bajo primero' ,  ]), new TestCaseBinding('Test Cases/ebayExercise - Iteration 2', 'Test Cases/ebayExercise',  [ 'varTalla' : '10' , 'varArticulo' : 'PUMA' , 'varCategoria' : '11450' , 'varOrdenamiento' : 'Duraci\u00F3n: primeros en finalizar' ,  ]), new TestCaseBinding('Test Cases/ebayExercise - Iteration 3', 'Test Cases/ebayExercise',  [ 'varTalla' : '10' , 'varArticulo' : 'PUMA' , 'varCategoria' : '11450' , 'varOrdenamiento' : 'Precio + Env\u00EDo: m\u00E1s alto primero' ,  ])])
