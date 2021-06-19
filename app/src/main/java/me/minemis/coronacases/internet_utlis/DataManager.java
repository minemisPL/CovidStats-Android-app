package me.minemis.coronacases.internet_utlis;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;

import me.minemis.coronacases.MainActivity;
import me.minemis.coronacases.R;
import me.minemis.coronacases.data.CovidData;

public class DataManager {

    private CovidData covidData = new CovidData();
    private final MainActivity mainActivity;

    public DataManager(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void updateData() {
        ProgressBar progressBar = mainActivity.findViewById(R.id.progress_bar_loading);
        TextView allCases = mainActivity.findViewById(R.id.overallcases);
        TextView casesToday = mainActivity.findViewById(R.id.cases_today);
        TextView allDeaths = mainActivity.findViewById(R.id.overall_deaths);
        TextView deathsToday = mainActivity.findViewById(R.id.deaths_today);

        new Thread(() -> {

            mainActivity.runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));

            try {
                URL oracle = new URL("https://www.worldometers.info/coronavirus/");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));

                String inputLine;

                StringBuffer stringBuffer = new StringBuffer();

                while ((inputLine = in.readLine()) != null){
                    stringBuffer.append(inputLine);
                }
                in.close();

                String rawContent = stringBuffer.toString();

                int i = rawContent.indexOf("World</td><td>");
                String s = rawContent.substring(i).split("<td></td>")[0];

                String result = s.replace("<td>", " ");
                result = result.replace("</td>", "");
                result = result.replace("+", "");
                result = result.replace("World", "");
                result = result.replace(",", "");
                String[] strings = result.split(" ");

                covidData.setAllCases(Integer.parseInt(strings[1]));
                covidData.setCasesToday(Integer.parseInt(strings[2]));
                covidData.setAllDeaths(Integer.parseInt(strings[3]));
                covidData.setDeathsToday(Integer.parseInt(strings[4]));

                mainActivity.runOnUiThread(() ->{
                    progressBar.setVisibility(View.GONE);

                    allCases.setText(NumberFormat.getNumberInstance().format(covidData.getAllCases()));
                    casesToday.setText(NumberFormat.getNumberInstance().format(covidData.getCasesToday()));
                    allDeaths.setText(NumberFormat.getNumberInstance().format(covidData.getAllDeaths()));
                    deathsToday.setText(NumberFormat.getNumberInstance().format(covidData.getDeathsToday()));
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
