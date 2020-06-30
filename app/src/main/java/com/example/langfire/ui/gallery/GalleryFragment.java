package com.example.langfire.ui.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.langfire.DataBaseHelper;
import com.example.langfire.GetRandomNum;
import com.example.langfire.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
         root = inflater.inflate(R.layout.fragment_gallery, container, false);

        FirebaseOptions op =  new FirebaseOptions.Builder()

                .setApplicationId("1:973213571697:android:aa72f9a2537f3d005359d0") // Required for Analytics.

                .setApiKey("AIzaSyBx-uQR9DCq-63woYVutBcxi8MDv9WBz1s") // Required for Auth.

                .setDatabaseUrl("https://lang-fire-ddb3c.firebaseio.com/") // Required for RTDB.

                .build();
        //  FirebaseApp.initializeApp(this,op,"secondary");
        boolean hasBeenInitialized = false;
        List<FirebaseApp> fbsLcl = FirebaseApp.getApps(getContext());
        for (FirebaseApp app : fbsLcl) {
            if (app.getName().equals("secondary")) {
                hasBeenInitialized = true;
            }
        }
        FirebaseApp  fbApp,app;
        if (!hasBeenInitialized)
            fbApp = FirebaseApp.initializeApp(getContext(), op, "secondary");
        else
            fbApp = FirebaseApp.getInstance("secondary");

        /*
        FirebaseApp myApp = FirebaseApp.initializeApp(this,op,
                "secondary");
        FirebaseApp app = myApp.getInstance("secondary");
*/

// Get the database for the other app.
        FirebaseDatabase secondaryDatabase = FirebaseDatabase.getInstance(fbApp);
        final DatabaseReference myRef=secondaryDatabase.getReference("Comments");
        root.findViewById(R.id.sendg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((EditText)root.findViewById(R.id.fedbt)).getText().toString().matches("")) {
                    if (isConnected()) {
                        String data = ((EditText) root.findViewById(R.id.fedbt)).getText().toString();
                        DataBaseHelper db =new DataBaseHelper(getContext());
                        Cursor cr=db.getName();
                        String nam="Unknown";
                        while(cr.moveToNext())
                            nam=cr.getString(1);

                        myRef.child(nam + Integer.toString(new GetRandomNum().getRanNum()) + Integer.toString(new GetRandomNum().getRanNum())).setValue(data);
                        Toast.makeText(getContext(), "Feedback Sent", Toast.LENGTH_LONG).show();
                        ((EditText) root.findViewById(R.id.fedbt)).setText("");
                    } else
                        alert(1);
                }else alert(0);

            }
        });

        return root;
    }
    public void alert(int n)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Alert");
        if (n==1)
            alertDialog.setMessage("Check Your Internet Connection !!");
        else
            alertDialog.setMessage("Feedback is Empty");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        alertDialog.show();
    }
    public boolean isConnected()
    {
        ConnectivityManager c=(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo n = c.getActiveNetworkInfo();
        return n!=null && n.isConnected();
    }
}
