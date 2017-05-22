/*
package info.androidhive.slidingmenu;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
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

public class CommunityFragment extends Fragment {
	Button btnadd;
    Button btndelete;
    Context m;

    public CommunityFragment(){}

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
        List<Studentdetails> studentdetailsList;
        Cursor resultSet;
        int uid;
    float rat;
        ListAdapter mListAdapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            final View rootView = inflater.inflate(R.layout.fragment_community, container, false);


            lview=(ListView)rootView.findViewById(R.id.view);
            db = new DBHelper(this.getActivity());
            studentdetailsList=new ArrayList<Studentdetails>();
            resultSet = db.getData();
            try{
            if(resultSet != null) {
                resultSet.moveToFirst();
                do {

                    studentdetailsList.add(new Studentdetails(resultSet.getInt(0), resultSet.getString(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)));
                } while (resultSet.moveToNext());
            }
            }
            catch (Exception e)
            {
                Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
            }

            if(studentdetailsList != null || studentdetailsList.size() > 0)
            {
                mListAdapter= new ListAdapter();
                lview.setAdapter(mListAdapter);

            }
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
*/
/*
                    TextView name = (TextView) rootView.findViewById(R.id.txtV1);
                    TextView mail1 = (TextView) rootView.findViewById(R.id.txtV2);
                    TextView rollno = (TextView) rootView.findViewById(R.id.txtV3);
                    TextView cls = (TextView) rootView.findViewById(R.id.txtV4);
                    TextView sex = (TextView) rootView.findViewById(R.id.txtV5);
                    TextView add = (TextView) rootView.findViewById(R.id.txtV6);
                    TextView dat = (TextView) rootView.findViewById(R.id.txtV7);
                    TextView rate = (TextView) rootView.findViewById(R.id.txtV8);
                    TextView dis = (TextView) rootView.findViewById(R.id.txtV9);
                    TextView sugge = (TextView) rootView.findViewById(R.id.txtV10);*//*


                    String nme, mail;
                    */
/*nme = studentdetailsList.get(position).name;
                    mail = studentdetailsList.get(position).email;*//*

                    String value = String.valueOf(studentdetailsList.get(position).id);;
                    final int val= Integer.parseInt(value);
                    onpressed(val);



                }
            });
            return rootView;
        }



        public class ListAdapter extends BaseAdapter
        {


            @Override
            public int getCount() {
                return studentdetailsList.size();
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

                View rowView = inflater.inflate(R.layout.listitem, parent, false);

                try {
                    name = (TextView) rowView.findViewById(R.id.txtV1);
                    mail1 = (TextView) rowView.findViewById(R.id.txtV2);
                    rollno = (TextView) rowView.findViewById(R.id.txtV3);
                    clss = (TextView) rowView.findViewById(R.id.txtV4);
                    sex = (TextView) rowView.findViewById(R.id.txtV5);
                    addr = (TextView) rowView.findViewById(R.id.txtV6);
                    //rtbr = (RatingBar) rowView.findViewById(R.id.ratingBar);
                    date1 = (TextView) rowView.findViewById(R.id.txtV7);
                    rate = (TextView) rowView.findViewById(R.id.txtV8);
                    dis = (TextView) rowView.findViewById(R.id.txtV9);
                    sug = (TextView) rowView.findViewById(R.id.txtV10);


                    name.setText(studentdetailsList.get(position).name);
                    mail1.setText(studentdetailsList.get(position).email);
                    rollno.setText(""+studentdetailsList.get(position).rollno);
                    clss.setText(studentdetailsList.get(position).cls);
                    sex.setText(studentdetailsList.get(position).sex);
                    addr.setText(studentdetailsList.get(position).address);
                    date1.setText(studentdetailsList.get(position).date);
                    rate.setText(studentdetailsList.get(position).rtbr);
                    dis.setText(studentdetailsList.get(position).describ);
                    sug.setText(studentdetailsList.get(position).sugg);



                }catch(Exception e)
                {
                    e.printStackTrace();
                }


                return rowView;
            }

        }
    public void onpressed(final Integer va) {
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
    }
}
*/
