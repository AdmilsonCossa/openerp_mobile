/*
 * Copyright (C) 2013  stevendreamer (in github)
 * Project Location: https://github.com/stevendreamer/openerp_mobile

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * Addition: any copy of this program should keep the author name info.
 * any copy without the author info will be a pirate

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.oe.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zijunlin.Zxing.Demo.CaptureActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.TabActivity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

public class MainActivity extends Activity {

	private static final String TAG = "==CrazyIt.org==";

	// this is the images used in the main page.
	int[] imageIds = new int[] { R.drawable.message, R.drawable.crm,
			R.drawable.inventory, R.drawable.po, R.drawable.sales,
			R.drawable.mo, R.drawable.reports, R.drawable.reports2,
			R.drawable.barcode_scanner, R.drawable.nopic };
	// this is the descriptions used in the main page, under the descriptions
	/*
	String message = "Message", CRM = "CRM", inventory = "���", purchase = "�ɹ�",
			sales = "����", manufacture = "����", reports = "����",
			chartTest = "ChartTest", barcodeTest = "BarcodeTest",
			bitmapTest = "����ͼƬ";

	String[] descs = new String[] { message, CRM, inventory, purchase, sales,
			manufacture, reports, chartTest, barcodeTest, bitmapTest };
*/
	
	String[] descs = new String[] { "Message", "CRM", "���", "�ɹ�", "����",
			"����","����" ,"ChartTest","ScanTest","ImageTest"};
	ArrayList<HashMap<String, Object>> lstImageItems = new ArrayList<HashMap<String, Object>>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// create the main page of 9 icons
		for (int i = 0; i < descs.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemImage", imageIds[i]);
			map.put("itemText", descs[i]);
			// map.put("nextActivityName", activityNames[i]);

			lstImageItems.add(map);
		}

		SimpleAdapter sa = new SimpleAdapter(this, lstImageItems,
				R.layout.grid_items, new String[] { "itemImage", "itemText" },
				new int[] { R.id.itemImage, R.id.itemText });

		GridView grid = (GridView) findViewById(R.id.main_grid);
		grid.setAdapter(sa);
		grid.setOnItemClickListener(new ItemClickListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Log.i("ZZYAN", "INSIDE ONITEMCLICK");
			// TODO Auto-generated method stub
			HashMap<String, Object> item = (HashMap<String, Object>) arg0
					.getItemAtPosition(arg2);
			String itemText = (String) item.get("itemText");
			Log.i("ZZYAN", "itemText:" + itemText);
			Intent intent = new Intent(MainActivity.this, MenuActivity.class);
			intent.putExtra("menuName", itemText);

			if (intent != null) {
				startActivity(intent);
			}
		}
	}
}
