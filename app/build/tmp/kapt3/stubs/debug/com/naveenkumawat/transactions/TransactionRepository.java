package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H&J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionRepository;", "", "deleteTransaction", "", "transaction", "Lcom/naveenkumawat/transactions/Transaction;", "getAllTransactions", "Landroidx/lifecycle/LiveData;", "", "getExpenseTransactions", "getIncomeTransactions", "insertTransaction", "app_debug"})
public abstract interface TransactionRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getAllTransactions();
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getExpenseTransactions();
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getIncomeTransactions();
    
    public abstract void insertTransaction(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.Transaction transaction);
    
    public abstract void deleteTransaction(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.Transaction transaction);
}