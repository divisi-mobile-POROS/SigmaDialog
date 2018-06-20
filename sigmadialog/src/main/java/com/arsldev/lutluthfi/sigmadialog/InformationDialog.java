package com.arsldev.lutluthfi.sigmadialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arsldev.lutluthfi.sigmadialog.base.BaseDialog;
import com.arsldev.lutluthfi.sigmadialog.utils.AppConstants;

import butterknife.ButterKnife;

public class InformationDialog extends BaseDialog {

    private TextView mTitleTextView;
    private TextView mSubtitleTextView;
    private Button mConfirmButton;

    private Bundle mBundle;
    private SigmaDialog.InformationDialogListener mListener;

    public static InformationDialog.Builder newInstance(Context context) {
        return new InformationDialog.Builder(context);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SigmaDialog.InformationDialogListener) {
            mListener = (SigmaDialog.InformationDialogListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SigmaDialog.InformationDialogListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_information, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBundle = this.getArguments();
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    @Override
    protected void setupView(View view) {
        mTitleTextView = view.findViewById(R.id.text_information_title);
        mSubtitleTextView = view.findViewById(R.id.text_information_subtitle);
        mConfirmButton = view.findViewById(R.id.button_information_confirm);

        mConfirmButton.setOnClickListener(this::onConfirmButtonClick);

        String title = mBundle.getString(AppConstants.BUNDLE_TITLE);
        String subtitle = mBundle.getString(AppConstants.BUNDLE_SUBTITLE);
        mTitleTextView.setText(title != null ? title : getString(R.string.default_information_title));
        mSubtitleTextView.setText(subtitle != null ? subtitle : getString(R.string.default_information_subtitle));
    }

    public void onConfirmButtonClick(View view) {
        mListener.onConfirmed(mBundle.getBundle(AppConstants.BUNDLE_DATA));
    }

    public static class Builder {

        private Bundle mArgs;
        private Context mContext;

        private Builder(Context context) {
            this.mArgs = new Bundle();
            this.mContext = context;
        }

        public Builder setTitle(int title) {
            this.mArgs.putString(AppConstants.BUNDLE_TITLE, this.mContext.getString(title));
            return this;
        }

        public Builder setTitle(String title) {
            this.mArgs.putString(AppConstants.BUNDLE_TITLE, title);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.mArgs.putString(AppConstants.BUNDLE_TITLE, title.toString());
            return this;
        }

        public Builder setSubTitle(int subTitle) {
            this.mArgs.putString(AppConstants.BUNDLE_SUBTITLE, this.mContext.getString(subTitle));
            return this;
        }

        public Builder setSubTitle(String subTitle) {
            this.mArgs.putString(AppConstants.BUNDLE_SUBTITLE, subTitle);
            return this;
        }

        public Builder setSubTitle(CharSequence subTitle) {
            this.mArgs.putString(AppConstants.BUNDLE_SUBTITLE, subTitle.toString());
            return this;
        }

        public Builder setBundle(Bundle bundle) {
            this.mArgs.putBundle(AppConstants.BUNDLE_DATA, bundle);
            return this;
        }

        public ConfirmDialog build(){
            ConfirmDialog dialog = new ConfirmDialog();
            dialog.setArguments(this.mArgs);
            return dialog;
        }
    }
}
