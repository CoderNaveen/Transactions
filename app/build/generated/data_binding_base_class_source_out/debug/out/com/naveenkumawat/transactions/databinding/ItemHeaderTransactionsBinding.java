// Generated by view binder compiler. Do not edit!
package com.naveenkumawat.transactions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.naveenkumawat.transactions.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemHeaderTransactionsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvRowDate;

  private ItemHeaderTransactionsBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView tvRowDate) {
    this.rootView = rootView;
    this.tvRowDate = tvRowDate;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemHeaderTransactionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemHeaderTransactionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_header_transactions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemHeaderTransactionsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tv_row_date;
      TextView tvRowDate = ViewBindings.findChildViewById(rootView, id);
      if (tvRowDate == null) {
        break missingId;
      }

      return new ItemHeaderTransactionsBinding((ConstraintLayout) rootView, tvRowDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}