package com.example.administrator.liistiewcoban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> mangten;
    ArrayAdapter adapter;
    EditText edtten;
    Button btncapnhat,btnthem;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        edtten = (EditText) findViewById(R.id.edittexttensinhvien);
        btnthem = (Button) findViewById(R.id.buttonthem);
        btncapnhat = (Button) findViewById(R.id.buttoncapnhat);
        mangten = new ArrayList<>();
        mangten.add("Phạm Tấn Phát");
        mangten.add("Phạm Tấn 1");
        mangten.add("Phạm Tấn 2");
        mangten.add("Phạm Tấn 3");
        mangten.add("Phạm Tấn 4");
        mangten.add("Phạm Tấn 5");
        mangten.add("Phạm Tấn 6");
        mangten.add("Phạm Tấn 7");
        mangten.add("Phạm Tấn 8");
        mangten.add("Phạm Tấn 9");
        mangten.add("Phạm Tấn 10");
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangten);
        lv.setAdapter(adapter);

        int firstVisiblePosition = lv.getFirstVisiblePosition();
        View view = lv.getChildAt(0);
        int distFromTop = (view == null) ? 0 : view.getTop();
        lv.setSelectionFromTop(firstVisiblePosition, distFromTop);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtten.setText(mangten.get(i).toString());
                position = i;
            }
        });
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String update = edtten.getText().toString();
                mangten.set(position,update);
                adapter.notifyDataSetChanged();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String update = edtten.getText().toString();
                mangten.add(update);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
