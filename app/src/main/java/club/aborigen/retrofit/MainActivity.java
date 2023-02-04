package club.aborigen.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.fetchUser(255419);
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Response<User> resp = call.execute();
                    Log.i("RTR", "Response: " + resp.body());
                } catch (Exception e) {
                    Log.e("RTR", "Request failed: " + e);
                }
            }
        };
        t.start();
    }
}