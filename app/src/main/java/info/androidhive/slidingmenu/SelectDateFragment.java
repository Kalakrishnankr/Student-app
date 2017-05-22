/*
package info.androidhive.slidingmenu;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
public  static String dateString ="";
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }


        public void  populateSetDate(int year, int month, int day) {

            dateString=String.valueOf(new StringBuilder()
                    // Month is 0 based, just add 1
                    .append(day).append("-").append(month).append("-")
                    .append(year).append(" "));
            if(Addmore.fromAddmore)
            {
                Addmore. tvDisplayDate.setText(dateString);
                Addmore.fromAddmore=false;
            }
            else
            Addmore. tvDisplayDate.setText(dateString);
            }

    */
/**
     * @param view        The view associated with this listener.
     * @param year        The year that was set.
     * @param monthOfYear The month that was set (0-11) for compatibility
     *                    with {@link Calendar}.
     * @param dayOfMonth  The day of the month that was set.
     *//*

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        populateSetDate(year, monthOfYear+1, dayOfMonth);
    }
}
*/
