package com.example.nestedrecycleview.InterFace;
import com.example.nestedrecycleview.CourseD.CourseHis;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

 @GET("/api/home_list")
 Call<CourseHis> home_list();

}
