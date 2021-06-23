package calculadora;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes da classe calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializar() {
		calc = new Calculadora();
	}
	
	@DisplayName("Soma")
	@Test
	public void testSoma() {
		int soma = calc.soma(2, 1);		
		Assertions.assertEquals(3, soma);		
	}
	
	@DisplayName("Subtracao")
	@Test
	public void testSubtracao() {
		int subtracao = calc.subtracao(2, 1);
		Assertions.assertEquals(1, subtracao);
	}
	
	@DisplayName("Multiplicacao")
	@Test
	public void testMultiplicacao() {
		int multiplicacao = calc.multiplicacao(2, 1);
		Assertions.assertEquals(2, multiplicacao);
	}
	
	@DisplayName("Divisao")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(2, 1);
		Assertions.assertEquals(2, divisao);
	}
	
	@DisplayName("Divisao por zero")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(2, 0));
	}
	
	@DisplayName("Somatorio")
	@Test
	public void testSomatorio() {
		int somatorio = calc.somatoria(4);
		Assertions.assertEquals(10, somatoria);
	}
	
	@DisplayName("Metodo que retorna verdadeiro em caso de numero positivo")
	@Test
	public void testRetornaPositivo() {
		Assertions.assertTrue(calc.ehPositivo(4));		
	}
	
	@DisplayName("Comparacao quando os numeros sao iguais")
	@Test
	public void testComparaIguais() {
		int igual = calc.compara(1,1);
		Assertions.assertEquals(igual, 0);		
	}
	
	@DisplayName("Comparacao quando o primeiro numero e maior")
	@Test
	public void testComparaPrimeiroMaior() {
		int primeiro = calc.compara(2,1);
		Assertions.assertEquals(primeiro, 1);		
	}
	
	@DisplayName("Comparacao quando o segundo numero e maior")
	@Test
	public void testComparaSegundoMaior() {
		int segundo = calc.compara(1,2)
		Assertions.assertEquals(segundo, -1);		
	}

}
