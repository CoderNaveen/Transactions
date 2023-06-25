package com.naveenkumawat.transactions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/naveenkumawat/transactions/AccountingNumberKeyListener;", "Landroid/text/method/NumberKeyListener;", "()V", "getAcceptedChars", "", "getInputType", "", "Companion", "app_debug"})
public final class AccountingNumberKeyListener extends android.text.method.NumberKeyListener {
    @org.jetbrains.annotations.NotNull
    private static final char[] CHARS_ACCEPTED = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '.'};
    @org.jetbrains.annotations.NotNull
    public static final com.naveenkumawat.transactions.AccountingNumberKeyListener.Companion Companion = null;
    
    public AccountingNumberKeyListener() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    protected char[] getAcceptedChars() {
        return null;
    }
    
    @java.lang.Override
    public int getInputType() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/naveenkumawat/transactions/AccountingNumberKeyListener$Companion;", "", "()V", "CHARS_ACCEPTED", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}