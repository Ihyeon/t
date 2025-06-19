document.addEventListener("DOMContentLoaded", () => {
    const status = "예약중";
    const author = "홍길동";
    const title = "자바";
    const createdAt = "2025-06-19";

    const query = new URLSearchParams({
        status,
        author,
        title,
        createdAt
    });

    fetch(`/api/book?${query.toString()}`)
        .then(res => res.json())
        .then(data => {
            console.log(data);
            renderBookList(data);
        })
        .catch(err => console.error("에러:", err));
});

function renderBookList(bookList) {
    const container = document.getElementById("bookList");
    container.innerHTML = "";
    bookList.forEach(book => {
        const li = document.createElement("li");
        li.textContent = `${book.title} (${book.author}) - ${book.status}`;
        container.appendChild(li);
    });
}
