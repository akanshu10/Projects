package com.akihsna.skart.college.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.skart.R;
import com.akihsna.skart.college.AttendanceActivity;
import com.akihsna.skart.college.ExamActivity;
import com.akihsna.skart.college.accountActivity;
import com.akihsna.skart.college.classesActivity;
import com.akihsna.skart.college.collegeloginActivity;
import com.akihsna.skart.college.collegeprofileActivity;
import com.akihsna.skart.college.collegeteacherActivity;
import com.akihsna.skart.college.eventsActivity;
import com.akihsna.skart.college.guardiansActivity;
import com.akihsna.skart.college.holidayActivity;
import com.akihsna.skart.college.libraryActivity;
import com.akihsna.skart.college.resultActivity;
import com.akihsna.skart.college.scholarshipActivity;
import com.akihsna.skart.college.studentActivity;
import com.akihsna.skart.college.syllabusActivity;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    //private collegeprofileActivity cprofileActivity;
    //private studentActivity studentActivity;
    Button profilebtn,studentbtn,teacherbtn,guardianbtn,classbtn,exambtn,attendancebtn,scholarshipbtn,holidaysbtn,eventsbtn;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final Button profilebtn=view.findViewById(R.id.btnprofile);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),collegeprofileActivity.class));
            }
        });
        final Button studentbtn=view.findViewById(R.id.btnstudent);
        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),studentActivity.class));
            }
        });
        final Button teacherbtn=view.findViewById(R.id.btnteacher);
        teacherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), collegeteacherActivity.class));
            }
        });
        final Button guardianbtn=view.findViewById(R.id.btnguardian);
        guardianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), guardiansActivity.class));
            }
        });
        final Button classbtn=view.findViewById(R.id.btnclass);
        classbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), classesActivity.class));
            }
        });
        final Button exambtn=view.findViewById(R.id.btnexam);
        exambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ExamActivity.class));
            }
        });
        final Button attendancebtn=view.findViewById(R.id.btnattendance);
        attendancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AttendanceActivity.class));
            }
        });
        final Button scholarshipbtn=view.findViewById(R.id.btnscholarship);
        scholarshipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), scholarshipActivity.class));
            }
        });
        final Button holidaybtn=view.findViewById(R.id.btnholidays);
        holidaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), holidayActivity.class));
            }
        });
        final Button eventbtn=view.findViewById(R.id.btnevents);
        eventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), eventsActivity.class));
            }
        });
        final Button accountbtn=view.findViewById(R.id.btnaccount);
        accountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), accountActivity.class));
            }
        });
        final Button librarybtn=view.findViewById(R.id.btnlibrary);
        librarybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), libraryActivity.class));
            }
        });
        final Button syllabusbtn=view.findViewById(R.id.btnsyllabus);
        syllabusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), syllabusActivity.class));
            }
        });
        final Button resultbtn=view.findViewById(R.id.btnresult);
        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), resultActivity.class));
            }
        });

        return view;
    }
}
