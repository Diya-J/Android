@Entity
public class BookEntity {
    @PrimaryKey
    @NonNull
    private String title;

    private String author;
    private String description;
    private String thumbnailUrl;
    private float rating;

    // Getters and setters
}
