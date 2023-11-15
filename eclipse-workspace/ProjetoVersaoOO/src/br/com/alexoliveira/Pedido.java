/**
 * 
 */
package br.com.alexoliveira;

/**
 * @author alex.oliveira
 *
 */
public class Pedido {
	private Cliente cliente;
	private Vendedor vendedor;
	private ItemVenda[] itens;
	
	public Pedido(Cliente cliente, Vendedor vendedor, ItemVenda[] itens) {
		super();
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public ItemVenda[] getItens() {
		return itens;
	}

	public void setItens(ItemVenda[] itens) {
		this.itens = itens;
	}
	
	
	public float calcularComissaPedido() {
		return calcularValorTotalPedido()*vendedor.getPercentualComissao();
	}
	
	
	private float calcularValorTotalPedido() {
		float valorTotal = 0;
		for(ItemVenda item : itens) {
			valorTotal = valorTotal + item.calcularValorTotalItem();
		}
		return valorTotal;
	}

	public void realizarVenda() {
		//Remove os produtos vendidos do estoque
		for(ItemVenda itemVenda :getItens()) {
			Produto produto = itemVenda.getProduto();
			String nomeProduto = produto.getNome();
			float valorProduto = produto.getValor();
			int estoqueProduto = produto.getEstoque();
			int qtdeItem = itemVenda.getQuantidade();
			float totalItem = itemVenda.calcularValorTotalItem();
			produto.saidaEstoque(qtdeItem);
			System.out.println("Item Pedido: Produto:");
			System.out.println("   Nome do produto = " + nomeProduto);
			System.out.println("   Estoque anterior = " +  estoqueProduto);
			System.out.println("    Quantidade item = " + qtdeItem);
			System.out.printf("    		valor = R$%.2f\n",  totalItem);
			System.out.printf("        Total item = R$%.2f\n" , totalItem);

			
		}
		// Busaca nome do vendedor e calcula a comissão
		float percentualComissao = getVendedor().getPercentualComissao();
		String nomeVendedor = getVendedor().getNome();
		System.out.println("Nome do vendedor: " + nomeVendedor);
		System.out.println("Percentua da comissão: " + percentualComissao);
		
		//Busca nome do cliente
		String nomeCliente = getCliente().getNome();
		String enderecoCLiente = getCliente().getEndereco();
		System.out.println("Nome do cliente: " + nomeCliente);
		System.out.println("Endereço do cliente: " + enderecoCLiente);
		
		// Acessa os dados totais
		float totalPedido = calcularValorTotalPedido();
		float totalComissa = calcularComissaPedido();
		System.out.printf("Valor total do pedido: R$%.2f\n" , totalPedido);
		System.out.printf("Valor total da comissão: R$%.2f\n" , totalComissa);
		
	}
}