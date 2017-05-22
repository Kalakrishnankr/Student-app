package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.slidingmenu.model.DBHelper;

public class Searchview extends Fragment {
    Button btnadd;
    Button btndelete;
    Context m;

    public Searchview(){}

    DBHelper db ;
    TextView name ;
    TextView rollno;
    TextView clss;
    TextView mail1;
    TextView sex;
    TextView addr;
    ListView lview;
    TextView dat;
    TextView id;
    TextView rate;
    TextView dis;
    TextView sug;
    RatingBar rtbr;
    TextView date1;
    List<Filmdetails> Filmdetailslist;
    Cursor resultSet;
    int uid;
    float rat;
    ListAdapter mListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.searchresultview, container, false);


        lview=(ListView)rootView.findViewById(R.id.lview);
        db = new DBHelper(this.getActivity());
        Filmdetailslist=new ArrayList<Filmdetails>();
         String nm=getArguments().getString("name");
        resultSet = db.searchData(nm);
        try{
            if(resultSet != null) {
                resultSet.moveToFirst();
                do {

                    Filmdetailslist.add(new Filmdetails(resultSet.getInt(0), resultSet.getString(1),resultSet.getString(2)));
                } while (resultSet.moveToNext());
            }
            else
            {
                Toast.makeText(getActivity(), "No match found", Toast.LENGTH_SHORT).show();


            }
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
        }

        if(Filmdetailslist != null || Filmdetailslist.size() > 0)
        {
            mListAdapter= new ListAdapter();
            lview.setAdapter(mListAdapter);

        }
  lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView fid = (TextView) rootView.findViewById(R.id.txt1);
                TextView name = (TextView) rootView.findViewById(R.id.txt2);
                TextView dis = (TextView) rootView.findViewById(R.id.txt3);


                Integer fid1 = Filmdetailslist.get(position).fid;
                String rt = Filmdetailslist.get(position).rate;
                String des = Filmdetailslist.get(position).desc;

                String value = String.valueOf(Filmdetailslist.get(position).id);

                ViewdetailsFragment addmore = new ViewdetailsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                Bundle args = new Bundle();
                args.putString("id", value);
                args.putString("rat", rt);
                args.putString("des", des);



                addmore.setArguments(args);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, addmore);
                fragmentTransaction.commit();
                /*final int val= Integer.parseInt(value);
                onpressed(val);*/




            }
        });

        return rootView;
    }



    public class ListAdapter extends BaseAdapter
    {


        @Override
        public int getCount() {
            return Filmdetailslist.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.list_view, parent, false);

            try {
                TextView fname = (TextView)rowView.findViewById(R.id.txt1);
                TextView dname = (TextView) rowView.findViewById(R.id.txt2);
                TextView id = (TextView) rowView.findViewById(R.id.txt3);

                fname.setText(Filmdetailslist.get(position).name);
                dname.setText(""+Filmdetailslist.get(position).dname);
                id.setText(""+Filmdetailslist.get(position).id);




            }catch(Exception e)
            {
                e.printStackTrace();
            }


            return rowView;
        }

    }
/*    public void onpressed(final Integer va) {
        new AlertDialog.Builder(this.getActivity())
                .setTitle("Really Delete?")
                .setMessage("Are you sure you want to delete?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        //db.deletestudent(va);
                        if (true) {
                            CommunityFragment addmore = new CommunityFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_container, addmore);
                            fragmentTransaction.commit();
                        }
                    }
                }).create().show();
    }*/
}
