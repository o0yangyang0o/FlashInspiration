package com.heima.nicephoto;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private ImageView iv;
	private SeekBar sb_red;
	private SeekBar sb_green;
	private SeekBar sb_blue;
	private Paint paint;
	private Bitmap bitmap;
	private Canvas canvas;
	private Bitmap aftBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 初始化控件
		iv = (ImageView) findViewById(R.id.iv);
		sb_red = (SeekBar) findViewById(R.id.sb_red);
		sb_green = (SeekBar) findViewById(R.id.sb_green);
		sb_blue = (SeekBar) findViewById(R.id.sb_blue);
		// 1,利用位图工厂获取原图
		bitmap = BitmapFactory.decodeFile("/mnt/sdcard/demo1.jpg");
		// 2,拷贝原图,创建画纸,再修改
		aftBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
				bitmap.getConfig());
		// 3,根据拷贝后的画纸创建画板
		canvas = new Canvas(aftBitmap);
		// 4,创建画笔
		paint = new Paint();
		// 对画笔参数进行设置
		paint.setColor(Color.BLACK);
		// 5,给滑块注册一个滑动的监听事件
		sb_red.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// 获取滑条当前停止的位置
				int progress = seekBar.getProgress();
				// 根据当前位置设置颜色矩阵
				float rate_red = progress / 50f;

				ColorMatrix matrix = new ColorMatrix();
				matrix.set(new float[] { 1 * rate_red, 0, 0, 0, 0, 0, 1, 0, 0,
						0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 });
				paint.setColorFilter(new ColorMatrixColorFilter(matrix));
				// 开始作画
				canvas.drawBitmap(bitmap, new Matrix(), paint);
				iv.setImageBitmap(aftBitmap);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

			}
		});
		sb_green.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// 获取滑条当前停止的位置
				int progress = seekBar.getProgress();
				// 根据当前位置设置颜色矩阵
				float rate_green = progress / 50f;

				ColorMatrix matrix = new ColorMatrix();
				matrix.set(new float[] { 1, 0, 0, 0, 0, 0, 1 * rate_green, 0,
						0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 });
				paint.setColorFilter(new ColorMatrixColorFilter(matrix));
				// 开始作画
				canvas.drawBitmap(bitmap, new Matrix(), paint);
				iv.setImageBitmap(aftBitmap);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

			}
		});
		sb_blue.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// 获取滑条当前停止的位置
				int progress = seekBar.getProgress();
				// 根据当前位置设置颜色矩阵
				float rate_blue = progress / 50f;

				ColorMatrix matrix = new ColorMatrix();
				matrix.set(new float[] { 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
						1 * rate_blue, 0, 0, 0, 0, 0, 1, 0 });
				paint.setColorFilter(new ColorMatrixColorFilter(matrix));
				// 开始作画
				canvas.drawBitmap(bitmap, new Matrix(), paint);
				iv.setImageBitmap(aftBitmap);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
