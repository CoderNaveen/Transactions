package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nH\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionRepositoryImpl;", "Lcom/naveenkumawat/transactions/TransactionRepository;", "transactionDao", "Lcom/naveenkumawat/transactions/TransactionDao;", "(Lcom/naveenkumawat/transactions/TransactionDao;)V", "deleteTransaction", "", "transaction", "Lcom/naveenkumawat/transactions/Transaction;", "getAllTransactions", "Landroidx/lifecycle/LiveData;", "", "getExpenseTransactions", "getIncomeTransactions", "insertTransaction", "app_debug"})
public final class TransactionRepositoryImpl implements com.naveenkumawat.transactions.TransactionRepository {
    @org.jetbrains.annotations.NotNull
    private final com.naveenkumawat.transactions.TransactionDao transactionDao = null;
    
    public TransactionRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.TransactionDao transactionDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getAllTransactions() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getExpenseTransactions() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getIncomeTransactions() {
        return null;
    }
    
    @java.lang.Override
    public void insertTransaction(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.Transaction transaction) {
    }
    
    @java.lang.Override
    public void deleteTransaction(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.Transaction transaction) {
    }
}