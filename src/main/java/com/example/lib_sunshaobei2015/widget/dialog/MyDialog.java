package com.example.lib_sunshaobei2015.widget.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lib_sunshaobei2015.R;

/**
 * Created by sunshaobei on 2017/6/7.
 */

public class MyDialog extends DialogFragment {

    private int rid;
    private View dialogview;

    public MyDialog(Context context,int rid) {
        this.rid = rid;
        dialogview = LayoutInflater.from(context).inflate(rid, null);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.dialog);
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_anim;
        dialog.setContentView(dialogview);
        return dialog;
    }

    public <T extends View> T getView(int id){
        return (T) dialogview.findViewById(id);
    }
}
