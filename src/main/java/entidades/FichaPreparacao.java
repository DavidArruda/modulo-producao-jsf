/**
 * 
 */
package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author david
 *
 */

@Entity
public class FichaPreparacao implements Serializable {

	public FichaPreparacao() {

	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codFicha;

	@Column(nullable = false)
	private String fBase64;

	@Column(nullable = false)
	private String fContentType;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "operacao_id")
	private Operacao operacao;

	public Long getCodFicha() {
		return codFicha;
	}

	public void setCodFicha(Long codFicha) {
		this.codFicha = codFicha;
	}

	public String getfBase64() {
		return fBase64;
	}

	public void setfBase64(String fBase64) {
		this.fBase64 = fBase64;
	}

	public String getfContentType() {
		return fContentType;
	}

	public void setfContentType(String fContentType) {
		this.fContentType = fContentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFicha == null) ? 0 : codFicha.hashCode());
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
		FichaPreparacao other = (FichaPreparacao) obj;
		if (codFicha == null) {
			if (other.codFicha != null)
				return false;
		} else if (!codFicha.equals(other.codFicha))
			return false;
		return true;
	}

}
