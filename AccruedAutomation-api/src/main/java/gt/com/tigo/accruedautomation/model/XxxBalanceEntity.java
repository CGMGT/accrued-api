package gt.com.tigo.accruedautomation.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "xxx_balance", schema = "", catalog = "")
public class XxxBalanceEntity {
    private Long id;
    private String fctDt;
    private String prdCd;
    private String cmpnyCd;
    private String accntngAccntCd;
    private String lclAccntCd;
    private String cstCntrCd;
    private String trrtryCd;
    private String bsnssUntEbsCd;
    private String ctgryCd;
    private String prdctCd;
    private String prjctCd;
    private String intrcmpnyCd;
    private String flwCd;
    private String ftr1Cd;
    private String ftr2Cd;
    private String bgnBlncAmnt;
    private String prdNtAmnt;
    private String clsngBlncAmnt;
    private String crrncyCd;
    private String ldgrNm;
    private String ldgrCtgryCd;
    private String ppnDt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fct_dt", nullable = true, length = 100)
    public String getFctDt() {
        return fctDt;
    }

    public void setFctDt(String fctDt) {
        this.fctDt = fctDt;
    }

    @Basic
    @Column(name = "prd_cd", nullable = true, length = 100)
    public String getPrdCd() {
        return prdCd;
    }

    public void setPrdCd(String prdCd) {
        this.prdCd = prdCd;
    }

    @Basic
    @Column(name = "cmpny_cd", nullable = true, length = 100)
    public String getCmpnyCd() {
        return cmpnyCd;
    }

    public void setCmpnyCd(String cmpnyCd) {
        this.cmpnyCd = cmpnyCd;
    }

    @Basic
    @Column(name = "accntng_accnt_cd", nullable = true, length = 100)
    public String getAccntngAccntCd() {
        return accntngAccntCd;
    }

    public void setAccntngAccntCd(String accntngAccntCd) {
        this.accntngAccntCd = accntngAccntCd;
    }

    @Basic
    @Column(name = "lcl_accnt_cd", nullable = true, length = 100)
    public String getLclAccntCd() {
        return lclAccntCd;
    }

    public void setLclAccntCd(String lclAccntCd) {
        this.lclAccntCd = lclAccntCd;
    }

    @Basic
    @Column(name = "cst_cntr_cd", nullable = true, length = 100)
    public String getCstCntrCd() {
        return cstCntrCd;
    }

    public void setCstCntrCd(String cstCntrCd) {
        this.cstCntrCd = cstCntrCd;
    }

    @Basic
    @Column(name = "trrtry_cd", nullable = true, length = 100)
    public String getTrrtryCd() {
        return trrtryCd;
    }

    public void setTrrtryCd(String trrtryCd) {
        this.trrtryCd = trrtryCd;
    }

    @Basic
    @Column(name = "bsnss_unt_ebs_cd", nullable = true, length = 100)
    public String getBsnssUntEbsCd() {
        return bsnssUntEbsCd;
    }

    public void setBsnssUntEbsCd(String bsnssUntEbsCd) {
        this.bsnssUntEbsCd = bsnssUntEbsCd;
    }

    @Basic
    @Column(name = "ctgry_cd", nullable = true, length = 100)
    public String getCtgryCd() {
        return ctgryCd;
    }

    public void setCtgryCd(String ctgryCd) {
        this.ctgryCd = ctgryCd;
    }

    @Basic
    @Column(name = "prdct_cd", nullable = true, length = 100)
    public String getPrdctCd() {
        return prdctCd;
    }

    public void setPrdctCd(String prdctCd) {
        this.prdctCd = prdctCd;
    }

    @Basic
    @Column(name = "prjct_cd", nullable = true, length = 100)
    public String getPrjctCd() {
        return prjctCd;
    }

    public void setPrjctCd(String prjctCd) {
        this.prjctCd = prjctCd;
    }

    @Basic
    @Column(name = "intrcmpny_cd", nullable = true, length = 100)
    public String getIntrcmpnyCd() {
        return intrcmpnyCd;
    }

    public void setIntrcmpnyCd(String intrcmpnyCd) {
        this.intrcmpnyCd = intrcmpnyCd;
    }

    @Basic
    @Column(name = "flw_cd", nullable = true, length = 100)
    public String getFlwCd() {
        return flwCd;
    }

    public void setFlwCd(String flwCd) {
        this.flwCd = flwCd;
    }

    @Basic
    @Column(name = "ftr1_cd", nullable = true, length = 100)
    public String getFtr1Cd() {
        return ftr1Cd;
    }

    public void setFtr1Cd(String ftr1Cd) {
        this.ftr1Cd = ftr1Cd;
    }

    @Basic
    @Column(name = "ftr2_cd", nullable = true, length = 100)
    public String getFtr2Cd() {
        return ftr2Cd;
    }

    public void setFtr2Cd(String ftr2Cd) {
        this.ftr2Cd = ftr2Cd;
    }

    @Basic
    @Column(name = "bgn_blnc_amnt", nullable = true, length = 100)
    public String getBgnBlncAmnt() {
        return bgnBlncAmnt;
    }

    public void setBgnBlncAmnt(String bgnBlncAmnt) {
        this.bgnBlncAmnt = bgnBlncAmnt;
    }

    @Basic
    @Column(name = "prd_nt_amnt", nullable = true, length = 100)
    public String getPrdNtAmnt() {
        return prdNtAmnt;
    }

    public void setPrdNtAmnt(String prdNtAmnt) {
        this.prdNtAmnt = prdNtAmnt;
    }

    @Basic
    @Column(name = "clsng_blnc_amnt", nullable = true, length = 100)
    public String getClsngBlncAmnt() {
        return clsngBlncAmnt;
    }

    public void setClsngBlncAmnt(String clsngBlncAmnt) {
        this.clsngBlncAmnt = clsngBlncAmnt;
    }

    @Basic
    @Column(name = "crrncy_cd", nullable = true, length = 100)
    public String getCrrncyCd() {
        return crrncyCd;
    }

    public void setCrrncyCd(String crrncyCd) {
        this.crrncyCd = crrncyCd;
    }

    @Basic
    @Column(name = "ldgr_nm", nullable = true, length = 100)
    public String getLdgrNm() {
        return ldgrNm;
    }

    public void setLdgrNm(String ldgrNm) {
        this.ldgrNm = ldgrNm;
    }

    @Basic
    @Column(name = "ldgr_ctgry_cd", nullable = true, length = 100)
    public String getLdgrCtgryCd() {
        return ldgrCtgryCd;
    }

    public void setLdgrCtgryCd(String ldgrCtgryCd) {
        this.ldgrCtgryCd = ldgrCtgryCd;
    }

    @Basic
    @Column(name = "ppn_dt", nullable = true, length = 100)
    public String getPpnDt() {
        return ppnDt;
    }

    public void setPpnDt(String ppnDt) {
        this.ppnDt = ppnDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxxBalanceEntity that = (XxxBalanceEntity) o;
        return Objects.equals(fctDt, that.fctDt) &&
                Objects.equals(prdCd, that.prdCd) &&
                Objects.equals(cmpnyCd, that.cmpnyCd) &&
                Objects.equals(accntngAccntCd, that.accntngAccntCd) &&
                Objects.equals(lclAccntCd, that.lclAccntCd) &&
                Objects.equals(cstCntrCd, that.cstCntrCd) &&
                Objects.equals(trrtryCd, that.trrtryCd) &&
                Objects.equals(bsnssUntEbsCd, that.bsnssUntEbsCd) &&
                Objects.equals(ctgryCd, that.ctgryCd) &&
                Objects.equals(prdctCd, that.prdctCd) &&
                Objects.equals(prjctCd, that.prjctCd) &&
                Objects.equals(intrcmpnyCd, that.intrcmpnyCd) &&
                Objects.equals(flwCd, that.flwCd) &&
                Objects.equals(ftr1Cd, that.ftr1Cd) &&
                Objects.equals(ftr2Cd, that.ftr2Cd) &&
                Objects.equals(bgnBlncAmnt, that.bgnBlncAmnt) &&
                Objects.equals(prdNtAmnt, that.prdNtAmnt) &&
                Objects.equals(clsngBlncAmnt, that.clsngBlncAmnt) &&
                Objects.equals(crrncyCd, that.crrncyCd) &&
                Objects.equals(ldgrNm, that.ldgrNm) &&
                Objects.equals(ldgrCtgryCd, that.ldgrCtgryCd) &&
                Objects.equals(ppnDt, that.ppnDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fctDt, prdCd, cmpnyCd, accntngAccntCd, lclAccntCd, cstCntrCd, trrtryCd, bsnssUntEbsCd, ctgryCd, prdctCd, prjctCd, intrcmpnyCd, flwCd, ftr1Cd, ftr2Cd, bgnBlncAmnt, prdNtAmnt, clsngBlncAmnt, crrncyCd, ldgrNm, ldgrCtgryCd, ppnDt);
    }
}
