package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes da Calculadora gerados com auxílio de IA")
public class CalculadoraTestIA {

    private Calculadora calculadora;

    @BeforeEach
    public void inicializa() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Soma dois números positivos")
    public void testSoma() {
        assertEquals(9, calculadora.soma(4, 5));
    }

    @Test
    @DisplayName("Soma com número negativo")
    public void testSomaComNegativo() {
        assertEquals(-1, calculadora.soma(4, -5));
    }

    @Test
    @DisplayName("Subtração de dois números")
    public void testSubtracao() {
        assertEquals(7, calculadora.subtracao(12, 5));
    }

    @Test
    @DisplayName("Subtração resultando em número negativo")
    public void testSubtracaoResultadoNegativo() {
        assertEquals(-3, calculadora.subtracao(2, 5));
    }

    @Test
    @DisplayName("Multiplicação de dois números")
    public void testMultiplicacao() {
        assertEquals(10, calculadora.multiplicacao(2, 5));
    }

    @Test
    @DisplayName("Multiplicação por zero")
    public void testMultiplicacaoPorZero() {
        assertEquals(0, calculadora.multiplicacao(5, 0));
    }

    @Test
    @DisplayName("Divisão exata entre dois números")
    public void testDivisao() {
        assertEquals(2, calculadora.divisao(8, 4));
    }

    @Test
    @DisplayName("Divisão por zero lança ArithmeticException")
    public void testDivisaoPorZeroLancaExcecao() {
        ArithmeticException excecao = assertThrows(ArithmeticException.class,
                () -> calculadora.divisao(8, 0));
        assertEquals("/ by zero", excecao.getMessage());
    }

    @Test
    @DisplayName("Somatória de 0 até n")
    public void testSomatoriaDeZeroAteN() {
        assertEquals(15, calculadora.somatoria(5));
    }

    @Test
    @DisplayName("Somatória de n igual a zero")
    public void testSomatoriaDeZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("Número positivo retorna true")
    public void testEhPositivoComNumeroPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Zero é considerado positivo pela implementação")
    public void testEhPositivoComZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Número negativo retorna false")
    public void testEhPositivoComNumeroNegativo() {
        assertFalse(calculadora.ehPositivo(-1));
    }

    @Test
    @DisplayName("Compara dois números iguais")
    public void testComparaNumerosIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    @DisplayName("Compara quando o primeiro número é maior")
    public void testComparaPrimeiroMaior() {
        assertEquals(1, calculadora.compara(10, 5));
    }

    @Test
    @DisplayName("Compara quando o primeiro número é menor")
    public void testComparaPrimeiroMenor() {
        assertEquals(-1, calculadora.compara(3, 5));
    }
}
