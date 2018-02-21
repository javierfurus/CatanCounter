package com.example.android.courtcounter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA;
    int scoreTeamB;
    int originalColor;
    int winColor;
    int loseColor;
    private ToggleButton mySwitchA;
    private ToggleButton mySwitchB;
    private ToggleButton mySwitchA2;
    private ToggleButton mySwitchB2;
    private TextView scoreViewA;
    private TextView scoreViewB;
    private TextView teamA;
    private TextView teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);
        mySwitchA = findViewById(R.id.myswitcha);
        mySwitchB = findViewById(R.id.myswitchb);
        mySwitchA2 = findViewById(R.id.myswitcha2);
        mySwitchB2 = findViewById(R.id.myswitchb2);
        teamA = findViewById(R.id.team_a);
        teamB = findViewById(R.id.team_b);
        originalColor = getResources().getColor(R.color.teams);
        winColor = getResources().getColor(R.color.winColor);
        loseColor = getResources().getColor(R.color.loseColor);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        /**
         * Adds SwitchFunction A.
         */
        mySwitchA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton bv, boolean isChecked) {
                if (isChecked) {
                    scoreTeamA = scoreTeamA + 2;
                    displayForTeamA(scoreTeamA);
                    mySwitchB.setChecked(false);
                } else if (scoreTeamA >= 2) {
                    scoreTeamA = scoreTeamA - 2;
                    displayForTeamA(scoreTeamA);
                }
            }
        });

        /**
         * Adds SwitchFunction B.
         */
        mySwitchB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton bv, boolean isChecked) {
                if (isChecked) {
                    scoreTeamB = scoreTeamB + 2;
                    displayForTeamB(scoreTeamB);
                    mySwitchA.setChecked(false);
                } else if (scoreTeamB >= 2) {
                    scoreTeamB = scoreTeamB - 2;
                    displayForTeamB(scoreTeamB);
                }
            }
        });

        /**
         * Adds SwitchFunction A 2.
         */
        mySwitchA2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton bv, boolean isChecked) {
                if (isChecked) {
                    scoreTeamA = scoreTeamA + 2;
                    displayForTeamA(scoreTeamA);
                    mySwitchB2.setChecked(false);
                } else if (scoreTeamA >= 2) {
                    scoreTeamA = scoreTeamA - 2;
                    displayForTeamA(scoreTeamA);
                }
            }
        });

        /**
         * Adds SwitchFunction B 2.
         */
        mySwitchB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton bv, boolean isChecked) {
                if (isChecked) {
                    scoreTeamB = scoreTeamB + 2;
                    displayForTeamB(scoreTeamB);
                    mySwitchA2.setChecked(false);
                } else if (scoreTeamB >= 2) {
                    scoreTeamB = scoreTeamB - 2;
                    displayForTeamB(scoreTeamB);
                }
            }
        });

    }

    private void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int scoreTeamA) {
        scoreViewA.setText(String.valueOf(scoreTeamA));
        if (scoreTeamA >= 10) {
            winColorA();
            loseColorB();
            makeToast(getString(R.string.whiteWins));
        }
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreTeamB) {
        scoreViewB.setText(String.valueOf(scoreTeamB));
        if (scoreTeamB >= 10) {
            winColorB();
            loseColorA();
            makeToast(getString(R.string.blueWins));
        }
    }

    /**
     * Gives Team A 2 points
     */
    public void addTwoScoreA(View view) {
        if (scoreTeamA <= 1) {
            scoreTeamA = scoreTeamA + 2;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamA = scoreTeamA + 1;
            displayForTeamA(scoreTeamA);
        }

    }

    /**
     * Gives Team A 1 point
     */
    public void addOneScoreA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

    }

    /**
     * Gives Team B 2 points
     */
    public void addTwoScoreB(View view) {
        if (scoreTeamB <= 1) {
            scoreTeamB = scoreTeamB + 2;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamB = scoreTeamB + 1;
            displayForTeamB(scoreTeamB);
        }

    }

    /**
     * Gives Team A 1 point
     */
    public void addOneScoreB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);

    }

    /**
     * Resets scores.
     */
    public void resetScores(View view) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
        originalColor();
        mySwitchA.setChecked(false);
        mySwitchB.setChecked(false);
        mySwitchA2.setChecked(false);
        mySwitchB2.setChecked(false);

    }

    /**
     * Removes score from Team A.
     */
    public void removeScoreA(View view) {
        if (scoreTeamA > 0) {
            scoreTeamA = scoreTeamA - 1;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamA = 0;
        }
    }

    /**
     * Removes score from Team B.
     */
    public void removeScoreB(View view) {
        if (scoreTeamB > 0) {
            scoreTeamB = scoreTeamB - 1;
            displayForTeamB(scoreTeamB);
        } else {
            scoreTeamB = 0;
        }
    }

    /**
     * These methods change the color of the teams when they win or lose or the game is reset
     */
    public void winColorA() {
        teamA.setBackgroundColor(winColor);
    }

    public void winColorB() {
        teamB.setBackgroundColor(winColor);

    }

    public void loseColorA() {
        teamA.setBackgroundColor(loseColor);
    }

    public void loseColorB() {
        teamB.setBackgroundColor(loseColor);
    }

    public void originalColor() {
        teamA.setBackgroundColor(originalColor);
        teamB.setBackgroundColor(originalColor);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreA", scoreTeamA);
        outState.putInt("scoreB", scoreTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreA");
        scoreTeamB = savedInstanceState.getInt("scoreB");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
