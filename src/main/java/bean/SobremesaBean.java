package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.SobremesaDAO;
import entidade.Sobremesa;

@ManagedBean
public class SobremesaBean {
	private Sobremesa sobremesa = new Sobremesa();
	private List<Sobremesa> lista;
	

	public String salvar() {
		try {
			SobremesaDAO.salvar(sobremesa);
			sobremesa = new Sobremesa();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Produto salvo com sucesso"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao salvar a produto"));
		}
		
		return null;
		
	}
	
	public String editar() {
		try {
			SobremesaDAO.editar(sobremesa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Produto editado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao editar a produto"));
		}
		return null;
	}
	
	public String excluir() {
		try {
			SobremesaDAO.excluir(sobremesa);
			lista.remove(sobremesa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Produto removido com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao remover produto"));
		}
		return null;
	}
	
	public Sobremesa getSobremesa() {
		return sobremesa;
	}
	public void setSobremesa(Sobremesa sobremesa) {
		this.sobremesa = sobremesa;
	}
	public List<Sobremesa> getLista() {
		if(lista == null) {
			lista = SobremesaDAO.listarTodos();
		}
		return lista;
	}
	public void setLista(List<Sobremesa> lista) {
		this.lista = lista;
	}
	
}
