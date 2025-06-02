package com.example.bookreviewapp.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.bookreviewapp.data.local.BookDao;
import com.example.bookreviewapp.data.local.BookDatabase;
import com.example.bookreviewapp.data.model.Book;
import com.example.bookreviewapp.data.remote.FakeApiService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookRepository {
    private final BookDao bookDao;
    private final LiveData<List<Book>> allBooks;
    private final ExecutorService executorService;

    public BookRepository(Application application) {
        BookDatabase db = BookDatabase.getDatabase(application);
        bookDao = db.bookDao();
        allBooks = bookDao.getAllBooks();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }

    public void insert(Book book) {
        executorService.execute(() -> bookDao.insert(book));
    }
}