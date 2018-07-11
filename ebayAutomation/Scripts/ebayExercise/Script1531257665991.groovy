import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(varUrl)

WebUI.maximizeWindow()

WebUI.selectOptionByValue(findTestObject('Page_Home/cmbCategoria'), varCategoria, true)

WebUI.setText(findTestObject('Page_Home/txtArticuloBuscar'), varArticulo)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Page_Home/btnBuscar'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Page_Catalogo/cbxTalla', [('talla') : varTalla]))

WebUI.delay(2)

WebUI.takeScreenshot()

String resultados = WebUI.getText(findTestObject('Page_Catalogo/lblResultado'))

//imprimimos la cantidad de resultados de la búsqueda
println "Nro. resultados => " + resultados

//Verificamos que el check marcado se el correcto
WebUI.scrollToElement(findTestObject('Page_Catalogo/cbxTalla', [('talla') : varTalla]), 5)
WebUI.verifyElementClickable(findTestObject('Page_Catalogo/cbxTalla', [('talla') : varTalla]))

WebUI.takeScreenshot()

//Realizamos el ordemaniento de la búsqueda realizada
WebUI.mouseOver(findTestObject('Page_Catalogo/cmbOrdenamiento'))
WebUI.click(findTestObject('Page_Catalogo/cmbValorOrdenamiento', [('orden') : varOrdenamiento]))

WebUI.waitForPageLoad(10)
WebUI.takeScreenshot()

//Imprimimos los 1eros 5 productos de la lista ordenada
obtenerListaProductos(5)

WebUI.closeBrowser()



//Método para obtener los productos - precio y envío definiendo la cantidad
def obtenerListaProductos(int cantidad){
	
	def listaProductos = [];
	String producto = "", precio = "", envio = "";
	String productos = "";
	
	for(int i = 1; i <= cantidad; i++){
		producto = WebUI.getText(findTestObject('Object Repository/Page_Catalogo/lblDescripcionProducto', [('indexProd') : i])).replaceAll(',', ' ')
		precio = WebUI.getText(findTestObject('Object Repository/Page_Catalogo/lblPrecioProducto', [('indexPrecio') : i]))
		envio = WebUI.getText(findTestObject('Object Repository/Page_Catalogo/lblEnvio', [('indexEnvio') : i]))
		
		productos = producto + " | " + precio + " " + envio
		
		listaProductos.addAll(productos)
	}
	
	listaProductos.eachWithIndex { val, idx -> println " Producto ${idx + 1} => ${val}" }
		
}
