/**
 * 
 */
package entidades;

import java.io.Serializable;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author david
 *
 */
@Entity
public class OrdemServico implements Serializable {

	public OrdemServico() {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codOs;

	@Temporal(TemporalType.DATE)
	private Date dateEmissao;

	@Temporal(TemporalType.DATE)
	private Date dataEntrega;

	@Column(length = 3, nullable = false)
	private Integer quantidade;

	@Column(length = 45, nullable = false)
	private String status;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@OneToMany(mappedBy = "ordemServico")
	private List<Apontamento> listaApontamentos;

	// private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public List<Apontamento> getListaApontamentos() {
		return listaApontamentos;
	}

	public void setListaApontamentos(List<Apontamento> listaApontamentos) {
		this.listaApontamentos = listaApontamentos;
	}

	public Long getCodOs() {
		return codOs;
	}

	public void setCodOs(Long codOs) {
		this.codOs = codOs;
	}

	public Date getDateEmissao() {
		return dateEmissao;
	}

	public void setDateEmissao(Date dateEmissao) {
		this.dateEmissao = dateEmissao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOs == null) ? 0 : codOs.hashCode());
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
		OrdemServico other = (OrdemServico) obj;
		if (codOs == null) {
			if (other.codOs != null)
				return false;
		} else if (!codOs.equals(other.codOs))
			return false;
		return true;
	}

	// public String getData() {
	// return format.format(dataEntrega);
	// }

	// public String getDataEmissao() {
	// return format.format(dateEmissao);
	// }
}
