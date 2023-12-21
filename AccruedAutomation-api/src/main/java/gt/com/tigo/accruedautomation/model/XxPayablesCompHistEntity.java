package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "xx_payables_comp_hist", schema = "", catalog = "")
public class XxPayablesCompHistEntity extends AbstractEntity {
    private String company;
    private String receiptCreationDate;
    private String invoiceCurrencyCode;
    private String amount;
    private String invoiceNum;
    private String baseAmount;
    private String quantityInvoiced;
    private String unitPrice;
    private String accountingDate;
    private String receiptNum;
    private String lineNum;
    private String poLine;
    private String shipmentLineStatusCode;
    private String orgName;
    private String operatingUnit;
    private String poNum;
    private String vendorName;
    private String vendorSiteCode;
    private String lineTypeLookupCode;
    private Long id;
    private String periodo;

    @Basic
    @Column(name = "company", nullable = true, length = 150)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "receipt_creation_date", nullable = true, length = 150)
    public String getReceiptCreationDate() {
        return receiptCreationDate;
    }

    public void setReceiptCreationDate(String receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }

    @Basic
    @Column(name = "invoice_currency_code", nullable = true, length = 150)
    public String getInvoiceCurrencyCode() {
        return invoiceCurrencyCode;
    }

    public void setInvoiceCurrencyCode(String invoiceCurrencyCode) {
        this.invoiceCurrencyCode = invoiceCurrencyCode;
    }

    @Basic
    @Column(name = "amount", nullable = true, length = 150)
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "invoice_num", nullable = true, length = 150)
    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    @Basic
    @Column(name = "base_amount", nullable = true, length = 150)
    public String getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(String baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Basic
    @Column(name = "quantity_invoiced", nullable = true, length = 150)
    public String getQuantityInvoiced() {
        return quantityInvoiced;
    }

    public void setQuantityInvoiced(String quantityInvoiced) {
        this.quantityInvoiced = quantityInvoiced;
    }

    @Basic
    @Column(name = "unit_price", nullable = true, length = 150)
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "accounting_date", nullable = true, length = 150)
    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    @Basic
    @Column(name = "receipt_num", nullable = true, length = 150)
    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    @Basic
    @Column(name = "line_num", nullable = true, length = 150)
    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    @Basic
    @Column(name = "po_line", nullable = true, length = 150)
    public String getPoLine() {
        return poLine;
    }

    public void setPoLine(String poLine) {
        this.poLine = poLine;
    }

    @Basic
    @Column(name = "shipment_line_status_code", nullable = true, length = 150)
    public String getShipmentLineStatusCode() {
        return shipmentLineStatusCode;
    }

    public void setShipmentLineStatusCode(String shipmentLineStatusCode) {
        this.shipmentLineStatusCode = shipmentLineStatusCode;
    }

    @Basic
    @Column(name = "org_name", nullable = true, length = 150)
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "operating_unit", nullable = true, length = 150)
    public String getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(String operatingUnit) {
        this.operatingUnit = operatingUnit;
    }

    @Basic
    @Column(name = "po_num", nullable = true, length = 150)
    public String getPoNum() {
        return poNum;
    }

    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }

    @Basic
    @Column(name = "vendor_name", nullable = true, length = 150)
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Basic
    @Column(name = "vendor_site_code", nullable = true, length = 150)
    public String getVendorSiteCode() {
        return vendorSiteCode;
    }

    public void setVendorSiteCode(String vendorSiteCode) {
        this.vendorSiteCode = vendorSiteCode;
    }

    @Basic
    @Column(name = "line_type_lookup_code", nullable = true, length = 150)
    public String getLineTypeLookupCode() {
        return lineTypeLookupCode;
    }

    public void setLineTypeLookupCode(String lineTypeLookupCode) {
        this.lineTypeLookupCode = lineTypeLookupCode;
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
        XxPayablesCompHistEntity that = (XxPayablesCompHistEntity) o;
        return Objects.equals(company, that.company) && Objects.equals(receiptCreationDate, that.receiptCreationDate) && Objects.equals(invoiceCurrencyCode, that.invoiceCurrencyCode) && Objects.equals(amount, that.amount) && Objects.equals(invoiceNum, that.invoiceNum) && Objects.equals(baseAmount, that.baseAmount) && Objects.equals(quantityInvoiced, that.quantityInvoiced) && Objects.equals(unitPrice, that.unitPrice) && Objects.equals(accountingDate, that.accountingDate) && Objects.equals(receiptNum, that.receiptNum) && Objects.equals(lineNum, that.lineNum) && Objects.equals(poLine, that.poLine) && Objects.equals(shipmentLineStatusCode, that.shipmentLineStatusCode) && Objects.equals(orgName, that.orgName) && Objects.equals(operatingUnit, that.operatingUnit) && Objects.equals(poNum, that.poNum) && Objects.equals(vendorName, that.vendorName) && Objects.equals(vendorSiteCode, that.vendorSiteCode) && Objects.equals(lineTypeLookupCode, that.lineTypeLookupCode) && Objects.equals(id, that.id) && Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, receiptCreationDate, invoiceCurrencyCode, amount, invoiceNum, baseAmount, quantityInvoiced, unitPrice, accountingDate, receiptNum, lineNum, poLine, shipmentLineStatusCode, orgName, operatingUnit, poNum, vendorName, vendorSiteCode, lineTypeLookupCode, id, periodo);
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
