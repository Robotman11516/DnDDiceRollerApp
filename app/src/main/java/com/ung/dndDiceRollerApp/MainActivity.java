package com.ung.dndDiceRollerApp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int MAX_DICE = 6;
    private int mDie;
    private Dice[] mDice;
    private ImageView[] mDiceImageViews;
    private TextView[] mDiceTextViews;
    private FrameLayout[] mDiceFrames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array of Dice
        mDice = new Dice[MAX_DICE];
        mDice[0] = new Dice(R.drawable.d4);
        mDice[1] = new Dice(R.drawable.d6);
        mDice[2] = new Dice(R.drawable.d8);
        mDice[3] = new Dice(R.drawable.d10);
        mDice[4] = new Dice(R.drawable.d12);
        mDice[5] = new Dice(R.drawable.d20);

        //Create an array of FrameViews
        mDiceFrames = new FrameLayout[MAX_DICE];
        mDiceFrames[0] = findViewById(R.id.d4frame);
        mDiceFrames[1] = findViewById(R.id.d6frame);
        mDiceFrames[2] = findViewById(R.id.d8frame);
        mDiceFrames[3] = findViewById(R.id.d10frame);
        mDiceFrames[4] = findViewById(R.id.d12frame);
        mDiceFrames[5] = findViewById(R.id.d20frame);

        // Create an array of ImageViews
        mDiceImageViews = new ImageView[MAX_DICE];
        mDiceImageViews[0] = findViewById(R.id.d4Image);
        mDiceImageViews[1] = findViewById(R.id.d6Image);
        mDiceImageViews[2] = findViewById(R.id.d8Image);
        mDiceImageViews[3] = findViewById(R.id.d10Image);
        mDiceImageViews[4] = findViewById(R.id.d12Image);
        mDiceImageViews[5] = findViewById(R.id.d20Image);

        //Array of TextViews
        mDiceTextViews = new TextView[MAX_DICE];
        mDiceTextViews[0] = findViewById(R.id.d4Text);
        mDiceTextViews[1] = findViewById(R.id.d6Text);
        mDiceTextViews[2] = findViewById(R.id.d8Text);
        mDiceTextViews[3] = findViewById(R.id.d10Text);
        mDiceTextViews[4] = findViewById(R.id.d12Text);
        mDiceTextViews[5] = findViewById(R.id.d20Text);

        // All dice are initially visible
        mDie = MAX_DICE;

        showDice();

        mDiceFrames[0].setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                int randomD4 = new Random().nextInt(4) + 1;
                mDiceTextViews[0].setText(String.valueOf(randomD4));
            }
        });
        mDiceFrames[1].setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                int randomD6 = new Random().nextInt(6) + 1;
                mDiceTextViews[1].setText(String.valueOf(randomD6));
            }
        });
        mDiceFrames[2].setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                int randomD8 = new Random().nextInt(8) + 1;
                mDiceTextViews[2].setText(String.valueOf(randomD8));
            }
        });
        mDiceFrames[3].setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                int randomD10 = new Random().nextInt(10) + 1;
                mDiceTextViews[3].setText(String.valueOf(randomD10));
            }
        });
        mDiceFrames[4].setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                int randomD12 = new Random().nextInt(12) + 1;
                mDiceTextViews[4].setText(String.valueOf(randomD12));
            }
        });
        mDiceFrames[5].setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                int randomD20 = new Random().nextInt(20) + 1;
                mDiceTextViews[5].setText(String.valueOf(randomD20));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showDice() {
        // Display only the number of dice visible
        for (int i = 0; i < 6; i++) {
            if (mDice[i].visabiliy) {
                Drawable diceDrawable = ContextCompat.getDrawable(this, mDice[i].getImageId());
                mDiceImageViews[i].setImageDrawable(diceDrawable);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Determine which menu option was chosen
        if (item.getItemId() == R.id.action_D4) {
            changeDiceVisibility(0);
            showDice();
            return true;
        }
        else if (item.getItemId() == R.id.action_D6) {
            changeDiceVisibility(1);
            showDice();
            return true;
        }
        else if (item.getItemId() == R.id.action_D8) {
            changeDiceVisibility(2);
            showDice();
            return true;
        }
        else if (item.getItemId() == R.id.action_D10) {
            changeDiceVisibility(3);
            showDice();
            return true;
        }
        else if (item.getItemId() == R.id.action_D12) {
            changeDiceVisibility(4);
            showDice();
            return true;
        }
        else if (item.getItemId() == R.id.action_D20) {
            changeDiceVisibility(5);
            showDice();
            return true;
        }

        else if (item.getItemId() == R.id.user_green) {
            for (int i = 0; i < 6; i++) {
                mDiceImageViews[i].setColorFilter(getColor(R.color.user_green));
            }
        }

        else if (item.getItemId() == R.id.user_blue) {
            for (int i = 0; i < 6; i++) {
                mDiceImageViews[i].setColorFilter(getColor(R.color.user_blue));
            }
        }

        else if (item.getItemId() == R.id.user_purple) {
            for (int i = 0; i < 6; i++) {
                mDiceImageViews[i].setColorFilter(getColor(R.color.user_purple));
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeDiceVisibility(int die) {
        mDie = die;

        // Make dice visible
        if (mDice[die].visabiliy) {
            mDiceImageViews[die].setVisibility(View.GONE);
            mDiceTextViews[die].setVisibility(View.GONE);
            mDice[die].visabiliy = false;
        }
        else{
            mDiceImageViews[die].setVisibility(View.VISIBLE);
            mDiceTextViews[die].setVisibility(View.VISIBLE);
            mDice[die].visabiliy = true;
        }
    }
}
