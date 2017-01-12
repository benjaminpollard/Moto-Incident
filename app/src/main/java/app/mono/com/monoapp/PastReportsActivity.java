package app.mono.com.monoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import Adapter.PastReportsAdapter;
import Controller.ReportsListController;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PastReportsActivity extends AppCompatActivity {

    @BindView(R.id.past_info_recycler_view) RecyclerView recycleView;
    @BindView(R.id.past_info_no_content) TextView noResult;

    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_reports);

        ButterKnife.bind(this);
        recycleView.setHasFixedSize(true);


        if(new ReportsListController().GetAllReports() != null && new ReportsListController().GetAllReports().size() > 0)
        {
            noResult.setVisibility(View.GONE);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
            recycleView.setLayoutManager(manager);
            adapter = new PastReportsAdapter(new ReportsListController().GetAllReports());
            recycleView.setAdapter(adapter);
        }else
        {
            recycleView.setVisibility(View.GONE);
            noResult.setText(R.string.no_reports_text);
        }

    }
}
