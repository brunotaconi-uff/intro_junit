import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste do jokenpo")
public class JokenpoTest {
    private Jokenpo jokenpo;

    @BeforeEach
    public void inicializa() {
        jokenpo = new Jokenpo();
    }

    @Test
    public void testVitoriaJogador1() {
        int resultado = jokenpo.jogar(1, 2);
        assertEquals(1, resultado); 
    }

    @Test 
    public void testVitoriaJogador2() {
        int resultado = jokenpo.jogar(2, 1);
        assertEquals(2, resultado);
    }

    @Test 
    public void testEmpate() {
        int resultado = jokenpo.jogar(1, 1);
        assertEquals(0, resultado);
    }

    @Test 
    public void testValorInvalido() {
        int resultado = jokenpo.jogar(4, 1);
        assertEquals(-1, resultado);
    }
}