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

@Entity
public class Desenho implements Serializable {

	public Desenho() {

	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codDesenho;

	@Column(nullable = false)
	private String dBase64;

	@Column(nullable = false)
	private String fContentType;

	@Column(nullable = false)
	private String dBase64Miniatura;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "operacao_id")
	Operacao operacao;
	
	public Long getCodDesenho() {
		return codDesenho;
	}

	public void setCodDesenho(Long codDesenho) {
		this.codDesenho = codDesenho;
	}

	public String getdBase64() {
		return dBase64;
	}

	public void setdBase64(String dBase64) {
		this.dBase64 = dBase64;
	}

	public String getfContentType() {
		return fContentType;
	}

	public void setfContentType(String fContentType) {
		this.fContentType = fContentType;
	}

	public String getdBase64Miniatura() {
		return dBase64Miniatura;
	}

	public void setdBase64Miniatura(String dBase64Miniatura) {
		this.dBase64Miniatura = dBase64Miniatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDesenho == null) ? 0 : codDesenho.hashCode());
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
		Desenho other = (Desenho) obj;
		if (codDesenho == null) {
			if (other.codDesenho != null)
				return false;
		} else if (!codDesenho.equals(other.codDesenho))
			return false;
		return true;
	}

}
