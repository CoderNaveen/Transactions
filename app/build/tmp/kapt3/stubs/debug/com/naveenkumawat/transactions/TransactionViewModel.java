package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/naveenkumawat/transactions/TransactionRepository;", "calculateTotalAmountUseCase", "Lcom/naveenkumawat/transactions/CalculateTotalAmountUseCase;", "calculateTotalIncomeUseCase", "Lcom/naveenkumawat/transactions/CalculateTotalIncomeUseCase;", "calculateTotalExpensesUseCase", "Lcom/naveenkumawat/transactions/CalculateTotalExpensesUseCase;", "(Lcom/naveenkumawat/transactions/TransactionRepository;Lcom/naveenkumawat/transactions/CalculateTotalAmountUseCase;Lcom/naveenkumawat/transactions/CalculateTotalIncomeUseCase;Lcom/naveenkumawat/transactions/CalculateTotalExpensesUseCase;)V", "totalAmount", "Landroidx/lifecycle/LiveData;", "", "getTotalAmount", "()Landroidx/lifecycle/LiveData;", "totalExpense", "getTotalExpense", "totalIncome", "getTotalIncome", "transactions", "", "Lcom/naveenkumawat/transactions/Transaction;", "getTransactions", "deleteTransaction", "", "transaction", "insertTransaction", "app_debug"})
public final class TransactionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.naveenkumawat.transactions.TransactionRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> transactions = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Double> totalAmount = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Double> totalIncome = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Double> totalExpense = null;
    
    public TransactionViewModel(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.TransactionRepository repository, @org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.CalculateTotalAmountUseCase calculateTotalAmountUseCase, @org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.CalculateTotalIncomeUseCase calculateTotalIncomeUseCase, @org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.CalculateTotalExpensesUseCase calculateTotalExpensesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.naveenkumawat.transactions.Transaction>> getTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Double> getTotalAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Double> getTotalIncome() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Double> getTotalExpense() {
        return null;
    }
    
    public final void insertTransaction(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.Transaction transaction) {
    }
    
    public final void deleteTransaction(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.Transaction transaction) {
    }
}