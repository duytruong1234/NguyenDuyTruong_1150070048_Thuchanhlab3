package com.example.lab3duytruong;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GridViewContributorsActivity extends AppCompatActivity {

    private GridView gridViewContributors;
    private ContributorAdapter adapter;
    private List<Contributor> contributorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_contributors);

        gridViewContributors = findViewById(R.id.gridViewContributors);

        initializeContributors();

        adapter = new ContributorAdapter(this, contributorList);
        gridViewContributors.setAdapter(adapter);
    }

    private void initializeContributors() {
        contributorList = new ArrayList<>();
        contributorList.add(new Contributor("Maboo", "283,297", R.drawable.phunu));
        contributorList.add(new Contributor("Brandon", "100,466", R.drawable.phunu));
        contributorList.add(new Contributor("BBDS", "81,762", R.drawable.phunu));
        contributorList.add(new Contributor("palacelight", "75,497", R.drawable.phunu));
        contributorList.add(new Contributor("SameOldShawn", "252,433", R.drawable.phunu));
        contributorList.add(new Contributor("Clement_RGF", "93,932", R.drawable.phunu));
        contributorList.add(new Contributor("PleaseDe-ModMe", "79,243", R.drawable.phunu));
        contributorList.add(new Contributor("TheDarkKnight", "68,138", R.drawable.phunu));
        contributorList.add(new Contributor("Magnitude901", "164,935", R.drawable.phunu));
        contributorList.add(new Contributor("Nebja", "84,187", R.drawable.phunu));
        contributorList.add(new Contributor("DLizzle", "76,331", R.drawable.phunu));
        contributorList.add(new Contributor("hellrel", "68,903", R.drawable.phunu));
    }
}

