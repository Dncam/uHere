package com.uhere.auto.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.uhere.auto.entity.enums.Uso;
import com.uhere.auto.entity.enums.convert.ConverterUso;

/**
 * TblGec generated by hbm2java
 */
@Entity
@DynamicUpdate(true)
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="dojo2")
@Table(name = "TBL_VEICULO", catalog = "uherebd")
public class TblVeiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "renavam", nullable = false, unique=true, insertable=true, updatable = false)
	@NumberFormat(style=Style.NUMBER)
	private Long renavam;

	@Column(name = "descricao", length = 300, nullable = false, unique=false, insertable=true, updatable = true)
	private String descricao;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "marca", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "marca_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblMarca tblMarca;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "modelo", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "modelo_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblModelo tblModelo;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "cambio", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "cambio_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblCambio tblCambio;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "combustivel", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "combustivel_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblCombustivel tblCombustivel;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "carroceria", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "carroceria_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblCarroceria tblCarroceria;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "cor", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "cor_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblCor tblCor;

	@Convert(converter=ConverterUso.class)
	@Column(name = "uso", precision = 1, nullable = false, unique=false, insertable=true, updatable = true)
	private Uso uso ;

	@Column(name = "anoFabricacao",precision = 6, nullable = false, unique=false, insertable=true, updatable = true)
	private Long anoFabricacao;

	@Column(name = "anoModelo", precision = 6, nullable = false, unique=false, insertable=true, updatable = true)
	private Long anoModelo;

	@Column(name = "quilometragem",  nullable = false, unique=false, insertable=true, updatable = true)
	@NumberFormat(style=Style.NUMBER)
	private Long quilometragem;

	@Column(name = "placa",  nullable = false, unique=false, insertable=true, updatable = true)
	private Integer placa;

	@Column(name = "portas",  nullable = false, unique=false, insertable=true, updatable = true)
	private Integer portas;

	@Column(name = "blindagem", precision = 1,  nullable = false, unique=false, insertable=true, updatable = true)
	private Boolean blindagem = false;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "documentacao", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "documentacao_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblDocumentacao tblDocumentacao;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name = "necessidade", referencedColumnName = "chave", foreignKey = @ForeignKey(name = "necessidade_fk"), nullable = false, unique=false, insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private TblNecessidade tblNecessidade;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(name = "TBL_VEICULO_TBL_OPCIONAIS", joinColumns = @JoinColumn(name = "renavam",nullable = false, unique=false, insertable=true, updatable = true), inverseJoinColumns = @JoinColumn(name = "chave", nullable = false, unique=false, insertable=true, updatable = true))
	@Fetch(FetchMode.SELECT)
	private List<TblOpcionais> tblOpcionais ;

	@ElementCollection
	@CollectionTable(name = "TBL_VEICULO_IMAGEM", joinColumns = @JoinColumn(name = "renavam"),schema="uherebd")
	@Column(name = "imagensVeiculo",columnDefinition="longblob",nullable=false,unique=false,insertable=true,updatable=true)
	@MapKeyColumn(name="imagemId",nullable=false,unique=false,insertable=true,updatable=true)
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="dojo2")
	private Map<Long,byte[]> fotos = new LinkedHashMap<Long,byte[]>();

	public TblVeiculo() {
		super();
	}

	public TblVeiculo(Long renavam, String descricao, TblMarca tblMarca, TblModelo tblModelo, TblCambio tblCambio,
			TblCombustivel tblCombustivel, TblCarroceria tblCarroceria, TblCor tblCor, Uso uso,
			Long anoFabricacao, Long anoModelo, Long quilometragem, Integer placa, Integer portas, Boolean blindagem,
			TblDocumentacao tblDocumentacao, TblNecessidade tblNecessidade, List<TblOpcionais> tblOpcionais,
			Map<Long, byte[]> fotos) {
		super();
		this.renavam = renavam;
		this.descricao = descricao;
		this.tblMarca = tblMarca;
		this.tblModelo = tblModelo;
		this.tblCambio = tblCambio;
		this.tblCombustivel = tblCombustivel;
		this.tblCarroceria = tblCarroceria;
		this.tblCor = tblCor;
		this.uso = uso;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.quilometragem = quilometragem;
		this.placa = placa;
		this.portas = portas;
		this.blindagem = blindagem;
		this.tblDocumentacao = tblDocumentacao;
		this.tblNecessidade = tblNecessidade;
		this.tblOpcionais = tblOpcionais;
		this.fotos = fotos;
	}

	public Long getRenavam() {
		return renavam;
	}

	public void setRenavam(Long renavam) {
		this.renavam = renavam;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TblMarca getTblMarca() {
		return tblMarca;
	}

	public void setTblMarca(TblMarca tblMarca) {
		this.tblMarca = tblMarca;
	}

	public TblModelo getTblModelo() {
		return tblModelo;
	}

	public void setTblModelo(TblModelo tblModelo) {
		this.tblModelo = tblModelo;
	}

	public TblCambio getTblCambio() {
		return tblCambio;
	}

	public void setTblCambio(TblCambio tblCambio) {
		this.tblCambio = tblCambio;
	}

	public TblCombustivel getTblCombustivel() {
		return tblCombustivel;
	}

	public void setTblCombustivel(TblCombustivel tblCombustivel) {
		this.tblCombustivel = tblCombustivel;
	}

	public TblCarroceria getTblCarroceria() {
		return tblCarroceria;
	}

	public void setTblCarroceria(TblCarroceria tblCarroceria) {
		this.tblCarroceria = tblCarroceria;
	}

	public TblCor getTblCor() {
		return tblCor;
	}

	public void setTblCor(TblCor tblCor) {
		this.tblCor = tblCor;
	}

	public Uso getUso() {
		return uso;
	}

	public void setUso(Uso uso) {
		this.uso = uso;
	}

	public Long getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Long anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Long getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Long anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Long getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Long quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

	public Integer getPortas() {
		return portas;
	}

	public void setPortas(Integer portas) {
		this.portas = portas;
	}

	public Boolean getBlindagem() {
		return blindagem;
	}

	public void setBlindagem(Boolean blindagem) {
		this.blindagem = blindagem;
	}

	public TblDocumentacao getTblDocumentacao() {
		return tblDocumentacao;
	}

	public void setTblDocumentacao(TblDocumentacao tblDocumentacao) {
		this.tblDocumentacao = tblDocumentacao;
	}

	public TblNecessidade getTblNecessidade() {
		return tblNecessidade;
	}

	public void setTblNecessidade(TblNecessidade tblNecessidade) {
		this.tblNecessidade = tblNecessidade;
	}

	public List<TblOpcionais> getTblOpcionais() {
		return tblOpcionais;
	}

	public void setTblOpcionais(List<TblOpcionais> tblOpcionais) {
		this.tblOpcionais = tblOpcionais;
	}

	public Map<Long, byte[]> getFotos() {
		return fotos;
	}

	public void setFotos(Map<Long, byte[]> fotos) {
		this.fotos = fotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
		result = prime * result + ((anoModelo == null) ? 0 : anoModelo.hashCode());
		result = prime * result + ((blindagem == null) ? 0 : blindagem.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fotos == null) ? 0 : fotos.hashCode());
		result = prime * result + ((uso == null) ? 0 : uso.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((portas == null) ? 0 : portas.hashCode());
		result = prime * result + ((quilometragem == null) ? 0 : quilometragem.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
		result = prime * result + ((tblCambio == null) ? 0 : tblCambio.hashCode());
		result = prime * result + ((tblCarroceria == null) ? 0 : tblCarroceria.hashCode());
		result = prime * result + ((tblCombustivel == null) ? 0 : tblCombustivel.hashCode());
		result = prime * result + ((tblCor == null) ? 0 : tblCor.hashCode());
		result = prime * result + ((tblDocumentacao == null) ? 0 : tblDocumentacao.hashCode());
		result = prime * result + ((tblMarca == null) ? 0 : tblMarca.hashCode());
		result = prime * result + ((tblModelo == null) ? 0 : tblModelo.hashCode());
		result = prime * result + ((tblNecessidade == null) ? 0 : tblNecessidade.hashCode());
		result = prime * result + ((tblOpcionais == null) ? 0 : tblOpcionais.hashCode());
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
		TblVeiculo other = (TblVeiculo) obj;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (anoModelo == null) {
			if (other.anoModelo != null)
				return false;
		} else if (!anoModelo.equals(other.anoModelo))
			return false;
		if (blindagem == null) {
			if (other.blindagem != null)
				return false;
		} else if (!blindagem.equals(other.blindagem))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fotos == null) {
			if (other.fotos != null)
				return false;
		} else if (!fotos.equals(other.fotos))
			return false;
		if (uso == null) {
			if (other.uso != null)
				return false;
		} else if (!uso.equals(other.uso))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (portas == null) {
			if (other.portas != null)
				return false;
		} else if (!portas.equals(other.portas))
			return false;
		if (quilometragem == null) {
			if (other.quilometragem != null)
				return false;
		} else if (!quilometragem.equals(other.quilometragem))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		if (tblCambio == null) {
			if (other.tblCambio != null)
				return false;
		} else if (!tblCambio.equals(other.tblCambio))
			return false;
		if (tblCarroceria == null) {
			if (other.tblCarroceria != null)
				return false;
		} else if (!tblCarroceria.equals(other.tblCarroceria))
			return false;
		if (tblCombustivel == null) {
			if (other.tblCombustivel != null)
				return false;
		} else if (!tblCombustivel.equals(other.tblCombustivel))
			return false;
		if (tblCor == null) {
			if (other.tblCor != null)
				return false;
		} else if (!tblCor.equals(other.tblCor))
			return false;
		if (tblDocumentacao == null) {
			if (other.tblDocumentacao != null)
				return false;
		} else if (!tblDocumentacao.equals(other.tblDocumentacao))
			return false;
		if (tblMarca == null) {
			if (other.tblMarca != null)
				return false;
		} else if (!tblMarca.equals(other.tblMarca))
			return false;
		if (tblModelo == null) {
			if (other.tblModelo != null)
				return false;
		} else if (!tblModelo.equals(other.tblModelo))
			return false;
		if (tblNecessidade == null) {
			if (other.tblNecessidade != null)
				return false;
		} else if (!tblNecessidade.equals(other.tblNecessidade))
			return false;
		if (tblOpcionais == null) {
			if (other.tblOpcionais != null)
				return false;
		} else if (!tblOpcionais.equals(other.tblOpcionais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TblVeiculo [renavam=" + renavam + ", descricao=" + descricao + ", tblMarca=" + tblMarca + ", tblModelo="
				+ tblModelo + ", tblCambio=" + tblCambio + ", tblCombustivel=" + tblCombustivel + ", tblCarroceria="
				+ tblCarroceria + ", tblCor=" + tblCor + ", uso=" + uso + ", anoFabricacao=" + anoFabricacao
				+ ", anoModelo=" + anoModelo + ", quilometragem=" + quilometragem + ", placa=" + placa + ", portas="
				+ portas + ", blindagem=" + blindagem + ", tblDocumentacao=" + tblDocumentacao + ", tblNecessidade="
				+ tblNecessidade + ", tblOpcionais=" + tblOpcionais + ", fotos=" + fotos + "]";
	}
	
}