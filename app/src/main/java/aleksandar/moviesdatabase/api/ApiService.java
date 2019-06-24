package aleksandar.moviesdatabase.api;

import aleksandar.moviesdatabase.models.CreditsModel;
import aleksandar.moviesdatabase.models.Movie;
import aleksandar.moviesdatabase.models.MoviesModel;
import aleksandar.moviesdatabase.models.PeopleModel;
import aleksandar.moviesdatabase.models.Person;
import aleksandar.moviesdatabase.models.RequestToken;
import aleksandar.moviesdatabase.models.ResponseFavourites;
import aleksandar.moviesdatabase.models.SessionModel;
import aleksandar.moviesdatabase.models.VideoModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mende on 08.2.2018.
 */

public interface ApiService {
    @GET("movie/popular")
    Call<MoviesModel> getPopularMovies();

    @GET("movie/top_rated")
    Call<MoviesModel> getTopRatedMovies();

    @GET("movie/upcoming")
    Call<MoviesModel> getUpComingMovies();

    @GET("movie/now_playing")
    Call<MoviesModel> getNowPlayingMovies();

    @GET("search/movie")
    Call<MoviesModel> searchMovies(@Query("query") CharSequence c);

    @GET("person/popular")
    Call<PeopleModel> getPopularPeople();

    @GET("person/{person_id}")
    Call<Person> getPeople(@Path("person_id") int id);

    @GET("search/person")
    Call<PeopleModel> searchPeoples(@Query("query") CharSequence c);

    @GET("movie/{movie_id}")
    Call<Movie> getMovie(@Path("movie_id") int id);

    @GET("movie/{movie_id}/credits")
    Call<CreditsModel> getCredits(@Path("movie_id") int id);

    @GET("movie/{movie_id}/videos")
    Call<VideoModel> getVideos(@Path("movie_id") int id);

    @GET("authentication/token/new")
    Call<RequestToken> getToken();

    @GET("authentication/token/validate_with_login")
    Call<RequestToken> validateToken(@Query("username") String username,@Query("password") String password,@Query("request_token") String token );

    @GET("authentication/session/new")
    Call<SessionModel> getSession(@Query("request_token") String token );

    @GET("account/{account_id}/favorite/movies")
    Call<MoviesModel> getFavourites(@Query("session_id") String session_id);

    @FormUrlEncoded
    @POST("account/{account_id}/favorite")
    Call<ResponseFavourites> postFavourites(@Query("session_id") String session_id, @Field("media_id") int id, @Field("media_type") String type, @Field("favorite") boolean isFav);
}
