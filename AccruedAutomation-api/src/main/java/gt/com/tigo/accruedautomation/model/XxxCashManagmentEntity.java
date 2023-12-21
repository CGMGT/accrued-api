package gt.com.tigo.accruedautomation.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "xxx_cash_managment", schema = "", catalog = "")
public class XxxCashManagmentEntity {
    private Long id;
    private String batchName;
    private String documentSequence;
    private String gjhPeriodName;
    private String journalName;
    private String xhEventTypeCode;
    private String xhAeHeaderId;
    private String gjlJeLineNum;
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
    private String transactionDescription;
    private String paymentCurrencyCode;
    private String bankAccountName;
    private String bankAccountNum;
    private String currencyCode;
    private String bankAccountDestination;
    private String bankAccountNumDestination;
    private String cashflowDirection;
    private String cashflowNumber;
    private String bankAccountStatementDate;

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
    @Column(name = "xh_ae_header_id", nullable = true, length = 150)
    public String getXhAeHeaderId() {
        return xhAeHeaderId;
    }

    public void setXhAeHeaderId(String xhAeHeaderId) {
        this.xhAeHeaderId = xhAeHeaderId;
    }

    @Basic
    @Column(name = "gjl_je_line_num", nullable = true, length = 150)
    public String getGjlJeLineNum() {
        return gjlJeLineNum;
    }

    public void setGjlJeLineNum(String gjlJeLineNum) {
        this.gjlJeLineNum = gjlJeLineNum;
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
    @Column(name = "transaction_description", nullable = true, length = 250)
    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    @Basic
    @Column(name = "payment_currency_code", nullable = true, length = 150)
    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    @Basic
    @Column(name = "bank_account_name", nullable = true, length = 150)
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    @Basic
    @Column(name = "bank_account_num", nullable = true, length = 150)
    public String getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(String bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
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
    @Column(name = "bank_account_destination", nullable = true, length = 150)
    public String getBankAccountDestination() {
        return bankAccountDestination;
    }

    public void setBankAccountDestination(String bankAccountDestination) {
        this.bankAccountDestination = bankAccountDestination;
    }

    @Basic
    @Column(name = "bank_account_num_destination", nullable = true, length = 150)
    public String getBankAccountNumDestination() {
        return bankAccountNumDestination;
    }

    public void setBankAccountNumDestination(String bankAccountNumDestination) {
        this.bankAccountNumDestination = bankAccountNumDestination;
    }

    @Basic
    @Column(name = "cashflow_direction", nullable = true, length = 150)
    public String getCashflowDirection() {
        return cashflowDirection;
    }

    public void setCashflowDirection(String cashflowDirection) {
        this.cashflowDirection = cashflowDirection;
    }

    @Basic
    @Column(name = "cashflow_number", nullable = true, length = 150)
    public String getCashflowNumber() {
        return cashflowNumber;
    }

    public void setCashflowNumber(String cashflowNumber) {
        this.cashflowNumber = cashflowNumber;
    }

    @Basic
    @Column(name = "bank_account_statement_date", nullable = true, length = 150)
    public String getBankAccountStatementDate() {
        return bankAccountStatementDate;
    }

    public void setBankAccountStatementDate(String bankAccountStatementDate) {
        this.bankAccountStatementDate = bankAccountStatementDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxxCashManagmentEntity that = (XxxCashManagmentEntity) o;
        return Objects.equals(batchName, that.batchName) &&
                Objects.equals(documentSequence, that.documentSequence) &&
                Objects.equals(gjhPeriodName, that.gjhPeriodName) &&
                Objects.equals(journalName, that.journalName) &&
                Objects.equals(xhEventTypeCode, that.xhEventTypeCode) &&
                Objects.equals(xhAeHeaderId, that.xhAeHeaderId) &&
                Objects.equals(gjlJeLineNum, that.gjlJeLineNum) &&
                Objects.equals(xlCurrencyCode, that.xlCurrencyCode) &&
                Objects.equals(accountingLineCode, that.accountingLineCode) &&
                Objects.equals(eventClassCode, that.eventClassCode) &&
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
                Objects.equals(jeCategory, that.jeCategory) &&
                Objects.equals(ledgerName, that.ledgerName) &&
                Objects.equals(transactionDescription, that.transactionDescription) &&
                Objects.equals(paymentCurrencyCode, that.paymentCurrencyCode) &&
                Objects.equals(bankAccountName, that.bankAccountName) &&
                Objects.equals(bankAccountNum, that.bankAccountNum) &&
                Objects.equals(currencyCode, that.currencyCode) &&
                Objects.equals(bankAccountDestination, that.bankAccountDestination) &&
                Objects.equals(bankAccountNumDestination, that.bankAccountNumDestination) &&
                Objects.equals(cashflowDirection, that.cashflowDirection) &&
                Objects.equals(cashflowNumber, that.cashflowNumber) &&
                Objects.equals(bankAccountStatementDate, that.bankAccountStatementDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchName, documentSequence, gjhPeriodName, journalName, xhEventTypeCode, xhAeHeaderId, gjlJeLineNum, xlCurrencyCode, accountingLineCode, eventClassCode, company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, future2, concatenatedSegments, enteredDebits, enteredCredits, enteredNet, accountedCredits, accountedDebits, accountedNet, accountingDate, jeSource, jeCategory, ledgerName, transactionDescription, paymentCurrencyCode, bankAccountName, bankAccountNum, currencyCode, bankAccountDestination, bankAccountNumDestination, cashflowDirection, cashflowNumber, bankAccountStatementDate);
    }
}
