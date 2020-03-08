package tw.org.iii.ellen.ellen06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyView myView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView) ;
    }

    public void clearMyView(View view) {
        myView.clear() ;

    }

    public void redoMyView(View view) {
        myView.redo() ;
    }

    public void undoMyView(View view) {
        myView.undo() ;
    }

    public void chColor(View view) {

    }
}
