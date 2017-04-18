package com.jal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.jal.weatherdemo.R;

/**
 * Created by SEELE on 2017/4/17.
 */

public class EditTextWithDel extends EditText {

    private Context context;

    private Drawable drawable;

//    private final static String TAG = "EditTextWithDel";

    public EditTextWithDel(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public EditTextWithDel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public EditTextWithDel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init();
    }

    private void init() {
        drawable = context.getResources().getDrawable(R.mipmap.login_password_close);

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }


        });

        setDrawable();
    }

    private void setDrawable() {
        if(length()<1){
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(drawable!=null&&event.getAction()==MotionEvent.ACTION_UP){
            int eventX= (int) event.getRawX();
            int eventY= (int) event.getRawY();

            Rect rect=new Rect();
            getGlobalVisibleRect(rect);

            rect.left=rect.right-50;

            if(rect.contains(eventX,eventY)){
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
