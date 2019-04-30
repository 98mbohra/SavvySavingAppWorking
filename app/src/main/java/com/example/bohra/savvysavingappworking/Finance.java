package com.example.bohra.savvysavingappworking;

import com.example.bohra.savvysavingappworking.Period;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class Finance extends Observable
{

    public Finance()
    {
        //instantiate all data
       /* if  checkPriorUse(); is true then continue
       check pin
       LOAD
       fillSavings, fillPurchases, fillFixed costs, financesData
       All data should be set up at this point
        */

    }



    private int income; //In finance db
    private Period incomePeriod; //In finance db
    private int fixedCosts; //in finance db
    private String savePeriod; //in finance db
    private int savingAmount; //in finance db
    private int savingGoal; //in finance db

    private int budget; // calculated on initialising

    public Date currentDate; // Holds the current date on start up, updates whenever a transaction is made


    private int pinCode; //used for setting and taking input held in file
    private String pinFileAddress; //fixed path to pin text file which contains encoded pin

    private String linkToSavingDB ;  //Fixed link to the db
    private String linkToPurchasesDB;  //Fixed link to the db
    private String linkToFixedPaymentsDB;  //Fixed link to the db

    private ArrayList<Purchase>  purchaseList= new ArrayList<Purchase>(); //arraylist which is loaded from db
    private ArrayList<FixedPayment> fixedPayments = new ArrayList<FixedPayment>(); //arraylist which is loaded from db
    private ArrayList<Saving> savings = new ArrayList<Saving>(); //filled from db

    public void closingSequence(){
        /*
        This method will use submethods to clear each database return all arraylists to database
        Close connections and datafiles

         */
    }

    public void checkPriorUse()
    {
        /*
        if pinfile is empty
        then run through the views for the starting sequence gathering new pin income, fixed costs, saving goal, amount, and period.
        Remind user that it is their responsibility to deduct funds when saving
        send data to db and files as recorded
        send user to first enter user pin screen

         */
    }

    public void addFixedCost(){
        /*Adds a new fixed cost to the arraylist
        Takes in the amount, period, category.
         */
    }



    public void fillSavings (){


        /*
        This method connects to savings database, and iteratively loads all the saving records into the arraylist
         */
        //ERIC

    }

    public void fillPurchases(){
        /*
        This method connects to purchase database and iteratively loads all purchase records into the arraylist
         */

        //ERIC
    }

    public void fillFixed()
    {
        /*
        This Method connects to the fixed payment database and iteratively loads all fixed payments into the arraylist
         */

        //ERIC
    }

    public void fillFinance()
    {
        /*
        This method fills all other financial data from the finance database (income e.t.c.)

         */
        //ERIC
    }

    public int checkPin()
    {
        String pin;

        /*
        This method will load the encoded pin from the pincode file, decrypt the pincode, and then compare it with the entered pin
        It will return a 1 if the two match
         */

        //ARSHAD
        return 1;
    }

    public void assignPin(String pin){
        /*
        This method will take a new pin encrypt it, return it to the pin file.
         */

        //ARSHAD


    }

    public void changePin(){
        /*
        This method will first use check pin, if successful it will then
        use the assignPin method to send the new pin to the file.
         */

        //ARSHAD
    }

    public void addPurchase(SpendingCategory purchaseType, String comment, Date currentDate, int purchaseAmount){
        /*
        This method will take a purchase values specified by the input fields, and device specified current date
          to generate a new purchase object, and add it to the arraylist
        Subtracts amount from the income value
         */
    }

    public void handleSaving(){
        /*
        This method checks the data of last saving contribution from saving.getLast() or whatever,
        and then uses the saving period and decides whether a saving needs to be made. If monthly it checks that next date is the second of month

        It deducts from the income.
         */
    }

    public void undoPurchase(){
        /*
        This method will remove the last purchase from the arraylist, prompting the user with the details of the last purchase before
        Accepting
         */
    }


    public void closeSavings(){
        /*
        return arraylist savings to db

        //ERIC
         */
    }

    public void closePurchases(){
        /*
        return arraylist purchases to db

        //ERIC
         */
    }

    public void closeFixedPayments(){
        /*
        return arraylist fixedPayments to db

        //ERIC
         */
    }

    public void closeFinances(){
        /*
        Return finance data to the db

        //ERIC
         */
    }

    public ArrayList<Saving> getSavings() {
        return savings;
    }

    public void setSavings(ArrayList<Saving> savings) {
        this.savings = savings;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getFixedCosts() {
        return fixedCosts;
    }

    public void setFixedCosts(int fixedCosts) {
        this.fixedCosts = fixedCosts;
    }

    public String getLinkToSavingDB() {
        return linkToSavingDB;
    }

    public void setLinkToSavingDB(String linkToSavingDB) {
        this.linkToSavingDB = linkToSavingDB;
    }

    public String getLinkToPurchasesDB() {
        return linkToPurchasesDB;
    }

    public void setLinkToPurchasesDB(String linkToPurchasesDB) {
        this.linkToPurchasesDB = linkToPurchasesDB;
    }

    public String getLinkToFixedPaymentsDB() {
        return linkToFixedPaymentsDB;
    }

    public void setLinkToFixedPaymentsDB(String linkToFixedPaymentsDB) {
        this.linkToFixedPaymentsDB = linkToFixedPaymentsDB;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }


    public String getPinFileAddress() {
        return pinFileAddress;
    }

    public void setPinFileAddress(String pinFileAddress) {
        this.pinFileAddress = pinFileAddress;
    }

    public ArrayList<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(ArrayList<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public ArrayList<FixedPayment> getFixedPayments() {
        return fixedPayments;
    }

    public void setFixedPayments(ArrayList<FixedPayment> fixedPayments) {
        this.fixedPayments = fixedPayments;
    }


    public String getSavePeriod() {
        return savePeriod;
    }

    public void setSavePeriod(String savePeriod) {
        this.savePeriod = savePeriod;
    }

    public int getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(int savingAmount) {
        this.savingAmount = savingAmount;
    }

    public int getSavingGoal() {
        return savingGoal;
    }

    public void setSavingGoal(int savingGoal) {
        this.savingGoal = savingGoal;
    }


}
