package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/naveenkumawat/transactions/presentation/AddButtonListener;", "()V", "adapter", "Lcom/naveenkumawat/transactions/presentation/adapter/TransactionAdapter;", "binding", "Lcom/naveenkumawat/transactions/databinding/ActivityTransactionsBinding;", "fabAddButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "lpiBalanceBar", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "rvTransactions", "Landroidx/recyclerview/widget/RecyclerView;", "tvBalanceHeading", "Landroid/widget/TextView;", "tvBalanceLabel", "tvExpensesHeading", "tvExpensesLabel", "tvIncomeHeading", "tvIncomeLabel", "viewModel", "Lcom/naveenkumawat/transactions/presentation/viewmodel/TransactionViewModel;", "deleteTransaction", "", "transaction", "Lcom/naveenkumawat/transactions/domain/model/Transaction;", "initComponents", "onAddButtonClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openDialog", "setBalanceContainerHeadings", "setBalanceContainerValues", "setFloatingActionButton", "setRecyclerViewList", "setViewBindings", "Companion", "app_debug"})
public final class TransactionsActivity extends androidx.appcompat.app.AppCompatActivity implements com.naveenkumawat.transactions.presentation.AddButtonListener {
    private com.naveenkumawat.transactions.databinding.ActivityTransactionsBinding binding;
    private android.widget.TextView tvExpensesHeading;
    private android.widget.TextView tvExpensesLabel;
    private android.widget.TextView tvIncomeHeading;
    private android.widget.TextView tvIncomeLabel;
    private android.widget.TextView tvBalanceHeading;
    private android.widget.TextView tvBalanceLabel;
    private androidx.recyclerview.widget.RecyclerView rvTransactions;
    private com.google.android.material.floatingactionbutton.FloatingActionButton fabAddButton;
    private com.google.android.material.progressindicator.LinearProgressIndicator lpiBalanceBar;
    private com.naveenkumawat.transactions.presentation.viewmodel.TransactionViewModel viewModel;
    private com.naveenkumawat.transactions.presentation.adapter.TransactionAdapter adapter;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "TransactionsActivity";
    @org.jetbrains.annotations.NotNull
    public static final com.naveenkumawat.transactions.TransactionsActivity.Companion Companion = null;
    
    public TransactionsActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initComponents() {
    }
    
    private final void setBalanceContainerHeadings() {
    }
    
    private final void setBalanceContainerValues() {
    }
    
    private final void setViewBindings() {
    }
    
    private final void setFloatingActionButton(com.naveenkumawat.transactions.databinding.ActivityTransactionsBinding binding) {
    }
    
    private final void openDialog() {
    }
    
    private final void setRecyclerViewList() {
    }
    
    private final void deleteTransaction(com.naveenkumawat.transactions.domain.model.Transaction transaction) {
    }
    
    @java.lang.Override
    public void onAddButtonClicked(@org.jetbrains.annotations.NotNull
    com.naveenkumawat.transactions.domain.model.Transaction transaction) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionsActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}