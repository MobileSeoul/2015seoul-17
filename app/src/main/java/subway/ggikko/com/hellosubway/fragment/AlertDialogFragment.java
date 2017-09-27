package subway.ggikko.com.hellosubway.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import subway.ggikko.com.hellosubway.R;
import subway.ggikko.com.hellosubway.activity.MapActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertDialogFragment extends DialogFragment implements View.OnClickListener {

    MapActivity mMapActivity;
    AlertDialog dialog;
    public AlertDialogFragment(){
    }

    @SuppressLint("ValidFragment")
    public AlertDialogFragment(MapActivity mapActivity) {
        this.mMapActivity = mapActivity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_alert_dialog, null);
        builder.setView(view);
        view.setOnClickListener(this);

        dialog = builder.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
      //  Button positiveButton =dialog.getButton(DialogInterface.BUTTON_POSITIVE);
      //  positiveButton.setBackgroundColor(getResources().getColor(R.color.toolbartextcolor));

        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {

        mMapActivity.goToDefaultMap();
        dismiss();

    }
}
