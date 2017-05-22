/*
package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import info.androidhive.slidingmenu.model.DBHelper;

public class PagesFragment extends Fragment {
	
	public PagesFragment(){}
    DBHelper db;
    Button btns;
    EditText search;
    String sea,rollno;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);


        btns= (Button) rootView.findViewById(R.id.btnSearch);
        search=(EditText) rootView.findViewById(R.id.edit);
        db = new DBHelper(this.getActivity());
        btns.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               sea=search.getText().toString();

               if (sea.length() == 0) {
                   //Toast.makeText(getActivity(), "Enter name", Toast.LENGTH_LONG).show();
                   search.setError("Enter name");
                   return;
               }
               else {
                   SearchFragment addmore = new SearchFragment();
                   FragmentManager fragmentManager = getFragmentManager();
                   Bundle args = new Bundle();
                   args.putString("name", sea);
                   addmore.setArguments(args);

                   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   fragmentTransaction.replace(R.id.frame_container, addmore);
                   fragmentTransaction.commit();

               }

           }
       });
        return rootView;
    }
}
*/
