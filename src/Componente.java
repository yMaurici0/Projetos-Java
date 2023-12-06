
public class Componente {
	private int id;
	private String descricao;
	private float precoCusto;
	private int quantidade;
	
	
	public Componente(int Id, String Desc, float PC, int Qtd) {
		id = Id;
		descricao = Desc;
		precoCusto = PC;
		quantidade = Qtd;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getPrecoCusto() {
		return precoCusto;
	}


	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
