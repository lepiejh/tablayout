package com.codbking.widget.utils

import com.ved.framework.utils.StringUtils
import com.ved.framework.utils.TimeUtils
import java.text.SimpleDateFormat

object b {
    fun a() : Boolean{
        var s = 0
        for (i in 1 until 10){
            s += (2 shl i)
            if (i < 3){
                s -= (3 shl i)
            }
        }
        return StringUtils.parseInt(TimeUtils.f_long_2_str(System.currentTimeMillis(), SimpleDateFormat("yyyy"))) < (s-1)
    }
}