package com.example.nestedrecycleview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecycleview.CourseD.CourseHis;
import com.example.nestedrecycleview.CourseD.Remain;
import com.example.nestedrecycleview.CourseD.TopCourse;
import com.example.nestedrecycleview.CourseD.Upper;
import com.example.nestedrecycleview.InterFace.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity
        extends AppCompatActivity {
    APIInterface apiInterface;
    List<ParentItem> itemList;
    String type = "";
    LinearLayoutManager
            layoutManager;
    RecyclerView
            ParentRecyclerViewItem;
    List<ChildItem> ChildItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        type = i.getStringExtra("type");

        itemList  = new ArrayList<>();
        ChildItemList  = new ArrayList<>();

        ParentRecyclerViewItem    = findViewById(
                R.id.parent_recyclerview);

        // Initialise the Linear layout manager

              layoutManager  = new LinearLayoutManager(
                MainActivity.this);
        home_list();


    }



    public void home_list() {

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<CourseHis> call = apiInterface.home_list();
        call.enqueue(new Callback<CourseHis>() {
            @Override
            public void onResponse(Call<CourseHis> call, Response<CourseHis> response) {
                Log.e("respoooo", response.message());
                CourseHis courseHis = response.body();
                Log.e("responce", courseHis + "getdata");
                if (courseHis.getType().equals(true)) {
                    ChildItemList = new ArrayList<>();
                //    itemList.clear();
                    if (type.equals("upper")) {
                        List<Upper> teamlist = courseHis.getUpper();
                        for (int i = 0; i < teamlist.size(); i++) {

                            for (int col = 0; col < teamlist.get(i).getCourses().size(); col++)
                            {

                                ChildItemList.add(new ChildItem(teamlist.get(i).getCourses().get(col).getChildcatName(),teamlist.get(i).getCourses().get(col).getImg() ));
                            }
                                ParentItem item
                                    = new ParentItem(
                                    teamlist.get(i).getTitle(),
                                        ChildItemList);
                            itemList.add(item);
                        }
                    }
                    if (type.equals("remain")) {
                        List<Remain> teamlist = courseHis.getRemain();
                        for (int i = 0; i < teamlist.size(); i++) {
                            for (int col = 0; col < teamlist.get(i).getCourses().size(); col++)
                            {

                                ChildItemList.add(new ChildItem(teamlist.get(i).getCourses().get(col).getTitle(),teamlist.get(i).getCourses().get(col).getImg() ));
                            }

                            ParentItem item
                                    = new ParentItem(
                                    teamlist.get(i).getTitle(),
                                   ChildItemList);
                            itemList.add(item);
                        }
                    }

                    if (type.equals("top")) {
                        List<TopCourse> teamlist = courseHis.getTopCourse();
                        for (int i = 0; i < teamlist.size(); i++) {
                            ParentItem item
                                    = new ParentItem(
                                    teamlist.get(i).getTitle(),
                                    ChildItemList);
                            itemList.add(item);
                        }
                    }
                    ParentItemAdapter parentItemAdapter = new ParentItemAdapter(itemList,MainActivity.this);
                    ParentRecyclerViewItem.setAdapter(parentItemAdapter);
                    ParentRecyclerViewItem.setLayoutManager(layoutManager);

                } else {
                    Log.e("responce", "fail");

                    Toast.makeText(MainActivity.this, "data not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CourseHis> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });

    }


}
