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

    //final Button blueButton;
    //final Button redButton;
    //final Button greenButton;
   //final Button skyBlueButton;
    //final Button limeGreenButton;
    //final Button purpleButton;
   //final Button magentaButton;
   //final Button lightPinkButton;
   //final Button yellowButton;
   //final Button orangeButton;



    final Path path = new Path();
    final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ColorEtchView(Context context) {
        super(context);

        //Switch(paint) {
        //Case R.id.redButton:
        //redButton.isPressed();
        // paint.setColor(Color.parseColor("#ffff1e15"));
        //break;
        // }


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);

        //LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.color_picker, null);

        //blueButton = (Button)linearLayout.findViewById(R.id.blueButton);
        //redButton = (Button) linearLayout.findViewById(R.id.redButton);
        //greenButton = (Button) linearLayout.findViewById(R.id.greenButton);
        //skyBlueButton = (Button) linearLayout.findViewById(R.id.skyBlueButton);
        //limeGreenButton = (Button) linearLayout.findViewById(R.id.limeGreenButton);
        //purpleButton = (Button) linearLayout.findViewById(R.id.purpleButton);
        //magentaButton = (Button) linearLayout.findViewById(R.id.magentaButton);
        //lightPinkButton = (Button) linearLayout.findViewById(R.id.lightPinkButton);
        //yellowButton = (Button) linearLayout.findViewById(R.id.yellowButton);
        //orangeButton = (Button) linearLayout.findViewById(R.id.orangeButton);

        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        path.moveTo(event.getX(), event.getY());
                        invalidate();	//call onDraw
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

        RectF blueRect = new RectF();
        blueRect.set(0, 0, 40, 40); //left, top, right, bottom
        Paint blue = new Paint(); //setting up blue variable to paint rectangle blue
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);


        RectF greenRect = new RectF();
        greenRect.set(40, 0, 80, 40); //left, top, right, bottom
        Paint green = new Paint();
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);

        RectF redRect = new RectF(80, 0, 120, 40);
        redRect.set(80, 0, 120, 40); //left, top, right, bottom
        Paint red = new Paint();
        red.setColor(Color.RED);
        red.setStyle(Paint.Style.FILL);


        canvas.drawRect(blueRect, blue); //This makes the blue rectangle finally appear on Canvas "canvas"
        canvas.drawRect(greenRect, green);
        canvas.drawRect(redRect, red);


    }


}
