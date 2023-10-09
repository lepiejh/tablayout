package com.utils

import java.io.ObjectStreamException
import java.util.*

class TimeNow private constructor() {
    private object SingletonHolder {
        val instance = TimeNow()
    }

    //防止反序列化产生多个对象
    @Throws(ObjectStreamException::class)
    private fun readResolve(): Any {
        return SingletonHolder.instance
    }

    companion object {
        fun getInstance() = SingletonHolder.instance
    }

    fun parseCalendar(timeMillis: Long): Calendar = Calendar.getInstance().apply {
        timeInMillis = timeMillis
        set(get(Calendar.YEAR),
            get(Calendar.MONTH),
            get(Calendar.DAY_OF_MONTH),
            get(Calendar.HOUR_OF_DAY),
            get(Calendar.MINUTE))
    }

    /**
     * 开始时间  ---> 当前时间
     */
    fun getCurrentStarTime(): Calendar = Calendar.getInstance().apply {
        when (get(Calendar.MINUTE)) {
            0 -> {
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    1
                )
            }
            in 1..9 -> {
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    10
                )
            }
            in 10..19 -> {
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    20
                )
            }
            in 20..29 -> {
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    30
                )
            }
            in 30..39 -> {
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    40
                )
            }
            in 40..49 -> {
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    50
                )
            }
            in 50..59 -> {
                val current = timeInMillis + 600000
                time = Date().apply {
                    time = current
                }
                set(
                    get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    1
                )
            }
            else ->{
                set(get(Calendar.YEAR),
                    get(Calendar.MONTH),
                    get(Calendar.DAY_OF_MONTH),
                    get(Calendar.HOUR_OF_DAY),
                    get(Calendar.MINUTE))
            }
        }
    }

    /**
     * 结束时间  + 8H
     */
    fun getCurrentEndTime(startCal: Calendar?): Calendar? = Calendar.getInstance().apply {
        time = Date().apply {
            startCal?.timeInMillis?.let {
                time = it + 28800000
            }
        }
    }

    fun getRangCal(startCal: Calendar?): Calendar? = Calendar.getInstance().apply {
        startCal?.get(Calendar.YEAR)?.let { y ->
            set(
                y + 1,
                startCal.get(Calendar.MONTH),
                startCal.get(Calendar.DAY_OF_MONTH),
                startCal.get(Calendar.HOUR_OF_DAY),
                startCal.get(Calendar.MINUTE)
            )
        }
    }
}