package xyz.ariq.mvptutor.Presenter;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.ariq.mvptutor.Interface.BiodataPresenterInterface;
import xyz.ariq.mvptutor.Interface.BiodataViewInterface;
import xyz.ariq.mvptutor.Model.ApiRequest;
import xyz.ariq.mvptutor.Model.ResponsModel;

/**
 * Created by AriqMT on 20/12/2017.
 */

public class BiodataPresenter implements BiodataPresenterInterface{
    private BiodataViewInterface view;
    private ApiRequest api;

    public BiodataPresenter (BiodataViewInterface view, ApiRequest api){
        this.view = view;
        this.api = api;
    }
    @Override
    public void doBiodata(String namalengkap, String namapanggilan, String tmptlahir, String tgllahir, String jenisk, String alamat, String nomerhp, String email) {
        view.showLoading();
        view.log("init");

        Call<ResponsModel> send = api.sendBiodata(namalengkap, namapanggilan, tmptlahir, tgllahir, jenisk, alamat, nomerhp, email);
        send.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                ResponsModel res = response.body();
                if (res.getKode()==1){
                    view.onFinishinsert(res);
                }
                else {
                    view.onFailureinsert();
                }
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                view.hideLoading();
                Log.d("Base","Failure: "+"Gagal Mengirim Request");

            }
        });
    }
}
