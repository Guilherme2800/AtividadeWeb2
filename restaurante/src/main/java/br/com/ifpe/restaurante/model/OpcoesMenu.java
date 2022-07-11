package br.com.ifpe.restaurante.model;

public enum OpcoesMenu {

	MEUS_PEDIDOS("ALL", "/pedido/meusPedidos", "Meus pedidos"), 
	CADASTRAR_PRATOS("ADM", "/prato/cadastroTela", "Cadastrar Pratos"), 
	VISUALIZAR_CLIENTES("ADM", "/cliente/telaVisualizarCliente", "Visualizar Clientes"), 
	CADASTRAR_FORMA_PAGAMENTO("ADM", "/formaPagamento/cadastroTela", "Cadastrar forma de pagamento"), 
	VISUALIZAR_PEDIDOS("ADM", "/pedido/todosPedidos", "Visualizar pedidos");

	public String tipoAcesso;
	public String url;
	public String nome;
	
	OpcoesMenu(String tipoAcesso, String url, String nome) {
		this.tipoAcesso = tipoAcesso;
		this.url = url;
		this.nome = nome;
	}
	
	public String getTipoAcesso() {
		return this.tipoAcesso;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getNome() {
		return this.nome;
	}
}
