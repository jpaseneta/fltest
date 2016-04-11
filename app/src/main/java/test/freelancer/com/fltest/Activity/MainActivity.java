package test.freelancer.com.fltest.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import test.freelancer.com.fltest.Fragments.CollectionViewFragment;
import test.freelancer.com.fltest.R;


public class MainActivity extends ActionBarActivity {
    private CollectionViewFragment collectionViewFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        collectionViewFragment = new CollectionViewFragment();
        fragmentTransaction.add(R.id.container_body, collectionViewFragment, "collectionViewFragment");
        fragmentTransaction.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
