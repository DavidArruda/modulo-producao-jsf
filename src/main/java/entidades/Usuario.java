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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author david
 *
 */
@Entity
public class Usuario implements Serializable {
	
	public Usuario() {

	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codUsuario;

	@Column(length = 45, nullable = true)
	private String nome;

	@Column(length = 45, nullable = true)
	private String sobrenome;

	@Column(length = 20, nullable = true)
	private String login;

	@Column(length = 10, nullable = true)
	private String senha;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TipoUsuario tipoUsuario;

	@OneToMany(mappedBy = "usuario")
	private List<Apontamento> listaApontamentos;

	public List<Apontamento> getListaApontamentos() {
		return listaApontamentos;
	}

	public void setListaApontamentos(List<Apontamento> listaApontamentos) {
		this.listaApontamentos = listaApontamentos;
	}

	public TipoUsuario getTipo_usuario() {
		return tipoUsuario;
	}

	public void setTipo_usuario(TipoUsuario tipo_usuario) {
		this.tipoUsuario = tipo_usuario;
	}

	public Long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUsuario == null) ? 0 : codUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codUsuario == null) {
			if (other.codUsuario != null)
				return false;
		} else if (!codUsuario.equals(other.codUsuario))
			return false;
		return true;
	}

}
