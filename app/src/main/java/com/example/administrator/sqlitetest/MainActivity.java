package com.example.administrator.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import db.BankDAO;

public class MainActivity extends AppCompatActivity {

    private BankDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new BankDAO(this);
    }
    public void insert(View v) {

        dao.insert("zhangsan", 12);
        dao.insert("lisi", 22);
        dao.insert("wangwu", 32);
        dao.insert("zhaoqi", 42);

    }

    public void delete(View v) {
        dao.delete("zhaoqi");
    }

    public void update(View v) {
        dao.update("lisi", 62);
    }

    public void query(View v) {
        float query = dao.query("lisi");

        Toast.makeText(this, "" + query, Toast.LENGTH_LONG).show();
    }

}
