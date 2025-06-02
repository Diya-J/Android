public interface ApiService {
    @GET("books")
    Call<List<Book>> getBooks();
}
