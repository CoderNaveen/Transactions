package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/naveenkumawat/transactions/CalculateTotalExpensesUseCaseImpl;", "Lcom/naveenkumawat/transactions/CalculateTotalExpensesUseCase;", "transactionRepository", "Lcom/naveenkumawat/transactions/TransactionRepository;", "(Lcom/naveenkumawat/transactions/TransactionRepository;)V", "getExpenseTotal", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public final class CalculateTotalExpensesUseCaseImpl implements com.naveenkumawat.transactions.CalculateTotalExpensesUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.naveenkumawat.transactions.TransactionRepository transactionRepository = null;
    
    public CalculateTotalExpensesUseCaseImpl(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.TransactionRepository transactionRepository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.lang.Double> getExpenseTotal() {
        return null;
    }
}