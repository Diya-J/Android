public class MainActivity extends AppCompatActivity {
    private BookViewModel viewModel;
    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new BookAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(BookViewModel.class);
        viewModel.getAllBooks().observe(this, books -> adapter.setBooks(books));

        viewModel.fetchBooks();
    }
}
