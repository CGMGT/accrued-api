package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "xx_payables_hist", schema = "", catalog = "")
public class XxPayablesHistEntity extends AbstractEntity {
    private String batchName;
    private String documentSequence;
    private String gjhPeriodName;
    private String journalName;
    private String xhEventTypeCode;
    private String accountingLineCode;
    private String eventClassCode;
    private String xlCurrencyCode;
    private String company;
    private String account;
    private String local;
    private String cc;
    private String territory;
    private String bu;
    private String category;
    private String product;
    private String project;
    private String interco;
    private String flow;
    private String future1;
    private String future2;
    private String concatenatedSegments;
    private String aidDescription;
    private String aiInvoiceNum;
    private String aiInvoiceDate;
    private String aiInvoiceAmount;
    private String vendorName;
    private String enteredDebits;
    private String enteredCredits;
    private String enteredNet;
    private String accountedCredits;
    private String accountedDebits;
    private String accountedNet;
    private String accountingDate;
    private String usuarioRegistroFact;
    private String jeSource;
    private String jeCategory;
    private String ledgerName;
    private String poNumber;
    private String poComments;
    private String poStatus;
    private String poCurrencyCode;
    private String poCombinacionContable;
    private String poCompany;
    private String poAccount;
    private String poLocal;
    private String poCc;
    private String poTerritory;
    private String poBu;
    private String poCategory;
    private String poProduct;
    private String poProject;
    private String poInterco;
    private String poFlow;
    private String poFuture1;
    private String poFuture2;
    private String fechaModificacionPo;
    private String invoiceTypeLookupCode;
    private Long id;
    private String periodo;

    @Basic
    @Column(name = "batch_name", nullable = true, length = 150)
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    @Basic
    @Column(name = "document_sequence", nullable = true, length = 150)
    public String getDocumentSequence() {
        return documentSequence;
    }

    public void setDocumentSequence(String documentSequence) {
        this.documentSequence = documentSequence;
    }

    @Basic
    @Column(name = "gjh_period_name", nullable = true, length = 150)
    public String getGjhPeriodName() {
        return gjhPeriodName;
    }

    public void setGjhPeriodName(String gjhPeriodName) {
        this.gjhPeriodName = gjhPeriodName;
    }

    @Basic
    @Column(name = "journal_name", nullable = true, length = 150)
    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    @Basic
    @Column(name = "xh_event_type_code", nullable = true, length = 150)
    public String getXhEventTypeCode() {
        return xhEventTypeCode;
    }

    public void setXhEventTypeCode(String xhEventTypeCode) {
        this.xhEventTypeCode = xhEventTypeCode;
    }

    @Basic
    @Column(name = "accounting_line_code", nullable = true, length = 150)
    public String getAccountingLineCode() {
        return accountingLineCode;
    }

    public void setAccountingLineCode(String accountingLineCode) {
        this.accountingLineCode = accountingLineCode;
    }

    @Basic
    @Column(name = "event_class_code", nullable = true, length = 150)
    public String getEventClassCode() {
        return eventClassCode;
    }

    public void setEventClassCode(String eventClassCode) {
        this.eventClassCode = eventClassCode;
    }

    @Basic
    @Column(name = "xl_currency_code", nullable = true, length = 150)
    public String getXlCurrencyCode() {
        return xlCurrencyCode;
    }

    public void setXlCurrencyCode(String xlCurrencyCode) {
        this.xlCurrencyCode = xlCurrencyCode;
    }

    @Basic
    @Column(name = "company", nullable = true, length = 150)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "account", nullable = true, length = 150)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "local", nullable = true, length = 150)
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Basic
    @Column(name = "cc", nullable = true, length = 150)
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Basic
    @Column(name = "territory", nullable = true, length = 150)
    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Basic
    @Column(name = "bu", nullable = true, length = 150)
    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    @Basic
    @Column(name = "category", nullable = true, length = 150)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "product", nullable = true, length = 150)
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "project", nullable = true, length = 150)
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Basic
    @Column(name = "interco", nullable = true, length = 150)
    public String getInterco() {
        return interco;
    }

    public void setInterco(String interco) {
        this.interco = interco;
    }

    @Basic
    @Column(name = "flow", nullable = true, length = 150)
    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    @Basic
    @Column(name = "future1", nullable = true, length = 150)
    public String getFuture1() {
        return future1;
    }

    public void setFuture1(String future1) {
        this.future1 = future1;
    }

    @Basic
    @Column(name = "future2", nullable = true, length = 150)
    public String getFuture2() {
        return future2;
    }

    public void setFuture2(String future2) {
        this.future2 = future2;
    }

    @Basic
    @Column(name = "concatenated_segments", nullable = true, length = 150)
    public String getConcatenatedSegments() {
        return concatenatedSegments;
    }

    public void setConcatenatedSegments(String concatenatedSegments) {
        this.concatenatedSegments = concatenatedSegments;
    }

    @Basic
    @Column(name = "aid_description", nullable = true, length = 500)
    public String getAidDescription() {
        return aidDescription;
    }

    public void setAidDescription(String aidDescription) {
        this.aidDescription = aidDescription;
    }

    @Basic
    @Column(name = "ai_invoice_num", nullable = true, length = 150)
    public String getAiInvoiceNum() {
        return aiInvoiceNum;
    }

    public void setAiInvoiceNum(String aiInvoiceNum) {
        this.aiInvoiceNum = aiInvoiceNum;
    }

    @Basic
    @Column(name = "ai_invoice_date", nullable = true, length = 150)
    public String getAiInvoiceDate() {
        return aiInvoiceDate;
    }

    public void setAiInvoiceDate(String aiInvoiceDate) {
        this.aiInvoiceDate = aiInvoiceDate;
    }

    @Basic
    @Column(name = "ai_invoice_amount", nullable = true, length = 150)
    public String getAiInvoiceAmount() {
        return aiInvoiceAmount;
    }

    public void setAiInvoiceAmount(String aiInvoiceAmount) {
        this.aiInvoiceAmount = aiInvoiceAmount;
    }

    @Basic
    @Column(name = "vendor_name", nullable = true, length = 250)
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Basic
    @Column(name = "entered_debits", nullable = true, length = 150)
    public String getEnteredDebits() {
        return enteredDebits;
    }

    public void setEnteredDebits(String enteredDebits) {
        this.enteredDebits = enteredDebits;
    }

    @Basic
    @Column(name = "entered_credits", nullable = true, length = 150)
    public String getEnteredCredits() {
        return enteredCredits;
    }

    public void setEnteredCredits(String enteredCredits) {
        this.enteredCredits = enteredCredits;
    }

    @Basic
    @Column(name = "entered_net", nullable = true, length = 150)
    public String getEnteredNet() {
        return enteredNet;
    }

    public void setEnteredNet(String enteredNet) {
        this.enteredNet = enteredNet;
    }

    @Basic
    @Column(name = "accounted_credits", nullable = true, length = 150)
    public String getAccountedCredits() {
        return accountedCredits;
    }

    public void setAccountedCredits(String accountedCredits) {
        this.accountedCredits = accountedCredits;
    }

    @Basic
    @Column(name = "accounted_debits", nullable = true, length = 150)
    public String getAccountedDebits() {
        return accountedDebits;
    }

    public void setAccountedDebits(String accountedDebits) {
        this.accountedDebits = accountedDebits;
    }

    @Basic
    @Column(name = "accounted_net", nullable = true, length = 150)
    public String getAccountedNet() {
        return accountedNet;
    }

    public void setAccountedNet(String accountedNet) {
        this.accountedNet = accountedNet;
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
    @Column(name = "usuario_registro_fact", nullable = true, length = 150)
    public String getUsuarioRegistroFact() {
        return usuarioRegistroFact;
    }

    public void setUsuarioRegistroFact(String usuarioRegistroFact) {
        this.usuarioRegistroFact = usuarioRegistroFact;
    }

    @Basic
    @Column(name = "je_source", nullable = true, length = 150)
    public String getJeSource() {
        return jeSource;
    }

    public void setJeSource(String jeSource) {
        this.jeSource = jeSource;
    }

    @Basic
    @Column(name = "je_category", nullable = true, length = 150)
    public String getJeCategory() {
        return jeCategory;
    }

    public void setJeCategory(String jeCategory) {
        this.jeCategory = jeCategory;
    }

    @Basic
    @Column(name = "ledger_name", nullable = true, length = 150)
    public String getLedgerName() {
        return ledgerName;
    }

    public void setLedgerName(String ledgerName) {
        this.ledgerName = ledgerName;
    }

    @Basic
    @Column(name = "po_number", nullable = true, length = 150)
    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    @Basic
    @Column(name = "po_comments", nullable = true, length = 500)
    public String getPoComments() {
        return poComments;
    }

    public void setPoComments(String poComments) {
        this.poComments = poComments;
    }

    @Basic
    @Column(name = "po_status", nullable = true, length = 150)
    public String getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(String poStatus) {
        this.poStatus = poStatus;
    }

    @Basic
    @Column(name = "po_currency_code", nullable = true, length = 150)
    public String getPoCurrencyCode() {
        return poCurrencyCode;
    }

    public void setPoCurrencyCode(String poCurrencyCode) {
        this.poCurrencyCode = poCurrencyCode;
    }

    @Basic
    @Column(name = "po_combinacion_contable", nullable = true, length = 150)
    public String getPoCombinacionContable() {
        return poCombinacionContable;
    }

    public void setPoCombinacionContable(String poCombinacionContable) {
        this.poCombinacionContable = poCombinacionContable;
    }

    @Basic
    @Column(name = "po_company", nullable = true, length = 150)
    public String getPoCompany() {
        return poCompany;
    }

    public void setPoCompany(String poCompany) {
        this.poCompany = poCompany;
    }

    @Basic
    @Column(name = "po_account", nullable = true, length = 150)
    public String getPoAccount() {
        return poAccount;
    }

    public void setPoAccount(String poAccount) {
        this.poAccount = poAccount;
    }

    @Basic
    @Column(name = "po_local", nullable = true, length = 150)
    public String getPoLocal() {
        return poLocal;
    }

    public void setPoLocal(String poLocal) {
        this.poLocal = poLocal;
    }

    @Basic
    @Column(name = "po_cc", nullable = true, length = 150)
    public String getPoCc() {
        return poCc;
    }

    public void setPoCc(String poCc) {
        this.poCc = poCc;
    }

    @Basic
    @Column(name = "po_territory", nullable = true, length = 150)
    public String getPoTerritory() {
        return poTerritory;
    }

    public void setPoTerritory(String poTerritory) {
        this.poTerritory = poTerritory;
    }

    @Basic
    @Column(name = "po_bu", nullable = true, length = 150)
    public String getPoBu() {
        return poBu;
    }

    public void setPoBu(String poBu) {
        this.poBu = poBu;
    }

    @Basic
    @Column(name = "po_category", nullable = true, length = 150)
    public String getPoCategory() {
        return poCategory;
    }

    public void setPoCategory(String poCategory) {
        this.poCategory = poCategory;
    }

    @Basic
    @Column(name = "po_product", nullable = true, length = 150)
    public String getPoProduct() {
        return poProduct;
    }

    public void setPoProduct(String poProduct) {
        this.poProduct = poProduct;
    }

    @Basic
    @Column(name = "po_project", nullable = true, length = 150)
    public String getPoProject() {
        return poProject;
    }

    public void setPoProject(String poProject) {
        this.poProject = poProject;
    }

    @Basic
    @Column(name = "po_interco", nullable = true, length = 150)
    public String getPoInterco() {
        return poInterco;
    }

    public void setPoInterco(String poInterco) {
        this.poInterco = poInterco;
    }

    @Basic
    @Column(name = "po_flow", nullable = true, length = 150)
    public String getPoFlow() {
        return poFlow;
    }

    public void setPoFlow(String poFlow) {
        this.poFlow = poFlow;
    }

    @Basic
    @Column(name = "po_future1", nullable = true, length = 150)
    public String getPoFuture1() {
        return poFuture1;
    }

    public void setPoFuture1(String poFuture1) {
        this.poFuture1 = poFuture1;
    }

    @Basic
    @Column(name = "po_future2", nullable = true, length = 150)
    public String getPoFuture2() {
        return poFuture2;
    }

    public void setPoFuture2(String poFuture2) {
        this.poFuture2 = poFuture2;
    }

    @Basic
    @Column(name = "fecha_modificacion_po", nullable = true, length = 150)
    public String getFechaModificacionPo() {
        return fechaModificacionPo;
    }

    public void setFechaModificacionPo(String fechaModificacionPo) {
        this.fechaModificacionPo = fechaModificacionPo;
    }

    @Basic
    @Column(name = "invoice_type_lookup_code", nullable = true, length = 150)
    public String getInvoiceTypeLookupCode() {
        return invoiceTypeLookupCode;
    }

    public void setInvoiceTypeLookupCode(String invoiceTypeLookupCode) {
        this.invoiceTypeLookupCode = invoiceTypeLookupCode;
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
        XxPayablesHistEntity that = (XxPayablesHistEntity) o;
        return Objects.equals(batchName, that.batchName) && Objects.equals(documentSequence, that.documentSequence) && Objects.equals(gjhPeriodName, that.gjhPeriodName) && Objects.equals(journalName, that.journalName) && Objects.equals(xhEventTypeCode, that.xhEventTypeCode) && Objects.equals(accountingLineCode, that.accountingLineCode) && Objects.equals(eventClassCode, that.eventClassCode) && Objects.equals(xlCurrencyCode, that.xlCurrencyCode) && Objects.equals(company, that.company) && Objects.equals(account, that.account) && Objects.equals(local, that.local) && Objects.equals(cc, that.cc) && Objects.equals(territory, that.territory) && Objects.equals(bu, that.bu) && Objects.equals(category, that.category) && Objects.equals(product, that.product) && Objects.equals(project, that.project) && Objects.equals(interco, that.interco) && Objects.equals(flow, that.flow) && Objects.equals(future1, that.future1) && Objects.equals(future2, that.future2) && Objects.equals(concatenatedSegments, that.concatenatedSegments) && Objects.equals(aidDescription, that.aidDescription) && Objects.equals(aiInvoiceNum, that.aiInvoiceNum) && Objects.equals(aiInvoiceDate, that.aiInvoiceDate) && Objects.equals(aiInvoiceAmount, that.aiInvoiceAmount) && Objects.equals(vendorName, that.vendorName) && Objects.equals(enteredDebits, that.enteredDebits) && Objects.equals(enteredCredits, that.enteredCredits) && Objects.equals(enteredNet, that.enteredNet) && Objects.equals(accountedCredits, that.accountedCredits) && Objects.equals(accountedDebits, that.accountedDebits) && Objects.equals(accountedNet, that.accountedNet) && Objects.equals(accountingDate, that.accountingDate) && Objects.equals(usuarioRegistroFact, that.usuarioRegistroFact) && Objects.equals(jeSource, that.jeSource) && Objects.equals(jeCategory, that.jeCategory) && Objects.equals(ledgerName, that.ledgerName) && Objects.equals(poNumber, that.poNumber) && Objects.equals(poComments, that.poComments) && Objects.equals(poStatus, that.poStatus) && Objects.equals(poCurrencyCode, that.poCurrencyCode) && Objects.equals(poCombinacionContable, that.poCombinacionContable) && Objects.equals(poCompany, that.poCompany) && Objects.equals(poAccount, that.poAccount) && Objects.equals(poLocal, that.poLocal) && Objects.equals(poCc, that.poCc) && Objects.equals(poTerritory, that.poTerritory) && Objects.equals(poBu, that.poBu) && Objects.equals(poCategory, that.poCategory) && Objects.equals(poProduct, that.poProduct) && Objects.equals(poProject, that.poProject) && Objects.equals(poInterco, that.poInterco) && Objects.equals(poFlow, that.poFlow) && Objects.equals(poFuture1, that.poFuture1) && Objects.equals(poFuture2, that.poFuture2) && Objects.equals(fechaModificacionPo, that.fechaModificacionPo) && Objects.equals(invoiceTypeLookupCode, that.invoiceTypeLookupCode) && Objects.equals(id, that.id) && Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchName, documentSequence, gjhPeriodName, journalName, xhEventTypeCode, accountingLineCode, eventClassCode, xlCurrencyCode, company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, future2, concatenatedSegments, aidDescription, aiInvoiceNum, aiInvoiceDate, aiInvoiceAmount, vendorName, enteredDebits, enteredCredits, enteredNet, accountedCredits, accountedDebits, accountedNet, accountingDate, usuarioRegistroFact, jeSource, jeCategory, ledgerName, poNumber, poComments, poStatus, poCurrencyCode, poCombinacionContable, poCompany, poAccount, poLocal, poCc, poTerritory, poBu, poCategory, poProduct, poProject, poInterco, poFlow, poFuture1, poFuture2, fechaModificacionPo, invoiceTypeLookupCode, id, periodo);
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
