package club.aborigen.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/public/v2/users")
    Call<List<User>> fetchAllUsers();
    @GET("/public/v2/users/{id}")
    Call<User> fetchUser(@Path("id") Integer id);
}