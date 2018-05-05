package com.sma_rasanehsoft.phonebook2;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;

import Adaptors.AdapterPerson;
import Models.Persons;
import ServerRetrofit.AnswerPosts;
import ServerRetrofit.Post;
import StructPerson.StructPerson;
import activity.Fulltext_Activity;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

public class MainActivity extends ActivityEnhanced  {
    public static AdapterPerson adapter;
    public static RecyclerView rvPersons;
    private SwipeRefreshLayout swpReload;
    private boolean exit = false;
    public String tablename = Persons.tableName;
    DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        rvPersons = (RecyclerView) findViewById(R.id.rvPersons);

        adapter = new AdapterPerson(Persons.all());
        rvPersons.setLayoutManager(new LinearLayoutManager(App.ACTIVITY));
        rvPersons.setHasFixedSize(true);
        rvPersons.setAdapter(adapter);
        rvPersons.setItemAnimator(new LandingAnimator());
        adapter.notifyDataSetChanged();
        rvPersons.setItemViewCacheSize(20);
        rvPersons.setDrawingCacheEnabled(true);
        rvPersons.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        swpReload = (SwipeRefreshLayout) findViewById(R.id.swpReload);


        swpReload.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Post().getPosts(new AnswerPosts() {
                    @Override
                    public void AnswerBase(ArrayList<StructPerson> answer) {
                        Persons.clear();

                        for (StructPerson person : answer) {
                            Persons.save(person);
                        }
                        adapter.persons = Persons.all();
                        adapter.notifyDataSetChanged();
                        swpReload.setRefreshing(false);
                    }

                    @Override
                    public void SendError(Throwable t) {

                        Toast.makeText(App.CONTEXT, R.string.Connectivity_check_alert,Toast.LENGTH_LONG).show();
                        if (swpReload.isRefreshing()) {
                            swpReload.setRefreshing(false);
                        }
                    }
                });
            }
        });
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.imgsearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.startActivity(ActivitySearch.class,false);

            }
        });


        findViewById(R.id.imgfavactivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.startActivity(FavItemsActivity.class,false);

            }
        });


        findViewById(R.id.hambergurmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
//        findViewById(R.id.btnregister).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "مهمان گرامی بخش ورود و ثبت نام در حال حاضر غیر فعال میباشد!", Toast.LENGTH_LONG).show();
//            }
//        });
        findViewById(R.id.txtafgnews).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, CatActivity.class);
                intent.putExtra("cat","2");
                startActivity(intent);
            }
        });
        findViewById(R.id.txtmohajerin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, CatActivity.class);
                intent.putExtra("cat","87");
                startActivity(intent);
            }
        });
        findViewById(R.id.txtvariousnews).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, CatActivity.class);
                intent.putExtra("cat","127");
                startActivity(intent);
            }
        });
        findViewById(R.id.txtsport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, CatActivity.class);
                intent.putExtra("cat","96");
                startActivity(intent);
            }
        });
        findViewById(R.id.txtscience).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, CatActivity.class);
                intent.putExtra("cat","98");
                startActivity(intent);
            }
        });
        findViewById(R.id.Film).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, CatActivity.class);
                intent.putExtra("type","4");
                startActivity(intent);
            }
        });
        findViewById(R.id.Email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"afghanistanema@gmail.com"});
                    intent.setData(Uri.parse("mailto:"));
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(App.CONTEXT, "برنامه ای برای ارسال ایمیل یافت نشد!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.aboutus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentabout=new Intent(App.CONTEXT,AboutUs.class);
                startActivity(intentabout);
            }
        });
        findViewById(R.id.imgsearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.CONTEXT, ActivitySearch.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.afglogo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.afghanistanema.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        Cursor cursor = App.DB.rawQuery("SELECT * FROM \"" + tablename + "\""  , null);
        if(cursor.moveToFirst()){
            final String id = cursor.getString(0);
            final String title = cursor.getString(1);
            final String fulltext = cursor.getString(2);
            final String introtext= cursor.getString(3);

            SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
            sliderShow.setDuration(10000);
            sliderShow.setPresetTransformer(SliderLayout.Transformer.Fade);
            sliderShow.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView.description(title);
            textSliderView.image("http://192.168.1.201/joomla/" +introtext);
            textSliderView.setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Intent intent = new Intent(App.CONTEXT, Fulltext_Activity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("title", title);
                    intent.putExtra("fulltext", fulltext);
                    intent.putExtra("image",introtext );
                    intent.putExtra("featured", true);
                    intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    App.CONTEXT.startActivity(intent);

                }
            });
            sliderShow.addSlider(textSliderView);
        }
  }


//        swpReload.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                if (OnlineCheck.isOnline()) {
//                    new AsyncRead().setOnDataReceivedListener(new AsyncRead.OnDataReceivedListener() {
//                        @Override
//                        public void OnDataReceived(ArrayList<StructPerson> result) {
//                            Persons.clear();
//                            for (StructPerson person : result) {
//                                Persons.save(person);
//                            }
//                            adapter.persons = Persons.all();
//                            adapter.notifyDataSetChanged();
//                            swpReload.setRefreshing(false);
//                        }
//                    })
//                            .execute(0);
//
//                } else {
//                    Toast.makeText(App.CONTEXT, R.string.Connectivity_check_alert,Toast.LENGTH_LONG).show();
//                    if (swpReload.isRefreshing()) {
//                        swpReload.setRefreshing(false);
//                    }
//                }
//            }
//        });}
    @Override
    public void onBackPressed() {
        if (exit) {
            System.exit(0);
        } else {
            exit = true;
            Toast.makeText(App.CONTEXT, R.string.confirm_exit,Toast.LENGTH_SHORT).show();
            App.HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 2000);
        }
    }

}
