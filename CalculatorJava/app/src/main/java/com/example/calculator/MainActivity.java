package com.example.calculator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.appbar);
        display = findViewById(R.id.plainText);
        display.setShowSoftInputOnFocus(false);


    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr, strToAdd ,rightStr));
        display.setSelection(cursorPos + 1);

    }

    public void zero (View view){
   updateText("0" );
    }
    public void one (View view){
        updateText("1" );
    }
    public void two (View view){
        updateText("2" );
    }
    public void tree (View view){
        updateText("3" );
    }
    public void four (View view){
        updateText("4" );
    }
    public void five (View view){
        updateText("5" );
    }
    public void six (View view){
        updateText("6" );
    }
    public void seven (View view){ updateText("7" ); }
    public void eight (View view){
        updateText("8" );
    }
    public void nine (View view){
        updateText("9" );
    }
    public void clear (View view){
display.setText("");
    }
    public void exponent (View view){
        updateText("^");
    }
    public void brackets (View view){
        updateText("()");
    }
    public void divide (View view){
        updateText("÷");
    }
    public void multiply (View view){updateText("x");}
    public void add (View view){ updateText("+"); }
    public void subtract(View view){updateText("-");}
    public void plusmines (View view){ updateText("-"); }
    public void point (View view){
        updateText(".");
    }
    public void equals (View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("x" ,"*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
}