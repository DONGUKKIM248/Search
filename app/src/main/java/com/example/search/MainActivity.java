package com.example.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editTextSearch;
    private Button searchButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editTextSearch = findViewById(R.id.editTextSearch);
        searchButton = findViewById(R.id.searchButton);

        // 예시 데이터 생성
        String[] dataArray = {"Apple", "Banana", "Orange", "Pineapple", "Grapes", "Strawberry"};
        dataList = new ArrayList<>(Arrays.asList(dataArray));

        // 어댑터 설정
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // 검색 버튼 클릭 시 동작 설정
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        String searchText = editTextSearch.getText().toString().toLowerCase();
        ArrayList<String> filteredList = new ArrayList<>();

        for (String item : dataList) {
            if (item.toLowerCase().contains(searchText)) {
                filteredList.add(item);
            }
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredList);
        listView.setAdapter(adapter);
    }
}