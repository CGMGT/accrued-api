package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "xx_journal_entries_hist", schema = "", catalog = "")
public class XxJournalEntriesHistEntity extends AbstractEntity {
    private String fctDt;
    private String ldgrNm;
    private String dcSqncVl;
    private String ldgrId;
    private String jrnlNmbr;
    private String lstUpdtDt;
    private String jeCtgry;
    private String jeSrc;
    private String prdDd;
    private String nmDd;
    private String crrncyCd;
    private String sttsDd;
    private String dtCrtd;
    private String actlFlg;
    private String blncdJeFlg;
    private String jeBtchId;
    private String pstdDt;
    private String dscrptnGl;
    private String rnngTtlDr;
    private String rnngTtlCr;
    private String rnngTtlAccntdDr;
    private String rnngTtlAccntdCr;
    private String crtdBy;
    private String lstUpdtdBy;
    private String effctvDt;
    private String jeLnNmbr;
    private String entrdDr;
    private String entrdCr;
    private String entrdNt;
    private String accntdDr;
    private String accntdCr;
    private String accntdNt;
    private String dscrptnGh;
    private String cmpnyDd;
    private String accntDd;
    private String lclDd;
    private String ccDd;
    private String trrtryDd;
    private String buDd;
    private String ctgryDd;
    private String prdctDd;
    private String prjctDd;
    private String intrcDd;
    private String flwDd;
    private String ftr1Dd;
    private String ftr2Dd;
    private String ppnDt;
    private String source;
    private String jrnalStdFlg;
    private Long id;
    private String periodo;

    @Basic
    @Column(name = "fct_dt", nullable = true, length = 150)
    public String getFctDt() {
        return fctDt;
    }

    public void setFctDt(String fctDt) {
        this.fctDt = fctDt;
    }

    @Basic
    @Column(name = "ldgr_nm", nullable = true, length = 150)
    public String getLdgrNm() {
        return ldgrNm;
    }

    public void setLdgrNm(String ldgrNm) {
        this.ldgrNm = ldgrNm;
    }

    @Basic
    @Column(name = "dc_sqnc_vl", nullable = true, length = 150)
    public String getDcSqncVl() {
        return dcSqncVl;
    }

    public void setDcSqncVl(String dcSqncVl) {
        this.dcSqncVl = dcSqncVl;
    }

    @Basic
    @Column(name = "ldgr_id", nullable = true, length = 150)
    public String getLdgrId() {
        return ldgrId;
    }

    public void setLdgrId(String ldgrId) {
        this.ldgrId = ldgrId;
    }

    @Basic
    @Column(name = "jrnl_nmbr", nullable = true, length = 150)
    public String getJrnlNmbr() {
        return jrnlNmbr;
    }

    public void setJrnlNmbr(String jrnlNmbr) {
        this.jrnlNmbr = jrnlNmbr;
    }

    @Basic
    @Column(name = "lst_updt_dt", nullable = true, length = 150)
    public String getLstUpdtDt() {
        return lstUpdtDt;
    }

    public void setLstUpdtDt(String lstUpdtDt) {
        this.lstUpdtDt = lstUpdtDt;
    }

    @Basic
    @Column(name = "je_ctgry", nullable = true, length = 150)
    public String getJeCtgry() {
        return jeCtgry;
    }

    public void setJeCtgry(String jeCtgry) {
        this.jeCtgry = jeCtgry;
    }

    @Basic
    @Column(name = "je_src", nullable = true, length = 150)
    public String getJeSrc() {
        return jeSrc;
    }

    public void setJeSrc(String jeSrc) {
        this.jeSrc = jeSrc;
    }

    @Basic
    @Column(name = "prd_dd", nullable = true, length = 150)
    public String getPrdDd() {
        return prdDd;
    }

    public void setPrdDd(String prdDd) {
        this.prdDd = prdDd;
    }

    @Basic
    @Column(name = "nm_dd", nullable = true, length = 150)
    public String getNmDd() {
        return nmDd;
    }

    public void setNmDd(String nmDd) {
        this.nmDd = nmDd;
    }

    @Basic
    @Column(name = "crrncy_cd", nullable = true, length = 150)
    public String getCrrncyCd() {
        return crrncyCd;
    }

    public void setCrrncyCd(String crrncyCd) {
        this.crrncyCd = crrncyCd;
    }

    @Basic
    @Column(name = "stts_dd", nullable = true, length = 150)
    public String getSttsDd() {
        return sttsDd;
    }

    public void setSttsDd(String sttsDd) {
        this.sttsDd = sttsDd;
    }

    @Basic
    @Column(name = "dt_crtd", nullable = true, length = 150)
    public String getDtCrtd() {
        return dtCrtd;
    }

    public void setDtCrtd(String dtCrtd) {
        this.dtCrtd = dtCrtd;
    }

    @Basic
    @Column(name = "actl_flg", nullable = true, length = 150)
    public String getActlFlg() {
        return actlFlg;
    }

    public void setActlFlg(String actlFlg) {
        this.actlFlg = actlFlg;
    }

    @Basic
    @Column(name = "blncd_je_flg", nullable = true, length = 150)
    public String getBlncdJeFlg() {
        return blncdJeFlg;
    }

    public void setBlncdJeFlg(String blncdJeFlg) {
        this.blncdJeFlg = blncdJeFlg;
    }

    @Basic
    @Column(name = "je_btch_id", nullable = true, length = 150)
    public String getJeBtchId() {
        return jeBtchId;
    }

    public void setJeBtchId(String jeBtchId) {
        this.jeBtchId = jeBtchId;
    }

    @Basic
    @Column(name = "pstd_dt", nullable = true, length = 150)
    public String getPstdDt() {
        return pstdDt;
    }

    public void setPstdDt(String pstdDt) {
        this.pstdDt = pstdDt;
    }

    @Basic
    @Column(name = "dscrptn_gl", nullable = true, length = 250)
    public String getDscrptnGl() {
        return dscrptnGl;
    }

    public void setDscrptnGl(String dscrptnGl) {
        this.dscrptnGl = dscrptnGl;
    }

    @Basic
    @Column(name = "rnng_ttl_dr", nullable = true, length = 150)
    public String getRnngTtlDr() {
        return rnngTtlDr;
    }

    public void setRnngTtlDr(String rnngTtlDr) {
        this.rnngTtlDr = rnngTtlDr;
    }

    @Basic
    @Column(name = "rnng_ttl_cr", nullable = true, length = 150)
    public String getRnngTtlCr() {
        return rnngTtlCr;
    }

    public void setRnngTtlCr(String rnngTtlCr) {
        this.rnngTtlCr = rnngTtlCr;
    }

    @Basic
    @Column(name = "rnng_ttl_accntd_dr", nullable = true, length = 150)
    public String getRnngTtlAccntdDr() {
        return rnngTtlAccntdDr;
    }

    public void setRnngTtlAccntdDr(String rnngTtlAccntdDr) {
        this.rnngTtlAccntdDr = rnngTtlAccntdDr;
    }

    @Basic
    @Column(name = "rnng_ttl_accntd_cr", nullable = true, length = 150)
    public String getRnngTtlAccntdCr() {
        return rnngTtlAccntdCr;
    }

    public void setRnngTtlAccntdCr(String rnngTtlAccntdCr) {
        this.rnngTtlAccntdCr = rnngTtlAccntdCr;
    }

    @Basic
    @Column(name = "crtd_by", nullable = true, length = 150)
    public String getCrtdBy() {
        return crtdBy;
    }

    public void setCrtdBy(String crtdBy) {
        this.crtdBy = crtdBy;
    }

    @Basic
    @Column(name = "lst_updtd_by", nullable = true, length = 150)
    public String getLstUpdtdBy() {
        return lstUpdtdBy;
    }

    public void setLstUpdtdBy(String lstUpdtdBy) {
        this.lstUpdtdBy = lstUpdtdBy;
    }

    @Basic
    @Column(name = "effctv_dt", nullable = true, length = 150)
    public String getEffctvDt() {
        return effctvDt;
    }

    public void setEffctvDt(String effctvDt) {
        this.effctvDt = effctvDt;
    }

    @Basic
    @Column(name = "je_ln_nmbr", nullable = true, length = 150)
    public String getJeLnNmbr() {
        return jeLnNmbr;
    }

    public void setJeLnNmbr(String jeLnNmbr) {
        this.jeLnNmbr = jeLnNmbr;
    }

    @Basic
    @Column(name = "entrd_dr", nullable = true, length = 150)
    public String getEntrdDr() {
        return entrdDr;
    }

    public void setEntrdDr(String entrdDr) {
        this.entrdDr = entrdDr;
    }

    @Basic
    @Column(name = "entrd_cr", nullable = true, length = 150)
    public String getEntrdCr() {
        return entrdCr;
    }

    public void setEntrdCr(String entrdCr) {
        this.entrdCr = entrdCr;
    }

    @Basic
    @Column(name = "entrd_nt", nullable = true, length = 150)
    public String getEntrdNt() {
        return entrdNt;
    }

    public void setEntrdNt(String entrdNt) {
        this.entrdNt = entrdNt;
    }

    @Basic
    @Column(name = "accntd_dr", nullable = true, length = 150)
    public String getAccntdDr() {
        return accntdDr;
    }

    public void setAccntdDr(String accntdDr) {
        this.accntdDr = accntdDr;
    }

    @Basic
    @Column(name = "accntd_cr", nullable = true, length = 150)
    public String getAccntdCr() {
        return accntdCr;
    }

    public void setAccntdCr(String accntdCr) {
        this.accntdCr = accntdCr;
    }

    @Basic
    @Column(name = "accntd_nt", nullable = true, length = 150)
    public String getAccntdNt() {
        return accntdNt;
    }

    public void setAccntdNt(String accntdNt) {
        this.accntdNt = accntdNt;
    }

    @Basic
    @Column(name = "dscrptn_gh", nullable = true, length = 250)
    public String getDscrptnGh() {
        return dscrptnGh;
    }

    public void setDscrptnGh(String dscrptnGh) {
        this.dscrptnGh = dscrptnGh;
    }

    @Basic
    @Column(name = "cmpny_dd", nullable = true, length = 150)
    public String getCmpnyDd() {
        return cmpnyDd;
    }

    public void setCmpnyDd(String cmpnyDd) {
        this.cmpnyDd = cmpnyDd;
    }

    @Basic
    @Column(name = "accnt_dd", nullable = true, length = 150)
    public String getAccntDd() {
        return accntDd;
    }

    public void setAccntDd(String accntDd) {
        this.accntDd = accntDd;
    }

    @Basic
    @Column(name = "lcl_dd", nullable = true, length = 150)
    public String getLclDd() {
        return lclDd;
    }

    public void setLclDd(String lclDd) {
        this.lclDd = lclDd;
    }

    @Basic
    @Column(name = "cc_dd", nullable = true, length = 150)
    public String getCcDd() {
        return ccDd;
    }

    public void setCcDd(String ccDd) {
        this.ccDd = ccDd;
    }

    @Basic
    @Column(name = "trrtry_dd", nullable = true, length = 150)
    public String getTrrtryDd() {
        return trrtryDd;
    }

    public void setTrrtryDd(String trrtryDd) {
        this.trrtryDd = trrtryDd;
    }

    @Basic
    @Column(name = "bu_dd", nullable = true, length = 150)
    public String getBuDd() {
        return buDd;
    }

    public void setBuDd(String buDd) {
        this.buDd = buDd;
    }

    @Basic
    @Column(name = "ctgry_dd", nullable = true, length = 150)
    public String getCtgryDd() {
        return ctgryDd;
    }

    public void setCtgryDd(String ctgryDd) {
        this.ctgryDd = ctgryDd;
    }

    @Basic
    @Column(name = "prdct_dd", nullable = true, length = 150)
    public String getPrdctDd() {
        return prdctDd;
    }

    public void setPrdctDd(String prdctDd) {
        this.prdctDd = prdctDd;
    }

    @Basic
    @Column(name = "prjct_dd", nullable = true, length = 150)
    public String getPrjctDd() {
        return prjctDd;
    }

    public void setPrjctDd(String prjctDd) {
        this.prjctDd = prjctDd;
    }

    @Basic
    @Column(name = "intrc_dd", nullable = true, length = 150)
    public String getIntrcDd() {
        return intrcDd;
    }

    public void setIntrcDd(String intrcDd) {
        this.intrcDd = intrcDd;
    }

    @Basic
    @Column(name = "flw_dd", nullable = true, length = 150)
    public String getFlwDd() {
        return flwDd;
    }

    public void setFlwDd(String flwDd) {
        this.flwDd = flwDd;
    }

    @Basic
    @Column(name = "ftr1_dd", nullable = true, length = 150)
    public String getFtr1Dd() {
        return ftr1Dd;
    }

    public void setFtr1Dd(String ftr1Dd) {
        this.ftr1Dd = ftr1Dd;
    }

    @Basic
    @Column(name = "ftr2_dd", nullable = true, length = 150)
    public String getFtr2Dd() {
        return ftr2Dd;
    }

    public void setFtr2Dd(String ftr2Dd) {
        this.ftr2Dd = ftr2Dd;
    }

    @Basic
    @Column(name = "ppn_dt", nullable = true, length = 150)
    public String getPpnDt() {
        return ppnDt;
    }

    public void setPpnDt(String ppnDt) {
        this.ppnDt = ppnDt;
    }

    @Basic
    @Column(name = "source", nullable = true, length = 150)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "jrnal_std_flg", nullable = true, length = 150)
    public String getJrnalStdFlg() {
        return jrnalStdFlg;
    }

    public void setJrnalStdFlg(String jrnalStdFlg) {
        this.jrnalStdFlg = jrnalStdFlg;
    }

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "periodo", nullable = true, length = 50)
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxJournalEntriesHistEntity that = (XxJournalEntriesHistEntity) o;
        return Objects.equals(fctDt, that.fctDt) && Objects.equals(ldgrNm, that.ldgrNm) && Objects.equals(dcSqncVl, that.dcSqncVl) && Objects.equals(ldgrId, that.ldgrId) && Objects.equals(jrnlNmbr, that.jrnlNmbr) && Objects.equals(lstUpdtDt, that.lstUpdtDt) && Objects.equals(jeCtgry, that.jeCtgry) && Objects.equals(jeSrc, that.jeSrc) && Objects.equals(prdDd, that.prdDd) && Objects.equals(nmDd, that.nmDd) && Objects.equals(crrncyCd, that.crrncyCd) && Objects.equals(sttsDd, that.sttsDd) && Objects.equals(dtCrtd, that.dtCrtd) && Objects.equals(actlFlg, that.actlFlg) && Objects.equals(blncdJeFlg, that.blncdJeFlg) && Objects.equals(jeBtchId, that.jeBtchId) && Objects.equals(pstdDt, that.pstdDt) && Objects.equals(dscrptnGl, that.dscrptnGl) && Objects.equals(rnngTtlDr, that.rnngTtlDr) && Objects.equals(rnngTtlCr, that.rnngTtlCr) && Objects.equals(rnngTtlAccntdDr, that.rnngTtlAccntdDr) && Objects.equals(rnngTtlAccntdCr, that.rnngTtlAccntdCr) && Objects.equals(crtdBy, that.crtdBy) && Objects.equals(lstUpdtdBy, that.lstUpdtdBy) && Objects.equals(effctvDt, that.effctvDt) && Objects.equals(jeLnNmbr, that.jeLnNmbr) && Objects.equals(entrdDr, that.entrdDr) && Objects.equals(entrdCr, that.entrdCr) && Objects.equals(entrdNt, that.entrdNt) && Objects.equals(accntdDr, that.accntdDr) && Objects.equals(accntdCr, that.accntdCr) && Objects.equals(accntdNt, that.accntdNt) && Objects.equals(dscrptnGh, that.dscrptnGh) && Objects.equals(cmpnyDd, that.cmpnyDd) && Objects.equals(accntDd, that.accntDd) && Objects.equals(lclDd, that.lclDd) && Objects.equals(ccDd, that.ccDd) && Objects.equals(trrtryDd, that.trrtryDd) && Objects.equals(buDd, that.buDd) && Objects.equals(ctgryDd, that.ctgryDd) && Objects.equals(prdctDd, that.prdctDd) && Objects.equals(prjctDd, that.prjctDd) && Objects.equals(intrcDd, that.intrcDd) && Objects.equals(flwDd, that.flwDd) && Objects.equals(ftr1Dd, that.ftr1Dd) && Objects.equals(ftr2Dd, that.ftr2Dd) && Objects.equals(ppnDt, that.ppnDt) && Objects.equals(source, that.source) && Objects.equals(jrnalStdFlg, that.jrnalStdFlg) && Objects.equals(id, that.id) && Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fctDt, ldgrNm, dcSqncVl, ldgrId, jrnlNmbr, lstUpdtDt, jeCtgry, jeSrc, prdDd, nmDd, crrncyCd, sttsDd, dtCrtd, actlFlg, blncdJeFlg, jeBtchId, pstdDt, dscrptnGl, rnngTtlDr, rnngTtlCr, rnngTtlAccntdDr, rnngTtlAccntdCr, crtdBy, lstUpdtdBy, effctvDt, jeLnNmbr, entrdDr, entrdCr, entrdNt, accntdDr, accntdCr, accntdNt, dscrptnGh, cmpnyDd, accntDd, lclDd, ccDd, trrtryDd, buDd, ctgryDd, prdctDd, prjctDd, intrcDd, flwDd, ftr1Dd, ftr2Dd, ppnDt, source, jrnalStdFlg, id, periodo);
    }

    @Override
    public void setFechaCreacion(Timestamp fechaCreacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setUsuarioCreacion(String usuarioCreacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setFechaModificacion(Timestamp fechaModificacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setUsuarioModificacion(String usuarioModificacion) {
        // Do nothing because field is not part of this entity.
    }
}
