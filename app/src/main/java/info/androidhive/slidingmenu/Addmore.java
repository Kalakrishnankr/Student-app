/*
package info.androidhive.slidingmenu;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import info.androidhive.slidingmenu.model.DBHelper;

public class Addmore extends Fragment {
        Spinner spinner1;
        RadioGroup radioGroup;
        ArrayAdapter<String> adapter;
        List<String> list;
        EditText desc;
        EditText sug;
        EditText rollno;
        EditText address;
        String sex,roll,add,text;
        String dat,describ,sugge,rating;
        Button btnSave;
        Button btnReset;
        RadioButton radioButton;
        int selectedId;
          DBHelper db;
        RatingBar rtbr;
        public static TextView tvDisplayDate;
//    DatePicker dpResult;
    Button btnChangeDate;
    int year;
    int month;
    int day;
public static boolean fromAddmore=false;
//  TextView   datePicker;

    public Addmore(){}
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            final View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
            final String sid;
            sid=getArguments().getString("id");
            final Integer i;
            i=Integer.parseInt(sid);
            btnSave= (Button) rootView.findViewById(R.id.btnSave);
            btnReset= (Button) rootView.findViewById(R.id.btnReset);
            rollno=(EditText) rootView.findViewById(R.id.rollno);
            list = new ArrayList<String>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            list.add("7");
            list.add("8");
            list.add("9");
            list.add("10");
            adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_spinner_item, list);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1 = (Spinner) rootView.findViewById(R.id.spin);
            spinner1.setAdapter(adapter);
            rollno=(EditText) rootView.findViewById(R.id.rollno);
            radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
            address=(EditText) rootView.findViewById(R.id.txt3);
            selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) rootView.findViewById(selectedId);
            sex = radioButton.getText().toString();
            rtbr = (RatingBar) rootView.findViewById(R.id.ratingBar);
            desc = (EditText) rootView.findViewById(R.id.editText);
            sug=(EditText) rootView.findViewById(R.id.editText1);
            tvDisplayDate=(TextView) rootView.findViewById(R.id.datePicker);

            db = new DBHelper(this.getActivity());

            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            // set current date into textview
            tvDisplayDate.setText(new StringBuilder()
                    // Month is 0 based, just add 1
                    .append(month + 1).append("-").append(day).append("-")
                    .append(year).append(" "));
//            setCurrentDateOnView();
            tvDisplayDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    fromAddmore=true;

                    DialogFragment newFragment = new SelectDateFragment();
                    newFragment.show(getFragmentManager(), "DatePicker");

                }
            });
            btnSave.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    if (desc.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Enter description", Toast.LENGTH_LONG).show();
                        desc.setError("Enter description");
                        return;
                    } else if (rollno.getText().toString().length() == 0) {

                        Toast.makeText(getActivity(), "Enter your rollno", Toast.LENGTH_LONG).show();
                        rollno.setError("Enter your roll no");
                        return;
                    } else if (address.getText().toString().length() == 0) {

                        Toast.makeText(getActivity(), "Enter your address", Toast.LENGTH_LONG).show();
                        address.setError("Enter your address");
                        return;
                    } else if (desc.getText().toString().length() == 0) {

                        Toast.makeText(getActivity(), "Enter your description", Toast.LENGTH_LONG).show();
                        desc.setError("Enter your description");
                        return;
                    } else if (sug.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Please give a suggestion", Toast.LENGTH_LONG).show();
                        sug.setError("Please give a suggestion");
                        return;
                    } else {

                        sex = radioButton.getText().toString();
                        add = address.getText().toString();
                        roll = rollno.getText().toString();
                        text = spinner1.getSelectedItem().toString();
                        radioGroup.clearCheck();
                        describ = desc.getText().toString();
                        sugge = sug.getText().toString();
                        rating = String.valueOf(rtbr.getRating());
                        dat = tvDisplayDate.getText().toString();

                */
/*Toast.makeText(getActivity(),
                        radioButton.getText(), Toast.LENGTH_SHORT).show();
*//*

                        //db.updatestudent(i, roll, text, sex, add, rating, describ, sugge, dat);

                        if (true) {
                            Toast.makeText(getActivity(), "Update successfully", Toast.LENGTH_SHORT).show();
                      */
/*  s_name.setText("");
                        rollno.setText("");
                        address.setText("");*//*

                        */
/*spinner.setSelection(0);
                        radioGroup.clearCheck();*//*

                            desc.setText("");
                            sug.setText("");
                            rtbr.setRating(0);
                            tvDisplayDate.setText(new StringBuilder()
                                    // Month is 0 based, just add 1
                                    .append(month + 1).append("-").append(day).append("-")
                                    .append(year).append(" "));


                        } else {
                            Toast.makeText(getActivity(), "Try again", Toast.LENGTH_SHORT).show();
                        }

                */
/*Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();*//*

                    }
                }
            });
            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    desc.setText("");
                    sug.setText("");
                    rtbr.setRating(0);
                    tvDisplayDate.setText(new StringBuilder()
                            // Month is 0 based, just add 1
                            .append(month + 1).append("-").append(day).append("-")
                            .append(year).append(" "));


                }
            });


            return rootView;
        }
 */
/*   public void setCurrentDateOnView() {

      *//*
*/
/*  tvDisplayDate = (TextView)findViewById(R.id.txtvdate);
        dpResult = (DatePicker) findViewById(R.id.dpResult);
*//*
*/
/*
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        tvDisplayDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));

        // set current date into datepicker
//        dpResult.init(year, month, day, null);

    }*//*


    }
*/
