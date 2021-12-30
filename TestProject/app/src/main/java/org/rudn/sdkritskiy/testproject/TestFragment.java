package org.rudn.sdkritskiy.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class TestFragment extends Fragment{
    EditText text_to_sendtxt;
    Button second_activitybtn;

    public TestFragment()
    {
        super(R.layout.fragment_test);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        text_to_sendtxt = view.findViewById(R.id.textsendertxt);
        second_activitybtn = view.findViewById(R.id.senderbtn);

        second_activitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sender.SetMessage(text_to_sendtxt.getText().toString());
                FragmentActivity fa = getActivity();
                Intent i = new Intent(fa, SecondTestActivity.class);
                getActivity().startActivity(i);
            }
        });
    }
}
