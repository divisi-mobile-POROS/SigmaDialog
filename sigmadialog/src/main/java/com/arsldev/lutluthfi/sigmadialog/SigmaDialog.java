package com.arsldev.lutluthfi.sigmadialog;

import android.os.Bundle;

public interface SigmaDialog {

    interface ConfirmDialogListener {
        void onDeclined();

        void onAccepted(Bundle bundle);
    }

    interface InformationDialogListener {
        void onConfirmed(Bundle bundle);
    }
}
