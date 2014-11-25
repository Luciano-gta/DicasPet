package br.com.dicaspet.model;

import java.io.Serializable;
import java.util.Date;

public class UsuarioServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3740663057346055248L;
    private UsuarioServico pk = new UsuarioServico();


    private String status_servico_confirmacao;
   
    private Long ptsv_id;

    private Date data_agendamento;

    public UsuarioServico getPk() {
            return pk;
    }

    public void setPk(UsuarioServico pk) {
            this.pk = pk;
    }

     public boolean equals(Object o) {
             if (this == o)
             return true;
             if (o == null || getClass() != o.getClass())
             return false;
             
             UsuarioServico that = (UsuarioServico) o;
             
             if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null)
             return false;
             
             return true;
             }
     
     
     public Usuario getUsuario() {
     return this.getPk().getUsuario();
     }
     
     
     public Servico getServico() {
     return this.getPk().getServico();
     }
     
     public int hashCode() {
             return (getPk() != null ? getPk().hashCode() : 0);
             }

    public String getStatus_servico_confirmacao() {
            return status_servico_confirmacao;
    }

    public void setStatus_servico_confirmacao(String status_servico_confirmacao) {
            this.status_servico_confirmacao = status_servico_confirmacao;
    }

    public Date getData_agendamento() {
            return data_agendamento;
    }

    public void setData_agendamento(Date data_agendamento) {
            this.data_agendamento = data_agendamento;
    }

    public Long getPtsv_id() {
            return ptsv_id;
    }

    public void setPtsv_id(Long ptsv_id) {
            this.ptsv_id = ptsv_id;
    }

    public static long getSerialversionuid() {
            return serialVersionUID;
    }

}
