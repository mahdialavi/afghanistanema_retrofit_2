package com.sma_rasanehsoft.phonebook2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Adaptors.AdapterPerson;
import ServerRetrofit.AnswerPosts;
import ServerRetrofit.Post;
import StructPerson.StructPerson;

public class ActivitySearch extends ActivityEnhanced {
    RecyclerView rvPersons;
    AdapterPerson adapter;
    LinearLayout desConnect,notfind;
    EditText txtsearch;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("درحال بارگیری...");
        progressDialog.setTitle("لطفا صبر کنید...");

//        if (Persons.all().size() > 0) {
//            adapter = new AdapterPerson(Persons.all());
//        }
        rvPersons = (RecyclerView) findViewById(R.id.searchRecycle);
        desConnect = (LinearLayout) findViewById(R.id.desConnect);
        notfind = (LinearLayout) findViewById(R.id.notfind);
        rvPersons.setHasFixedSize(true);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));
        rvPersons.setNestedScrollingEnabled(false);
        rvPersons.setAdapter(adapter);
        txtsearch = (EditText) findViewById(R.id.txtsearch);
        txtsearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String text = txtsearch.getText().toString();
                if (!text.equals("")){
                    Search(text);
                }else {
                    Toast.makeText(ActivitySearch.this, "لطفا ورودی را چک کنید!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        findViewById(R.id.connectretry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desConnect.setVisibility(View.GONE);
                String text = txtsearch.getText().toString();
                if (!text.equals("")){
                    Search(text);
                }else {
                    Toast.makeText(ActivitySearch.this, "لطفا ورودی را چک کنید!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.imgsearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtsearch.getText().toString();



//                if (!text.equals("")){
                    Search(text);
//                }else {
//                    Toast.makeText(ActivitySearch.this, "لطفا ورودی را چک کنید!", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        findViewById(R.id.imgback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void Search(String text){
        progressDialog.show();
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }


        Post post =new Post();
        post.getPostsSearch(text,new AnswerPosts() {
            @Override
            public void AnswerBase(ArrayList<StructPerson> answer) {
//                rvPersons.removeAllViews();
//                }
                if (answer != null) {
//                    AdapterPerson.persons.clear();
//                    adapter.setPersons(answer);
                    adapter = new AdapterPerson(answer);
                    rvPersons.setLayoutManager(new LinearLayoutManager(App.ACTIVITY));
                    rvPersons.setHasFixedSize(true);
                    rvPersons.setAdapter(adapter);
                    progressDialog.dismiss();
                    rvPersons.removeAllViews();
                    adapter.notifyDataSetChanged();

                } else {
                    adapter = new AdapterPerson(App.persons);
                    notfind.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void SendError(Throwable t) {
//                rvPersons.removeAllViews();
//
                 progressDialog.dismiss();

                    App.toast("no");


//                 desConnect.setVisibility(View.VISIBLE);
//                App.toast("error");
            }
        });

    }
}
