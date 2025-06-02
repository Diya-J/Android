package com.yourapp.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    // This method will fetch a list of books from the endpoint 'https://yourapi.com/books'
    @GET("books")  // If base URL = "https://yourapi.com/", this becomes https://yourapi.com/books
    Call<List<Book>> getBooks();
}
