package com.sma_rasanehsoft.phonebook2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import Adaptors.AdapterPerson;
import ServerRetrofit.AnswerPosts;
import ServerRetrofit.Post;
import StructPerson.StructPerson;

public class CatActivity extends ActivityEnhanced {
    String cat ;
    LinearLayoutManager manager;
    RecyclerView rvPersons;
    AdapterPerson adapter;
    ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cat);
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("درحال بارگیری...");
            progressDialog.setTitle("لطفاصبر کنید...");
            progressDialog.show();
            Bundle bundle = getIntent().getExtras();
            cat = bundle.getString("cat", cat);
            rvPersons= (RecyclerView) findViewById(R.id.recyclerNews);
            manager = new LinearLayoutManager(this);
            rvPersons.setLayoutManager(manager);
            adapter= new AdapterPerson(new ArrayList<StructPerson>());
            rvPersons.setAdapter(adapter);
            findViewById(R.id.imgback).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               finish();
                }
            });

            new Post().getPostCat(cat, new AnswerPosts() {
                @Override
                public void AnswerBase(ArrayList<StructPerson> answer) {
                    adapter.setPersons(answer);
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();
                }

                @Override
                public void SendError(Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(CatActivity.this, "مشکل در ارتباط با سرور لطفا بعدا امتحان کنید.", Toast.LENGTH_LONG).show();
                    finish();
                }
            });
        }







    }
