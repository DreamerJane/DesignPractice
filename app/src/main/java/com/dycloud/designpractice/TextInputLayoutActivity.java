package com.dycloud.designpractice;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by le on 2015/12/28.
 */
public class TextInputLayoutActivity extends AppCompatActivity {
    private TextInputLayout usernameWraper;
    private TextInputLayout passwordWraper;
    private EditText usernameText;
    private EditText passwordText;
    private Button loginBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayout);

        initViews();
        initEvents();
        //显示软键盘
        //showKeyboard();
        showSoftKeyboard();
    }

    private void initEvents() {
        usernameWraper.setHint("请输入用户名");
        passwordWraper.setHint("请输入密码");

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameWraper.getEditText().getText().toString();
                String password = passwordWraper.getEditText().getText().toString();

                hideKeyboard();
                if (!username.equals("hello")) {
                    usernameWraper.setError("用户名输入错误");
                } else if (!password.equals("123")) {
                    passwordWraper.setError("密码输入错误");
                } else {
                    Toast.makeText(TextInputLayoutActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        usernameWraper = (TextInputLayout) findViewById(R.id.username_wrapper);
        passwordWraper = (TextInputLayout) findViewById(R.id.password_wrapper);

        /*usernameText = (EditText) findViewById(R.id.username);
        passwordText = (EditText) findViewById(R.id.password);*/

        loginBtn = (Button) findViewById(R.id.btn_login);

    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    private void showKeyboard() {
        Timer timer = new Timer();
        //对于刚跳到一个新的界面就要弹出软键盘的情况上述代码可能由于界面为加载完全而无法弹出软键盘。
        // 此时应该适当的延迟弹出软键盘如998毫秒
        timer.schedule(new TimerTask() {
            public void run(){
                InputMethodManager inputManager =
                        (InputMethodManager)usernameWraper.getEditText().getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(usernameWraper.getEditText(), 0);
            }
        }, 998);
    }
 private void showSoftKeyboard() {
        Timer timer = new Timer();
        //对于刚跳到一个新的界面就要弹出软键盘的情况上述代码可能由于界面为加载完全而无法弹出软键盘。
        // 此时应该适当的延迟弹出软键盘如998毫秒
        timer.schedule(new TimerTask() {
            public void run() {
                View view = getCurrentFocus();
                if (view != null) {
                    InputMethodManager inputManager =
                            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.showSoftInput(view, 0);
                }
            }
        }, 998);
    }

}
