/**
 * 
 */
package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author david
 *
 */
@Entity
public class Produto implements Serializable {

	public Produto() {

	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codProduto;

	@Column(length = 13, nullable = false, unique = true)
	private String pn;

	@Column(length = 45, nullable = false)
	private String cliente;

	@Column(length = 90, nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "produto")
	private List<OrdemServico> listaOs;
	
	@OneToMany(mappedBy = "produto")
	private List<Operacao> listaOperacoes;
	
	//@OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)

	public List<Operacao> getListaOperacoes() {
		return listaOperacoes;
	}

	public void setListaOperacoes(List<Operacao> listaOperacoes) {
		this.listaOperacoes = listaOperacoes;
	}

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<OrdemServico> getListaOs() {
		return listaOs;
	}

	public void setListaOs(List<OrdemServico> listaOs) {
		this.listaOs = listaOs;
	}

	@Override
	public String toString() {
		return "" + pn + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		return true;
	}

}
