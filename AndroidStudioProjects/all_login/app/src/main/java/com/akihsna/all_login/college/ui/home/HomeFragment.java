package com.akihsna.all_login.college.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.akihsna.all_login.R;
import com.akihsna.all_login.college.AttendanceActivity;
import com.akihsna.all_login.college.ExamActivity;
import com.akihsna.all_login.college.accountActivity;
import com.akihsna.all_login.college.classesActivity;
import com.akihsna.all_login.college.collegeprofileActivity;
import com.akihsna.all_login.college.collegeteacherActivity;
import com.akihsna.all_login.college.eventsActivity;
import com.akihsna.all_login.college.guardiansActivity;
import com.akihsna.all_login.college.holidayActivity;
import com.akihsna.all_login.college.libraryActivity;
import com.akihsna.all_login.college.resultActivity;
import com.akihsna.all_login.college.scholarshipActivity;
import com.akihsna.all_login.college.studentActivity;
import com.akihsna.all_login.college.syllabusActivity;

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
