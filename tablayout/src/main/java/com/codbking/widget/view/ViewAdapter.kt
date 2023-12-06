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
import com.ved.framework.binding.command.BindingCommand
import com.ved.framework.utils.DpiUtils
import com.ved.framework.utils.ScreenUtils
import com.ved.framework.utils.Utils
import com.zkk.view.rulerview.RulerView
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter
import org.sufficientlysecure.htmltextview.HtmlTextView

object ViewAdapter {
    @BindingAdapter("ingestion_reference_type")
    @JvmStatic
    fun AppCompatTextView.a(s: String?) {
        try {
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
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("html_text")
    @JvmStatic
    fun HtmlTextView.b(s: String?) {
        try {
            s?.replace("http://", "https://")?.let {
                setHtml(
                    it,
                    HtmlHttpImageGetter(this)
                )
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["audio_image_url", "audio_url"],
        requireAll = false
    )
    @JvmStatic
    fun MyJzvdStd.c(s: String?, b: String?) {
        try {
            setUp(b,"")
            positionInList = 1
            if (s?.isNotEmpty() == true) {
                Glide.with(posterImageView.context)
                    .load(s)
                    .into(posterImageView)
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["leftValue", "rightValue"],
        requireAll = false
    )
    @JvmStatic
    fun IView.d(s: String?, b: String?) {
        try {
            setLeftValue(s)
            setRightValue(b)
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["progressValue", "foodIngestion"],
        requireAll = false
    )
    @JvmStatic
    fun IView.e(s: Int?, b: String?) {
        try {
            s?.toFloat()?.let { setCurrentProgress(it) }
            if (b != null) {
                setText(b)
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["hasWeek", "hasBubble"],
        requireAll = false
    )
    @JvmStatic
    fun LineChart.f(hasWeek: Int?, hasBubble:Int?) {
        try {
            if (hasBubble == View.GONE || hasBubble == View.INVISIBLE){
                hasWeek?.let {
                    visibility = it
                }
            }else{
                hasBubble?.let {
                    visibility = View.GONE
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["blood_sugar_avg", "blood_sugar_proportion","blood_sugar_fluctuate","blood_sugar_reachts","blood_sugar_high","blood_sugar_low","blood_sugar_normal"],
        requireAll = false
    )
    @JvmStatic
    fun IVGroup.g(avg: String?, proportion:String?, fluctuate:String?, reachts:String?, high:String?, low:String?, normal:String?) {
        try {
            loadData(avg,proportion,fluctuate,reachts,high,low,normal)
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["sleep_length", "sleep_lie_length"],
        requireAll = false
    )
    @JvmStatic
    fun IVGroup.h(sleepLength: String?, lieinbedLength:String?) {
        try {
            loadData(sleepLength, lieinbedLength)
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("fat_values")
    @JvmStatic
    fun IVGroup.i(fat: String?) {
        try {
            loadData(fat)
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("diet_values")
    @JvmStatic
    fun IVGroup.j(diet: String?) {
        try {
            loadData(diet)
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["card_value", "card_unit"],
        requireAll = false
    )
    @JvmStatic
    fun AppCompatTextView.k(value:String?,unit: String?) {
        try {
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
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("card_weight")
    @JvmStatic
    fun AppCompatTextView.l(weight: String?) {
        try {
            weight?.let {
                text = if (it.isNotEmpty()){
                    weight
                }else{
                    "--"
                }
            }?: kotlin.run {
                text = "--"
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_01")
    @JvmStatic
    fun AppCompatTextView.m(t: String?) {
        try {
            t?.let {
                text = if (t.length >= 16){
                    t.substring(0,16)
                }else{
                    t
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_02")
    @JvmStatic
    fun AppCompatTextView.n(t: String?) {
        try {
            t?.let {
                text = if (t.length >= 34){
                    t.substring(16,34)
                }else if (t.length >= 16){
                    t.subSequence(16,t.length)
                }else{
                    ""
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_03")
    @JvmStatic
    fun AppCompatTextView.k(t: String?) {
        try {
            t?.let {
                text = if (t.length >= 53){
                    t.substring(34,53)
                }else if (t.length >= 34){
                    t.substring(34,t.length)
                }else{
                    ""
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_04")
    @JvmStatic
    fun AppCompatTextView.r(t: String?) {
        try {
            t?.let {
                text = if (t.length >= 53){
                    t.substring(53,t.length)
                }else{
                    ""
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_problem_01")
    @JvmStatic
    fun AppCompatTextView.u(t: String?) {
        try {
            t?.let {
                text = t.substring(0,1)
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_problem_02")
    @JvmStatic
    fun AppCompatTextView.y(t: String?) {
        try {
            t?.let {
                text = t.substring(1,t.length)
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_price")
    @JvmStatic
    fun AppCompatTextView.t(t: String?) {
        try {
            t?.let {
                val s = "¥${it}"
                val sp = SpannableString(s)
                sp.setSpan(StrikethroughSpan(),0,s.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                text = sp
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("width_run_progress")
    @JvmStatic
    fun View.w(t: Int?) {
        try {
            t?.let {
                val w = ScreenUtils.getScreenWidth(Utils.getContext())-DpiUtils.dip2px(Utils.getContext(),52)
                val w1 = w*t/100
                val lp: ViewGroup.LayoutParams = layoutParams
                lp.width = w1
                layoutParams = lp
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("left_run_progress")
    @JvmStatic
    fun View.q(t: Int?) {
        try {
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
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["rule_min_value", "rule_max_value","rule_grid_value","rule_value"],
        requireAll = false
    )
    @JvmStatic
    fun RulerView.ab(a: String?, b:String?, g:String?, v:String?) {
        try {
            setValue(v?.let {
                if (it.isNotEmpty()){
                    it.toFloat()
                }else{
                    60f
                }
            }?: kotlin.run {
                60f
            }, a?.let {
                if (it.isNotEmpty()){
                    it.toFloat()
                }else{
                    0f
                }
            }?: kotlin.run {
                0f
            }, b?.let {
                if (it.isNotEmpty()){
                    it.toFloat()
                }else{
                    200f
                }
            }?: kotlin.run {
                200f
            }, g?.let {
                if (it.isNotEmpty()){
                    it.toFloat()/10f
                }else{
                    0.1f
                }
            }?: kotlin.run {
                0.1f
            })
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["onValueChangeCommand"],
        requireAll = false
    )
    @JvmStatic
    fun RulerView.ac(
        a: BindingCommand<String?>?
    ) {
        try {
            setOnValueChangeListener{
                a?.execute(it.toString())
            }
        } catch (_: Exception) {
        }
    }
}