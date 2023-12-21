package gt.com.tigo.accruedautomation.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "xxx_cost", schema = "", catalog = "")
public class XxxCostEntity {
    private Long id;
    private String batchName;
    private String documentSequence;
    private String gjhPeriodName;
    private String journalName;
    private String jeCategory;
    private String xhEventTypeCode;
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
    private String enteredDebits;
    private String enteredCredits;
    private String enteredNet;
    private String accountedCredits;
    private String accountedDebits;
    private String accountedNet;
    private String accountingDate;
    private String jeSource;
    private String poNumber;
    private String receiptNumber;
    private String documentDescription;
    private String documentDate;
    private String partyName;
    private String exchangeRate;
    private String sourceDocQuantity;
    private String item;
    private String itemDescription;
    private String ledgerName;
    private String comments;
    private String poStatus;
    private String poCurrencyCode;
    private String combinacionContablePo;
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
    private String prLineNum;
    private String uom;
    private String quantity;
    private String unitCost;
    private String requesterEmail;
    private String requisitionNumber;
    private String description;
    private String reqStatus;
    private String requisitionType;
    private String creatorName;
    private String creatorEmail;
    private String transactionDate;
    private String transactionTypeName;
    private String transactionReference;
    private String transactionId;
    private String organizationName;

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
    @Column(name = "batch_name", nullable = true, length = 250)
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
    @Column(name = "je_category", nullable = true, length = 150)
    public String getJeCategory() {
        return jeCategory;
    }

    public void setJeCategory(String jeCategory) {
        this.jeCategory = jeCategory;
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
    @Column(name = "je_source", nullable = true, length = 150)
    public String getJeSource() {
        return jeSource;
    }

    public void setJeSource(String jeSource) {
        this.jeSource = jeSource;
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
    @Column(name = "receipt_number", nullable = true, length = 150)
    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Basic
    @Column(name = "document_description", nullable = true, length = 1000)
    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    @Basic
    @Column(name = "document_date", nullable = true, length = 50)
    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    @Basic
    @Column(name = "party_name", nullable = true, length = 150)
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    @Basic
    @Column(name = "exchange_rate", nullable = true, length = 150)
    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Basic
    @Column(name = "source_doc_quantity", nullable = true, length = 150)
    public String getSourceDocQuantity() {
        return sourceDocQuantity;
    }

    public void setSourceDocQuantity(String sourceDocQuantity) {
        this.sourceDocQuantity = sourceDocQuantity;
    }

    @Basic
    @Column(name = "item", nullable = true, length = 150)
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "item_description", nullable = true, length = 1000)
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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
    @Column(name = "comments", nullable = true, length = 1000)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
    @Column(name = "combinacion_contable_po", nullable = true, length = 150)
    public String getCombinacionContablePo() {
        return combinacionContablePo;
    }

    public void setCombinacionContablePo(String combinacionContablePo) {
        this.combinacionContablePo = combinacionContablePo;
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
    @Column(name = "pr_line_num", nullable = true, length = 150)
    public String getPrLineNum() {
        return prLineNum;
    }

    public void setPrLineNum(String prLineNum) {
        this.prLineNum = prLineNum;
    }

    @Basic
    @Column(name = "uom", nullable = true, length = 150)
    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    @Basic
    @Column(name = "quantity", nullable = true, length = 150)
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit_cost", nullable = true, length = 150)
    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    @Basic
    @Column(name = "requester_email", nullable = true, length = 150)
    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    @Basic
    @Column(name = "requisition_number", nullable = true, length = 150)
    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "req_status", nullable = true, length = 150)
    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    @Basic
    @Column(name = "requisition_type", nullable = true, length = 150)
    public String getRequisitionType() {
        return requisitionType;
    }

    public void setRequisitionType(String requisitionType) {
        this.requisitionType = requisitionType;
    }

    @Basic
    @Column(name = "creator_name", nullable = true, length = 150)
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Basic
    @Column(name = "creator_email", nullable = true, length = 150)
    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    @Basic
    @Column(name = "transaction_date", nullable = true, length = 50)
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "transaction_type_name", nullable = true, length = 150)
    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @Basic
    @Column(name = "transaction_reference", nullable = true, length = 1000)
    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    @Basic
    @Column(name = "transaction_id", nullable = true, length = 150)
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "organization_name", nullable = true, length = 250)
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxxCostEntity that = (XxxCostEntity) o;
        return Objects.equals(batchName, that.batchName) &&
                Objects.equals(documentSequence, that.documentSequence) &&
                Objects.equals(gjhPeriodName, that.gjhPeriodName) &&
                Objects.equals(journalName, that.journalName) &&
                Objects.equals(jeCategory, that.jeCategory) &&
                Objects.equals(xhEventTypeCode, that.xhEventTypeCode) &&
                Objects.equals(xlCurrencyCode, that.xlCurrencyCode) &&
                Objects.equals(company, that.company) &&
                Objects.equals(account, that.account) &&
                Objects.equals(local, that.local) &&
                Objects.equals(cc, that.cc) &&
                Objects.equals(territory, that.territory) &&
                Objects.equals(bu, that.bu) &&
                Objects.equals(category, that.category) &&
                Objects.equals(product, that.product) &&
                Objects.equals(project, that.project) &&
                Objects.equals(interco, that.interco) &&
                Objects.equals(flow, that.flow) &&
                Objects.equals(future1, that.future1) &&
                Objects.equals(future2, that.future2) &&
                Objects.equals(concatenatedSegments, that.concatenatedSegments) &&
                Objects.equals(enteredDebits, that.enteredDebits) &&
                Objects.equals(enteredCredits, that.enteredCredits) &&
                Objects.equals(enteredNet, that.enteredNet) &&
                Objects.equals(accountedCredits, that.accountedCredits) &&
                Objects.equals(accountedDebits, that.accountedDebits) &&
                Objects.equals(accountedNet, that.accountedNet) &&
                Objects.equals(accountingDate, that.accountingDate) &&
                Objects.equals(jeSource, that.jeSource) &&
                Objects.equals(poNumber, that.poNumber) &&
                Objects.equals(receiptNumber, that.receiptNumber) &&
                Objects.equals(documentDescription, that.documentDescription) &&
                Objects.equals(documentDate, that.documentDate) &&
                Objects.equals(partyName, that.partyName) &&
                Objects.equals(exchangeRate, that.exchangeRate) &&
                Objects.equals(sourceDocQuantity, that.sourceDocQuantity) &&
                Objects.equals(item, that.item) &&
                Objects.equals(itemDescription, that.itemDescription) &&
                Objects.equals(ledgerName, that.ledgerName) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(poStatus, that.poStatus) &&
                Objects.equals(poCurrencyCode, that.poCurrencyCode) &&
                Objects.equals(combinacionContablePo, that.combinacionContablePo) &&
                Objects.equals(poCompany, that.poCompany) &&
                Objects.equals(poAccount, that.poAccount) &&
                Objects.equals(poLocal, that.poLocal) &&
                Objects.equals(poCc, that.poCc) &&
                Objects.equals(poTerritory, that.poTerritory) &&
                Objects.equals(poBu, that.poBu) &&
                Objects.equals(poCategory, that.poCategory) &&
                Objects.equals(poProduct, that.poProduct) &&
                Objects.equals(poProject, that.poProject) &&
                Objects.equals(poInterco, that.poInterco) &&
                Objects.equals(poFlow, that.poFlow) &&
                Objects.equals(poFuture1, that.poFuture1) &&
                Objects.equals(poFuture2, that.poFuture2) &&
                Objects.equals(fechaModificacionPo, that.fechaModificacionPo) &&
                Objects.equals(prLineNum, that.prLineNum) &&
                Objects.equals(uom, that.uom) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(unitCost, that.unitCost) &&
                Objects.equals(requesterEmail, that.requesterEmail) &&
                Objects.equals(requisitionNumber, that.requisitionNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(reqStatus, that.reqStatus) &&
                Objects.equals(requisitionType, that.requisitionType) &&
                Objects.equals(creatorName, that.creatorName) &&
                Objects.equals(creatorEmail, that.creatorEmail) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(transactionTypeName, that.transactionTypeName) &&
                Objects.equals(transactionReference, that.transactionReference) &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(organizationName, that.organizationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchName, documentSequence, gjhPeriodName, journalName, jeCategory, xhEventTypeCode, xlCurrencyCode, company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, future2, concatenatedSegments, enteredDebits, enteredCredits, enteredNet, accountedCredits, accountedDebits, accountedNet, accountingDate, jeSource, poNumber, receiptNumber, documentDescription, documentDate, partyName, exchangeRate, sourceDocQuantity, item, itemDescription, ledgerName, comments, poStatus, poCurrencyCode, combinacionContablePo, poCompany, poAccount, poLocal, poCc, poTerritory, poBu, poCategory, poProduct, poProject, poInterco, poFlow, poFuture1, poFuture2, fechaModificacionPo, prLineNum, uom, quantity, unitCost, requesterEmail, requisitionNumber, description, reqStatus, requisitionType, creatorName, creatorEmail, transactionDate, transactionTypeName, transactionReference, transactionId, organizationName);
    }
}
