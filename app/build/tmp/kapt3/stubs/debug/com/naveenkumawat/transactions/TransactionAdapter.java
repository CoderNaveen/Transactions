package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001d\u001e\u001f B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0014\u0010\u001c\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R6\u0010\f\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\rj\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "onDeleteTransaction", "Lkotlin/Function1;", "Lcom/naveenkumawat/transactions/Transaction;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "transactions", "", "transactionsByDate", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "getItemViewType", "position", "getSwipeCallback", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setTransactions", "Companion", "EmptyViewHolder", "HeaderViewHolder", "TransactionViewHolder", "app_debug"})
public final class TransactionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.naveenkumawat.transactions.Transaction, kotlin.Unit> onDeleteTransaction = null;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_TRANSACTION = 1;
    private static final int VIEW_TYPE_EMPTY = -1;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.naveenkumawat.transactions.Transaction> transactions;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, java.util.List<com.naveenkumawat.transactions.Transaction>> transactionsByDate;
    @org.jetbrains.annotations.NotNull
    public static final com.naveenkumawat.transactions.TransactionAdapter.Companion Companion = null;
    
    public TransactionAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.naveenkumawat.transactions.Transaction, kotlin.Unit> onDeleteTransaction) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setTransactions(@org.jetbrains.annotations.NotNull
    java.util.List<com.naveenkumawat.transactions.Transaction> transactions) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback getSwipeCallback() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionAdapter$Companion;", "", "()V", "VIEW_TYPE_EMPTY", "", "VIEW_TYPE_HEADER", "VIEW_TYPE_TRANSACTION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/naveenkumawat/transactions/databinding/ItemEmptyBinding;", "(Lcom/naveenkumawat/transactions/TransactionAdapter;Lcom/naveenkumawat/transactions/databinding/ItemEmptyBinding;)V", "app_debug"})
    public final class EmptyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.naveenkumawat.transactions.databinding.ItemEmptyBinding binding = null;
        
        public EmptyViewHolder(@org.jetbrains.annotations.NotNull
        com.naveenkumawat.transactions.databinding.ItemEmptyBinding binding) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/naveenkumawat/transactions/databinding/ItemHeaderTransactionsBinding;", "(Lcom/naveenkumawat/transactions/TransactionAdapter;Lcom/naveenkumawat/transactions/databinding/ItemHeaderTransactionsBinding;)V", "bind", "", "date", "", "app_debug"})
    public final class HeaderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.naveenkumawat.transactions.databinding.ItemHeaderTransactionsBinding binding = null;
        
        public HeaderViewHolder(@org.jetbrains.annotations.NotNull
        com.naveenkumawat.transactions.databinding.ItemHeaderTransactionsBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String date) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/naveenkumawat/transactions/TransactionAdapter$TransactionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/naveenkumawat/transactions/databinding/ItemTransactionDataBinding;", "(Lcom/naveenkumawat/transactions/TransactionAdapter;Lcom/naveenkumawat/transactions/databinding/ItemTransactionDataBinding;)V", "bind", "", "transaction", "Lcom/naveenkumawat/transactions/Transaction;", "app_debug"})
    public final class TransactionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.naveenkumawat.transactions.databinding.ItemTransactionDataBinding binding = null;
        
        public TransactionViewHolder(@org.jetbrains.annotations.NotNull
        com.naveenkumawat.transactions.databinding.ItemTransactionDataBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.naveenkumawat.transactions.Transaction transaction) {
        }
    }
}