// Generated by view binder compiler. Do not edit!
package com.naveenkumawat.transactions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
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

public final class LayoutDollarComponentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnDown;

  @NonNull
  public final ImageButton btnUp;

  @NonNull
  public final EditText etDollarAmount;

  @NonNull
  public final TextView tvDollarSign;

  private LayoutDollarComponentBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton btnDown, @NonNull ImageButton btnUp, @NonNull EditText etDollarAmount,
      @NonNull TextView tvDollarSign) {
    this.rootView = rootView;
    this.btnDown = btnDown;
    this.btnUp = btnUp;
    this.etDollarAmount = etDollarAmount;
    this.tvDollarSign = tvDollarSign;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutDollarComponentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutDollarComponentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_dollar_component, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutDollarComponentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_down;
      ImageButton btnDown = ViewBindings.findChildViewById(rootView, id);
      if (btnDown == null) {
        break missingId;
      }

      id = R.id.btn_up;
      ImageButton btnUp = ViewBindings.findChildViewById(rootView, id);
      if (btnUp == null) {
        break missingId;
      }

      id = R.id.et_dollar_amount;
      EditText etDollarAmount = ViewBindings.findChildViewById(rootView, id);
      if (etDollarAmount == null) {
        break missingId;
      }

      id = R.id.tv_dollar_sign;
      TextView tvDollarSign = ViewBindings.findChildViewById(rootView, id);
      if (tvDollarSign == null) {
        break missingId;
      }

      return new LayoutDollarComponentBinding((ConstraintLayout) rootView, btnDown, btnUp,
          etDollarAmount, tvDollarSign);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}