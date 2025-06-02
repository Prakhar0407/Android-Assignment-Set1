package com.example.bookreviewapp.data.remote;

import android.content.Context;
import com.example.bookreviewapp.data.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FakeApiService {

    public static List<Book> getBooksFromAssets(Context context) {
        List<Book> books = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open("books.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Book book = new Book();
                book.setTitle(obj.getString("title"));
                book.setAuthor(obj.getString("author"));
                book.setDescription(obj.getString("description"));
                book.setRating((float) obj.getDouble("rating"));
                book.setThumbnail(obj.getString("thumbnail"));
                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}