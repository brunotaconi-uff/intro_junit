package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Testes do Carrinho gerados com auxílio de IA")
public class CarrinhoTestIA {

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
    @DisplayName("Carrinho novo começa vazio")
    public void testCarrinhoComecaVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertTrue(carrinho.getValorTotal() == 0.0);
    }

    @Test
    @DisplayName("Adicionar um item aumenta a quantidade")
    public void testAddItemAumentaQuantidade() {
        carrinho.addItem(livro);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Valor total com um único item")
    public void testValorTotalComUmItem() {
        carrinho.addItem(livro);
        assertEquals(100.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Valor total soma todos os itens adicionados")
    public void testValorTotalComVariosItens() {
        carrinho.addItem(livro);
        carrinho.addItem(caderno);
        assertEquals(115.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Remover um item existente reduz a quantidade e o valor total")
    public void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(livro);
        carrinho.addItem(caderno);

        carrinho.removeItem(caderno);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(100.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Remover um item inexistente lança ProdutoNaoEncontradoException")
    public void testRemoveItemInexistenteLancaExcecao() {
        carrinho.addItem(livro);

        assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(caderno));
    }

    @Test
    @DisplayName("Remover de um carrinho vazio lança ProdutoNaoEncontradoException")
    public void testRemoveDeCarrinhoVazioLancaExcecao() {
        assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(livro));
    }

    @Test
    @DisplayName("Esvaziar o carrinho zera a quantidade de itens")
    public void testEsvaziaZeraQuantidade() {
        carrinho.addItem(livro);
        carrinho.addItem(caderno);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertTrue(carrinho.getValorTotal() == 0.0);
    }

    @Test
    @DisplayName("Adicionar o mesmo produto duas vezes conta como dois itens")
    public void testAddMesmoProdutoDuasVezes() {
        carrinho.addItem(livro);
        carrinho.addItem(livro);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(200.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Produto.equals compara só pelo nome, então removeItem ignora o preço")
    public void testRemoveIgnoraPrecoPorCausaDoEqualsDeProduto() throws ProdutoNaoEncontradoException {
        Produto livroPromocional = new Produto(livro.getNome(), 50.00);
        carrinho.addItem(livro);

        carrinho.removeItem(livroPromocional);

        assertEquals(0, carrinho.getQtdeItems());
    }
}
