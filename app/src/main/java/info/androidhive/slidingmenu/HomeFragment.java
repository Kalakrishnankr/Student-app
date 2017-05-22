package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import info.androidhive.slidingmenu.model.DBHelper;

public class HomeFragment extends Fragment {
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
    EditText email;


    public HomeFragment(){}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        dname = (EditText) rootView.findViewById(R.id.d_name);
        fname= (EditText) rootView.findViewById(R.id.name);
        btnSave= (Button) rootView.findViewById(R.id.btnup);
        btnreset= (Button) rootView.findViewById(R.id.btn2);
        db = new DBHelper(this.getActivity());


         btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Validation for Blank Field
                if (fname.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Name cannot be Blank", Toast.LENGTH_LONG).show();
                    fname.setError("Name cannot be Blank");
                    return;
                } else if (dname.getText().toString().length() == 0)  {

                    Toast.makeText(getActivity(), "director name cannot be Blank", Toast.LENGTH_LONG).show();
                    dname.setError("Name cannot be Blank");
                    return;

                } else {

                    fn = fname.getText().toString();
                    dn = dname.getText().toString();

                /*Toast.makeText(getActivity(),
                        radioButton.getText(), Toast.LENGTH_SHORT).show();
*/
                    //text = spinner.getSelectedItem().toString();
                   db.insertfilm(fn,dn);
                    if (true) {
                        Toast.makeText(getActivity(), "Insertion success", Toast.LENGTH_SHORT).show();
                        fname.setText("");
                        dname.setText("");

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

                fname.setText("");
                dname.setText("");
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
