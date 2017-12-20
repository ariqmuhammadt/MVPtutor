package xyz.ariq.mvptutor.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.ariq.mvptutor.Interface.BiodataPresenterInterface;
import xyz.ariq.mvptutor.Interface.BiodataViewInterface;
import xyz.ariq.mvptutor.Model.BaseActivity;
import xyz.ariq.mvptutor.Model.ResponsModel;
import xyz.ariq.mvptutor.Presenter.BiodataPresenter;
import xyz.ariq.mvptutor.R;

public class MainActivity extends BaseActivity implements BiodataViewInterface {
    @BindView(R.id.input_namalengkap) EditText namalengkap;
    @BindView(R.id.input_namap) EditText namap;
    @BindView(R.id.input_tmptlahir) EditText tmptlahir;
    @BindView(R.id.input_tgllahir) EditText tgllahir;
    @BindView(R.id.input_Alamat) EditText alamat;
    @BindView(R.id.checkjk) RadioGroup checkjk;
    @BindView(R.id.input_nohp) EditText nohp;
    @BindView(R.id.inputjk) TextView inputjk;
    @BindView(R.id.input_email) EditText email;
    ProgressDialog pg;

    public BiodataPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pg = new ProgressDialog(this);
        ButterKnife.bind(MainActivity.this);

        presenter = new BiodataPresenter(this,getApi());
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.checkjk_l:
                if (checked)
                    inputjk.setText("Laki-Laki");
                break;
            case R.id.checkjk_p:
                if (checked)
                    inputjk.setText("Perempuan");
        }
    }
    @OnClick(R.id.btnsave) void doBiodata(){
        pg.setMessage("Sending Data...");
        pg.setCancelable(false);
        pg.show();

        String $namalengkap=namalengkap.getText().toString();
        String $namap=namap.getText().toString();
        String $tmptlahir=tmptlahir.getText().toString();
        String $tgllahir=tgllahir.getText().toString();
        String $inputjk = inputjk.getText().toString();
        String $alamat = alamat.getText().toString();
        String $nohp = nohp.getText().toString();
        String $email = email.getText().toString();

        presenter.doBiodata($namalengkap,$namap,$tmptlahir,$tgllahir,$inputjk,$alamat,$nohp,$email);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onFinishinsert(ResponsModel res) {
        pg.hide();
        Toast.makeText(MainActivity.this,"Insert Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailureinsert() {
        pg.hide();
        Toast.makeText(MainActivity.this,"Insert Failed",Toast.LENGTH_SHORT).show();
    }
}
