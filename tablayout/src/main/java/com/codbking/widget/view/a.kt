package com.codbking.widget.view

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import cn.jzvd.IVGroup
import cn.jzvd.IView
import cn.jzvd.MyJzvdStd
import com.androidkun.xtablayout.R
import com.donkor.cn.BatteryView
import com.github.mikephil.charting.charts.LineChart
import com.orhanobut.dialog.view.WifiSignalView
import com.ved.framework.binding.command.BindingCommand
import com.ved.framework.utils.DpiUtils
import com.ved.framework.utils.StringUtils
import com.ved.framework.utils.UIUtils
import com.ved.framework.utils.Utils
import com.zkk.view.rulerview.RulerView
import org.sufficientlysecure.htmltextview.HtmlTextView

object a {
    @BindingAdapter("ingestion_reference_type")
    @JvmStatic
    internal fun TextView.a(s: String?) {
        try {
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("html_text")
    @JvmStatic
    internal fun HtmlTextView.b(s: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("web_html_text")
    @JvmStatic
    internal fun WebView.b(s: String?) {
        try {
            loadDataWithBaseURL(null, "<html>" + "<head>" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                    "<style>img{display: block; width:100%; height:auto;}" +
                    "video{ width:100%; height:auto;}" +
                    "html, body {margin: 0px;padding: 0px;}" +
                    "p{color:#666666;font-size: 14px!important;word-break: break-word;}" +
                    "span{color: #666;font-size: 14px!important;}" +
                    "</style>" +
                    "</head>" + "<body style:'height:auto; width:100%;'>" + s + "</body></html>", "text/html", "UTF-8", null)
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["audio_image_url", "audio_url"],
        requireAll = false
    )
    @JvmStatic
    internal fun MyJzvdStd.c(s: String?, b: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["leftValue", "rightValue"],
        requireAll = false
    )
    @JvmStatic
    internal fun View.d(s: String?, b: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["format_key", "format_value"],
        requireAll = false
    )
    @JvmStatic
    internal fun View.sd(k: Int?, v: String?) {
        try {
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["progressValue", "foodIngestion"],
        requireAll = false
    )
    @JvmStatic
    internal fun IView.e(s: Int?, b: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["hasWeek", "hasBubble"],
        requireAll = false
    )
    @JvmStatic
    internal fun LineChart.f(hasWeek: Int?, hasBubble:Int?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["blood_sugar_avg", "blood_sugar_proportion","blood_sugar_fluctuate","blood_sugar_react","blood_sugar_high","blood_sugar_low","blood_sugar_normal"],
        requireAll = false
    )
    @JvmStatic
    internal fun IVGroup.g(avg: String?, proportion:String?, fluctuate:String?, reachts:String?, high:String?, low:String?, normal:String?) {
        try {
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["sleep_length", "sleep_lie_length"],
        requireAll = false
    )
    @JvmStatic
    internal fun IVGroup.h(sleepLength: String?, length:String?) {
        try {
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("fat_values")
    @JvmStatic
    internal fun View.i(fat: String?) {
        try {
            when(this){
                is BatteryView ->{
                    power = StringUtils.parseInt(fat)
                }
                is WifiSignalView ->{
                    when(StringUtils.parseInt(fat)){
                        -100 ->{
                            visibility = View.GONE
                        }
                        else ->{
                            visibility = View.VISIBLE
                            updateSignalStrength(StringUtils.parseInt(fat))
                        }
                    }
                }
                is TextView ->{
                    text = "${fat}%"
                    val f = StringUtils.parseInt(fat)
                    if (f <= 40) {
                        setTextColor(Color.RED)
                    }
                    if (f in 41..69) {
                        setTextColor(Color.BLUE)
                    }
                    if (f >= 70) {
                        setTextColor(Color.GREEN)
                    }
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("diet_values")
    @JvmStatic
    internal fun IVGroup.j(diet: String?) {
        try {
        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["card_value", "card_unit"],
        requireAll = false
    )
    @JvmStatic
    internal fun TextView.k(value:String?,unit: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("card_weight")
    @JvmStatic
    internal fun TextView.l(weight: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_one")
    @JvmStatic
    internal fun TextView.m(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_tow")
    @JvmStatic
    internal fun TextView.n(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_three")
    @JvmStatic
    internal fun TextView.k(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_text_four")
    @JvmStatic
    internal fun TextView.r(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_problem_one")
    @JvmStatic
    internal fun TextView.u(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_problem_tow")
    @JvmStatic
    internal fun TextView.y(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("plan_price")
    @JvmStatic
    internal fun TextView.t(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("width_run_progress")
    @JvmStatic
    internal fun View.w(t: Int?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("left_run_progress")
    @JvmStatic
    internal fun View.q(t: Int?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["rule_min_value", "rule_max_value","rule_grid_value","rule_value"],
        requireAll = false
    )
    @JvmStatic
    internal fun RulerView.ab(a: String?, b:String?, g:String?, v:String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["onValueChangeCommand"],
        requireAll = false
    )
    @JvmStatic
    internal fun RulerView.ac(
        a: BindingCommand<String?>?
    ) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["text_value", "text_default_value"],
        requireAll = false
    )
    @JvmStatic
    internal fun TextView.ad(a: String?, b: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter(
        value = ["float_to_int", "format_to_string"],
        requireAll = false
    )
    @JvmStatic
    internal fun TextView.bd(a: String?, b: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("text_length")
    @JvmStatic
    internal fun TextView.ae(t: String?) {
        try {

        } catch (_: Exception) {
        }
    }

    @BindingAdapter("blood_state")
    @JvmStatic
    internal fun View.af(t: String?) {
        try {
            when(this){
                is TextView ->{
                    when(t){
                        "1","离线" ->{
                            text = "离线"
                            background =  GradientDrawable().apply {
                                orientation = GradientDrawable.Orientation.LEFT_RIGHT
                                colors = intArrayOf(Color.parseColor("#999999"), Color.parseColor("#423F3F"))
                                shape = GradientDrawable.RECTANGLE
                                cornerRadius = DpiUtils.dipFpx(Utils.getContext(),3)
                            }
                        }
                        "2","在线" ->{
                            text = "在线"
                            background =  GradientDrawable().apply {
                                orientation = GradientDrawable.Orientation.LEFT_RIGHT
                                colors = intArrayOf(Color.parseColor("#85B8AB"), Color.parseColor("#1a9273"))
                                shape = GradientDrawable.RECTANGLE
                                cornerRadius = DpiUtils.dipFpx(Utils.getContext(),3)
                            }
                        }
                        else ->{
                            text = "待激活"
                            background =  GradientDrawable().apply {
                                orientation = GradientDrawable.Orientation.LEFT_RIGHT
                                colors = intArrayOf(Color.parseColor("#E3A89E"), Color.parseColor("#F82C0C"))
                                shape = GradientDrawable.RECTANGLE
                                cornerRadius = DpiUtils.dipFpx(Utils.getContext(),3)
                            }
                        }
                    }
                }
                else ->{
                    visibility = when(t){
                        "1","离线","2","在线" ->{
                            View.VISIBLE
                        }
                        else ->{
                            View.GONE
                        }
                    }
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("button_status")
    @JvmStatic
    internal fun TextView.ag(status: Int?) {
        try {
            when(status){
                -2 ->{
                    isEnabled = true
                    background = UIUtils.getDrawable(R.drawable.b)
                    setTextColor(UIUtils.getColor(R.color.b))
                }
                -1 ->{
                    isEnabled = false
                    background = UIUtils.getDrawable(R.drawable.e)
                    setTextColor(UIUtils.getColor(R.color.a))
                }
                0 ->{
                    isEnabled = true
                    background = UIUtils.getDrawable(R.drawable.a)
                    setTextColor(UIUtils.getColor(R.color.b))
                }
                1 ->{
                    isEnabled = true
                    background = UIUtils.getDrawable(R.drawable.g)
                    setTextColor(UIUtils.getColor(R.color.b))
                }
                2 ->{
                    isEnabled = true
                    background = UIUtils.getDrawable(R.drawable.h)
                    setTextColor(UIUtils.getColor(R.color.b))
                }
            }
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("view_width")
    @JvmStatic
    internal fun View.ah(i: Int?) {
        try {
            val params = layoutParams
            when (i) {
                0 -> {
                    params.width = 0
                }
                ViewGroup.LayoutParams.MATCH_PARENT ->{
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT
                }
                ViewGroup.LayoutParams.WRAP_CONTENT ->{
                    params.width = ViewGroup.LayoutParams.WRAP_CONTENT
                }
                else ->{
                    params.width = DpiUtils.dip2px(Utils.getContext(),StringUtils.parseInt(i))
                }
            }
            layoutParams = params
        } catch (_: Exception) {
        }
    }

    @BindingAdapter("view_height")
    @JvmStatic
    internal fun View.ai(i: Int?) {
        try {
            val params = layoutParams
            when (i) {
                0 -> {
                    params.height = 0
                }
                ViewGroup.LayoutParams.MATCH_PARENT ->{
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT
                }
                ViewGroup.LayoutParams.WRAP_CONTENT ->{
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT
                }
                else ->{
                    params.height = DpiUtils.dip2px(Utils.getContext(),StringUtils.parseInt(i))
                }
            }
            layoutParams = params
        } catch (_: Exception) {
        }
    }
}