package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Apontamento implements Serializable {
	
	public Apontamento() {

	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codApontamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date inicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date termino;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "operacao_id")
	private Operacao operacao;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "os_id")
	private OrdemServico ordemServico;

	public Long getCodApontamento() {
		return codApontamento;
	}

	public void setCodApontamento(Long codApontamento) {
		this.codApontamento = codApontamento;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public OrdemServico getOrdem_servico() {
		return ordemServico;
	}

	public void setOrdem_servico(OrdemServico ordem_servico) {
		this.ordemServico = ordem_servico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codApontamento == null) ? 0 : codApontamento.hashCode());
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
		Apontamento other = (Apontamento) obj;
		if (codApontamento == null) {
			if (other.codApontamento != null)
				return false;
		} else if (!codApontamento.equals(other.codApontamento))
			return false;
		return true;
	}

}
