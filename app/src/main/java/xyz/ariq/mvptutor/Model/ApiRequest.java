package xyz.ariq.mvptutor.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by AriqMT on 20/12/2017.
 */

public interface ApiRequest {
    @FormUrlEncoded
    @POST("insertbiodata.php")
    Call<ResponsModel> sendBiodata(@Field("namalengkap") String namalengkap,
                                   @Field("namapanggilan") String namapanggilan,
                                   @Field("tmptlahir") String tmptlahir,
                                   @Field("tgllahir") String tgllahir,
                                   @Field("jenisk") String jenisk,
                                   @Field("alamat") String alamat,
                                   @Field("nomerhp") String nomerhp,
                                   @Field("email") String email);
}
