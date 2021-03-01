package umn.ac.id.week5_33081;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private static String bentuk = "Path";
    private static int warna = Color.rgb(0,0,0);

    private Paint paintKu;
    private Path pathKu;
    private static Canvas kanvasku;
    private Bitmap bitmapKu;
    private float pathX, pathY, awalX, awalY, antarX, antarY;
    private static final float Toleransi_Sentuh = 4;

    private boolean clear = false;

    public void gantiBentuk(String bentukBaru){
        bentuk = bentukBaru;
    }

    public void gantiWarna(int red, int green, int blue){
        warna = Color.rgb(red, green, blue);
    }


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paintKu = new Paint();
        paintKu.setColor(warna);
        paintKu.setAntiAlias(true);
        paintKu.setDither(true);
        paintKu.setStyle(Paint.Style.STROKE);
        paintKu.setStrokeJoin(Paint.Join.ROUND);
        paintKu.setStrokeCap(Paint.Cap.ROUND);
        paintKu.setStrokeWidth(12);
        pathKu = new Path();
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldwidth, int oldheight) {
        super.onSizeChanged(width, height, oldwidth, oldheight);
        bitmapKu = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        kanvasku = new Canvas(bitmapKu);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmapKu, 0, 0, null);
        Paint lokalPaint = new Paint();
        lokalPaint.setStyle(Paint.Style.FILL);
        lokalPaint.setColor(Color.RED);
        canvas.drawCircle(50,50,50, lokalPaint);
        lokalPaint.setStyle(Paint.Style.STROKE);
        lokalPaint.setStrokeWidth(10);
        lokalPaint.setColor(Color.WHITE);
        canvas.drawLine(20,20,80,80, lokalPaint);
        canvas.drawLine(20,80,80,20, lokalPaint);
        // menggambar Bantuk antara(Rect, Oval dan Line)
        if (!clear) {
            if (bentuk.equalsIgnoreCase("Rect")) {
                canvas.drawRect(awalX, awalY, antarX, antarY, paintKu);
            } else if (bentuk.equalsIgnoreCase("Oval")) {
                canvas.drawOval(awalX, awalY, antarX, antarY, paintKu);
            } else if (bentuk.equalsIgnoreCase("Line")) {
                canvas.drawLine(awalX, awalY, antarX, antarY, paintKu);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mulaiSentuh(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                geser(x, y);
                break;
            case MotionEvent.ACTION_UP:
                lepas();
                break;
            default:
        }
        return true;
    }

    private void mulaiSentuh(float x, float y){
        if (x <= 100 && y <= 100) {
            kanvasku.drawColor(Color.WHITE);
            clear = true;
            invalidate();
        } else {
            if (bentuk.equalsIgnoreCase("Path")) {
                pathKu.moveTo(x, y);
                pathX = x;
                pathY = y;
            } else {
                awalX = x;
                awalY = y;
            }
            clear = false;
        }
    }

    private void geser(float x, float y){
        float dx = Math.abs(x - pathX);
        float dy = Math.abs(y - pathY);
        if (dx >= Toleransi_Sentuh || dy >= Toleransi_Sentuh){
            paintKu.setColor(warna);
            if (bentuk.equalsIgnoreCase("Path")){
                pathKu.quadTo(pathX, pathY, (x + pathX)/ 2, (y + pathY)/2);
            pathX = x;
            pathY = y;
            } else{
                antarX = x;
                antarY = y;
            }
        }
        invalidate();
    }

    private void lepas() {
        if (!clear) {
            if (bentuk.equalsIgnoreCase("Path")) {
                pathKu.reset();
            } else if (bentuk.equalsIgnoreCase("Rect")) {
                kanvasku.drawRect(awalX, awalY, antarX, antarY, paintKu);
            } else if (bentuk.equalsIgnoreCase("Oval")) {
                kanvasku.drawOval(awalX, awalY, antarX, antarY, paintKu);
            } else if (bentuk.equalsIgnoreCase("Line")) {
                kanvasku.drawLine(awalX, awalY, antarX, antarY, paintKu);
            }
        }
    }

}
