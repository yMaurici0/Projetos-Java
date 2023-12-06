import java.util.List;

public class Kit {
	private int id;
	private String descricao;
	private float preco;
	private List<Componente> listaComponentes;
	
	public Kit(int i, String descricao2, float preco2, List<Componente> componenteAdd) {
		id = i;
		descricao = descricao2;
		preco = preco2;
		listaComponentes = componenteAdd;
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


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public List<Componente> getListaComponentes() {
		return listaComponentes;
	}


	public void setListaComponentes(List<Componente> listaComponentes) {
		this.listaComponentes = listaComponentes;
	}
	
	public void addComponente(Componente componente) {
        listaComponentes.add(componente);
    }
	
	public void removeComponente(Componente componente) {
        listaComponentes.remove(componente);
    }
	

	
}
