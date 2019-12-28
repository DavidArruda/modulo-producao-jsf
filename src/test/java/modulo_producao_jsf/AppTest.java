package modulo_producao_jsf;

import javax.persistence.Persistence;

import org.junit.Ignore;
import org.junit.Test;

import dao.DaoGeneric;
import entidades.Produto;
import entidades.TipoUsuario;
import entidades.Usuario;


/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	@Ignore
	public void testeHibernate() {
		Persistence.createEntityManagerFactory("modulo-producao-jsf");
	}
	
	
	@Test
	@Ignore
	public void testTipoUsuario() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		TipoUsuario tipoUsuario = new TipoUsuario();
		
		tipoUsuario.setDescricao("Lider de Qualidade");
		tipoUsuario.setSetor("Qualidade");	
		
		daoGeneric.salvar(tipoUsuario);
		
	}
	
	@Test
	@Ignore
	public void testProduto() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		Produto produto = new Produto();
		produto.setPn("170-39318-004");
		produto.setDescricao("Asa E");
		produto.setCliente("Ind Aeronautica");
		
		daoGeneric.salvar(produto);
		
	}
	
	
	@Test
	public void testeTipoUsuario() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		TipoUsuario tipoUsuario = (TipoUsuario) daoGeneric.pesquisar2(2L, TipoUsuario.class);
		
		Usuario usuario = new Usuario();
		usuario.setNome("David");
		usuario.setSobrenome("Arruda");
		usuario.setLogin("d.arruda");
		usuario.setSenha("123");
		usuario.setTipo_usuario(tipoUsuario);
		
		daoGeneric.updateMerge(usuario);
	}
	
	@Test
	@Ignore
	public void testeFicha() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		TipoUsuario tipoUsuario = (TipoUsuario) daoGeneric.pesquisar2(2L, TipoUsuario.class);
		
		Usuario usuario = new Usuario();
		usuario.setNome("David Salomão");
		usuario.setSobrenome("Arruda");
		usuario.setLogin("a.david");
		usuario.setSenha("123");
		usuario.setTipo_usuario(tipoUsuario);
		
		daoGeneric.updateMerge(usuario);
	}
	
}
