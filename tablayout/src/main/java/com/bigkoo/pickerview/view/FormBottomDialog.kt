package com.bigkoo.pickerview.view

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatTextView
import com.androidkun.xtablayout.R
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter
import com.ved.framework.widget.TouchOutsideDialog


class FormBottomDialog : TouchOutsideDialog {
    private val mContext: Context
    private val mOptionsItems: MutableList<String> = mutableListOf()
    private var mSelected:String = ""
    private lateinit var mDetermine: (String) -> Unit

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, theme: Int) : super(context, theme) {
        mContext = context
        initDialog()
    }

    /**
     * 设置默认值
     */
    fun setDefaultValue(v:String){
        mSelected = v
    }

    /**
     * 设置数据
     */
    fun setData(data:MutableList<String>){
        mOptionsItems.addAll(data)
    }

    /**
     * 设置确定按钮的监听器
     */
    fun setDetermine(click: (String) -> Unit){
        mDetermine = click
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.pickerview_time)
        val wheelView : com.contrarywind.view.WheelView = findViewById(R.id.year)
        val month : com.contrarywind.view.WheelView = findViewById(R.id.month)
        val day : com.contrarywind.view.WheelView = findViewById(R.id.day)
        val hour : com.contrarywind.view.WheelView = findViewById(R.id.hour)
        val min : com.contrarywind.view.WheelView = findViewById(R.id.min)
        val second : com.contrarywind.view.WheelView = findViewById(R.id.second)
        val btnCancel : AppCompatTextView = findViewById(R.id.btnCancel)
        val btnSubmit : AppCompatTextView = findViewById(R.id.btnSubmit)
        month.visibility = View.GONE
        day.visibility = View.GONE
        hour.visibility = View.GONE
        min.visibility = View.GONE
        second.visibility = View.GONE
        wheelView.setCyclic(false)
        if (mOptionsItems.isNotEmpty()) {
            wheelView.currentItem = mOptionsItems.indexOf(mSelected)
            wheelView.adapter = ArrayWheelAdapter(mOptionsItems)
        }
        wheelView.setOnItemSelectedListener {
            mSelected = mOptionsItems[it]
        }
        btnCancel.setOnClickListener{
            dismiss()
        }
        btnSubmit.setOnClickListener{
            mDetermine.invoke(mSelected)
            dismiss()
        }
    }

    private fun initDialog() {
        window?.let { win ->
            win.decorView.setPadding(0, 0, 0, 0)
            win.setGravity(Gravity.BOTTOM)
            val lp = win.attributes
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            win.attributes = lp
        }
        setCanceledOnTouchOutside(false)
        show()
    }
}