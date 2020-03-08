package tw.org.iii.ellen.ellen06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.LinkedList;

public class MyView extends View {
    private Paint paint ;
    private LinkedList<LinkedList<HashMap<String,Float>>> lines = new LinkedList<>() ;
    private LinkedList<LinkedList<HashMap<String,Float>>> recycler = new LinkedList<>() ;


    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //setBackgroundColor(Color.GRAY);
        paint = new Paint() ;
        paint.setColor(Color.GRAY) ;
        paint.setStrokeWidth(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas) ;
        for (LinkedList<HashMap<String,Float>> line : lines) {

            for (int i = 1; i < line.size(); i++) {
                HashMap<String, Float> p0 = line.get(i - 1);
                HashMap<String, Float> p1 = line.get(i);
                canvas.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"), paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            LinkedList<HashMap<String,Float>> line = new LinkedList<>() ;
            lines.add(line) ;
            //Log.v("ellen","down") ;
        }else {
            //Log.v("ellen","other") ;
        }

        float ex = event.getX() ;
        float ey = event.getY() ;
        HashMap<String,Float> point = new HashMap<>() ;
        point.put("x",ex) ;
        point.put("y",ey) ;
        lines.getLast().add(point) ;
        invalidate() ;  //相當於repaint()方法

        return true ; //super.onTouchEvent(event);
    }

    public void clear(){
        lines.clear() ;
        recycler.clear() ;
        invalidate() ;
    }

    public void redo(){
        if (recycler.size() > 0){
            lines.add(recycler.removeLast());
            invalidate();
        }
    }

    public void undo(){
        if (lines.size() > 0){
            recycler.add(lines.removeLast()) ;
            invalidate();
        }
    }

}
