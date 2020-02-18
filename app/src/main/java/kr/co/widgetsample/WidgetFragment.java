package kr.co.widgetsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class WidgetFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView textViewStatus;
    TextView textViewCounter;
    int countNumber = 0;

    public WidgetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_widget, container, false);

        int amount = WidgetFragmentArgs.fromBundle(getArguments()).getId();
        switch (amount) {
            case 0:
                rootView.findViewById(R.id.button).setVisibility(View.VISIBLE);
                break;

            case 1:
                rootView.findViewById(R.id.textview).setVisibility(View.VISIBLE);
                break;

            case 2:
                rootView.findViewById(R.id.edittext).setVisibility(View.VISIBLE);
                break;

            case 3:
                rootView.findViewById(R.id.imageview).setVisibility(View.VISIBLE);
                break;

            case 4:
                rootView.findViewById(R.id.switch_layout).setVisibility(View.VISIBLE);
                break;

            case 5:
                rootView.findViewById(R.id.radio).setVisibility(View.VISIBLE);
                break;

            case 6:
                rootView.findViewById(R.id.checkbox).setVisibility(View.VISIBLE);
                break;

            case 7:
                rootView.findViewById(R.id.button_textview).setVisibility(View.VISIBLE);
                break;

            case 8:
                rootView.findViewById(R.id.layout_linear_1).setVisibility(View.VISIBLE);
                break;
            case 9:
                rootView.findViewById(R.id.layout_linear_2).setVisibility(View.VISIBLE);
                break;
            case 10:
                rootView.findViewById(R.id.layout_frame_1).setVisibility(View.VISIBLE);
                break;
            case 11:
                rootView.findViewById(R.id.layout_frame_2).setVisibility(View.VISIBLE);
                break;
            case 12:
                rootView.findViewById(R.id.layout_relative).setVisibility(View.VISIBLE);
                break;


        }


        //버튼
        rootView.findViewById(R.id.button_1).setOnClickListener(this);

        //텍스트뷰
        rootView.findViewById(R.id.textview_8).setSelected(true);

        //스위치
        ((Switch) rootView.findViewById(R.id.switch_1)).setOnCheckedChangeListener(this);
        textViewStatus = rootView.findViewById(R.id.status);

        //체크박스
        rootView.findViewById(R.id.button_sign_up).setOnClickListener(this);

        //버튼과 체크박스
        rootView.findViewById(R.id.button_plus).setOnClickListener(this);
        textViewCounter = rootView.findViewById(R.id.textview_counter);
        return rootView;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                Toast.makeText(getContext(), "버튼 1 클릭.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_sign_up:
                Toast.makeText(getContext(), "회원가입을 완료했습니다.", Toast.LENGTH_SHORT).show();

                NavDirections action = WidgetFragmentDirections.backAction();
                Navigation.findNavController(view).navigate(action);
                break;
            case R.id.button_plus:
                countNumber++;
                textViewCounter.setText(countNumber + "");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isOn) {
        if (isOn) {
            textViewStatus.setText("ON");
        } else {
            textViewStatus.setText("OFF");
        }
    }
}
