public class BookViewModel extends AndroidViewModel {
    private BookRepository repository;
    private LiveData<List<BookEntity>> allBooks;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        allBooks = repository.getAllBooks();
    }

    public LiveData<List<BookEntity>> getAllBooks() {
        return allBooks;
    }

    public void fetchBooks() {
        repository.fetchBooksFromApi();
    }
}
