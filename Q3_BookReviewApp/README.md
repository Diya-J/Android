# 📚 Q3 Book Review App

An Android app built in Java, showing a list of books using the MVVM architecture and Retrofit.

## 🔧 Tech Stack

- Java
- MVVM Architecture
- Retrofit (API calls)
- LiveData + ViewModel

## 📂 Folder Structure

app/
├── java/com/yourapp/
│   ├── model/
│   │   ├── Book.java          ← From API
│   │   └── BookEntity.java    ← For Room
│   ├── network/
│   │   ├── ApiService.java
│   │   └── RetrofitClient.java
│   ├── db/
│   │   ├── BookDao.java
│   │   └── AppDatabase.java
│   ├── repository/
│   │   └── BookRepository.java
│   ├── viewmodel/
│   │   └── BookViewModel.java
│   ├── adapter/
│   │   └── BookAdapter.java
│   └── ui/
│       ├── MainActivity.java
│       └── BookDetailActivity.java
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── item_book.xml
    │   └── activity_book_detail.xml


- 'model' - Book.java (POJO)
- 'network' - ApiService.java, RetrofitClient.java
- 'repository' - BookRepository.java
- 'ui' - BookListActivity.java (Main screen)




