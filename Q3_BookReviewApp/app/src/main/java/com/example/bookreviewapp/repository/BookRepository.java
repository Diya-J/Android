public class BookRepository {
    private BookDao bookDao;
    private ApiService apiService;

    public BookRepository(Application application) {
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "book-db").build();
        bookDao = db.bookDao();
        apiService = RetrofitClient.getApiService();
    }

    public LiveData<List<BookEntity>> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public void fetchBooksFromApi() {
        apiService.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (Book book : response.body()) {
                        BookEntity entity = new BookEntity();
                        entity.setTitle(book.getTitle());
                        entity.setAuthor(book.getAuthor());
                        entity.setDescription(book.getDescription());
                        entity.setRating(book.getRating());
                        entity.setThumbnailUrl(book.getThumbnailUrl());
                        new Thread(() -> bookDao.insert(entity)).start();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("BookRepo", "API error", t);
            }
        });
    }
}
