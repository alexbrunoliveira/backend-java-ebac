package br.com.alexoliveira;

import java.util.List;

/**
 * @author alex.oliveira
 *
 */
public class Programa1 {
	public static void main(String[] args) {
	
	List<Pedido> pedidos = criarPedidos();
	for(int i=0; i<pedidos.size(); i++) {
		Pedido pedido = pedidos.get(i);
		System.out.println("*********");
		System.out.println("Iniciando venda ("+ i +")");
		pedido.realizarVenda();
		System.out.println("*********\n");

	}
}
	public static List<Pedido> criarPedidos(){
		Pedido pedido1 = criarPedido1();
		Pedido pedido2 = criarPedido2();
		Pedido pedido3 = criarPedido3();
		Pedido pedido4 = criarPedido4();
		return List.of(pedido1,pedido2,pedido3,pedido4);

	}
	
	private static Pedido criarPedido1() {
		Produto produtoMesa = cadastrarProduto(1,"Mesa",20,500);
		Cliente cliente1 = cadastrarCliente(1,"João", "Rua X, 100");
		ItemVenda[] item1= {new ItemVenda(1, produtoMesa)};
		Vendedor vendedor1 = cadastrarVendedor(1,"Vendedor 1", 0.1f);
		Pedido pedido = new Pedido(cliente1, vendedor1, item1);
		return pedido;
	}
		private static Pedido criarPedido2() {
			Produto produtoCadeira = cadastrarProduto(2,"Cadeira",20,150);
			Cliente cliente2 = cadastrarCliente(2,"Carlos", "Rua Y, 200");
			ItemVenda[] item2= {new ItemVenda(2, produtoCadeira)};
			Vendedor vendedor2 = cadastrarVendedor(2,"Vendedor 2", 0.1f);
			return new Pedido(cliente2, vendedor2, item2);
		
	}
		
		private static Pedido criarPedido3() {
			Produto produtoFogao = cadastrarProduto(3,"Fogão",5,1000);
			Cliente cliente3 = cadastrarCliente(3,"Karina", "Rua Z, 500");
			ItemVenda[] item3= {new ItemVenda(3, produtoFogao)};
			Vendedor vendedor3 = cadastrarVendedor(3,"Vendedor 3", 0.1f);
			return new Pedido(cliente3, vendedor3, item3);
	}
		private static Pedido criarPedido4() {
			Produto produtoSofa = cadastrarProduto(4,"Sofá",5,2000);
			Cliente cliente4 = cadastrarCliente(4,"Paula", "Rua A, 500");
			ItemVenda[] item4= {new ItemVenda(4, produtoSofa)};
			Vendedor vendedor4 = cadastrarVendedor(4,"Vendedor 4", 0.1f);
			return new Pedido(cliente4, vendedor4, item4);
		
	}
		
		private static Vendedor cadastrarVendedor(int codigo, String nome, float percentualComissao) {
			return new Vendedor(codigo, nome, percentualComissao);
		}
		
		private static Cliente cadastrarCliente(int codigo, String nome, String endereco) {
			return new Cliente(codigo, nome, endereco);
		}
		
		private static Produto cadastrarProduto(int codigo, String nome, int estoque, float valor) {
			return new Produto(codigo, nome, estoque, valor);
		}
}