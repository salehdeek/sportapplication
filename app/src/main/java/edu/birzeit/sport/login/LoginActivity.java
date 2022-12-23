package edu.birzeit.sport.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.birzeit.sport.R;
import edu.birzeit.sport.login.createAccount.CreateAccount;
import edu.birzeit.sport.playersPages.Liva;
import edu.birzeit.sport.services.LoginService;

public class LoginActivity extends AppCompatActivity {
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String FLAG = "FLAG";
    private EditText editEmail, editPassword;
    private CheckBox checkBox;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private LoginService loginService = new LoginService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        checkBox = findViewById(R.id.remember_check);
        editEmail = findViewById(R.id.text_email);
        editPassword = findViewById(R.id.text_password);
        setSharedPref();
        checkPreference();
    }

    private void checkPreference() {
        boolean isChecked = preferences.getBoolean(FLAG, false);
        if (isChecked) {
            String email = preferences.getString(EMAIL, "");
            String password = preferences.getString(PASSWORD, "");
            editEmail.setText(email);
            editPassword.setText(password);
            checkBox.setChecked(true);
        }
    }

    private void setSharedPref() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
    }

    public void sign_click(View view) {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        if (loginService.loginStatus(email, password)!=null) {
            if (checkBox.isChecked()) {
                editor.putString(EMAIL, email);
                editor.putString(PASSWORD, password);
                editor.putBoolean(FLAG, true);
                editor.commit();
            }
            Toast.makeText(this, "Hello"+loginService.loginStatus(email, password), Toast.LENGTH_LONG).show();

//            startActivity(new Intent("edu.birzeit.sport.Dashboard"));
        } else {
            Toast.makeText(this, "sorry you have to create account!", Toast.LENGTH_LONG).show();
        }
    }


    public void signUp_click(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}