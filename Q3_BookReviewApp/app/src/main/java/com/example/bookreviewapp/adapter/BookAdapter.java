public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<BookEntity> books = new ArrayList<>();
    private Context context;

    public BookAdapter(Context context) {
        this.context = context;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BookEntity book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookDetailActivity.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            intent.putExtra("description", book.getDescription());
            intent.putExtra("rating", book.getRating());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView title, author;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            author = itemView.findViewById(R.id.textAuthor);
        }
    }
}
