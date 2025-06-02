@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BookEntity book);

    @Query("SELECT * FROM BookEntity")
    LiveData<List<BookEntity>> getAllBooks();
}
