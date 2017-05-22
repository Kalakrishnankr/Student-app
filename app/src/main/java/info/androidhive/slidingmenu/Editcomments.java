package info.androidhive.slidingmenu;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import info.androidhive.slidingmenu.model.DBHelper;

/**
 * Created by raghul.sn on 30/6/16.
 */
public class Editcomments extends Fragment {

    RadioGroup rb;
    DBHelper mydb;
    RadioButton ml,fm;
    EditText dis,ag,id;
    Button update,dlt;
    RatingBar rtbr;
    public Editcomments(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mydb=new DBHelper(this.getActivity());
        //final String strtext = getArguments().getString("id");
        final String strrt = getArguments().getString("rat");
        String strdesc = getArguments().getString("des");
        final Integer uid,fid;
        uid=Integer.parseInt(getArguments().getString("id"));
        fid=Integer.parseInt(getArguments().getString("fid"));
        //final String strid = getArguments().getString("id");
        final View rootView = inflater.inflate(R.layout.fragment_edit, container, false);
        dis=(EditText)rootView.findViewById(R.id.editText);

        //ag=(EditText)rootView.findViewById(R.id.editText2);
        //id=(EditText)rootView.findViewById(R.id.editText3);
        /*rb = (RadioGroup)rootView.findViewById(R.id.radioGender);
        ml =(RadioButton)rootView.findViewById(R.id.genderMale);
        fm =(RadioButton)rootView.findViewById(R.id.genderFemale);*/
        update=(Button)rootView.findViewById(R.id.btnup);
        rtbr=(RatingBar) rootView.findViewById(R.id.ratingBar);
        dlt=(Button)rootView.findViewById(R.id.btndel);
        dis.setText(strdesc);
        rtbr.setRating(Float.parseFloat(strrt));
        //id.setText(strid);
        //ag.setText(strage);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       // fragmentTransaction.replace(..............);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        update.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //Integer sid;
                int selectid;
                String rt,desc;
                desc=(dis).getText().toString();
                rt = String.valueOf(rtbr.getRating());

                // sid=Integer.parseInt(id.getText().toString());
                // find the radiobutton by returned id

                mydb.updatecomments(uid, rt, desc);
                if (true) {

                    Toast.makeText(getActivity(), "updated",
                            Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getActivity(), "error",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        dlt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                delete(uid,fid);

                //mydb.deleteContact(uid);


            }
        });


        return rootView;
    }

    public void delete(final Integer u, final Integer f) {
        new AlertDialog.Builder(this.getActivity())
                .setTitle("Really Delete?")
                .setMessage("Are you sure you want to Delete?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        mydb.deleteContact(u);
                        if(true)
                        {

                            Toast.makeText(getActivity(), "Deleted",
                                    Toast.LENGTH_LONG).show();


                            ViewdetailsFragment view = new ViewdetailsFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            Bundle args = new Bundle();
                            args.putString("id", String.valueOf(f));




                            view.setArguments(args);
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_container, view).addToBackStack(null);
                            fragmentTransaction.commit();
                        }

                    }
                }).create().show();
    }


}