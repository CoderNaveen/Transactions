// Generated by view binder compiler. Do not edit!
package com.naveenkumawat.transactions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.naveenkumawat.transactions.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RowListDataBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clRowContainer;

  @NonNull
  public final RecyclerView rvTransactions;

  @NonNull
  public final TextView tvRowDate;

  private RowListDataBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout clRowContainer, @NonNull RecyclerView rvTransactions,
      @NonNull TextView tvRowDate) {
    this.rootView = rootView;
    this.clRowContainer = clRowContainer;
    this.rvTransactions = rvTransactions;
    this.tvRowDate = tvRowDate;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RowListDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowListDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_list_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowListDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout clRowContainer = (ConstraintLayout) rootView;

      id = R.id.rv_transactions;
      RecyclerView rvTransactions = ViewBindings.findChildViewById(rootView, id);
      if (rvTransactions == null) {
        break missingId;
      }

      id = R.id.tv_row_date;
      TextView tvRowDate = ViewBindings.findChildViewById(rootView, id);
      if (tvRowDate == null) {
        break missingId;
      }

      return new RowListDataBinding((ConstraintLayout) rootView, clRowContainer, rvTransactions,
          tvRowDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}