package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho carrinho;
	private Produto livro;
	private Produto caderno;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		livro = new Produto("Introducao ao Teste de Software", 100.00);
		caderno = new Produto("Caderno", 15.00);
	}

	@Test
	public void testCarrinhoComecaVazio() {
		assertEquals(0, carrinho.getQtdeItems());
	}

	@Test
	public void testAddItem() {
		carrinho.addItem(livro);
		assertEquals(1, carrinho.getQtdeItems());
	}

	@Test
	public void testValorTotalComUmItem() {
		carrinho.addItem(livro);
		assertTrue(carrinho.getValorTotal() == 100.00);
	}

	@Test
	public void testValorTotalComVariosItens() {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);
		assertEquals(115.00, carrinho.getValorTotal());
	}

	@Test
	public void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);

		carrinho.removeItem(caderno);

		assertEquals(1, carrinho.getQtdeItems());
		assertTrue(carrinho.getValorTotal() == 100.00);
	}

	@Test
	public void testRemoveItemInexistenteLancaExcecao() {
		carrinho.addItem(livro);

		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(caderno));
	}

	@Test
	public void testEsvazia() {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);

		carrinho.esvazia();

		assertEquals(0, carrinho.getQtdeItems());
	}

}
