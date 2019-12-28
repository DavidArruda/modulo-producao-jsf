/**
 * 
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author david
 *
 */
@Entity
public class Operacao implements Serializable {

	public Operacao() {

	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codOperacao;

	@Column(length = 90, nullable = false)
	private String descricao;

	@Column(length = 20, nullable = false)
	private String maquina;

	@Temporal(TemporalType.TIME)
	private Date tempoEstimado;

	@Column(length = 4, nullable = false)
	private Integer nOperacao;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id")
	private Produto produto = new Produto();

	@OneToOne(mappedBy = "operacao", fetch = FetchType.EAGER)
	private Desenho desenho;
	
	@OneToOne(mappedBy = "operacao", fetch = FetchType.EAGER)
	private FichaPreparacao fichaPreparacao;

	@OneToMany(mappedBy = "operacao")
	private List<Apontamento> listaApontamentos;

	public Long getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(Long codOperacao) {
		this.codOperacao = codOperacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public Date getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(Date tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public Integer getnOperacao() {
		return nOperacao;
	}

	public void setnOperacao(Integer nOperacao) {
		this.nOperacao = nOperacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Desenho getDesenho() {
		return desenho;
	}

	public void setDesenho(Desenho desenho) {
		this.desenho = desenho;
	}

	public FichaPreparacao getFichaPreparacao() {
		return fichaPreparacao;
	}

	public void setFichaPreparacao(FichaPreparacao fichaPreparacao) {
		this.fichaPreparacao = fichaPreparacao;
	}

	public List<Apontamento> getListaApontamentos() {
		return listaApontamentos;
	}

	public void setListaApontamentos(List<Apontamento> listaApontamentos) {
		this.listaApontamentos = listaApontamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOperacao == null) ? 0 : codOperacao.hashCode());
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
		Operacao other = (Operacao) obj;
		if (codOperacao == null) {
			if (other.codOperacao != null)
				return false;
		} else if (!codOperacao.equals(other.codOperacao))
			return false;
		return true;
	}

}
