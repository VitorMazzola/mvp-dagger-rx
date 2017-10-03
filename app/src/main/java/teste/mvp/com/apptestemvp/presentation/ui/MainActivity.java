package teste.mvp.com.apptestemvp.presentation.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import teste.mvp.com.apptestemvp.R;
import teste.mvp.com.apptestemvp.domain.entities.Marca;
import teste.mvp.com.apptestemvp.presentation.base.BaseActivity;
import teste.mvp.com.apptestemvp.presentation.adapter.OnClickListener;
import teste.mvp.com.apptestemvp.presentation.adapter.RecyclerViewAdapter;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ProgressDialog mProgressDialog;

    @Inject MainContract.Presenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        super.getDaggerUiComponent().inject(this);
        configureRcyclerView();

        mMainPresenter.setView(this);
        mMainPresenter.callGetMarcas();

        refreshList();
    }

    private void configureRcyclerView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog = ProgressDialog.show(this, "Aguarde", "Carregando...");
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateMarcas(List<Marca> marcas) {
        mRecyclerViewAdapter = new RecyclerViewAdapter(marcas);
        mRecyclerViewAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mRecyclerViewAdapter.setOnItemClick(new OnClickListener<Marca>() {
            @Override
            public void onClick(Marca entity) {
                Toast.makeText(MainActivity.this, String.valueOf(entity.getName()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void refreshList() {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mMainPresenter.callGetMarcas();
                /*new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mMainPresenter.callGetMarcas();

                    }
                }, 1000);*/

            }
        });
    }

    @Override
    public void stopRefresh() {
        mSwipeRefresh.setRefreshing(false);
    }
}
