package com.codbking.widget.view;

import android.widget.CheckBox;

import androidx.databinding.BindingAdapter;

import com.ved.framework.command.BindingCommand;

/**
 * Created by ved on 2017/6/16.
 */

public class c {
    /**
     * @param bindingCommand //绑定监听
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"onCheckedChangedCommand"}, requireAll = false)
    public static void setCheckedChanged(final CheckBox checkBox, final BindingCommand<Boolean> bindingCommand) {
        checkBox.setOnCheckedChangeListener((compoundButton, b) -> bindingCommand.execute(b));
    }
}
