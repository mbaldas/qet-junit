package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Testes da classe carrinho")
public class CarrinhoTest {
	
	private Carrinho carrinho;

	@BeforeEach
	public void inicializar() {
		carrinho = new Carrinho();
		Produto item = new Produto("Notebook", 3000.0);
		carrinho.addItem(item);
	}
	
	@DisplayName("Get valor total")
	@Test
	public void testGetValorTotal() {
		double valor = carrinho.getValorTotal();
		Assertions.assertEquals(3000.0, valor);
	}
	
	@DisplayName("Retornar quantidade de itens")
	@Test
	public void testGetQtdItems() {
		Assertions.assertEquals(1, carrinho.getQtdeItems());
	}
	
	@DisplayName("Esvaziar carrinho")
	@Test
	public void testEsvaziar() {
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Adicionar um item no carrinho")
	@Test
	public void testAddItem() {
		Produto item = new Produto("CaseNotebook", 50.0);
		Produto item2 = new Produto("CarregadorNotebook", 150.0);
		carrinho.addItem(item);
		carrinho.addItem(item2);
		//Fazendo assert com 3 itens pois já temos o notebook adicionado com o BeforeEach
		Assertions.assertEquals(3, carrinho.getQtdeItems());
	}
	
	@DisplayName("Remover item quando o carrinho nao esta vazio")
	@Test
	public void testRemoveItemCarrinhoComItem() throws ProdutoNaoEncontradoException {
		Produto item = new Produto("CaseNotebook", 50.0);
		carrinho.esvazia();
		carrinho.addItem(item);
		carrinho.removeItem(item);
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Remover item quando o carrinho esta vazio")
	@Test
	public void testRemoveItemCarrinhoSemItemComAssertThrows() throws ProdutoNaoEncontradoException {
		Produto item = new Produto("CaseNotebook", 50.0);
		carrinho.esvazia();
		assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(item));
	}

}
