/**
 * 
 */
package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public TipoUsuario() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codTipo;

	@Column(length = 45, nullable = false)
	private String descricao;

	@Column(length = 45, nullable = false)
	private String setor;
	
	@OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.EAGER)
	List<Usuario> listaUsuarios;

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Long getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(Long codTipo) {
		this.codTipo = codTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return " " + descricao + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTipo == null) ? 0 : codTipo.hashCode());
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
		TipoUsuario other = (TipoUsuario) obj;
		if (codTipo == null) {
			if (other.codTipo != null)
				return false;
		} else if (!codTipo.equals(other.codTipo))
			return false;
		return true;
	}

}
