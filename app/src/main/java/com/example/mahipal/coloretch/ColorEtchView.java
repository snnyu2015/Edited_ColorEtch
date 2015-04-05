package com.example.mahipal.coloretch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class ColorEtchView extends View {


final RectF blueRect = new RectF(0.0f, 0.0f, 40.0f, 40.0f);
final RectF greenRect = new RectF(40.0f, 0.0f, 80.0f, 40.0f);
final RectF redRect = new RectF(80.0f, 0.0f, 120.0f, 40.0f);


   final Path path = new Path();
   final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);



    public ColorEtchView(Context context) {
        super(context);


        //paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);



        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        path.moveTo(event.getX(), event.getY());
                        invalidate();	//call onDraw


//change the stroke colors:
                    if (blueRect.contains(event.getX(),event.getY())) {
                        //path.reset();
                        paint.setColor(Color.BLUE);

                    }
                    else if(greenRect.contains(event.getX(),event.getY())) {
                       //path.reset();
                        paint.setColor(Color.GREEN);
                    }


                    else if(redRect.contains(event.getX(),event.getY())) {
                        //path.reset();
                        paint.setColor(Color.RED);
                    }
                        else{}


                        return true;

                    case MotionEvent.ACTION_MOVE:

                        path.lineTo(event.getX(), event.getY());
                        invalidate();	//call onDraw



                        return true;



                    default:

                        return false;
                }
            }
        });


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);	//background
        canvas.drawPath(path, paint);


        //RectF blueRect = new RectF();
        blueRect.set(0.0f, 0.0f, 40.0f, 40.0f); //left, top, right, bottom
        Paint blue = new Paint(); //setting up blue variable to paint rectangle blue
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);


        //RectF greenRect = new RectF();
        greenRect.set(40, 0, 80, 40); //left, top, right, bottom
        Paint green = new Paint();
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);

        //RectF redRect = new RectF(80, 0, 120, 40);
        redRect.set(80, 0, 120, 40); //left, top, right, bottom
        Paint red = new Paint();
        red.setColor(Color.RED);
        red.setStyle(Paint.Style.FILL);


        canvas.drawRect(blueRect, blue); //This makes the blue rectangle finally appear on Canvas "canvas"
        canvas.drawRect(greenRect, green);
        canvas.drawRect(redRect, red);


    }


}

