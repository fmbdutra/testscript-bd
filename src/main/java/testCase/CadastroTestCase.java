package testCase;

//Todo testCases possuem essa estrutura
//Before-setup, test-main e teardown

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import tasks.CadastroTask;

public class CadastroTestCase {
	
	private WebDriver driver;
	private CadastroTask cadastro;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		
		this.driver.get("http://www.xiru.rs/d/trocas/homolog/usuarios/cadastrar");
		driver.manage().window().maximize(); //Maximizada para prints de tela inteira
		this.cadastro = new CadastroTask(driver);
		
	}
	
	@Test
	public void main() {
		this.cadastro.preencherCadastro( "Maria",
									"test@test.com",
									"minhasenha123",
									"minhasenha123",
									"33445566");
		
		this.cadastro.enviarFormulario();
	}
	
	@After
	public void tearDown() {
		this.driver.close();
	
	}
}
