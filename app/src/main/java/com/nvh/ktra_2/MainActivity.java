package com.nvh.ktra_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Contacts> arrayList;
    Adapter adapter;
    int location=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        adapter=new Adapter(MainActivity.this,R.layout.row,arrayList);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                location=i;
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this,Detail.class));
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.setHeaderIcon(R.drawable.ic_baseline_add);
        menu.setHeaderTitle("Thông báo");
        super.onCreateContextMenu(menu, v, menuInfo);
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_xoa:
                Delete(location);
                break;
        }
        return super.onContextItemSelected(item);
    }



    private void mapping(){
        listView=(ListView) findViewById(R.id.listview);
        arrayList=new ArrayList<>();
        arrayList.add(new Contacts(R.drawable.vanhai,"Nguyễn Văn Hải"));
        arrayList.add(new Contacts(R.drawable.hanh,"Nguyễn Văn Hải"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Văn Ngọc Hùng"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Đinh Ngọc Trang"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Nguyễn Văn Hải"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Nguyễn Thanh Duy"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Văn Ngọc Hùng"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Đinh Ngọc Trang"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Bùi Duy Thảo"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Nguyễn Văn Hải"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Văn Ngọc Hùng"));
        arrayList.add(new Contacts(R.drawable.vanhai,"Đinh Ngọc Trang"));
    }
    private void Delete(final int position){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo !!!");
        alertDialog.setIcon(R.drawable.ic_launcher_foreground);
        alertDialog.setMessage("Can you want delete line "+arrayList.get(position).getTitle()+" in listview ?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Bạn đã xóa thành công !!",Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
}
