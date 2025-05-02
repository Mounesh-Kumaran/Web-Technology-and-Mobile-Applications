import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookName = findViewById<EditText>(R.id.bookName)
        val author = findViewById<EditText>(R.id.author)
        val isbn = findViewById<EditText>(R.id.isbn)
        val category = findViewById<EditText>(R.id.category)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val message = findViewById<TextView>(R.id.successMessage)

        submitBtn.setOnClickListener {
            val bName = bookName.text.toString().trim()
            val auth = author.text.toString().trim()
            val isbnCode = isbn.text.toString().trim()
            val cat = category.text.toString().trim()

            if (bName.isEmpty() || auth.isEmpty() || isbnCode.isEmpty() || cat.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                message.text = "📚 Book Added Successfully!"
                message.visibility = TextView.VISIBLE
            }
        }
    }
}
