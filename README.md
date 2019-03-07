# 1.Book-Details

<p><b>Get Book By BookId</b></p>
		curl -X GET \ http://localhost:8080/book-details/book/200

		Response:
		{
			"bookId": 200,
			"bookName": "Core Java Concept",
			"bookCategory": "Computer Science Program"
		}
		
# 2.Book-Inventory

<p><b>Create New Book</b></p>
		curl -d "@data.json" -H "Content-Type: application/json" -X POST http://localhost:8181/book-inventory/book

<p><b>Update Existing Book</b></p>
		curl -d "@data.json" -H "Content-Type: application/json" -X PUT http://localhost:8181/book-inventory/book

		data.json
		{
			"bookId": 400,
			"bookName": "Database Concept",
			"bookCategory": "Computer Science Program"
		}
