public class BookDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        TextView title = findViewById(R.id.detailTitle);
        TextView author = findViewById(R.id.detailAuthor);
        TextView rating = findViewById(R.id.detailRating);
        TextView description = findViewById(R.id.detailDescription);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        author.setText("Author: " + intent.getStringExtra("author"));
        rating.setText("Rating: " + intent.getFloatExtra("rating", 0));
        description.setText(intent.getStringExtra("description"));
    }
}
