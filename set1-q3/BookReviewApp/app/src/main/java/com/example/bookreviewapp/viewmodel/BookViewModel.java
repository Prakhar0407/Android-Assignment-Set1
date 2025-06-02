package com.example.bookreviewapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bookreviewapp.data.model.Book;
import com.example.bookreviewapp.data.repository.BookRepository;
import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private final BookRepository repository;
    private final LiveData<List<Book>> books;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        books = repository.getAllBooks();
    }

    public LiveData<List<Book>> getBooks() {
        return books;
    }

    public void saveBook(Book book) {
        repository.insert(book);
    }
}