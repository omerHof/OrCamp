package ViewModel;


import Model.MyModel;
import nextWord.SearchAlgo;
import nextWord.generateDataBaseAlgo;
import sentences.SentenceProcessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class MyViewModel {
    MyModel model;

    String mode;



    private String kid = "";
    private String kidHebrow="";



    private String general="";
    private TreeMap<Object,Object> generalSen;
    private String positive="";
    private TreeMap<Object,Object> positiveSen;
    private String negative="";
    private TreeMap<Object,Object> negativeSen;
    private String enjoy="";
    private TreeMap<Object,Object> enjoySen;
    private String discipline="";
    private TreeMap<Object,Object> disciplineSen;
    private String social="";
    private TreeMap<Object,Object> socialSen;


    private String night = "";
    private String equipment = "";
    private String drugs = "";
    private String health = "";
    private String hygine = "";
    private String food = "";

    private TreeMap<Object,Object> moreSen;



    private String summary="";
    private TreeMap<Object,Object> summarySen;
    generateDataBaseAlgo data;
    SearchAlgo s;


    public MyViewModel(MyModel model) throws IOException {
        this.model = model;
        generateDataBaseAlgo data = new generateDataBaseAlgo();
        s = new SearchAlgo(data.generateDataBase());
    }


    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getEnjoy() {
        return enjoy;
    }

    public void setEnjoy(String enjoy) {
        this.enjoy = enjoy;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void createSenDataBase(String kid) throws FileNotFoundException {
        SentenceProcessor sp = new SentenceProcessor();
        generalSen = sp.getData(kid,"general");
        positiveSen=sp.getData(kid,"positive");
        negativeSen =sp.getData(kid,"negative");
        enjoySen =sp.getData(kid,"enjoy");
        disciplineSen =sp.getData(kid,"discipline");
        socialSen =sp.getData(kid,"social");
        //moreSen = sp.getData(kid,"more");
    }

    public TreeMap<Object, Object> getGeneralSen() {
        return generalSen;
    }

    public TreeMap<Object, Object> getPositiveSen() {
        return positiveSen;
    }

    public TreeMap<Object, Object> getNegativeSen() {
        return negativeSen;
    }

    public TreeMap<Object, Object> getEnjoySen() {
        return enjoySen;
    }

    public TreeMap<Object, Object> getDisciplineSen() {
        return disciplineSen;
    }

    public TreeMap<Object, Object> getSocialSen() {
        return socialSen;
    }

    public TreeMap<Object, Object> getMoreSen() {
        return moreSen;
    }

    public TreeMap<Object, Object> getSummarySen() {
        return summarySen;
    }


    public String getNight() {
        return night;
    }

    public String getKidHebrow() {
        return kidHebrow;
    }

    public void setKidHebrow(String kidHebrow) {
        this.kidHebrow = kidHebrow;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHygine() {
        return hygine;
    }

    public void setHygine(String hygine) {
        this.hygine = hygine;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setGeneralSen(TreeMap<Object, Object> generalSen) {
        this.generalSen = generalSen;
    }

    public void setPositiveSen(TreeMap<Object, Object> positiveSen) {
        this.positiveSen = positiveSen;
    }

    public void setNegativeSen(TreeMap<Object, Object> negativeSen) {
        this.negativeSen = negativeSen;
    }

    public void setEnjoySen(TreeMap<Object, Object> enjoySen) {
        this.enjoySen = enjoySen;
    }

    public void setDisciplineSen(TreeMap<Object, Object> disciplineSen) {
        this.disciplineSen = disciplineSen;
    }

    public void setSocialSen(TreeMap<Object, Object> socialSen) {
        this.socialSen = socialSen;
    }

    public void setMoreSen(TreeMap<Object, Object> moreSen) {
        this.moreSen = moreSen;
    }

    public void setSummarySen(TreeMap<Object, Object> summarySen) {
        this.summarySen = summarySen;
    }

    public String[] nextWord(String word) throws FileNotFoundException {
        return s.searchNextWord(word);
    }
}
