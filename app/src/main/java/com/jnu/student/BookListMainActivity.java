package com.jnu.student;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookListMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist_main);

        RecyclerView bookListRecycleView = (RecyclerView)findViewById(R.id.booklist_recycleview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        bookListRecycleView.setLayoutManager(linearLayoutManager);

        bookListRecycleView.setAdapter(new MyRecyclerViewAdapter());
        bookListRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }



    private class MyRecyclerViewAdapter extends RecyclerView.Adapter{
        private List<Book> books = new ArrayList<Book>();

        public MyRecyclerViewAdapter() {
            initBook();
        }

        private void initBook(){
            books.add(new Book(R.drawable.book_1,"信息安全教学基础（第二版）"));
            books.add(new Book(R.drawable.book_2,"软件项目管理案例教程（第四版）"));
            books.add(new Book(R.drawable.book_no_name,"创新工程实践"));
        }

        private class BookViewHolder extends RecyclerView.ViewHolder{
            private ImageView imageView;
            private TextView textView;

            public BookViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view_book_cover);
                textView = itemView.findViewById(R.id.text_view_book_title);
            }

            public ImageView getImageView() {
                return imageView;
            }

            public TextView getTextView() {
                return textView;
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_element,parent,false);
            return new BookViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            BookViewHolder bookViewHolder = (BookViewHolder) holder;

            bookViewHolder.getImageView().setImageResource(books.get(position).getImgId());
            bookViewHolder.getTextView().setText(books.get(position).getBookName());
        }

        @Override
        public int getItemCount() {
            return books.size();
        }
    }


}
