package com.codbking.widget.view

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import cn.jzvd.IVGroup
import cn.jzvd.IView
import cn.jzvd.MyJzvdStd
import com.bumptech.glide.Glide
import com.github.mikephil.charting.charts.LineChart
import com.ved.framework.utils.DpiUtils
import com.ved.framework.utils.ScreenUtils
import com.ved.framework.utils.Utils
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter
import org.sufficientlysecure.htmltextview.HtmlTextView

object ViewAdapter {
    @BindingAdapter("ingestion_reference_type")
    @JvmStatic
    fun AppCompatTextView.a(s: String?) {
        when(s){
            "EAR" ->{
                text = "平均需要量"
            }
            "RNI" ->{
                text = "推荐摄入量"
            }
            "AI" ->{
                text = "适宜摄入量"
            }
            "UL" ->{
                text = "可耐受最高摄入量"
            }
            "AMDR" ->{
                text = "宏量营养素可接受范围"
            }
            "PI" ->{
                text = "建议摄入量"
            }
            else ->{
                text = "特定建议值"
            }
        }
    }

    @BindingAdapter("html_text")
    @JvmStatic
    fun HtmlTextView.b(s: String?) {
        s?.replace("http://", "https://")?.let {
            setHtml(
                it,
                HtmlHttpImageGetter(this)
            )
        }

    }

    @BindingAdapter(
        value = ["audio_image_url", "audio_url"],
        requireAll = false
    )
    @JvmStatic
    fun MyJzvdStd.c(s: String?, b: String?) {
        setUp(b,"")
        positionInList = 1
        if (s?.isNotEmpty() == true) {
            Glide.with(posterImageView.context)
                .load(s)
                .into(posterImageView)
        }
    }

    @BindingAdapter(
        value = ["leftValue", "rightValue"],
        requireAll = false
    )
    @JvmStatic
    fun IView.d(s: String?, b: String?) {
        setLeftValue(s)
        setRightValue(b)
    }

    @BindingAdapter(
        value = ["progressValue", "foodIngestion"],
        requireAll = false
    )
    @JvmStatic
    fun IView.e(s: Int?, b: String?) {
        s?.toFloat()?.let { setCurrentProgress(it) }
        if (b != null) {
            setText(b)
        }
    }

    @BindingAdapter(
        value = ["hasWeek", "hasBubble"],
        requireAll = false
    )
    @JvmStatic
    fun LineChart.f(hasWeek: Int?, hasBubble:Int?) {
        if (hasBubble == View.GONE || hasBubble == View.INVISIBLE){
            hasWeek?.let {
                visibility = it
            }
        }else{
            hasBubble?.let {
                visibility = View.GONE
            }
        }
    }

    @BindingAdapter(
        value = ["blood_sugar_avg", "blood_sugar_proportion","blood_sugar_fluctuate","blood_sugar_reachts","blood_sugar_high","blood_sugar_low","blood_sugar_normal"],
        requireAll = false
    )
    @JvmStatic
    fun IVGroup.g(avg: String?, proportion:String?, fluctuate:String?, reachts:String?, high:String?, low:String?, normal:String?) {
        loadData(avg,proportion,fluctuate,reachts,high,low,normal)
    }

    @BindingAdapter(
        value = ["sleep_length", "sleep_lie_length"],
        requireAll = false
    )
    @JvmStatic
    fun IVGroup.h(sleepLength: String?, lieinbedLength:String?) {
        loadData(sleepLength, lieinbedLength)
    }

    @BindingAdapter("fat_values")
    @JvmStatic
    fun IVGroup.i(fat: String?) {
        loadData(fat)
    }

    @BindingAdapter("diet_values")
    @JvmStatic
    fun IVGroup.j(diet: String?) {
        loadData(diet)
    }

    @BindingAdapter(
        value = ["card_value", "card_unit"],
        requireAll = false
    )
    @JvmStatic
    fun AppCompatTextView.k(value:String?,unit: String?) {
        value?.let {
            text = if (it.isNotEmpty()){
                if (it == "--"){
                    ""
                }else{
                    unit
                }
            } else {
                ""
            }
        }?: kotlin.run {
            text = ""
        }
    }

    @BindingAdapter("card_weight")
    @JvmStatic
    fun AppCompatTextView.l(weight: String?) {
        weight?.let {
            text = if (it.isNotEmpty()){
                weight
            }else{
                "--"
            }
        }?: kotlin.run {
            text = "--"
        }
    }

    @BindingAdapter("plan_text_01")
    @JvmStatic
    fun AppCompatTextView.m(t: String?) {
        t?.let {
            text = if (t.length >= 16){
                t.substring(0,16)
            }else{
                t
            }
        }
    }

    @BindingAdapter("plan_text_02")
    @JvmStatic
    fun AppCompatTextView.n(t: String?) {
        t?.let {
            text = if (t.length >= 34){
                t.substring(16,34)
            }else if (t.length >= 16){
                t.subSequence(16,t.length)
            }else{
                ""
            }
        }
    }

    @BindingAdapter("plan_text_03")
    @JvmStatic
    fun AppCompatTextView.k(t: String?) {
        t?.let {
            text = if (t.length >= 53){
                t.substring(34,53)
            }else if (t.length >= 34){
                t.substring(34,t.length)
            }else{
                ""
            }
        }
    }

    @BindingAdapter("plan_text_04")
    @JvmStatic
    fun AppCompatTextView.r(t: String?) {
        t?.let {
            text = if (t.length >= 53){
                t.substring(53,t.length)
            }else{
                ""
            }
        }
    }

    @BindingAdapter("plan_problem_01")
    @JvmStatic
    fun AppCompatTextView.u(t: String?) {
        t?.let {
            text = t.substring(0,1)
        }
    }

    @BindingAdapter("plan_problem_02")
    @JvmStatic
    fun AppCompatTextView.y(t: String?) {
        t?.let {
            text = t.substring(1,t.length)
        }
    }

    @BindingAdapter("plan_price")
    @JvmStatic
    fun AppCompatTextView.t(t: String?) {
        t?.let {
            val s = "¥${it}"
            val sp = SpannableString(s)
            sp.setSpan(StrikethroughSpan(),0,s.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            text = sp
        }
    }

    @BindingAdapter("width_run_progress")
    @JvmStatic
    fun View.w(t: Int?) {
        t?.let {
            val w = ScreenUtils.getScreenWidth(Utils.getContext())-DpiUtils.dip2px(Utils.getContext(),52)
            val w1 = w*t/100
            val lp: ViewGroup.LayoutParams = layoutParams
            lp.width = w1
            layoutParams = lp
        }
    }

    @BindingAdapter("left_run_progress")
    @JvmStatic
    fun View.q(t: Int?) {
        t?.let {
            if (it == 0){
                visibility = View.GONE
            }else{
                visibility = View.VISIBLE
                val w = ScreenUtils.getScreenWidth(Utils.getContext())-DpiUtils.dip2px(Utils.getContext(),52)
                val w1 = w*it/100-DpiUtils.dip2px(Utils.getContext(),20)
                val layoutParams = layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(w1,0,0,0)
                setLayoutParams(layoutParams)
            }
        }
    }
}