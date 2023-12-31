package com.codbking.widget;

import android.content.Context;
import android.widget.TextView;

import com.androidkun.xtablayout.R;
import com.codbking.widget.bean.DateType;
import com.codbking.widget.genview.WheelGeneralAdapter;
import com.codbking.widget.view.WheelView;

import java.util.Date;

/**
 * Created by codbking on 2016/8/10.
 */
class DatePicker extends BaseWheelPick {

    private static final String TAG = "WheelPicker";

    private WheelView yearView;
    private WheelView monthView;
    private WheelView dayView;
    private WheelView yearView1;
    private WheelView monthView1;
    private WheelView dayView1;
    private TextView weekView;
    private WheelView hourView;
    private WheelView minuteView;

    private Integer[] yearArr, mothArr, dayArr, hourArr, minutArr;
    private DatePickerHelper datePicker;

    public DateType type = DateType.TYPE_ALL;

    //开始时间
    private Date startDate = new Date();
    //年分限制，默认上下5年
    private int yearLimt = 5;

    private OnChangeLisener onChangeLisener;
    private int selectDay;

    //选择时间回调
    public void setOnChangeLisener(OnChangeLisener onChangeLisener) {
        this.onChangeLisener = onChangeLisener;
    }

    public DatePicker(Context context, DateType type) {
        super(context);
        if(this.type!=null){
            this.type = type;
        }
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setYearLimt(int yearLimt) {
        this.yearLimt = yearLimt;
    }

    //初始化值
    public void init() {

        this.minuteView = (WheelView) findViewById(R.id.minute);
        this.hourView = (WheelView) findViewById(R.id.hour);
        this.weekView = (TextView) findViewById(R.id.week);
        this.dayView = (WheelView) findViewById(R.id.day);
        this.monthView = (WheelView) findViewById(R.id.month);
        this.yearView = (WheelView) findViewById(R.id.year);
        this.dayView1 = (WheelView) findViewById(R.id.day1);
        this.monthView1= (WheelView) findViewById(R.id.month1);
        this.yearView1 = (WheelView) findViewById(R.id.year1);

        switch (type) {
            case TYPE_ALL:
                this.minuteView.setVisibility(GONE);
                this.hourView.setVisibility(GONE);
                this.weekView.setVisibility(VISIBLE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);
                this.dayView1.setVisibility(VISIBLE);
                this.monthView1.setVisibility(VISIBLE);
                this.yearView1.setVisibility(VISIBLE);
                break;
            case TYPE_YMDHM:
                this.minuteView.setVisibility(VISIBLE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);
                break;
            case TYPE_YMDH:
                this.minuteView.setVisibility(GONE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);
                break;
            case TYPE_YMD:
                this.minuteView.setVisibility(GONE);
                this.hourView.setVisibility(GONE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(VISIBLE);
                this.monthView.setVisibility(VISIBLE);
                this.yearView.setVisibility(VISIBLE);
                break;
            case TYPE_HM:
                this.minuteView.setVisibility(VISIBLE);
                this.hourView.setVisibility(VISIBLE);
                this.weekView.setVisibility(GONE);
                this.dayView.setVisibility(GONE);
                this.monthView.setVisibility(GONE);
                this.yearView.setVisibility(GONE);
                break;
        }

        datePicker = new DatePickerHelper();
        datePicker.setStartDate(startDate, yearLimt);

        dayArr = datePicker.genDay();
        yearArr = datePicker.genYear();
        mothArr = datePicker.genMonth();
        hourArr = datePicker.genHour();
        minutArr = datePicker.genMinut();

//        weekView.setText(datePicker.getDisplayStartWeek());

        setWheelListener(yearView, yearArr, false);
        setWheelListener(monthView, mothArr, true);
        setWheelListener(dayView, dayArr, true);
        setWheelListener(yearView1, yearArr, false);
        setWheelListener(monthView1, mothArr, true);
        setWheelListener(dayView1, dayArr, true);
        setWheelListener(hourView, hourArr, true);
        setWheelListener(minuteView, minutArr, true);

        yearView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.YEAR), yearArr));
        monthView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.MOTH), mothArr));
        dayView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.DAY), dayArr));
        yearView1.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.YEAR), yearArr));
        monthView1.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.MOTH), mothArr));
        dayView1.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.DAY), dayArr));
        hourView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.HOUR), hourArr));
        minuteView.setCurrentItem(datePicker.findIndextByValue(datePicker.getToady(DatePickerHelper.Type.MINUTE), minutArr));

    }


    protected String[] convertData(WheelView wheelView, Integer[] data) {
        if (wheelView == yearView) {
            return datePicker.getDisplayValue(data, "年");
        } else if (wheelView == monthView) {
            return datePicker.getDisplayValue(data, "月");
        } else if (wheelView == dayView) {
            return datePicker.getDisplayValue(data, "日");
        } else if (wheelView == yearView1) {
            return datePicker.getDisplayValue(data, "年");
        } else if (wheelView == monthView1) {
            return datePicker.getDisplayValue(data, "月");
        }else if (wheelView == dayView1) {
            return datePicker.getDisplayValue(data, "日");
        }
        return new String[0];
    }

    @Override
    protected int getLayout() {
        return R.layout.cbk_wheel_picker;
    }

    @Override
    protected int getItemHeight() {
        return dayView.getItemHeight();
    }


    @Override
    protected void setData(Object[] datas) {
    }

    private void setChangeDaySelect(int year, int moth) {
        dayArr = datePicker.genDay(year, moth);
        WheelGeneralAdapter adapter= (WheelGeneralAdapter) dayView.getViewAdapter();
        WheelGeneralAdapter adapter1= (WheelGeneralAdapter) dayView1.getViewAdapter();
        adapter.setData(convertData(dayView,  dayArr));
        adapter1.setData(convertData(dayView1,  dayArr));

        int indxt = datePicker.findIndextByValue(selectDay, dayArr);
        if (indxt == -1) {
            dayView.setCurrentItem(0);
            dayView1.setCurrentItem(0);
        } else {
            dayView.setCurrentItem(indxt);
            dayView1.setCurrentItem(indxt);
        }
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {

        int year = yearArr[yearView.getCurrentItem()];
        int moth = mothArr[monthView.getCurrentItem()];
        int day = dayArr[dayView.getCurrentItem()];
        int year1 = yearArr[yearView1.getCurrentItem()];
        int moth1 = mothArr[monthView1.getCurrentItem()];
        int day1 = dayArr[dayView1.getCurrentItem()];
        int hour = hourArr[hourView.getCurrentItem()];
        int minut = minutArr[minuteView.getCurrentItem()];

        if (wheel == yearView || wheel == monthView) {
            setChangeDaySelect(year, moth);
        } else {
            selectDay = day;
        }

        if (wheel == yearView || wheel == monthView || wheel == dayView) {
//            weekView.setText(datePicker.getDisplayWeek(year, moth, day));
        }

        if (onChangeLisener != null) {
            onChangeLisener.onChanged(DateUtils.getDate(year, moth, day),DateUtils.getDate(year1, moth1, day1));
        }

    }

    @Override
    public void onScrollingStarted(WheelView wheel) {
    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
    }


    //获取选中日期
    public Date getSelectDate() {

        int year = yearArr[yearView.getCurrentItem()];
        int moth = mothArr[monthView.getCurrentItem()];
        int day = dayArr[dayView.getCurrentItem()];

        int hour = hourArr[hourView.getCurrentItem()];
        int minut = minutArr[minuteView.getCurrentItem()];

        return DateUtils.getDate(year, moth, day);

    }
    //获取选中日期
    public Date getSelectDates() {


        int year1 = yearArr[yearView1.getCurrentItem()];
        int moth1 = mothArr[monthView1.getCurrentItem()];
        int day1 = dayArr[dayView1.getCurrentItem()];
        int hour = hourArr[hourView.getCurrentItem()];
        int minut = minutArr[minuteView.getCurrentItem()];

        return DateUtils.getDate(year1, moth1,day1);

    }



}
