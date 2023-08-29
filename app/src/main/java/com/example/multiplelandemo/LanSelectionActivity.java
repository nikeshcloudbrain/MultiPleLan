package com.example.multiplelandemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.multiplelandemo.databinding.ActivityLanSelectionBinding;

import java.util.ArrayList;

public class LanSelectionActivity extends AppCompatActivity implements OnItemClickListener{
ActivityLanSelectionBinding binding;
LanAdapter adapter;

String LanCode;
ArrayList<LanguageModel> Llist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLanSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter
                = new LanAdapter( this,Llist,this::onItemClick);

        Llist.add(new LanguageModel("(English)", "English", "United Kingdom", R.drawable.ic_english_lang, "en"));
        Llist.add(new LanguageModel("(Mandarin)", "普通话", "China", R.drawable.ic_chinese_lang, "zh"));
        Llist.add(new LanguageModel("(Hindi)", "हिन्दी", "India", R.drawable.ic_hindi_lang, "hi"));
        Llist.add(new LanguageModel("(Gujarati)", "ગુજરાતી", "India", R.drawable.ic_hindi_lang, "gu"));

        Llist.add(new LanguageModel("(Spanish)", "Española", "spain", R.drawable.ic_spanish_lang, "es"));
        Llist.add(new LanguageModel("(Arabic)", "عربي", "Egypt", R.drawable.ic_arabic__lang, "ar"));
        Llist.add(new LanguageModel("(Japanese)", "日本", "Japan", R.drawable.ic_japanese_lang, "ja"));
        Llist.add(new LanguageModel("(French)", "Français", "France", R.drawable.ic_french_lang, "fr"));
        Llist.add(new LanguageModel("(Russian)", "Русский", "Russia", R.drawable.ic_russian_lang, "ru"));
        Llist.add(new LanguageModel("(Portuguese)", "Português", "Portugal", R.drawable.ic_portugue_lang, "pt"));
        Llist.add(new LanguageModel("(Urdu)", "اردو", "United Arab", R.drawable.ic_urdu_lang, "ur"));
        Llist.add(new LanguageModel("(German)", "Deutsch", "Germany", R.drawable.ic_german__lang, "de"));
        Llist.add(new LanguageModel("(Bengali)", "বাংলা", "Bangladesh", R.drawable.ic_bengali_lang, "bn"));
        binding.rvViewLan.setLayoutManager(new LinearLayoutManager(this));
        binding.rvViewLan.setAdapter(adapter);


        binding.doneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LanCode.equals("en")){

                    setNewLocale(LanSelectionActivity.this, LocaleManager.ENGLISH);

            }else if (LanCode.equals("hi")){
                setNewLocale(LanSelectionActivity.this, LocaleManager.HINDI);

            }else if(LanCode.equals("gu")){
                setNewLocale(LanSelectionActivity.this, LocaleManager.GUJARATI);

            }else if(LanCode.equals("ar")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Arabic);

                }else if(LanCode.equals("bn")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Bengali);

                }else if(LanCode.equals("de")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.German);

                }else if(LanCode.equals("es")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Spanish);

                }else if(LanCode.equals("fr")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.French);

                }else if(LanCode.equals("ja")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Japanese);

                }else if(LanCode.equals("pt")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Portuguese);

                }else if(LanCode.equals("ru")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Russian);

                }else if(LanCode.equals("ur")){
                    setNewLocale(LanSelectionActivity.this, LocaleManager.Urdu);

                }
            }
        });

    }

    private void setNewLocale(AppCompatActivity mContext, @LocaleManager.LocaleDef String language) {
        LocaleManager.setNewLocale(this, language);
        Intent intent = new Intent(LanSelectionActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onItemClick(String item) {
        LanCode = item;

    }
}