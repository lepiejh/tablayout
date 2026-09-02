package com.codbking.widget.view;

import androidx.core.widget.NestedScrollView;
import androidx.databinding.BindingAdapter;

import com.ved.framework.command.BindingCommand;
import com.ved.framework.entity.NestScrollDataWrapper;

/**
 * Created by ved on 2017/6/18.
 */
public final class i {

    @SuppressWarnings("unchecked")
    @BindingAdapter({"onScrollChangeCommand"})
    public static void onScrollChangeCommand(final NestedScrollView nestedScrollView, final BindingCommand<NestScrollDataWrapper> onScrollChangeCommand) {
        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrolved, scrollY, oldScrolved, oldScrollY) -> {
            if (onScrollChangeCommand != null) {
                onScrollChangeCommand.execute(new NestScrollDataWrapper(scrolved, scrollY, oldScrolved, oldScrollY));
            }
        });
    }
}
