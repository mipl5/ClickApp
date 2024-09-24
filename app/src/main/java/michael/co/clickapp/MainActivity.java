package michael.co.clickapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button   btnClickMe;
    private Button   btnTerminate;
    private Button   btnGuess;
    private EditText etPhone;

    private String myPhoneNumber = "1234567890";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnClickMe =    (Button)   findViewById(R.id.btnClickMe);
        etPhone =       (EditText) findViewById(R.id.editTextPhone);
        btnTerminate =  (Button) findViewById(R.id.btnTerminate);
        btnGuess =      (Button) findViewById(R.id.btnGuess);

        btnClickMe.setOnClickListener(this);
        btnTerminate.setOnClickListener(this);
        btnGuess.setOnClickListener(this);
    }
    public void onClick(View v){
        if (v == btnClickMe){
            Toast.makeText(this, "Your phone number is: " + etPhone.getText(), Toast.LENGTH_SHORT).show();
        }
        if (v == btnTerminate){
            etPhone.setText("");
        }
        if (v == btnGuess){
            if (etPhone.getText().toString().equals(myPhoneNumber.toString())){
                outIsSame(true);
            }
            else
                outIsSame(false);
        }
    }
    private void outIsSame(boolean isSame){
        Toast.makeText(this, "Is correct: " + isSame, Toast.LENGTH_SHORT).show();
    }
}