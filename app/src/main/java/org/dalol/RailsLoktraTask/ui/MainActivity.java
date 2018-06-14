package org.dalol.RailsLoktraTask.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.dalol.RailsLoktraTask.R;
import org.dalol.RailsLoktraTask.application.RailsApplication;

import org.dalol.RailsLoktraTask.base.RailsPresenter;
import org.dalol.RailsLoktraTask.model.Rails;
import org.dalol.RailsLoktraTask.service.RailsViewInterface;
import org.dalol.RailsLoktraTask.service.RailsService;
import org.dalol.RailsLoktraTask.ui.adapter.RailsAdapter;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements RailsViewInterface {

    @Inject
    RailsService mService;

    private RailsPresenter mPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private RailsAdapter mAdapter;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resolveDependency();
        ButterKnife.bind(MainActivity.this);
        configViews();
        mPresenter = new RailsPresenter(MainActivity.this);
        mPresenter.onCreate();
    }

    private void resolveDependency() {
        ((RailsApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    private void configViews() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RailsAdapter(getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchRails();
        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading List");
        mDialog.setMessage("Please wait...");
        mDialog.show();
    }

    @Override
    public void onCompleted() {
        mDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRails(List<Rails> rails) {
        mAdapter.addFlowers(rails);

    }


    @Override
    public Observable<List<Rails>> getRails() {
        return mService.getRails();
    }

}
