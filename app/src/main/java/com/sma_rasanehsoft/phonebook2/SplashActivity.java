package com.sma_rasanehsoft.phonebook2;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import Adaptors.AdapterPerson;
import Models.Persons;
import ServerRetrofit.AnswerPosts;
import ServerRetrofit.Post;
import StructPerson.StructPerson;


public class SplashActivity extends ActivityEnhanced {
    LinearLayout disconnect;
    ImageView imageView3;
    private AdapterPerson adapter;
    private SwipeRefreshLayout swpReload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        disconnect = (LinearLayout) findViewById(R.id.desConnect);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        findViewById(R.id.connectretry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disconnect.setVisibility(View.GONE);
                recive1();
            }

        });
        recive1();

    }


    private void recive1() {
        new Post().getPosts(new AnswerPosts() {
            @Override
            public void AnswerBase(ArrayList<StructPerson> answer) {
                App.persons=answer;
                Persons.clear();
                for (StructPerson person : answer) {
                    Persons.save(person);
                }
                adapter.persons = Persons.all();
                App.startActivity(MainActivity.class,true);
            }


            @Override
            public void SendError(Throwable t) {

                if (Persons.all().size() > 0) {
                    App.HANDLER.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            App.startActivity(MainActivity.class,true);
                        }
                    }, 700);
                } else {
                    disconnect.setVisibility(View.VISIBLE);
                }
            }
        });
    }






//    public void recieve() {
//
//        if (OnlineCheck.isOnline()) {
//            final Timer timer = new Timer();
//            timer.scheduleAtFixedRate(new TimerTask() {
//                @Override
//                public void run() {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (Commands.read(0).size() > 0) {
//                                new AsyncRead().setOnDataReceivedListener(new AsyncRead.OnDataReceivedListener() {
//                                    @Override
//                                    public void OnDataReceived(ArrayList<StructPerson> result) {
//                                        Persons.clear();
//                                        for (StructPerson person : result) {
//                                            Persons.save(person);
//                                        }
//                                        adapter.persons = Persons.all();
//                                    }
//
//                                })
//                                        .execute(0);
//                            }
//                        }
//                    });
//                }
//            }, 1, 1000);
//            App.HANDLER.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(App.CONTEXT, MainActivity.class);
//                    startActivity(intent);
//                    timer.cancel();
//                    finish();
//
//
//                }
//            }, 2000);
//
//        }
//        else {
//            if (Persons.all().size() > 0) {
//                App.HANDLER.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(App.CONTEXT, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//
//                    }
//                }, 1000);
//            } else {
//
//                disconnect.setVisibility(View.VISIBLE);
//            }
//
//        }
//


//    }
}









