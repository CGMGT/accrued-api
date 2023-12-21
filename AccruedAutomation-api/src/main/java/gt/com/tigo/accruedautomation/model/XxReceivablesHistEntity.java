package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "xx_receivables_hist", schema = "", catalog = "")
public class XxReceivablesHistEntity extends AbstractEntity {
    private String batchName;
    private String documentSequence;
    private String gjhPeriodName;
    private String journalName;
    private String xhEventTypeCode;
    private String xlCurrencyCode;
    private String accountingLineCode;
    private String eventClassCode;
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
    private String jeCategory;
    private String ledgerName;
    private String receiptNumber;
    private String receiptDate;
    private String adjustmentDocumentNumber;
    private String depositDate;
    private String type;
    private String status;
    private String currencyCode;
    private String operatingUnit;
    private String receiptMethod;
    private String bankAccount;
    private String bankName;
    private String bankBranchName;
    private String legalEntity;
    private String createdBy;
    private String emailCreated;
    private String lastUpdateBy;
    private String emailUpdated;
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
    @Column(name = "xl_currency_code", nullable = true, length = 150)
    public String getXlCurrencyCode() {
        return xlCurrencyCode;
    }

    public void setXlCurrencyCode(String xlCurrencyCode) {
        this.xlCurrencyCode = xlCurrencyCode;
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
    @Column(name = "receipt_number", nullable = true, length = 150)
    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Basic
    @Column(name = "receipt_date", nullable = true, length = 150)
    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Basic
    @Column(name = "adjustment_document_number", nullable = true, length = 150)
    public String getAdjustmentDocumentNumber() {
        return adjustmentDocumentNumber;
    }

    public void setAdjustmentDocumentNumber(String adjustmentDocumentNumber) {
        this.adjustmentDocumentNumber = adjustmentDocumentNumber;
    }

    @Basic
    @Column(name = "deposit_date", nullable = true, length = 150)
    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 150)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 150)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "currency_code", nullable = true, length = 150)
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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
    @Column(name = "receipt_method", nullable = true, length = 150)
    public String getReceiptMethod() {
        return receiptMethod;
    }

    public void setReceiptMethod(String receiptMethod) {
        this.receiptMethod = receiptMethod;
    }

    @Basic
    @Column(name = "bank_account", nullable = true, length = 150)
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "bank_name", nullable = true, length = 150)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bank_branch_name", nullable = true, length = 150)
    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    @Basic
    @Column(name = "legal_entity", nullable = true, length = 150)
    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    @Basic
    @Column(name = "created_by", nullable = true, length = 150)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "email_created", nullable = true, length = 150)
    public String getEmailCreated() {
        return emailCreated;
    }

    public void setEmailCreated(String emailCreated) {
        this.emailCreated = emailCreated;
    }

    @Basic
    @Column(name = "last_update_by", nullable = true, length = 150)
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Basic
    @Column(name = "email_updated", nullable = true, length = 150)
    public String getEmailUpdated() {
        return emailUpdated;
    }

    public void setEmailUpdated(String emailUpdated) {
        this.emailUpdated = emailUpdated;
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
        XxReceivablesHistEntity that = (XxReceivablesHistEntity) o;
        return Objects.equals(batchName, that.batchName) && Objects.equals(documentSequence, that.documentSequence) && Objects.equals(gjhPeriodName, that.gjhPeriodName) && Objects.equals(journalName, that.journalName) && Objects.equals(xhEventTypeCode, that.xhEventTypeCode) && Objects.equals(xlCurrencyCode, that.xlCurrencyCode) && Objects.equals(accountingLineCode, that.accountingLineCode) && Objects.equals(eventClassCode, that.eventClassCode) && Objects.equals(company, that.company) && Objects.equals(account, that.account) && Objects.equals(local, that.local) && Objects.equals(cc, that.cc) && Objects.equals(territory, that.territory) && Objects.equals(bu, that.bu) && Objects.equals(category, that.category) && Objects.equals(product, that.product) && Objects.equals(project, that.project) && Objects.equals(interco, that.interco) && Objects.equals(flow, that.flow) && Objects.equals(future1, that.future1) && Objects.equals(future2, that.future2) && Objects.equals(concatenatedSegments, that.concatenatedSegments) && Objects.equals(enteredDebits, that.enteredDebits) && Objects.equals(enteredCredits, that.enteredCredits) && Objects.equals(enteredNet, that.enteredNet) && Objects.equals(accountedCredits, that.accountedCredits) && Objects.equals(accountedDebits, that.accountedDebits) && Objects.equals(accountedNet, that.accountedNet) && Objects.equals(accountingDate, that.accountingDate) && Objects.equals(jeSource, that.jeSource) && Objects.equals(jeCategory, that.jeCategory) && Objects.equals(ledgerName, that.ledgerName) && Objects.equals(receiptNumber, that.receiptNumber) && Objects.equals(receiptDate, that.receiptDate) && Objects.equals(adjustmentDocumentNumber, that.adjustmentDocumentNumber) && Objects.equals(depositDate, that.depositDate) && Objects.equals(type, that.type) && Objects.equals(status, that.status) && Objects.equals(currencyCode, that.currencyCode) && Objects.equals(operatingUnit, that.operatingUnit) && Objects.equals(receiptMethod, that.receiptMethod) && Objects.equals(bankAccount, that.bankAccount) && Objects.equals(bankName, that.bankName) && Objects.equals(bankBranchName, that.bankBranchName) && Objects.equals(legalEntity, that.legalEntity) && Objects.equals(createdBy, that.createdBy) && Objects.equals(emailCreated, that.emailCreated) && Objects.equals(lastUpdateBy, that.lastUpdateBy) && Objects.equals(emailUpdated, that.emailUpdated) && Objects.equals(id, that.id) && Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchName, documentSequence, gjhPeriodName, journalName, xhEventTypeCode, xlCurrencyCode, accountingLineCode, eventClassCode, company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, future2, concatenatedSegments, enteredDebits, enteredCredits, enteredNet, accountedCredits, accountedDebits, accountedNet, accountingDate, jeSource, jeCategory, ledgerName, receiptNumber, receiptDate, adjustmentDocumentNumber, depositDate, type, status, currencyCode, operatingUnit, receiptMethod, bankAccount, bankName, bankBranchName, legalEntity, createdBy, emailCreated, lastUpdateBy, emailUpdated, id, periodo);
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
