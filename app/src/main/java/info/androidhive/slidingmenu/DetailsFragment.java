package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import info.androidhive.slidingmenu.model.DBHelper;

public class DetailsFragment extends Fragment {
    Spinner spinner;
    RadioGroup radioGroup;
    ArrayAdapter<String> adapter;
    List<String> list;
    EditText fname,dname;
    String text,fn,dn;
    Button btnSave;
    Button btnreset;

    int selectedId;
    DBHelper db;
    EditText discrib;
    RatingBar rtbr;
    String desc,rate;
    Integer id,fid;


    public DetailsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final String sid=getArguments().getString("id");
        final Integer fid=Integer.parseInt(sid);
        final View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
        //dname = (EditText) rootView.findViewById(R.id.d_name);
        discrib= (EditText) rootView.findViewById(R.id.editText);
        rtbr = (RatingBar) rootView.findViewById(R.id.ratingBar);
        btnSave= (Button) rootView.findViewById(R.id.btnup);
        btnreset= (Button) rootView.findViewById(R.id.btnReset);
        db = new DBHelper(this.getActivity());


        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Validation for Blank Field
                if (discrib.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), " cannot be Blank", Toast.LENGTH_LONG).show();
                    discrib.setError("cannot be Blank");
                    return;
                } /*else if (dname.getText().toString().length() == 0)  {

                    Toast.makeText(getActivity(), "director name cannot be Blank", Toast.LENGTH_LONG).show();
                    dname.setError("Name cannot be Blank");
                    return;

                } */
                else {

                    desc = discrib.getText().toString();
                    rate = String.valueOf(rtbr.getRating());
                /*Toast.makeText(getActivity(),
                        radioButton.getText(), Toast.LENGTH_SHORT).show();
*/
                    //text = spinner.getSelectedItem().toString();
                    db.insertdetails(fid,rate, desc);
                    if (true) {
                        Toast.makeText(getActivity(), "Comment added", Toast.LENGTH_SHORT).show();


                        ViewdetailsFragment view = new ViewdetailsFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        Bundle args = new Bundle();
                        args.putString("id", String.valueOf(fid));




                        view.setArguments(args);
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container, view).addToBackStack(null);
                        fragmentTransaction.commit();
                        /*desc.setText("");
                        rate.setText("");*/

                    } else {
                        Toast.makeText(getActivity(), "Try again", Toast.LENGTH_SHORT).show();
                    }

                /*Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();*/
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*fname.setText("");
                dname.setText("");*/
                /*radioGroup.setOnCheckedChangeListener(this);
                radioGroup.setChecked(false);*/

            }
        });


        return rootView;
    }

  /*  private boolean isValidEmail(String email1) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email1);
        return matcher.matches();


    }*/


}