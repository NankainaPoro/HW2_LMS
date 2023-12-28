package vakulenko.hw2_lms;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final double robotCost = 35000;
    private static final double percent = 0.09;
    private static final double stipendiya = 1700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textViewAnsw);

        double savings = calculateSavings();
        double months = calculateMonthsToSave(savings);

        //Отображение результата
        if (months > 0) {
            textView.setText(String.format("Вы сможете накопить на робота за %.0f месяцев.", months));
        } else {
            textView.setText("У вас уже достаточно средств для покупки робота!");
        }
    }

    // Метод для рассчета количества месяцев для накопления нужной суммы
    private double calculateSavings() {
        double totalSavings = 700;
        double monthlyInterestRate = percent / 12;

        for (int i = 0; i < 12; i++) {
            totalSavings += stipendiya;
            totalSavings *= (1 + monthlyInterestRate);
        }

        return totalSavings;
    }

    private double calculateMonthsToSave(double savings) {
        double totalSavings = 700;
        double monthlyInterestRate = percent / 12;
        double months = 0;

        while (totalSavings < robotCost) {
            totalSavings += stipendiya;
            totalSavings *= (1 + monthlyInterestRate);
            months++;
        }

        return months;
    }
}